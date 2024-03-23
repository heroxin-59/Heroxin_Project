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
    <!-- 引入 Bootstrap Jquery -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script>
        function del(stuName,stuId){
            if (confirm("您确定要删除 "+stuName+" 吗？")){
                location.href="${pageContext.request.contextPath}/student/delete/"+stuId;
            }
        }
        //禁用功能
        $(function () {
            $("ul.pagination li.disabled a").click(function () {
                return false;
            })
        });
    </script>
</head>
<body>
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>学生列表 —— 显示所有学生信息</small>
                    </h1>
                </div>
            </div>
        </div>

        <div  class="row">
            <div class="col-md-2 column"  >
                <a class="btn btn-info" href="${pageContext.request.contextPath}/student/toAdd">新增学生</a>
            </div>
            <div class="col-md-2 column clearfix" >
                <a class="btn btn-info" href="###">学生宿舍</a>
            </div>
            <div class="col-md-4 column " >
                <form class="form-inline " action="${pageContext.request.contextPath}/student/queryOne" method="post">
                    <div class="form-group ">
                        <input type="text" class="form-control" name="stuId" id="exampleInputEmail3" placeholder="请输入学生学号..." required >
                        <input type="submit"  class="btn btn-default" value="搜 索">
                    </div>
                </form>
            </div>
            <div class="col-md-2 column clearfix" ></div>
            <div class="col-md-2 column clearfix" ></div>
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

        <!-- 分页标签 -->
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-4">
                <nav class="pageDIV">
                    <ul class="pagination">
                        <%--跳到首页 这里做了判断 如果没有前一页 那么 跳到首页的这个标签是不可点击的 class="disabled" --%>
                        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if> >
                            <a href="${pageContext.request.contextPath}/student/queryAllPage?page.start=0">   <%-- 首页的开始数据的索引为0 点击后会发现地址栏变为 http://localhost:8080/DemoMVC/getlist?page.start=0  是作为参数显式传递的 --%>
                                <span> << </span>
                            </a>
                        </li>
                        <%--跳到前一页 同样做了判断 如果没有前一页 则不可点击前跳 class="disabled" --%>
                        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if> >
                            <a href="${pageContext.request.contextPath}/student/queryAllPage?page.start=${page.start-page.count}"> <%--当前页面数据索引 - 每页显示条数 = 上一页的第一条数据索引 --%>
                                <span> < </span>
                            </a>
                        </li>
                        <%--中间的分页  显示各页号--%>
                        <%-- begin:开始的元素 end:最后一个元素 varStatus:代表循环状态的变量名称 --%>
                        <%-- 比如我一共39条元素 共4页 第一页记为0 最后一页 4-1 =3  --%>
                        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                            <%-- 这部分解释下
                                 status.count：从1开始计数  1 2 3 4 ....39
                                 status.index：从0开始计数  0 1 2 3 ....38
                                 page.count:   每页数量
                                  -10 <= status.count*page.count-page.start<= 30
                                 显示当前页码的前两个和后两个就可，例如当前页码为3的时候，就显示 1 2 3(当前页) 4 5 的页码
                                 这里不理解没关系 一会儿会有图解
                             --%>
                            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                                <%-- status.index*page.count==page.start 判断是否是目前的这一页
                                     举例：status.index = 2  page.count = 10
                                           第一页 0  第二页 10  第三页 20   （数字指每页第一行的索引）
                                           如果现在在第三页 那么 2 * 10 = 20  条件成立
                                           class="disabled"  此页数的标签不可点击
                                           class="current"   此页数的标签颜色显示为灰色表示目前位置停留在此页 --%>
                                <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                                    <a href="${pageContext.request.contextPath}/student/queryAllPage?page.start=${status.index*page.count}"
                                       <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                                    >${status.count}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <%--跳到下一页 同样做了判断 如果没有下一页 则不可点击后跳 class="disabled" --%>
                        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                            <a href="${pageContext.request.contextPath}/student/queryAllPage?page.start=${page.start+page.count}">
                                <span> > </span>
                            </a>
                        </li>
                        <%--跳到尾页 如果没有后一页 那么 跳到尾页的这个标签是不可点击的 class="disabled" --%>
                        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                            <a href="${pageContext.request.contextPath}/student/queryAllPage?page.start=${page.last}">
                                <span> >> </span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-md-5"></div>
        </div>
    </div>
</body>
</html>
