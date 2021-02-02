<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>

<p><a href="${pageContext.request.contextPath}/courses"> 학기별 이수학점 조회 </a></p>
<p><a href="${pageContext.request.contextPath}/createcourse"> 수강신청하기 </a></p>
<p><a href="${pageContext.request.contextPath}/viewcourse"> 수강신청조회 메뉴 </a></p>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	<c:url var="logoutUrl" value="/logout"/>
	<form class="form-inline" action="${logoutUrl}" method="post">
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    </c:if>
</body>
</html>
