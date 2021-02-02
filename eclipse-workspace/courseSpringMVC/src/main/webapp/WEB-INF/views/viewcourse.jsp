<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<table class="formtable" border=1>
		<tr><td>연도</td><td>학기</td><td>교과목</td><td>교과구분</td><td>담당교수</td><td>학점</td></tr>
		<c:forEach var="viewcourse" items="${viewcourse}">
		<tr>
		<td class="label"><c:out value="${viewcourse.year}"/></td>
		<td class="label"><c:out value="${viewcourse.semester}"/></td>
		<td class="label"><c:out value="${viewcourse.title}"/></td>
		<td class="label"><c:out value="${viewcourse.classification}"/></td>
		<td class="label"><c:out value="${viewcourse.professor}"/></td>
		<td class="label"><c:out value="${viewcourse.grade}"/></td>
		</tr>
		</c:forEach>
		</table>
</body>
</html>