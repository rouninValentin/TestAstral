<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false"%>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<jsp:include page="_menu.jsp" />
<h1>${message}</h1>
</body>
</html>
