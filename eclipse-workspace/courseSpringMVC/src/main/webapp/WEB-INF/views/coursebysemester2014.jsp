<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<table class="formtable" border=1>
	<caption>학기별 수강 내역</caption>
	<tr><td>연도</td><td>학기</td><td>교과목명</td><td>교과구분</td><td>담당교수</td><td>학점</td><td>링크</td></tr>
		<c:forEach var="course" items="${course}">
			<tr>
				<td class="label"><c:out value="${course.year}" /></td>
				<td class="label"><c:out value="${course.semester}" /></td>
				<td class="label"><c:out value="${course.title}" /></td>
				<td class="label"><c:out value="${course.classification}" /></td>
				<td class="label"><c:out value="${course.professor}" /></td>
				<td class="label"><c:out value="${course.grade}" /></td>
				<td class="label"><a href="${pageContext.request.contextPath}/">
						돌아가기 </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>