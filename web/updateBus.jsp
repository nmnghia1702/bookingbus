<%-- 
    Document   : updateBus
    Created on : Mar 14, 2024, 1:44:18 PM
    Author     : nmngh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Bus"%>
<%@page import="model.DAOBus"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Update Bus</h2>
        <% 
           DAOBus dao = new DAOBus();
           Bus or = dao.getBusById((String)request.getAttribute("id"));
           if(or!=null){
        %>
        <form action="/ASM_PRJ/admin" method="post">
            <input type="hidden" name="busID" value="<%= or.getBusID() %>">
            <input type="hidden" name="go" value="bus">
            <label for="busNumber">Bus Number:</label>
            <input type="text" id="busNumber" name="busNumber" value="<%= or.getBusNumber() %>"><br>

            <label for="capacity">Capacity:</label>
            <input type="text" id="capacity" name="capacity" value="<%= or.getCapacity() %>"><br>

            <label for="type">Type:</label>
            <input type="text" id="type" name="type" value="<%= or.getType() %>"><br>

            <label for="driver">Driver:</label>
            <input type="text" id="driver" name="driver" value="<%= or.getDriver() %>"><br>

            <label for="imageUrl">Image Url:</label>
            <input type="text" id="imageUrl" name="imageUrl" value="<%= or.getImageUrl() %>"><br>

            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="<%= or.getPrice() %>"><br>
            <label for="price">Price Cart:</label>
            <input type="text" id="price" name="pricecart" value="<%= or.getPriceCart() %>"><br>
            <input type="submit" value="Cập nhật">
        </form>
        <%}%>
    </body>
</html>
