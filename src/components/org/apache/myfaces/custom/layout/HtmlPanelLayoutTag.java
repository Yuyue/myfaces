/**
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
package net.sourceforge.myfaces.custom.layout;

import net.sourceforge.myfaces.renderkit.JSFAttr;
import net.sourceforge.myfaces.renderkit.html.HTML;
import net.sourceforge.myfaces.taglib.html.HtmlComponentBodyTagBase;

import javax.faces.component.UIComponent;

/**
 * @author Manfred Geiler (latest modification by $Author$)
 * @version $Revision$ $Date$
 * $Log$
 * Revision 1.3  2004/04/05 11:04:53  manolito
 * setter for renderer type removed, no more default renderer type needed
 *
 * Revision 1.2  2004/04/01 12:57:40  manolito
 * additional extended component classes for user role support
 *
 * Revision 1.1  2004/03/31 12:15:26  manolito
 * custom component refactoring
 *
 */
public class HtmlPanelLayoutTag
        extends HtmlComponentBodyTagBase
{
    public String getComponentType()
    {
        return HtmlPanelLayout.COMPONENT_TYPE;
    }

    public String getRendererType()
    {
        return "net.sourceforge.myfaces.Layout";
    }

    // UIComponent attributes --> already implemented in UIComponentBodyTagBase

    // HTML universal attributes --> already implemented in MyFacesTag

    // HTML event handler attributes --> already implemented in MyFacesTag

    // UIPanel attributes --> value attribute already implemented in UIComponentBodyTagBase

    // HtmlPanelLayout attributes
    private String _layout;
    private String _headerClass;
    private String _navigationClass;
    private String _bodyClass;
    private String _footerClass;
    private String _headerStyle;
    private String _navigationStyle;
    private String _bodyStyle;
    private String _footerStyle;

    // HTML table attributes
    private String _align;
    private String _bgcolor;
    private String _border;
    private String _cellpadding;
    private String _cellspacing;
    private String _datafld;
    private String _datasrc;
    private String _dataformatas;
    private String _frame;
    private String _rules;
    private String _summary;
    private String _width;

    // User Role support
    private String _enabledOnUserRole;
    private String _visibleOnUserRole;

    protected void setProperties(UIComponent component)
    {
        super.setProperties(component);

        setStringProperty(component, "layout", _layout);
        setStringProperty(component, "headerClass", _headerClass);
        setStringProperty(component, "navigationClass", _navigationClass);
        setStringProperty(component, "bodyClass", _bodyClass);
        setStringProperty(component, "footerClass", _footerClass);
        setStringProperty(component, "headerStyle", _headerStyle);
        setStringProperty(component, "navigationStyle", _navigationStyle);
        setStringProperty(component, "bodyStyle", _bodyStyle);
        setStringProperty(component, "footerStyle", _footerStyle);

        setStringProperty(component, HTML.ALIGN_ATTR, _align);
        setStringProperty(component, HTML.BGCOLOR_ATTR, _bgcolor);
        setStringProperty(component, HTML.BORDER_ATTR, _border);
        setStringProperty(component, HTML.CELLPADDING_ATTR, _cellpadding);
        setStringProperty(component, HTML.CELLSPACING_ATTR, _cellspacing);
        setStringProperty(component, HTML.DATAFLD_ATTR, _datafld);
        setStringProperty(component, HTML.DATASRC_ATTR, _datasrc);
        setStringProperty(component, HTML.DATAFORMATAS_ATTR, _dataformatas);
        setStringProperty(component, HTML.FRAME_ATTR, _frame);
        setStringProperty(component, HTML.RULES_ATTR, _rules);
        setStringProperty(component, HTML.SUMMARY_ATTR, _summary);
        setStringProperty(component, HTML.WIDTH_ATTR, _width);

        setStringProperty(component, JSFAttr.ENABLED_ON_USER_ROLE_ATTR, _enabledOnUserRole);
        setStringProperty(component, JSFAttr.VISIBLE_ON_USER_ROLE_ATTR, _visibleOnUserRole);
    }

    public void setLayout(String layout)
    {
        _layout = layout;
    }

    public void setHeaderClass(String headerClass)
    {
        _headerClass = headerClass;
    }

    public void setNavigationClass(String navigationClass)
    {
        _navigationClass = navigationClass;
    }

    public void setBodyClass(String bodyClass)
    {
        _bodyClass = bodyClass;
    }

    public void setFooterClass(String footerClass)
    {
        _footerClass = footerClass;
    }

    public void setHeaderStyle(String headerStyle)
    {
        _headerStyle = headerStyle;
    }

    public void setNavigationStyle(String navigationStyle)
    {
        _navigationStyle = navigationStyle;
    }

    public void setBodyStyle(String bodyStyle)
    {
        _bodyStyle = bodyStyle;
    }

    public void setFooterStyle(String footerStyle)
    {
        _footerStyle = footerStyle;
    }

    public void setAlign(String align)
    {
        _align = align;
    }

    public void setBgcolor(String bgcolor)
    {
        _bgcolor = bgcolor;
    }

    public void setBorder(String border)
    {
        _border = border;
    }

    public void setCellpadding(String cellpadding)
    {
        _cellpadding = cellpadding;
    }

    public void setCellspacing(String cellspacing)
    {
        _cellspacing = cellspacing;
    }

    public void setDatafld(String datafld)
    {
        _datafld = datafld;
    }

    public void setDatasrc(String datasrc)
    {
        _datasrc = datasrc;
    }

    public void setDataformatas(String dataformatas)
    {
        _dataformatas = dataformatas;
    }

    public void setFrame(String frame)
    {
        _frame = frame;
    }

    public void setRules(String rules)
    {
        _rules = rules;
    }

    public void setSummary(String summary)
    {
        _summary = summary;
    }

    public void setWidth(String width)
    {
        _width = width;
    }

    public void setEnabledOnUserRole(String enabledOnUserRole)
    {
        _enabledOnUserRole = enabledOnUserRole;
    }

    public void setVisibleOnUserRole(String visibleOnUserRole)
    {
        _visibleOnUserRole = visibleOnUserRole;
    }
}
