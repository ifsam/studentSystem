<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件     -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" action="${pageContext.request.contextPath}/loginServlet" method="post" >
    <div class="form-group">
        <label for="userName" class="col-sm-2 control-label">姓名：</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="userName" name="userName" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <label for="passWord" class="col-sm-2 control-label">密码：</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="passWord" id="passWord" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <label for="checkCode" class="col-sm-2 control-label">验证码：</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="checkCode" name="checkCode" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
    <span>${login_msg}</span>
</form>
</body>
</html>
