/**
 * MyFaces - the free JSF implementation
 * Copyright (C) 2003  The MyFaces Team (http://myfaces.sourceforge.net)
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
package net.sourceforge.myfaces.taglib.ext;

import net.sourceforge.myfaces.renderkit.html.ext.TabbedPaneRenderer;
import net.sourceforge.myfaces.renderkit.attr.CommonRendererAttributes;
import net.sourceforge.myfaces.renderkit.attr.ext.TabbedPaneRendererAttributes;
import net.sourceforge.myfaces.taglib.MyFacesTag;

/**
 * DOCUMENT ME!
 * @author Manfred Geiler (latest modification by $Author$)
 * @version $Revision$ $Date$
 *
 * @deprecated panel_group with facet should be used
 */
public class TabbedPaneTag
    extends MyFacesTag
    implements CommonRendererAttributes,
               TabbedPaneRendererAttributes
{
    public String getComponentType()
    {
        return "TabbedPane";
    }

    public String getRendererType()
    {
        return TabbedPaneRenderer.TYPE;
    }

    public void setValue(Object value)
    {
        super.setValue(value);
    }

    public void setPanelClass(String value)
    {
        setRendererAttributeString(PANEL_CLASS_ATTR, value);
    }


    public void setActiveHeaderClass(String value)
    {
        setRendererAttributeString(ACTIVE_HEADER_CLASS_ATTR, value);
    }

    public void setInactiveHeaderClass(String value)
    {
        setRendererAttributeString(INACTIVE_HEADER_CLASS_ATTR, value);
    }

}
