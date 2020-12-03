<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/template.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${ task != null }">
                <h2>■タスク編集</h2>
                <form action="<c:url value='/update' />" method="POST">
                    <c:import url="_form.jsp" />
                    <button type="submit">確定</button>
                </form>
                    <p><a href="#" onclick="confirmDestroy();">このタスクを削除</a></p>
                <form action="<c:url value='/delete' />" method="POST">
                    <input type="hidden" name="_token" value="${ _token }" />
                </form>
                <script>
                function confirmDestroy(){
                    if (confirm("本当に削除してもよろしいですか?")) {
                        document.forms[1].submit();
                    }
                }
                </script>
            </c:when>
            <c:otherwise>
                <p>お探しのページはみつかりませんでした。</p>
            </c:otherwise>
        </c:choose>
                <p><a href="<c:url value='/index' />">一覧に戻る</a></p>
        <p></p>
    </c:param>
</c:import>