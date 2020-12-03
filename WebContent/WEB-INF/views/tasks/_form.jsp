<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ errors != null }">
    <ul>
        <c:forEach var="error" items="${ errors }" >
            <li>${ error }</li>
        </c:forEach>
    </ul>
</c:if>

<label for="content">&nbsp;・</label>
<input type="text" id="content" name="content" value="${ task.content }"/>
<!-- リクエストスコープのトークンは新たにリクエストを発行すると消滅するので、再設定 -->
<input type="hidden" name="_token" value="${ _token }" />


