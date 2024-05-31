<%-- 
    Document   : admin
    Created on : Mar 13, 2024, 2:22:35 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.User"%>
<%@page import="entity.Order"%>
<%@page import="entity.Bus"%>
<%@page import="model.DAOUser"%>
<%@page import="model.DAOOrder"%>
<%@page import="model.DAOBus"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Control Panel</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/admin?go=logout">Logout</a>
        <form action="addBus.jsp">
            <input type="submit" value="Add Bus"/>
        </form>
        <% if(request.getAttribute("msBu")!=null){ %>
        <h4 style="color: red"><%=request.getAttribute("msBu")%></h4>
        <% } %>
        <a href="${pageContext.request.contextPath}/Cars.jsp">List Bus</a>
        <h2>Users</h2>
        <% if(request.getAttribute("msUs")!=null){ %>
        <h4 style="color: red"><%=request.getAttribute("msUs")%></h4>
        <% } %>
        <table>
            <tr>
                <th>User ID</th>
                <th>Username</th>
                <th>Role</th>
                <th>Phone Number</th>
                <th>Location ID</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <% 
                DAOUser dao = new DAOUser();
                ArrayList<User> list = dao.getData();
                for(User u : list){
            %>
            <tr>
                <td><%= u.getUserID() %></td>
                <td><%= u.getUsername() %></td>
                <td><%= u.getRole() %></td>
                <td><%= u.getPhoneNumber() %></td>
                <td><%= u.getLocationID() %></td>
                <td><a href="${pageContext.request.contextPath}/admin?go=updateUser&id=<%= u.getUserID()%>">update</a></td>
                <td><a href="${pageContext.request.contextPath}/admin?go=deleteUser&id=<%= u.getUserID()%>">delete</a></td>
            </tr>
            <% 
                }
            %>
        </table>

        <h2>Orders</h2>
        <% if(request.getAttribute("msOr")!=null){ %>
        <h4 style="color: red"><%=request.getAttribute("msOr")%></h4>
        <% } %>
        <table>
            <tr>
                <th>Order ID</th>
                <th>User ID</th>
                <th>Schedule ID</th>
                <th>Order Date</th>
                <th>Status</th>
                <th>Price</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <% 
                DAOOrder daoOr = new DAOOrder();
                ArrayList<Order> listOr = daoOr.getData();
                for(Order o : listOr){
            %>
            <tr>
                <td><%= o.getOrderID() %></td>
                <td><%= o.getUserID() %></td>
                <td><%= o.getScheduleID() %></td>
                <td><%= daoOr.getOrderDate(o.getOrderDate()) %></td>
                <td><%= o.getStatus() %></td>
                <td><%= o.getPrice() %></td>
                <td><a href="${pageContext.request.contextPath}/admin?go=updateOrder&id=<%=o.getOrderID()%>">update</a></td>
                <td><a href="${pageContext.request.contextPath}/admin?go=deleteOrder&id=<%=o.getOrderID()%>">delete</a></td>
            </tr>
            <% 
                }
            %>
        </table>
        <h2>Bus</h2>
        <% if(request.getAttribute("msBus")!=null){ %>
        <h4 style="color: red"><%=request.getAttribute("msBus")%></h4>
        <% } %>
        <table>
            <tr>
                <th>Bus ID</th>
                <th>Bus Number</th>
                <th>Capacity</th>
                <th>Type</th>
                <th>Driver</th>
                <th>ImageUrl</th>
                <th>Price</th>
                <th>PriceCart</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <% 
                DAOBus daoBu = new DAOBus();
                ArrayList<Bus> listBu = daoBu.getData("select * from Bus");
                for(Bus o : listBu){
            %>
            <tr>
                <td><%= o.getBusID() %></td>
                <td><%= o.getBusNumber() %></td>
                <td><%= o.getCapacity() %></td>
                <td><%= o.getType() %></td>
                <td><%= o.getDriver() %></td>
                <td><%= o.getImageUrl() %></td>
                <td><%= o.getPrice() %></td>
                <td><%= o.getPriceCart() %></td>
                <td><a href="${pageContext.request.contextPath}/admin?go=updateBus&id=<%=o.getBusID()%>">update</a></td>
                <td><a href="${pageContext.request.contextPath}/admin?go=deleteBus&id=<%=o.getBusID()%>">delete</a></td>
            </tr>
            <% 
                }
            %>
        </table>
    </body>
</html>
