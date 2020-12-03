<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/template.jsp">
    <c:param name = "content">
        <h2> ■タスク一覧</h2>
        <ul>
            <c:forEach var="task" items="${ tasks }">
               <li>
                    <c:out value="${ task.id }" /> &nbsp;>&nbsp;
                    <a href="<c:url value='/show' />?id=${ task.id }"><c:out value="${ task.content }" /></a>
               </li>
            </c:forEach>
        </ul>

        <p>
            <a href="${ pageContext.request.contextPath }/new">タスク追加</a>
        </p>
    </c:param>
</c:import>