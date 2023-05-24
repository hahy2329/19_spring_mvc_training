<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board detail</title>
</head>
<body> 
	
	<h3>게시글 상세조회</h3>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>${boardDTO.boardId }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${boardDTO.readCnt }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${boardDTO.writer }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><fmt:formatDate value="${boardDTO.enrollDt }" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${boardDTO.subject }</td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td>${boardDTO.content }</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정하기" onclick="location.href='${contextPath}/board/modifyBoard?boardId=${boardDTO.boardId}'">
				<input type="button" value="삭제하기" onclick="location.href='${contextPath}/board/removeBoard?boardId=${boardDTO.boardId}'">
				<input type="button" value="목록보기" onclick="location.href='${contextPath}/board/boardList'">
			</td>
		</tr>
	</table>
	
</body>
</html>