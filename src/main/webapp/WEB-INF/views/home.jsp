<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Upload/Download/Delete Documents</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>

    </c:if>

</div>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Documents</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Created</th>
                    <th>Author</th>
                    <th>Description</th>
                    <th>File</th>
                    <th width="100"></th>
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${documents}" var="doc" varStatus="counter">
                    <tr>
                        <td>${doc.id}</td>
                        <td>${doc.name}</td>
                        <td>${doc.created}</td>
                        <td>${doc.description}</td>
                        <td>${doc.file}</td>
                        <td><a href="<c:url value='/download-document-${user.id}-${doc.id}' />" class="btn btn-success custom-width">download</a></td>
                        <td><a href="<c:url value='/delete-document-${user.id}-${doc.id}' />" class="btn btn-danger custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="panel panel-default">

        <div class="panel-heading"><span class="lead">Upload New Document</span></div>
        <div class="uploadcontainer">
            <form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">

            <div class="row">
                    <%--<div class="form-group col-md-12">--%>
                    <%--<label class="col-md-3 control-lable" for="file">Upload a document</label>--%>
                    <%--<div class="col-md-7">--%>
                    <%--<form:input type="file" path="file" id="file" class="form-control input-sm"/>--%>
                    <%--<div class="has-error">--%>
                    <%--<form:errors path="file" class="help-inline"/>--%>
                    <%--</div>--%>
            </div>
        </div>
    </div>
    <div class="row">
            <%--<div class="form-group col-md-12">--%>
            <%--<label class="col-md-3 control-lable" for="description">Description</label>--%>
            <%--<div class="col-md-7">--%>
            <%--<form:input type="text" path="description" id="description" class="form-control input-sm"/>--%>
            <%--</div>--%>

    </div>
</div>

<div class="row">
    <div class="form-actions floatRight">
        <input type="submit" value="Upload" class="btn btn-primary btn-sm">
    </div>
</div>

</form:form>
</div>
</div>
</div>
</div>
</body>
</html>