<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增学生</title>
</head>
<body>
    <div style="text-align: center">
        <form action="../addServlet" method="post">
            <label for="xuehao">学号：</label><input type="text" name="xuehao" id="xuehao"><br>
            <label for="stuName">姓名：</label><input type="text" name="stuName" id="stuName"><br>
            <label for="age">年龄：</label><input type="text" name="age" id="age"><br>
            <label for="sex">性别：</label><input type="text" name="sex" id="sex"><br>
            <label for="tel">电话：</label><input type="text" name="tel" id="tel"><br>
            <label for="qqEmail">qq邮箱：</label><input type="text" name="qqEmail" id="qqEmail"><br>
            <input type="submit" value="添加">
        </form>
    </div>
</body>
</html>
