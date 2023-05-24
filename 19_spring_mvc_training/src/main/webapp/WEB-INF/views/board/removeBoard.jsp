<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bDelete</title>
</head>
<body>

	<h3>게시글 삭제하기</h3>
	<form action="${contextPath }/board/removeBoard" method="post">
		<table border="1">
			<tr>
				<td>작성자</td>
				<td>${boardDTO.writer }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate value="${boardDTO.modifyDt }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${boardDTO.subject }</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="boardId" value="${boardDTO.boardId }">
					<input type="submit" value="삭제">
					<input type="button" onclick="location.href='${contextPath}/board/boardList'" value="목록보기">
					
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>