<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lvsong
  Date: 12/20/15
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<form method="post" action="<c:url value="/user.html"/>">
    <table>
        <tr>
            <td>账户名：</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
                <tr>
            <td>真实姓名：</td>
            <td><input type="text" name="realName"></td>
        </tr>
        <tr>
            <td>地址：所属国家</td>
            <td><input type="text" name="address.country"></td>
        </tr>
        <tr>
            <td>地址：所属街道</td>
            <td><input type="text" name="address.street"></td>
        </tr>
        <tr>
            <td>地址：所属房屋名称</td>
            <td><input type="text" name="address.house.name"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
