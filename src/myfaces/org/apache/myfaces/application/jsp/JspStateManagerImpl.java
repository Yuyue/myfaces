package net.sourceforge.myfaces.application.jsp;

import net.sourceforge.myfaces.application.MyfacesStateManager;
import net.sourceforge.myfaces.renderkit.MyfacesResponseStateManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.FacesException;
import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitFactory;
import javax.faces.render.ResponseStateManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * DOCUMENT ME!
 * 
 * @author Thomas Spiegl (latest modification by $Author$)
 * @version $Revision$ $Date$
 */
public class JspStateManagerImpl
    extends MyfacesStateManager
{
    private static final Log log = LogFactory.getLog(JspStateManagerImpl.class);
    private static final String VIEW_MAP_SESSION_PARAM
            = JspStateManagerImpl.class.getName() + ".VIEW_MAP";

    private RenderKitFactory _renderKitFactory = null;

    public JspStateManagerImpl()
    {
        if (log.isTraceEnabled()) log.trace("New JspStateManagerImpl instance created");
    }


    protected Object getTreeStructureToSave(FacesContext facesContext)
    {
        UIViewRoot viewRoot = facesContext.getViewRoot();
        if (viewRoot.isTransient())
        {
            return null;
        }

        if (isSavingStateInClient(facesContext))
        {
            //TODO
            throw new UnsupportedOperationException("not yet implemented");
        }
        else
        {
            //TODO: Remove transient components
            return viewRoot;
        }
    }

    protected Object getComponentStateToSave(FacesContext facesContext)
    {
        UIViewRoot viewRoot = facesContext.getViewRoot();
        if (viewRoot.isTransient() || !isSavingStateInClient(facesContext))
        {
            return null;
        }

        Object serializedComponentStates = viewRoot.processSaveState(facesContext);
        //Locale is a state attribute of UIViewRoot and need not be saved explicitly
        return serializedComponentStates;
    }

    public SerializedView saveSerializedView(FacesContext facesContext) throws IllegalStateException
    {
        Object treeStruct = getTreeStructureToSave(facesContext);
        Object compStates = getComponentStateToSave(facesContext);
        SerializedView serializedView = new SerializedView(treeStruct, compStates);
        if (isSavingStateInClient(facesContext))
        {
            return serializedView;
        }
        else
        {
            //save state in server session
            ExternalContext externalContext = facesContext.getExternalContext();
            Map sessionViewMap = getSessionViewMap(externalContext);
            sessionViewMap.put(facesContext.getViewRoot().getViewId(), serializedView);
            return null;
        }
    }


    protected UIViewRoot restoreTreeStructure(FacesContext facesContext, String viewId)
    {
        if (isSavingStateInClient(facesContext))
        {
            //reconstruct tree structure from request
            //TODO: We do not know the former renderKitId !?
            RenderKit rk = getRenderKitFactory().getRenderKit(RenderKitFactory.DEFAULT_RENDER_KIT, facesContext);
            ResponseStateManager responseStateManager = rk.getResponseStateManager();
            Object treeStructure = responseStateManager.getTreeStructureToRestore(facesContext, viewId);
            if (treeStructure != null)
            {
                //TODO: Create UIViewRoot and whole structure out of treeStructure object
                throw new UnsupportedOperationException("not yet implemented");
            }
        }
        else
        {
            //get component tree from server session
            Map sessionViewMap = getSessionViewMap(facesContext.getExternalContext());
            SerializedView serializedView = (SerializedView)sessionViewMap.get(viewId);
            if (serializedView != null)
            {
                return (UIViewRoot)serializedView.getStructure();
            }
        }
        return null;
    }

    protected void restoreComponentState(FacesContext facesContext, UIViewRoot uiViewRoot) throws IOException
    {
        Object serializedComponentStates = null;
        if (isSavingStateInClient(facesContext))
        {
            RenderKit renderKit = getRenderKitFactory().getRenderKit(uiViewRoot.getRenderKitId(), facesContext);
            ResponseStateManager responseStateManager = renderKit.getResponseStateManager();
            serializedComponentStates = responseStateManager.getComponentStateToRestore(facesContext);
        }
        else
        {
            Map sessionViewMap = getSessionViewMap(facesContext.getExternalContext());
            SerializedView serializedView = (SerializedView)sessionViewMap.get(uiViewRoot.getViewId());
            if (serializedView != null)
            {
                serializedComponentStates = serializedView.getState();
            }
        }
        if (serializedComponentStates != null)
        {
            uiViewRoot.processRestoreState(facesContext, serializedComponentStates);
        }
    }

    public UIViewRoot restoreView(FacesContext facescontext, String viewId)
    {
        UIViewRoot uiViewRoot = restoreTreeStructure(facescontext, viewId);
        try
        {
            uiViewRoot.setViewId(viewId);
            restoreComponentState(facescontext, uiViewRoot);
        }
        catch (IOException e)
        {
            throw new FacesException(e);
        }
        return uiViewRoot;
    }


    public void writeState(FacesContext facesContext,
                           SerializedView serializedView) throws IOException
    {
        if (!isSavingStateInClient(facesContext))
        {
            throw new IllegalStateException("Must not be called in server state saving mode");
        }

        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        //save state in response (client)
        RenderKit renderKit = getRenderKitFactory().getRenderKit(uiViewRoot.getRenderKitId(), facesContext);
        renderKit.getResponseStateManager().writeState(facesContext, serializedView);
    }

    /**
     * MyFaces extension
     * @param facesContext
     * @param serializedView
     * @throws IOException
     */
    public void writeStateAsUrlParams(FacesContext facesContext,
                                      SerializedView serializedView) throws IOException
    {
        if (!isSavingStateInClient(facesContext))
        {
            throw new IllegalStateException("Must not be called in server state saving mode");
        }

        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        //save state in response (client)
        RenderKit renderKit = getRenderKitFactory().getRenderKit(uiViewRoot.getRenderKitId(), facesContext);
        ResponseStateManager responseStateManager = renderKit.getResponseStateManager();
        if (responseStateManager instanceof MyfacesResponseStateManager)
        {
            ((MyfacesResponseStateManager)responseStateManager).writeStateAsUrlParams(facesContext,
                                                                                      serializedView);
        }
        else
        {
            log.error("ResponseStateManager of render kit " + uiViewRoot.getRenderKitId() + " is no MyfacesResponseStateManager and does not support saving state in url parameters.");
        }
    }



    //helpers

    protected RenderKitFactory getRenderKitFactory()
    {
        if (_renderKitFactory == null)
        {
            _renderKitFactory = (RenderKitFactory)FactoryFinder.getFactory(FactoryFinder.RENDER_KIT_FACTORY);
        }
        return _renderKitFactory;
    }

    protected Map getSessionViewMap(ExternalContext externalContext)
    {
        Map sessionMap = externalContext.getSessionMap();
        Map viewMap = (Map)sessionMap.get(VIEW_MAP_SESSION_PARAM);
        if (viewMap == null)
        {
            viewMap = new HashMap();
            sessionMap.put(VIEW_MAP_SESSION_PARAM, viewMap);
        }
        return viewMap;
    }
}
