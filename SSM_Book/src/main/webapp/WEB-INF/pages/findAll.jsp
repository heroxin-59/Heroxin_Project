<%--
  Created by IntelliJ IDEA.
  User: hero_
  Date: 2022/3/27
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有书籍</title>
    <script>
        function del(bookId){
            if (confirm("您确定要删除？")){
                location.href = "${pageContext.request.contextPath}/book/del/"+bookId;
            }
        }
    </script>
</head>
<body>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>书名</th>
            <th>数量</th>
            <th>描述</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.bookCounts}</td>
            <td>${book.detail}</td>
            <td onclick="del('${book.bookId}')">删除</td>
            <td><a  href="${pageContext.request.contextPath}/book/toUpdateBook/${book.bookId}" >修改</a></td>
        </tr>
        </c:forEach>
        <tr >
            <td>
                <a href="${pageContext.request.contextPath}/book/toAddBook">添加一本书</a>
            </td>
        </tr>
    </table>
</body>
</html>
