<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生列表</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/a.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style>
        table,th,td{
            text-align: center;
        }
    </style>
    <script>
        function activeli() {
            document.getElementsByName("a")
        }
    </script>
</head>
<body>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/queryStuServlet?pages=0" method="post">
        <div>
            <label for="xuehao">学号：</label><input type="text" name="xuehao" id="xuehao" value="${stu.xuehao}">
            <label for="stuName">姓名：</label><input type="text" name="stuName" id="stuName" value="${stu.stuName}">
            <label for="sex">性别：</label><input type="text" name="sex" id="sex" value="${stu.sex}">
            <button type="submit">查询</button>
            <button ><a href="html/addStu.jsp">新增</a></button>
        </div>
        <table style="margin: auto; width: 80%;" class="table table-bordered table-hover">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>电话</th>
                <th>qq邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach begin="0" end="4" items="${stulist}" var="stu" varStatus="s">
                <tr>
                    <td>${stu.xuehao}</td>
                    <td>${stu.stuName}</td>
                    <td>${stu.age}</td>
                    <td>${stu.sex}</td>
                    <td>${stu.tel}</td>
                    <td>${stu.qqEmail}</td>
                    <td>修改 / <a href="${pageContext.request.contextPath}/deleteStu?stuId=${stu.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.pages<=1}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${page.pages>1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/queryStuServlet?pages=${page.pages-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${page.countPage}" varStatus="s" var="i">
                    <c:if test="${page.pages==i}">
                        <li class="active"><a onclick="activeli()" href="${pageContext.request.contextPath}/queryStuServlet?pages=${s.count}">${s.count}</a></li>
                    </c:if>
                    <c:if test="${page.pages!=i}">
                        <li><a onclick="activeli()" href="${pageContext.request.contextPath}/queryStuServlet?pages=${s.count}">${s.count}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.pages>=page.countPage}">
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${page.pages<page.countPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/queryStuServlet?pages=${page.pages+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
            <span>总共${page.countClums}条数据</span>
            <span>，共${page.countPage}页</span>
        </nav>
    </form>
</div>

</body>
</html>
