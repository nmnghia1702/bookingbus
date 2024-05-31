<%-- 
    Document   : updateUser
    Created on : Mar 13, 2024, 2:47:41 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.User"%>
<%@page import="model.DAOUser"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Update User</h2>
        <%
            DAOUser dao = new DAOUser();
           User or = dao.getUserById((String)request.getAttribute("id"));
           ResultSet rsUs = (ResultSet) request.getAttribute("rsUs");
           if(or!=null){
        %>
        <form method="post" action="/ASM_PRJ/admin">
            <input type="hidden" name="userId" value="<%= or.getUserID() %>">
            <input type="hidden" name="go" value="user">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%= or.getUsername() %>"><br>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" value="<%= or.getPassword() %>"><br>
            <label for="role">Role:</label>
            <select id="role" name="role">
                <option value="admin" <%= or.getRole().equals("admin") ? "selected" : "" %>>Admin</option>
                <option value="customer" <%= or.getRole().equals("customer") ? "selected" : "" %>>Customer</option>
                <option value="staff" <%= or.getRole().equals("staff") ? "selected" : "" %>>Staff</option>
            </select><br>
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="<%= or.getPhoneNumber() %>"><br>
            Location ID:<select id="role" name="locationId">
                <%
                while(rsUs.next()){
                %>
                <option value="<%=rsUs.getString(1)%>"><%=rsUs.getString(2)%></option>
                <%
                    }
                %>
            </select><br>
            <input type="submit" value="Update">
        </form>
        <% 
        }
        %>
    </body>
</html>
