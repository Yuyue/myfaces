<%@ page session="false"
%><%@ taglib uri="/WEB-INF/myfaces_basic.tld" prefix="f"
%><%@ taglib uri="/WEB-INF/myfaces_ext.tld" prefix="x"
%><html>

<!--
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
//-->

<head>
  <meta HTTP-EQUIV="Content-Type" CONTENT="text/html;CHARSET=iso-8859-1">
  <title>Simple Country List</title>
  <Link rel="stylesheet" type="text/css" href="css/basic.css">
</head>

<body>

<jsp:useBean id="countryList" class="net.sourceforge.myfaces.example.model.SimpleCountryList" scope="request" />

<f:use_faces>

    <table border="1"><tr>
        <td valign="top" width="140"><%@ include file="inc/navigation.jsp"  %></td>
        <td align="left" width="640" valign="top">
            <br>

            <f:errors id="errors" />

            <% int rows = 0, cols = 2; %>
            <f:list id="countryList"
                    style="standardTable"
                    headerClass="standardTable_Header"
                    footerClass="standardTable_Footer"
                    rowClasses="standardTable_Row1,standardTable_Row2"
                    columnClasses="standardTable_Column,standardTable_ColumnCentered" >
                <!-- HEADER -->
                <f:group id="header" >
                    <f:output_text id="header.name" text="Country name" />
                    <f:output_text id="header.isoCode" text="Iso-Code" />
                </f:group>
                <!-- DATA -->
                <f:listrow id="countryList.tr" var="country" modelReference="countryList.countries" >
                    <f:output_text id="countryList.name" modelReference="country.name" />
                    <f:group id="g1" >
                        <a href="#"><f:output_text id="countryList.isoCode" modelReference="country.isoCode" /></a>
                        <% rows++; %>
                    </f:group>
                </f:listrow>
                <!-- FOOTER -->
                <f:group id="footer" >
                    <f:output_text id="footer.1" text="take a look at this runtime values ..."/>
                    <f:group id="g2" >
                        <f:message id="row_count" msg="{0} rows" >
                            <f:param id="rows" value="<%=new Integer(rows)%>"/>
                        </f:message>
                        &nbsp; / &nbsp;
                        <f:message id="col_count" msg="{0} cols" >
                            <f:param id="cols" value="<%=new Integer(cols)%>"/>
                        </f:message>
                    </f:group>
                </f:group>
            </f:list>
            <br>

            <!-- TODO grid does not work anymore -->
            <f:grid id="grid"
                    columns="2"
                    style="standardTable"
                    headerClass="standardTable_Header"
                    footerClass="standardTable_Footer"
                    rowClasses="standardTable_Row1,standardTable_Row2" >
                <f:output_text id="grid.text1" text="Grid Header Column 1" />
                <f:output_text id="grid.text2" text="Grid Header Column 2" />
                <f:output_text id="grid.text3" text="row1" />
                <f:output_text id="grid.text4" text="row1" />
                <f:output_text id="grid.text5" text="row2" />
                <f:output_text id="grid.text6" text="row2" />
                <f:output_text id="grid.text7" text="footer" />
                <f:output_text id="grid.text8" text="footer" />
            </f:grid>

        </td>
    </tr></table>

</f:use_faces>

</body>

</html>