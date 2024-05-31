<%-- 
    Document   : updateOrder
    Created on : Mar 13, 2024, 2:47:47 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Order"%>
<%@page import="model.DAOOrder"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Update Order</h2>
        <% 
           DAOOrder dao = new DAOOrder();
           Order or = dao.getOrderById((String)request.getAttribute("id"));
           if(or!=null){
        %>
        <form action="/ASM_PRJ/admin" method="post">
            
            <input type="hidden" name="orderID" value="<%= or.getOrderID() %>">
            <input type="hidden" name="go" value="order">
            UserID: <input type="text" name="userID" value="<%= or.getUserID() %>"><br>
            ScheduleID: <input type="text" name="scheduleID" value="<%= or.getScheduleID() %>"><br>
            OrderDate: <input type="datetime-local" name="orderDate" value="<%= or.getOrderDate() + ":00" %>"><br>
            <label for="status">Status:</label>
            <select name="status" id="status">
                <option value="Confirmed" <%= or.getStatus().equals("Confirmed") ? "selected" : "" %>>Confirmed</option>
                <option value="Paid" <%= or.getStatus().equals("Paid") ? "selected" : "" %>>Paid</option>
            </select>
            <br>
            Price: <input type="number" name="price" value="<%= or.getPrice() %>"><br>
            PriceCart: <input type="number" name="pricecart" value="<%= or.getPriceCart() %>"><br>
            <input type="submit" value="Update">
        </form>
        <% 
            }
        %>
    </body>
</html>
