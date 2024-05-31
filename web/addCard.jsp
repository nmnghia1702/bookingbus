<%-- 
    Document   : addCar
    Created on : Mar 12, 2024, 8:17:19 AM
    Author     : nmngh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add to cart</h1>
        <%
            String id = (String)request.getAttribute("id");
            User bookingUser = (User) request.getSession().getAttribute("name");
            if(id!=null){
        %>
        <form action="cart">
            
        <input type="hidden" id="busId" name="busId" value="<%=id%>">
        <input type="hidden" name="go" value="add">
        
        <label for="departureTime">Departure Time:</label>
        <input type="datetime-local" id="departureTime" name="departureTime">
        <%
            if(request.getAttribute("der")!=null){
            %>
            <p style="color: red"><%=request.getAttribute("der")%></p>
        <%
            }
        %>
        <br><br>

        <label for="arrivalTime">Arrival Time:</label>
        <input type="datetime-local" id="arrivalTime" name="arrivalTime">
        <%
            if(request.getAttribute("aer")!=null){
            %>
            <p style="color: red"><%=request.getAttribute("aer")%></p>
        <%
            }
        %>
        <br><br>

        <label for="departureLocation">Departure Location:</label>
        <input type="text" id="departureLocation" name="departureLocation"><br><br>

        <label for="arrivalLocation">Arrival Location:</label>
        <input type="text" id="arrivalLocation" name="arrivalLocation"><br><br>
        <%
            if(request.getAttribute("error")!=null){
            %>
            <p style="color: red"><%=request.getAttribute("error")%></p>
        <%
            }
        %>
        <input type="submit" value="Book">
        <%}%>
    </form>
    </body>
</html>
