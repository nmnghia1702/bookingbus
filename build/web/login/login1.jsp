<%@page contentType="text/html" pageEncoding="UTF-8"%>
<span style="font-family: verdana, geneva, sans-serif;"><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Form | By Code Info</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div class="backgroud">
    <div class="login-box">
      
      <h2>Member Login</h2>
      <form action="login" method="post">
          <input type="text" name="user" placeholder="Username" />
          <input type="password" name="pass" placeholder="Password" />
          <input type="submit" value="Sign in" name="login">
      </form>
      <br />
      <%
      String error = "";
      if(request.getParameter("error")!=null){
        error = "Username or password is invalid";
      }
      %>
      <p style="color:red"><%=error%></p>
      <a href="#">Forgot Password?</a>
      
    </div>
    </div>
      
  </body>
</html></span>