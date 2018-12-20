<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page session="false"%>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h3 style="color:red;">${message}</h3>
</body>
</html>