<%@ page import="java.util.Random"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.sourceforge.net/tld/myfaces_ext_0_9.tld" prefix="x"%>
<html>

<%@include file="inc/head.inc" %>

<!--
/*
 * Copyright 2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//-->

<body>

<f:view>

    <f:loadBundle basename="net.sourceforge.myfaces.examples.resource.example_messages" var="example_messages"/>

    <x:saveState value="#{fileUploadForm.name}"/>

    <x:panelLayout id="page" layout="#{globalOptions.pageLayout}"
            styleClass="pageLayout"
            headerClass="pageHeader"
            navigationClass="pageNavigation"
            bodyClass="pageBody"
            footerClass="pageFooter" >

        <f:facet name="header">
            <f:subview id="header">
                <jsp:include page="inc/page_header.jsp" />
            </f:subview>
        </f:facet>

        <f:facet name="navigation">
            <f:subview id="menu" >
                <jsp:include page="inc/navigation.jsp" />
            </f:subview>
        </f:facet>

        <f:facet name="body">
            <h:panelGroup id="body">

                <h:messages id="messageList" showSummary="true" showDetail="true" />

                <f:verbatim>
                    <h4>Date input tag</h4>
                </f:verbatim>

                    <h:form>
                        <f:verbatim><p></f:verbatim>
	                        <h:outputText value="Gimme a date: "/> <h:message for="date1"/>
	                        <x:inputDate id="date1" value="#{date1}"/>
	                        <f:verbatim><br></f:verbatim>
	                        <h:outputText value="Date is: #{date1}"/> <%-- TODO : print date part only --%>
                        <f:verbatim></p></f:verbatim>
                        
                        <h:outputText value="Gimme a time: "/>
	                        <x:inputDate id="date2" value="#{date2}" type="time"/> <h:message for="date2"/>
	                        <f:verbatim><br></f:verbatim>
	                        <h:outputText value="Time is: #{date2}"/> <%-- TODO : print time part only --%>
                        <f:verbatim></p></f:verbatim>
                        
                        <h:outputText value="Gimme a date & time: "/>
	                        <x:inputDate id="date3" value="#{date3}" type="both"/> <h:message for="date3"/>
	                        <f:verbatim><br></f:verbatim>
	                        <h:outputText value="Date time is: #{date3}"/>
                        <f:verbatim></p></f:verbatim>

                        <h:commandButton value="Update texts"/>
                    </h:form>

            </h:panelGroup>
        </f:facet>

        <%@include file="inc/page_footer.jsp" %>

    </x:panelLayout>

</f:view>

</body>

</html>