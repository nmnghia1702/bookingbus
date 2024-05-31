<%-- 
    Document   : login
    Created on : Mar 12, 2024, 7:45:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form | By Code Info</title>
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="backgroud">
            <div class="login-box">

                <h2>Member Login</h2>
                <form action="/ASM_PRJ/login" method="post">
                    <input type="text" name="user" placeholder="Username" />
                    <input type="password" name="pass" placeholder="Password" />
                    <input type="submit" value="Sign in" name="login">
                </form>
                <br />
                <%
                String error = "";
                if(request.getParameter("error")!=null){
                  String go = request.getParameter("error").trim();
                  if(go.equals("invalid")){
                    error = "Username or password invalid";
                  }
                  if(go.equals("logout")){
                    error = "Logout succesfully";
                  }
                }
                %>
                <p style="color:red"><%=error%></p>
                <a href="#">Forgot Password?</a>

            </div>
        </div>
    </body>
</html>
