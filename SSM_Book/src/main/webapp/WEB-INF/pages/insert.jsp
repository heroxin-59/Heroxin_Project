<%--
  Created by IntelliJ IDEA.
  User: hero_
  Date: 2022/3/29
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insert</title>
</head>
<body>

<form name="insertbook" action="${pageContext.request.contextPath}/book/addbook" method="post">
    书名：<input type="text" name="bookName" required><br>
    数两：<input type="text" name="bookCounts" required><br>
    描述：<input type="text" name="detail" required><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
