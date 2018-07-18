<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1"  align="center" width="88%">
		<tr>
			<th>ID</th>
			<th>图片</th>
			<th>商品名</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>描述</th>
		</tr>
		<c:forEach items="${list }" var="p">
			<tr>
				<td width="2%">${p.pid}</td>
				<td width="8%"><img src="${pageContext.request.contextPath}/${p.pimage}" width="80"></td>
				<td width="8%">${p.pname}</td>
				<td width="8%">${p.market_price}</td>
				<td width="8%">${p.shop_price}</td>
				<td>${p.pdesc}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>