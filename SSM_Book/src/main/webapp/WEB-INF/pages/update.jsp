
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form name="deletebook" action="${pageContext.request.contextPath}/book/updateBook" method="post">
<%--    隐藏域--%>
         <input type="hidden" name="bookId" value="${qbook.bookId}">
    书名：<input type="text" name="bookName" required value="${qbook.bookName}"><br>
    数两：<input type="text" name="bookCounts" required value="${qbook.bookCounts}"><br>
    描述：<input type="text" name="detail" required value="${qbook.detail}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
