<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>

<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">

    <a href="${pageContext.request.contextPath}/welcome">Home</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/note">NOTE</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/admin">Admin</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/register">Registration</a>

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        | &nbsp;
        <a href="${pageContext.request.contextPath}/logout">Logout</a>

    </c:if>

</div>