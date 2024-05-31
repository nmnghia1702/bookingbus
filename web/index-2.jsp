<%-- 
    Document   : index-2
    Created on : Mar 12, 2024, 10:20:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cars</title>
        <meta charset="utf-8">
        <meta name = "format-detection" content = "telephone=no" />
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

            <div class="container mt-5 mb-5"  style="padding-left: 20px; padding-bottom: 30px ; padding-top: 20px">
                <div class="d-flex justify-content-center row">
                    <div class="col-md-10">
                        <div class="row p-2 bg-white border rounded" style="padding-bottom: 30px">
                            <div class="col-md-3 mt-1" style="width: 1000px; height: auto; border: 2px solid black; "><img class="img-fluid img-responsive rounded product-image" src="https://thacoauto.vn/storage/thacobus/banner-post-bus-giuongnam.jpg"></div>

                            <div class="col-md-6 mt-1">

                                <div class="mt-1 mb-1 spec-1"><span></span></div>
                                <div class="mt-1 mb-1 spec-1"><span>Unique design</span><span class="dot"></span><span>For men</span><span class="dot"></span><span>Casual<br></span></div>
                            </div>
                            <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                                <div class="d-flex flex-row align-items-center">
                                    <h4 class="mr-1">$13.99</h4><span class="strike-text">$20.99</span>
                                </div>
                                <h6 class="text-success">Free shipping</h6>
                                <div class="d-flex flex-column mt-4"><button class="btn btn-primary btn-sm" type="button">Details</button><button class="btn btn-outline-primary btn-sm mt-2" type="button">Add to wishlist</button></div>
                            </div>
                        </div>
                        <div class="row p-2 bg-white border rounded mt-2" style="padding-bottom: 30px">
                            <div class="col-md-3 mt-1" style="width: 300px; height: auto; border: 2px black "><img class="img-fluid img-responsive rounded product-image" src="https://i.imgur.com/JvPeqEF.jpg"></div>
                            <div class="col-md-6 mt-1">
                                <h5>Quant trident shirts</h5>
                                <div class="d-flex flex-row">
                                    <div class="ratings mr-2"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div><span>310</span>
                                </div>
                                <div class="mt-1 mb-1 spec-1"><span>100% cotton</span><span class="dot"></span><span>Light weight</span><span class="dot"></span><span>Best finish<br></span></div>
                                <div class="mt-1 mb-1 spec-1"><span>Unique design</span><span class="dot"></span><span>For men</span><span class="dot"></span><span>Casual<br></span></div>
                                <p class="text-justify text-truncate para mb-0">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.<br><br></p>
                            </div>
                            <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                                <div class="d-flex flex-row align-items-center">
                                    <h4 class="mr-1">$14.99</h4><span class="strike-text">$20.99</span>
                                </div>
                                <h6 class="text-success">Free shipping</h6>
                                <div class="d-flex flex-column mt-4"><button class="btn btn-primary btn-sm" type="button">Details</button><button class="btn btn-outline-primary btn-sm mt-2" type="button">Add to wishlist</button></div>
                            </div>
                        </div>
                        <div class="row p-2 bg-white border rounded mt-2" style="padding-bottom: 30px">
                            <div class="col-md-3 mt-1"><img class="img-fluid img-responsive rounded product-image" src="https://i.imgur.com/Bf4dIaN.jpg"></div>
                            <div class="col-md-6 mt-1">
                                <h5>Quant ruybi shirts</h5>
                                <div class="d-flex flex-row">
                                    <div class="ratings mr-2"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div><span>123</span>
                                </div>
                                <div class="mt-1 mb-1 spec-1"><span>100% cotton</span><span class="dot"></span><span>Light weight</span><span class="dot"></span><span>Best finish<br></span></div>
                                <div class="mt-1 mb-1 spec-1"><span>Unique design</span><span class="dot"></span><span>For men</span><span class="dot"></span><span>Casual<br></span></div>
                                <p class="text-justify text-truncate para mb-0">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.<br><br></p>
                            </div>
                            <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                                <div class="d-flex flex-row align-items-center">
                                    <h4 class="mr-1">$13.99</h4><span class="strike-text">$20.99</span>
                                </div>
                                <h6 class="text-success">Free shipping</h6>
                                <div class="d-flex flex-column mt-4"><button class="btn btn-primary btn-sm" type="button">Details</button><button class="btn btn-outline-primary btn-sm mt-2" type="button">Add to wishlist</button></div>
                            </div>
                        </div>
                        <div class="row p-2 bg-white border rounded mt-2" style="padding-bottom: 30px">
                            <div class="col-md-3 mt-1"><img class="img-fluid img-responsive rounded product-image" src="https://i.imgur.com/HO8e9b8.jpg"></div>
                            <div class="col-md-6 mt-1">
                                <h5>Quant tinor shirts</h5>
                                <div class="d-flex flex-row">
                                    <div class="ratings mr-2"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div><span>110</span>
                                </div>
                                <div class="mt-1 mb-1 spec-1"><span>100% cotton</span><span class="dot"></span><span>Light weight</span><span class="dot"></span><span>Best finish<br></span></div>
                                <div class="mt-1 mb-1 spec-1"><span>Unique design</span><span class="dot"></span><span>For men</span><span class="dot"></span><span>Casual<br></span></div>
                                <p class="text-justify text-truncate para mb-0">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.<br><br></p>
                            </div>
                            <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                                <div class="d-flex flex-row align-items-center">
                                    <h4 class="mr-1">$15.99</h4><span class="strike-text">$21.99</span>
                                </div>
                                <h6 class="text-success">Free shipping</h6>
                                <div class="d-flex flex-column mt-4"><button class="btn btn-primary btn-sm" type="button">Details</button><button class="btn btn-outline-primary btn-sm mt-2" type="button">Add to wishlist</button></div>
                            </div>
                        </div>
                        <div class="row p-2 bg-white border rounded mt-2" style="padding-bottom: 30px">
                            <div class="col-md-3 mt-1"><img class="img-fluid img-responsive rounded product-image" src="https://i.imgur.com/HO8e9b8.jpg"></div>
                            <div class="col-md-6 mt-1">
                                <h5>Quant tinor shirts</h5>
                                <div class="d-flex flex-row">
                                    <div class="ratings mr-2"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div><span>110</span>
                                </div>
                                <div class="mt-1 mb-1 spec-1"><span>100% cotton</span><span class="dot"></span><span>Light weight</span><span class="dot"></span><span>Best finish<br></span></div>
                                <div class="mt-1 mb-1 spec-1"><span>Unique design</span><span class="dot"></span><span>For men</span><span class="dot"></span><span>Casual<br></span></div>
                                <p class="text-justify text-truncate para mb-0">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.<br><br></p>
                            </div>
                            <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                                <div class="d-flex flex-row align-items-center">
                                    <h4 class="mr-1">$15.99</h4><span class="strike-text">$21.99</span>
                                </div>
                                <h6 class="text-success">Free shipping</h6>
                                <div class="d-flex flex-column mt-4"><button class="btn btn-primary btn-sm" type="button">Details</button><button class="btn btn-outline-primary btn-sm mt-2" type="button">Add to wishlist</button></div>
                            </div>
                        </div>
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
