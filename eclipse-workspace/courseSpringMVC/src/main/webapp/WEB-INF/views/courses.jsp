<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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
		<caption>학기별 이수현황</caption>
		<tr>
			<td>연도</td>
			<td>학기</td>
			<td>취득 학점</td>
			<td>상세보기</td>
		</tr>
		<c:set var="total" value="0" />
		<c:forEach var="course" items="${courses}">
			<tr>
				<td class="label"><c:out value="${course.year}" /></td>
				<td class="label"><c:out value="${course.semester}" /></td>
				<td class="label"><c:out value="${course.grade}" /></td>
				<td class="label"><a
					href="${pageContext.request.contextPath}/coursebysemester${course.year*course.semester}">상세보기
				</a></td>
				<c:set var="total" value="${total + course.grade}" />
			</tr>
		</c:forEach>
		<tr>
			<td class="label">총계</td>
			<td class="label">-</td>
			<td class="label"><c:out value="${total}" /></td>
			<td class="label">-</td>
		</tr>
	</table>
</body>
</html>