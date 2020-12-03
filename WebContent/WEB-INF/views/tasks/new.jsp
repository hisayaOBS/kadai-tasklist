<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/template.jsp">
    <c:param name="content">
        <h2>■タスク追加</h2>
        <p></p>
        <form action="<c:url value='/create' />" method="POST">
            <c:import url="_form.jsp" />
            <button type="submit">追加する</button>
        </form>
        <p><a href="<c:url value='/index' />">一覧に戻る</a></p>
        <p></p>
    </c:param>
</c:import>
