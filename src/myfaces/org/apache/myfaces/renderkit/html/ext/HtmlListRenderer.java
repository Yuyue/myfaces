/*
 * MyFaces - the free JSF implementation
 * Copyright (C) 2003, 2004  The MyFaces Team (http://myfaces.sourceforge.net)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package net.sourceforge.myfaces.renderkit.html.ext;

import net.sourceforge.myfaces.component.ext.HtmlDataList;
import net.sourceforge.myfaces.renderkit.JSFAttr;
import net.sourceforge.myfaces.renderkit.RendererUtils;
import net.sourceforge.myfaces.renderkit.html.HTML;
import net.sourceforge.myfaces.renderkit.html.HtmlRenderer;
import net.sourceforge.myfaces.renderkit.html.HtmlRendererUtils;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author Manfred Geiler (latest modification by $Author$)
 * @version $Revision$ $Date$
 */
public class HtmlListRenderer
    extends HtmlRenderer
{
    //private static final Log log = LogFactory.getLog(HtmlListRenderer.class);

    public static final String LAYOUT_SIMPLE = "simple";
    public static final String LAYOUT_UL = "unorderedList";
    public static final String LAYOUT_OL = "orderedList";

    public boolean getRendersChildren()
    {
        return true;
    }

    public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException
    {
        RendererUtils.checkParamValidity(facesContext, uiComponent, UIData.class);
        ResponseWriter writer = facesContext.getResponseWriter();
        HtmlRendererUtils.writePrettyLineSeparator(facesContext);
        String layout = getLayout(uiComponent);
        if (layout.equals(LAYOUT_UL))
        {
            writer.startElement(HTML.UL_ELEM, uiComponent);
        }
        else if (layout.equals(LAYOUT_OL))
        {
            writer.startElement(HTML.OL_ELEM, uiComponent);
        }
    }

    public void encodeChildren(FacesContext facesContext, UIComponent component) throws IOException
    {
        RendererUtils.checkParamValidity(facesContext, component, UIData.class);

        UIData uiData = (UIData)component;
        String layout = getLayout(component);
        String firstRowFlag = getFirstRowFlag(component);
        String lastRowFlag = getLastRowFlag(component);
        Map requestMap = facesContext.getExternalContext().getRequestMap();

        ResponseWriter writer = facesContext.getResponseWriter();

        int first = uiData.getFirst();
        int rows = uiData.getRows();
        int rowCount = uiData.getRowCount();
        if (rows <= 0)
        {
            rows = rowCount - first;
        }
        int last = first + rows;
        if (last > rowCount) last = rowCount;

        for (int i = first; i < last; i++)
        {
            uiData.setRowIndex(i);
            if (uiData.isRowAvailable())
            {
                if (firstRowFlag != null)
                {
                    requestMap.put(firstRowFlag, Boolean.valueOf(i == first));
                }
                if (lastRowFlag != null)
                {
                    requestMap.put(lastRowFlag, Boolean.valueOf(i + 1 == last));
                }

                HtmlRendererUtils.writePrettyLineSeparator(facesContext);
                if (layout.equals(LAYOUT_UL) || (layout.equals(LAYOUT_OL)))
                {
                    writer.startElement(HTML.LI_ELEM, component);
                }

                RendererUtils.renderChildren(facesContext, component);

                if (layout.equals(LAYOUT_UL) || (layout.equals(LAYOUT_OL)))
                {
                    writer.endElement(HTML.LI_ELEM);
                }
            }
        }

        if (firstRowFlag != null)
        {
            requestMap.remove(firstRowFlag);
        }
        if (lastRowFlag != null)
        {
            requestMap.remove(lastRowFlag);
        }
    }


    public void encodeEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException
    {
        RendererUtils.checkParamValidity(facesContext, uiComponent, UIData.class);
        ResponseWriter writer = facesContext.getResponseWriter();
        HtmlRendererUtils.writePrettyLineSeparator(facesContext);
        String layout = getLayout(uiComponent);
        if (layout.equals(LAYOUT_UL))
        {
            writer.endElement(HTML.UL_ELEM);
        }
        else if (layout.equals(LAYOUT_OL))
        {
            writer.endElement(HTML.OL_ELEM);
        }
    }


    private String getLayout(UIComponent component)
    {
        if (component instanceof HtmlDataList)
        {
            return ((HtmlDataList)component).getLayout();
        }
        else
        {
            return (String)component.getAttributes().get(JSFAttr.LAYOUT_ATTR);
        }
    }

    private String getFirstRowFlag(UIComponent component)
    {
        if (component instanceof HtmlDataList)
        {
            return ((HtmlDataList)component).getFirstRowFlag();
        }
        else
        {
            return (String)component.getAttributes().get("firstRowFlag");
        }
    }

    private String getLastRowFlag(UIComponent component)
    {
        if (component instanceof HtmlDataList)
        {
            return ((HtmlDataList)component).getLastRowFlag();
        }
        else
        {
            return (String)component.getAttributes().get("lastRowFlag");
        }
    }

}
