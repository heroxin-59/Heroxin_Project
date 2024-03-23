<%--
  Created by IntelliJ IDEA.
  User: hero_
  Date: 2022/3/30
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function del(stuName,stuId){
            if (confirm("您确定要删除 "+stuName+" 吗？")){
                location.href="${pageContext.request.contextPath}/student/delete/"+stuId;
            }
        }
    </script>
</head>
<body>
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>学生页面 —— 显示所有学生信息</small>
                    </h1>
                </div>
            </div>
        </div>

        <div  class="row">
            <div class="col-md-2 column"  >
                <a class="btn btn-info" href="${pageContext.request.contextPath}/student/toAdd">新增学生</a>
            </div>
            <div class="col-md-8 column">
                <form class="form-inline " action="${pageContext.request.contextPath}/student/queryOne" method="post">
                    <div class="form-group ">
                        <input type="text" class="form-control" name="stuId" id="exampleInputEmail3" placeholder="请输入学生学号..." required >
                        <input type="submit"  class="btn btn-default" value="搜 索">
                    </div>
                </form>
            </div>
        </div>
        <hr>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>宿舍</th>
                            <th>专业</th>
                            <th>地址</th>
                            <th>联系方式</th>
                            <th>操作</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${studentList}" var="student">
                            <tr>
                                <td>${student.stuId}</td>
                                <td>${student.stuName}</td>
                                <td>${student.stuGender}</td>
                                <td>${student.stuHome}</td>
                                <td>${student.stuProfession}</td>
                                <td>${student.stuAddress}</td>
                                <td>${student.stuTel}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}/student/toUpdate/${student.stuId}">更改</a>
                                    <a onclick="del('${student.stuName}','${student.stuId}')" class="btn btn-danger">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
