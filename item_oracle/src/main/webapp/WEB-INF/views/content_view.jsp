<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="item_write">
		<table style="width: 600px" border="1">
			<tr>
				<td width="40%">상품명</td>
				<td width="30%">가격</td>
				<td width="30%">설명</td>
			</tr>
			<c:forEach items="${list }" var="itemDto">
				<tr>
					<td>${itemDto.name }</td>
					<td>${itemDto.price }</td>
					<td>${itemDto.description }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3" align="right">
					<button type="submit">입력하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>