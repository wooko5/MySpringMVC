<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="course">
		<table class="formtable">
			<caption>수강신청</caption>
			<tr>
				<td class="label">교과목명:</td>
				<td><sf:input class="control" type="text" path="title" /><br />
					<sf:errors path="title" class="error" /></td>
			</tr>
			<tr>
				<td class="label">교과구분:</td>
				<td><sf:input class="control" type="text" path="classification" /><br />
					<sf:errors path="classification" class="error" /></td>
			</tr>
			<tr>
				<td class="label">담당교수:</td>
				<td><sf:input class="control" type="text" path="professor" /><br />
					<sf:errors path="professor" class="error" /></td>
			</tr>
			<tr>
				<td class="label">학점:</td>
				<td><sf:input class="control" type="text" path="grade" /><br />
					<sf:errors path="grade" class="error" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input type="submit" name="new proposal" /></td>
			</tr>
		</table>
	</sf:form>
</body>

</html>