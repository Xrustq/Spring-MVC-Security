<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Documents Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
    </h2>
</c:if>

<br/>
<br/>

<h1>Document list</h1>

    <table class="tg">
        <tr>
            <th width="80"><a href="<c:url value="/documents"/>">ID</a></th>
            <th width="120"><a href="<c:url value="/documents/sortByName"/>">Name</a></th>
            <th width="120"><a href="<c:url value="/documents/sortByCreated"/>">Created</a></th>
            <th width="120"><a href="<c:url value="/documents/sortByAuthor"/>">Author</a></th>
            <th width="120"><a href="<c:url value="/documents/sortByDescription"/>">Description</a></th>
            <th width="60">Download</th>
            <th width="60">Delete</th>
        </tr>
    <c:if test="${!empty listDocumentsById}">
        <c:forEach items="${listDocumentsById}" var="document">
            <tr>
                <td>${document.id}</td>
                <td>${document.name}</td>
                <td>${document.created}</td>
                <td>${document.author}</td>
                <td>${document.description}</td>
                <td><a href="<c:url value='/download/${document.id}'/>">Download</a></td>
                <td><a href="<c:url value='/remove/${document.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </c:if>
        <c:if test="${!empty listDocumentsByName}">
            <c:forEach items="${listDocumentsByName}" var="document">
                <tr>
                    <td>${document.id}</td>
                    <td>${document.name}</td>
                    <td>${document.created}</td>
                    <td>${document.author}</td>
                    <td>${document.description}</td>
                    <td><a href="<c:url value='/download/${document.id}'/>">Download</a></td>
                    <td><a href="<c:url value='/remove/${document.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${!empty listDocumentsByCreated}">
            <c:forEach items="${listDocumentsByCreated}" var="document">
                <tr>
                    <td>${document.id}</td>
                    <td>${document.name}</td>
                    <td>${document.created}</td>
                    <td>${document.author}</td>
                    <td>${document.description}</td>
                    <td><a href="<c:url value='/download/${document.id}'/>">Download</a></td>
                    <td><a href="<c:url value='/remove/${document.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${!empty listDocumentsByAuthor}">
            <c:forEach items="${listDocumentsByAuthor}" var="document">
                <tr>
                    <td>${document.id}</td>
                    <td>${document.name}</td>
                    <td>${document.created}</td>
                    <td>${document.author}</td>
                    <td>${document.description}</td>
                    <td><a href="<c:url value='/download/${document.id}'/>">Download</a></td>
                    <td><a href="<c:url value='/remove/${document.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${!empty listDocumentsByDescription}">
            <c:forEach items="${listDocumentsByDescription}" var="document">
                <tr>
                    <td>${document.id}</td>
                    <td>${document.name}</td>
                    <td>${document.created}</td>
                    <td>${document.author}</td>
                    <td>${document.description}</td>
                    <td><a href="<c:url value='/download/${document.id}'/>">Download</a></td>
                    <td><a href="<c:url value='/remove/${document.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

<h1>Add a Document</h1>

<c:url var="addAction" value="/documents/add"/>

<form:form action="${addAction}?${_csrf.parameterName}=${_csrf.token}"
           commandName="document" id="fileupload" method="post" enctype="multipart/form-data">
    <input hidden type="file" name="file" id="file" >
    <table>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>

                <c:if test="${empty document.name}">
                    <input type="submit" value="<spring:message text="Add Document"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
