<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.sourceforge.net/tld/myfaces_ext_0_9.tld" prefix="x"%>
<x:panelNavigation id="nav"
              styleClass="navigation"
              separatorClass="navseparator"
              itemClass="navitem"
              activeItemClass="navitem_active"
              openItemClass="navitem_open"   >
    <x:commandNavigation id="nav_1" value="#{example_messages['nav_Home']}" action="go_home" />
    <x:commandNavigation id="nav_2" value="#{example_messages['nav_Examples']}" >
        <x:commandNavigation id="nav_2_1" value="#{example_messages['nav_Sample_1']}" action="go_sample1" />
        <x:commandNavigation id="nav_2_2" value="#{example_messages['nav_Sample_2']}" action="go_sample2" />
        <x:commandNavigation id="nav_2_3" value="#{example_messages['nav_Components']}" >
            <x:commandNavigation id="nav_2_3_1" value="#{example_messages['nav_dataTable']}" action="go_dataTable" />
            <x:commandNavigation id="nav_2_3_2" value="#{example_messages['nav_sortTable']}" action="go_sortTable" />
            <x:commandNavigation id="nav_2_3_3" value="#{example_messages['nav_Selectbox']}" action="go_selectbox" />
            <x:commandNavigation id="nav_2_3_4" value="#{example_messages['nav_FileUpload']}" action="go_fileupload" />
            <x:commandNavigation id="nav_2_3_5" value="#{example_messages['nav_TabbedPane']}" action="go_tabbedPane" />
            <x:commandNavigation id="nav_2_3_6" value="#{example_messages['nav_Calendar']}" action="go_calendar" />
            <x:commandNavigation id="nav_2_3_7" value="#{example_messages['nav_dataList']}" action="go_dataList" />
        </x:commandNavigation>
    </x:commandNavigation>
    <x:commandNavigation id="nav_3" value="#{example_messages['nav_Documentation']}" >
        <x:commandNavigation id="nav_3_1" value="#{example_messages['nav_Features']}" action="go_features"/>
    </x:commandNavigation>
    <x:commandNavigation id="nav_4" value="#{example_messages['nav_Options']}" action="go_options" />
    <f:verbatim>&nbsp;</f:verbatim>
    <x:commandNavigation id="nav_5" value="#{example_messages['nav_Info']}" >
        <x:commandNavigation id="nav_5_1" value="#{example_messages['nav_Contact']}" action="go_contact" />
        <x:commandNavigation id="nav_5_2" value="#{example_messages['nav_Copyright']}" action="go_copyright" />
    </x:commandNavigation>
</x:panelNavigation>
