<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>Task List</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>ToDo アプリケーション</h1>
            </div>
            <div id="content">
                ${param.content }
            </div>
            <div id="footer">
                <small>(c) Hisaya Miyoshi. since 2020/12/03</small>
            </div>
        </div>
    </body>
</html>