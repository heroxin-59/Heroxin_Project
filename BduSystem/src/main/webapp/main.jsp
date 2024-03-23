<%--
  Created by IntelliJ IDEA.
  User: hero_
  Date: 2022/3/31
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row" style="margin-top: 100px">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/student/queryAllPage" class="btn btn-success">学生列表</a>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</body>
</html>
