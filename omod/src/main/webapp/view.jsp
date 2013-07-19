<%@ include file="/WEB-INF/template/include.jsp" %>
<%@ include file="/WEB-INF/template/header.jsp" %>

<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/styles/custom/custom.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/styles/bootstrap/css/bootstrap.css"/>

<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/js/jquery/jquery.js"/>

<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/js/angular/angular.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/js/angular/angular-resource.js"/>

<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/js/custom/app.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/js/custom/controller.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/js/custom/truncate.js"/>

<openmrs:htmlInclude file="/moduleResources/muzimapreferredform/js/ui-bootstrap/ui-bootstrap-custom-tpls-0.4.0.js"/>

<h3><spring:message code="muzimapreferredform.view"/></h3>

<div class="bootstrap-scope" ng-app="muzimaPreferredForm">
    <div ng-view></div>
</div>

<%@ include file="/WEB-INF/template/footer.jsp" %>

