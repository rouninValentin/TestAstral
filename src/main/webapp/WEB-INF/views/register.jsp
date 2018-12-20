<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true"%>

<html>
<head>

    <title>Registration</title>

</head>
<body>
<jsp:include page="_menu.jsp" />
<form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
    <table align="center">
        <tr>
            <td>
                <form:label path="username">Username</form:label>
            </td>
            <td>
                <form:input path="username" name="username" id="username" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password</form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button id="register" name="register">Register</form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="welcomePage.jsp">Home</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
