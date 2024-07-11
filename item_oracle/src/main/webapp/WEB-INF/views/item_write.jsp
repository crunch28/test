<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="write_result">
		<table>
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<td>설명</td>
				<td>
					<input type="text" name="description">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">전송</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>