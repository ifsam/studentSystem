<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <link rel="stylesheet" href="./css/a.css">
  <body>
  <span style="float: right;">欢迎${user.userName}回来！</span>
  <h1 style="text-align: center;"><a href="${pageContext.request.contextPath}/showAllStuServlet">点击查询所有学生信息</a></h1>
  </body>
</html>
