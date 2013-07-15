<%@ include file="/WEB-INF/template/include.jsp" %>
<%@ include file="/WEB-INF/template/header.jsp" %>

<openmrs:htmlInclude file="/moduleResources/muzimaform/styles/custom/custom.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimaform/styles/bootstrap/css/bootstrap.css"/>

<openmrs:htmlInclude file="/moduleResources/muzimaform/js/jquery/jquery.js" />

<openmrs:htmlInclude file="/moduleResources/muzimaform/js/angular/angular.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimaform/js/angular/angular-resource.js"/>

<openmrs:htmlInclude file="/moduleResources/muzimaform/js/custom/app.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimaform/js/custom/controller.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimaform/js/custom/truncate.js"/>

<openmrs:htmlInclude file="/moduleResources/muzimaform/js/ui-bootstrap/ui-bootstrap-custom-tpls-0.4.0.js"/>

<h3><spring:message code="muzimaform.view"/></h3>
<div class="bootstrap-scope" ng-app="muzimaform">
    <div ng-view ></div>
</div>

<%@ include file="/WEB-INF/template/footer.jsp" %>

