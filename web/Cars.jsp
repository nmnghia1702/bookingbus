<%-- 
    Document   : Cars
    Created on : Mar 12, 2024, 5:09:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Bus"%>
<%@page import="entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DAOBus"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cars</title>
        <link rel="icon" href="images/favicon.ico">
        <link rel="shortcut icon" href="images/favicon.ico" />
        <link rel="stylesheet" href="css/touchTouch.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-migrate-1.2.1.js"></script>
        <script src="js/script.js"></script>
        <script src="js/superfish.js"></script>
        <script src="js/jquery.ui.totop.js"></script>
        <script src="js/jquery.equalheights.js"></script>
        <script src="js/jquery.mobilemenu.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/touchTouch.jquery.js"></script>
        <script>
            $(document).ready(function () {
                $().UItoTop({easingType: 'easeOutQuart'});
                $('.gallery a.gal').touchTouch();
            });
        </script>

        <link rel="stylesheet" href="css/listBus.css">
    </head>
    <body class="" id="top">
        <%
            String sql = "select * from Bus";
            if(request.getParameter("ms")!=null){
                sql+=" where Type='"+request.getParameter("ms")+"'";
            }
            DAOBus dao = new DAOBus();
            ArrayList<Bus> listBus = dao.getData(sql);
        %>
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <div class="menu_block ">
                    <div class="container_12">
                        <div class="grid_12">
                            <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                                <ul class="sf-menu">
                                    <li><a href="jspForHome.jsp">Home</a></li>
                                    <li><a href="index-1.jsp">About</a></li>
                                    <li><a  href="Cars.jsp">Cars</a>

                                    </li>
                                    <li><a href="index-3.jsp">Services</a></li>
                                    <li><a href="index-4.jsp">Contacts</a></li>
                                    <li><a href="/ASM_PRJ/login">Login</a></li>
                                        <%
                                            if(request.getSession().getAttribute("name")!=null){
                                        %>
                                    <li><a href="${pageContext.request.contextPath}/login?go=logout">Logout</a></li>
                                    <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
                                        <%}%>
                                </ul>
                            </nav>
                            <div class="clear"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="container_12">
                    <div class="grid_12">
                        <h1>
                            <a href="jspForHome.jsp">
                                <img src="images/logo.png" alt="Your Happy Family">
                            </a>
                        </h1>
                    </div>
                </div>
                <div class="clear"></div>
            </header>
            <!--==============================Content=================================-->



            <%
            if(request.getParameter("add")!=null){
            %>
            <h3 style="color: red">Add to cart succesfully</h3>
            <%
            }
            %>
            <% if(request.getAttribute("MS")!=null){ %>
            <h4 style="color: red"><%=request.getAttribute("MS")%></h4>
            <% } %>
            <div class="container mt-5 mb-5"  style="padding-left: 20px; padding-bottom: 30px ; padding-top: 20px">
                <div class="d-flex justify-content-center row">
                    <div class="col-md-10">
                        <%
                        if(listBus.size()>=1){
                            for (Bus bus : listBus) {
                            String imageUrl = bus.getImageUrl();
                        %>
                        <div class="row p-2 bg-white border rounded" style="padding-bottom: 30px">
                            <div class="col-md-3 mt-1" style="width: 1000px; height: auto; border: 2px solid black; "><img class="img-fluid img-responsive rounded product-image" src="${pageContext.request.contextPath}<%=imageUrl%>"></div>

                            <div class="col-md-6 mt-1">

                                <div class="mt-1 mb-1 spec-1"><span></span></div>
                                <div class="mt-1 mb-1 spec-1"><span>Type: <%=bus.getType()%></span><span class="dot"></span><span>Driver: <%=bus.getDriver()%></span><span class="dot"></span><span>Bus number: <%=bus.getBusNumber()%></span>
                                </div>
                                <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                                    <div class="d-flex flex-row align-items-center">
                                        
                                        <h4 class="mr-1"><%=Float.parseFloat(bus.getPrice())*(100 - Float.parseFloat(bus.getPriceCart()))/100%> per day</h4>
                                     
                                        <span class="strike-text"><%=bus.getPrice()%></span>
                                        <span>Discount:<%=bus.getPriceCart()%>%</span>
                                    </div>
                                    <div class="d-flex flex-column mt-4"><%
                                        if(((User)request.getSession().getAttribute("name")) != null){
                                        %>

                                        <%
                                        if(((User)request.getSession().getAttribute("name")).getRole().equals("admin")){
                                        %>
                                        <a class="btn btn-outline-primary btn-sm mt-2" href="${pageContext.request.contextPath}/cart?go=deleteBus&id=<%=bus.getBusID()%>">Delete</a>
                                        <%
                                        }
                                        %>
                                        <%
                                        if(((User)request.getSession().getAttribute("name")).getRole().equals("customer")){
                                        %>
                                        
                                        <a class="btn btn-outline-primary btn-sm mt-2" href="${pageContext.request.contextPath}/cart?go=addtag&id=<%=bus.getBusID()%>">Add to card</a>
                                        <%
                                        }
                                        %>
                                        <%}else{%>
                                        <p style="color: red">Login to book bus </p>
                                       
                                        <%}%>
                                    </div>
                                </div>
                            </div><br><br><br>
                            <%}}%>
                        </div>
                    </div>
                </div>

                <!--==============================footer=================================-->
                <footer>
                    <div class="container_12">
                        <div class="grid_12">
                            <div class="f_phone"><span>Call Us:</span> 0974487338</div>
                            <div class="socials">
                                <a href="https://twitter.com/NghaNguynMinh18" class="fa fa-twitter"></a>
                                <a href="https://www.facebook.com/profile.php?id=100010090635953" class="fa fa-facebook"></a>
                                <a href="#" class="fa fa-google-plus"></a>
                            </div>
                            <div class="copy">
                                <div class="st1">
                                    <div class="brand">Tour<span class="color1">T</span>axi </div>
                                    &copy; 2014	| <a href="#">Privacy Policy</a> </div> Website designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </footer>

                </body>
                </html>
