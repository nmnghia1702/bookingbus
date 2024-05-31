<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Booking"%>
<%@page import="entity.User"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DAOBooking"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.logging.Level"%>
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
            User u = (User) request.getSession().getAttribute("name");
            DAOBooking dao = new DAOBooking();
            ArrayList<Booking> listBooking = dao.getDataByUserId(u.getUserID());
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
            if(request.getParameter("pay")!=null){
            %>
            <h2 style="color: red">Pay successfully!</h2>
            <%
    }
            %>

            <div class="container mt-5 mb-5"  style="padding-left: 20px; padding-bottom: 30px ; padding-top: 20px">
                <div class="d-flex justify-content-center row">
                    <div class="col-md-10">
                        <%
                        if (listBooking.size() >= 1) {
                            for (int i = 0; i < listBooking.size(); i++) {
                            ResultSet Rs = dao.getResultSet("SELECT b.*, bs.DepartureLocation, bs.ArrivalLocation\n"
                                + "FROM Booking bo\n"
                                + "JOIN BusSchedule bs ON bo.ScheduleID = bs.ScheduleID\n"
                                + "JOIN Bus b ON bs.BusID = b.BusID\n"
                                + "WHERE bo.BookingID = " +listBooking.get(i).getBookingID());
                
                        %>
                        <div class="row p-2 bg-white border rounded" style="padding-bottom: 30px">
                            <%
                                try {
                                    while (Rs.next()) {
                            %>
                            <div class="col-md-3 mt-1" style="width: 1000px; height: auto; border: 2px solid black; "><img class="img-fluid img-responsive rounded product-image" src="${pageContext.request.contextPath}<%=Rs.getString(6)%>"></div>

                            <div class="col-md-6 mt-1">

                                <div class="mt-1 mb-1 spec-1"><span></span></div>
                                <div class="mt-1 mb-1 spec-1"><span>Type: <%=Rs.getString(4)%></span><span class="dot"></span><span>Driver: <%=Rs.getString(5)%></span><span class="dot"></span><span>Bus number: <%=Rs.getString(2)%></span><br><!-- comment -->
                                    <span class="dot"></span><span>Departure Location: <%=Rs.getString(8)%> in <%=listBooking.get(i).getPickupDate()%></span><br>
                                    <span class="dot"></span><span>Departure Location: <%=Rs.getString(9)%> in <%=listBooking.get(i).getReturnDate()%></span><br>
                                </div>
                                <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                                    <div class="d-flex flex-row align-items-center">
                                        <%
                                            String dateString1 = listBooking.get(i).getPickupDate();
                                            String dateString2 = listBooking.get(i).getReturnDate();

                                            LocalDateTime dateTime1 = LocalDateTime.parse(dateString1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.S]"));
                                            LocalDateTime dateTime2 = LocalDateTime.parse(dateString2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.S]"));

                                            LocalDate date1 = dateTime1.toLocalDate();
                                            LocalDate date2 = dateTime2.toLocalDate();

                                            long daysDifference = ChronoUnit.DAYS.between(date1, date2);
        
                                            int intDifference = (int) daysDifference;
                                            float priceFloat = Float.parseFloat(Rs.getString(7));
                                            int price = (int) (priceFloat * intDifference);
                                        %>
                                        <h4 class="mr-1"><%=price%> for <%=intDifference%> days</h4><span class="strike-text"><%=price+20*intDifference%></span>
                                    </div>
                                    <div class="d-flex flex-column mt-4"><a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/cart?go=pay&id=<%=listBooking.get(i).getBookingID()%>&price=<%=price%>">Pay</a></div>
                                </div>
                            </div><br><br><br>
                            <%}
                            } catch (SQLException ex) {
                                
                            }
                                }
                        }%>
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
