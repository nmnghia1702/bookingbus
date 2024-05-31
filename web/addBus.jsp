<%-- 
    Document   : addBus
    Created on : Mar 14, 2024, 12:25:09 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Enter Bus Information</h2>
        <form action="/ASM_PRJ/admin" method="post" enctype="multipart/form-data">
            <input type="hidden" name="go" value="addbus"/>
            <label for="busNumber">Bus Number:</label><br>
            <input type="text" id="busNumber" name="busNumber"><br>
            <% if(request.getAttribute("ber")!=null){ %>
            <h4 style="color: red"><%=request.getAttribute("ber")%></h4>
            <% } %>

            <label for="capacity">Capacity:</label><br>
            <input type="number" id="capacity" name="capacity"><br>
            <% if(request.getAttribute("cer")!=null){ %>
            <h4 style="color: red"><%=request.getAttribute("cer")%></h4>
            <% } %>

            <label for="type">Type:</label><br>
            <select id="type" name="type">
                <option value="Standard">Standard</option>
                <option value="Executive">Executive</option>
                <option value="Luxury">Luxury</option>
            </select><br>
            <% if(request.getAttribute("ter")!=null){ %>
            <h4 style="color: red"><%=request.getAttribute("ter")%></h4>
            <% } %>

            <label for="driver">Driver:</label><br>
            <input type="text" id="driver" name="driver"><br>
            <% if(request.getAttribute("der")!=null){ %>
            <h4 style="color: red"><%=request.getAttribute("der")%></h4>
            <% } %>

            <label for="imageUrl">Image:</label><br>
            <input type="file" id="imageUrl" name="imageUrl"><br>
            <% if(request.getAttribute("ier")!=null){ %>
            <h4 style="color: red"><%=request.getAttribute("ier")%></h4>
            <% } %>

            <label for="price">Price:</label><br>
            <input type="number" id="price" name="price"><br>
            <% if(request.getAttribute("per")!=null){ %>
            <h4 style="color: red"><%=request.getAttribute("per")%></h4>
            <% } %>
            <label for="price">Price Cart:</label><br>
            <input type="number" id="pricecart" name="pricecart"><br>
            

            <input type="submit" value="Submit">
        </form>
    </body>
</html>
