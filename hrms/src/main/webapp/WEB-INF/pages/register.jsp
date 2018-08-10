<%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/6/22
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <script>
        function checkName() {
            //1，创建核心对象
            var xmlHttp = new XMLHttpRequest();
            //2,打开连接
            // xmlHttp.open("GET","check?name="+document.getElementById('uname').value,true);
            //3,发送数据
            //xmlHttp.send();

            xmlHttp.open("post","checkName",true);
            //g告知服务该请求携带了参数
            xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xmlHttp.send("name="+document.getElementById("uname").value);

            //4,服务器状态改变 触发事件  回调函数
            xmlHttp.onreadystatechange=function () {
                if (xmlHttp.readyState==4&&xmlHttp.status==200){
                    document.getElementById("sp").innerHTML=xmlHttp.responseText;
                    document.getElementById("sp").style.color="red";
                }
            }
        }
    </script>
    <script type="text/javascript">
        function check() {
            if (document.getElementById('uname').value==""){
                alert('请输入账号！');
                document.getElementById('uname').focus();
                return false;
            }
            if (document.getElementById('pass').value==""){
                alert('请输入密码！');
                document.getElementById('pass').focus();
                return false;
            }
            return true;
        }
    </script>
    <style>
        #div1{
            margin-left: auto;
            margin-right: auto;
            margin-top: 100px;
            padding-top: 100px;
            background-image: url("/pic/register.jpg");
            width: 800px;
            height: 400px;
            text-align: center;
        }
    </style>
</head>
<body>
<br/>
<br/>
<jsp:include page="/head.jsp"></jsp:include>
<br/>
<div id="div1">
<form action="register" method="post" onsubmit="return check()">
    账号：<input type="text" name="name" id="uname" onblur="checkName()"/><span id="sp"></span><br/>
    <%--账号：<input id="name" type="text" name="name"/><br/>--%>
    密码：<input id="pass" type="password" name="pass" /><br/>
    <input type="submit" value="注册">
</form>
<span>${regerror}</span>
</div>
</body>
</html>
