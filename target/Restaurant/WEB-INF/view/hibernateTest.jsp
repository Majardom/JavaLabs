</html><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="property/messages"/>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title><fmt:message key="admin.title">ADMIN</fmt:message></title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
         <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="entity" items="${requestScope.entities}">
            <tr>
                <td scope="row">
                    ${entity.id}
                </td>
                <td>
                    ${entity.name}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </body>
</html>