<%--
  Created by IntelliJ IDEA.
  User: hero_
  Date: 2022/3/30
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增学生信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>学生页面 —— 新增学生信息</small>
                </h1>
            </div>
        </div>
    </div>

    <hr>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/student/insert" method="post" >

                <div class="form-group">
                    <label class="col-sm-2 control-label">学号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required name="stuId">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required name="stuName">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required name="stuGender">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">宿舍</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required name="stuHome">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">专业</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required name="stuProfession">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required name="stuTel">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">地址</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" required name="stuAddress">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-info">提 交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>