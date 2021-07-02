<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${result ==1}">
관리자님 환영합니다.
</c:if>

<c:if test="${result ==0}">
로그인 실패 <a href="/test/quiz1">돌아가기</a>
</c:if>

</body>
</html>