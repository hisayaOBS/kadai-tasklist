<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/template.jsp">
    <c:param name="content">
<c:choose>
    <c:when test="${ task != null }">
    <h2>■タスク詳細</h2>
        <table>
            <tr>
                <th>タスク</th>
                <td>${ task.content }</td>
            </tr>
            <tr>
                <th>作成日時</th>
                <td><fmt:formatDate value="${ task.created_at }" pattern="yyyy-MM-dd HH:mm" /></td>
            </tr>
            <tr>
                <th>更新日時</th>
                <td><fmt:formatDate value="${ task.updated_at }" pattern="yyyy-MM-dd HH:mm" /></td>
            </tr>
        </table>
        <p><a href="<c:url value='/edit' />?id=${ task.id }">編集する</a></p>
        <p><a href=""></a></p>
        <p><a href="<c:url value='/index' />">一覧に戻る</a></p>
        <p></p>
    </c:when>

    <c:otherwise>
        <p>お探しのデータは見つかりませんでした。</p>
        <p><a href="<c:url value='/index' />">一覧に戻る</a></p>
        <p></p>
    </c:otherwise>
</c:choose>

    </c:param>
</c:import>
