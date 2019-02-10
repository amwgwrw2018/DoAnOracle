<!DOCTYPE html>
<html lang="en">

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>The News Paper - News &amp; Lifestyle Magazine Template</title>

    <!-- Favicon -->
    <link rel="icon" href="<%=request.getContextPath()%>/img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

</head>

<body>
    <!-- ##### Header Area Start ##### -->
    <header class="header-area">

        <!-- Top Header Area -->
        <div class="top-header-area">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="top-header-content d-flex align-items-center justify-content-between">
                            <!-- Logo -->
                            <div class="logo">
                                <a href="/DoAnGiuaKy/page/"><img src="<%=request.getContextPath()%>/img/mainlogo2.png" style="width:100px;" alt=""></a>
                            </div>

                            <!-- Login Search Area -->
                            <div class="login-search-area d-flex align-items-center">
                                <!-- Login -->
                                <div class="login d-flex">
                                <% if(session.getAttribute("currentUser")!=null){ %>
                                <a>Welcome <%= session.getAttribute("currentUser") %></a>
                                <a href="/DoAnGiuaKy/page/adminPage">Admin page</a>
                                <a href="/DoAnGiuaKy/User/listUser">User management</a>
                                <a href="/DoAnGiuaKy/page/logout">Log out</a>
                                 <% }else{ %>
                                 <a href="/DoAnGiuaKy/page/loginForm">Login</a>
                                    <a href="/DoAnGiuaKy/page/signUpForm">Register</a>
                                 <% } %>
                                    
                                </div>
                                <!-- Search Form -->
                                <div class="search-form">
                                    <form action="#" method="post">
                                        <input type="search" name="search" class="form-control" placeholder="Search">
                                        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Navbar Area -->
        <div class="newspaper-main-menu" id="stickyMenu">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="newspaperNav">

                        <!-- Logo -->
                        <div class="logo">
                            <a href="index.html"><img src="<%=request.getContextPath()%>/img/core-img/logo.png" alt=""></a>
                        </div>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- close btn -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <div class="classynav">
                                <ul>
                                    <li class="active"><a href="/DoAnGiuaKy/page/">Home</a></li>
                                
                       
                                </ul>
                            </div>
                            <!-- Nav End -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Hero Area Start ##### -->
    <div class="hero-area">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-12 col-lg-8">
                    <!-- Breaking News Widget -->
                    <div class="breaking-news-area d-flex align-items-center">
                        <div class="news-title">
                            <p>Breaking News</p>
                        </div>
                        <div id="breakingNewsTicker" class="ticker">
                            <ul>
                            <c:forEach items="${newestThree}" var="nsp" >
                            
                                <li><a href="/DoAnGiuaKy/page/singlePage/${nsp.id}">${nsp.title}</a></li>
                              
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <!-- Breaking News Widget -->
                    <div class="breaking-news-area d-flex align-items-center mt-15">
                        <div class="news-title title2">
                            <p>International</p>
                        </div>
                        <div id="internationalTicker" class="ticker">
                            <ul>
                         <c:forEach items="${newestThree}" var="nsp" >
                            
                                <li><a href="/DoAnGiuaKy/page/singlePage/${nsp.id}">${nsp.title}</a></li>
                              
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- Hero Add -->
                <div class="col-12 col-lg-4">
                    <div class="hero-add">
                        <a href="#"><img src="<%=request.getContextPath()%>/img/bg-img/hero-add.gif" alt=""></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Hero Area End ##### -->

    <!-- ##### Featured Post Area Start ##### -->
    <div class="featured-post-area">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-6 col-lg-8">
                    <div class="row">

                        <!-- Single Featured Post -->
                        <div class="col-12 col-lg-7">
                            <div class="single-blog-post featured-post">
                                <div class="post-thumb">
                                    <a href="/DoAnGiuaKy/page/singlePage/${newestnsp.id}"><img src="<%=request.getContextPath()%>/img/${newestnsp.mainimage}" alt=""></a>
                                </div>
                                <div class="post-data">
                                     <a href="/DoAnGiuaKy/page/catagories/${newestnsp.newspaperType}" class="post-catagory">${newestnsp.newspaperType}</a>
                                    <a href="#" class="post-title">
                                        <h6>${newestnsp.title}</h6>
                                    </a>
                                    <div class="post-meta">
                                        <p class="post-author">By <a href="#">${newestnsp.author}</a>  ${newestnsp.releaseDate}</p>
                                        <p class="post-excerp"></p>
                                        <!-- Post Like & Post Comment -->
                                        <div class="d-flex align-items-center">
                                            <a href="#" class="post-like"><img src="<%=request.getContextPath()%>/img/core-img/like.png" alt=""> <span>392</span></a>
                                            <a href="#" class="post-comment"><img src="<%=request.getContextPath()%>/img/core-img/chat.png" alt=""> <span>10</span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-lg-5">
                         <c:forEach items="${newestTwo}" var="nsp" >
      <div class="single-blog-post featured-post-2">
                                <div class="post-thumb">
                                    <a href="/DoAnGiuaKy/page/singlePage/${nsp.id}"><img src="<%=request.getContextPath()%>/img/${nsp.mainimage}" alt="" ></a>
                                </div>
                                <div class="post-data">
                                    <a href="/DoAnGiuaKy/page/catagories/${nsp.newspaperType}" class="post-catagory">${nsp.newspaperType}</a>
                                    <div class="post-meta">
                                        <a href="#" class="post-title">
                                            <h6>${nsp.title}</h6>
                                        </a>
                                        <p>By ${nsp.author} ${nsp.releaseDate}</p>
                                        <!-- Post Like & Post Comment -->
                                        <div class="d-flex align-items-center">
                                            <a href="#" class="post-like"><img src="<%=request.getContextPath()%>/img/core-img/like.png" alt=""> <span>392</span></a>
                                            <a href="#" class="post-comment"><img src="<%=request.getContextPath()%>/img/core-img/chat.png" alt=""> <span>10</span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                              </c:forEach>
                            
                           

                        
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6 col-lg-4">
                    <!-- Single Featured Post -->
                     <c:forEach items="${newestFive}" var="nsp" >
                    <div class="single-blog-post small-featured-post d-flex">
                        <div class="post-thumb">
                            <a href="/DoAnGiuaKy/page/singlePage/${nsp.id}"><img src="<%=request.getContextPath()%>/img/${nsp.mainimage}" alt=""></a>
                        </div>
                       <div class="post-data">
                                   <a href="/DoAnGiuaKy/page/catagories/${nsp.newspaperType}" class="post-catagory">${nsp.newspaperType}</a>
                                    <div class="post-meta">
                                        <a href="#" class="post-title">
                                            <h6>${nsp.title}</h6>
                                        </a>
                                        <!-- Post Like & Post Comment -->
                                        <div class="d-flex align-items-center">
                                            <a href="#" class="post-like"><img src="<%=request.getContextPath()%>/img/core-img/like.png" alt=""> <span>392</span></a>
                                            <a href="#" class="post-comment"><img src="<%=request.getContextPath()%>/img/core-img/chat.png" alt=""> <span>10</span></a>
                                        </div>
                                    </div>
                                </div>
                    </div>
</c:forEach>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Featured Post Area End ##### -->

    <!-- ##### Popular News Area Start ##### -->
    <div class="popular-news-area section-padding-80-50">
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-8">
                    <div class="section-heading">
                        <h6>Popular News</h6>
                    </div>

                    <div class="row">
      <c:forEach items="${newestSix}" var="nsp" >
                        <!-- Single Post -->
                        <div class="col-12 col-md-6">
                            <div class="single-blog-post style-3">
                                <div class="post-thumb">
                                    <a href="/DoAnGiuaKy/page/singlePage/${nsp.id}"><img src="<%=request.getContextPath()%>/img/${nsp.mainimage}" alt=""></a>
                                </div>
                                <div class="post-data">
                                    <a href="/DoAnGiuaKy/page/catagories/${nsp.newspaperType}" class="post-catagory">${nsp.newspaperType}</a>
                                    <a href="#" class="post-title">
<h6>${nsp.title}</h6>                                    </a>
                                    <div class="post-meta d-flex align-items-center">
                                        <a href="#" class="post-like"><img src="<%=request.getContextPath()%>/img/core-img/like.png" alt=""> <span>392</span></a>
                                        <a href="#" class="post-comment"><img src="<%=request.getContextPath()%>/img/core-img/chat.png" alt=""> <span>10</span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
</c:forEach>
                        <!-- Single Post -->
                      

                        <!-- Single Post -->
                       

                        <!-- Single Post -->
                   
                    </div>
                </div>

                <div class="col-12 col-lg-4">
                    <div class="section-heading">
                        <h6>Info</h6>
                    </div>
                    <!-- Popular News Widget -->
                    <div class="popular-news-widget mb-30">
                        <h3>4 Most Popular News</h3>
 <c:forEach items="${newestFour}" var="nsp" >
                        <!-- Single Popular Blog -->
                        <div class="single-popular-post">
                            <a href="/DoAnGiuaKy/page/singlePage/${nsp.id}">
                             <h6>${nsp.title}</h6> 
                            </a>
                            <p><p>By ${nsp.author} ${nsp.releaseDate}</p></p>
                        </div>
</c:forEach>
                 
                    </div>

                    <!-- Newsletter Widget -->
                    <div class="newsletter-widget">
                        <h4>Newsletter</h4>
                        <p>Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
                        <form action="#" method="post">
                            <input type="text" name="text" placeholder="Name">
                            <input type="email" name="email" placeholder="Email">
                            <button type="submit" class="btn w-100">Subscribe</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Popular News Area End ##### -->

   

    <!-- ##### Editorial Post Area Start ##### -->
    <div class="editors-pick-post-area section-padding-80-50">
        <div class="container">
            <div class="row">
                <!-- Editors Pick -->
                <div class="col-12 col-md-7 col-lg-9">
                    <div class="section-heading">
                        <h6>Editor’s Pick</h6>
                    </div>

                    <div class="row">
 <c:forEach items="${newestSix}" var="nsp" >
                        <!-- Single Post -->
                        <div class="col-12 col-lg-4">
                            <div class="single-blog-post">
                                <div class="post-thumb">
                                    <a href="/DoAnGiuaKy/page/singlePage/${nsp.id}"><img src="<%=request.getContextPath()%>/img/${nsp.mainimage}" alt=""></a>
                                </div>
                                <div class="post-data">
                                    <a href="#" class="post-title">
                                      <h6>${nsp.title}</h6> 
                                    </a>
                                    <div class="post-meta">
                                        <div class="post-date"><p>By ${nsp.author} ${nsp.releaseDate}</p></div>
                                    </div>
                                </div>
                            </div>
                        </div>
</c:forEach>
                  

                   

                  


                      
                    </div>
                </div>

                <!-- World News -->
                <div class="col-12 col-md-5 col-lg-3">
                    <div class="section-heading">
                        <h6>World News</h6>
                    </div>
 <c:forEach items="${newestFour}" var="nsp" >
                    <!-- Single Post -->
                    <div class="single-blog-post style-2">
                        <div class="post-thumb">
                                    <a href="/DoAnGiuaKy/page/singlePage/${nsp.id}"><img src="<%=request.getContextPath()%>/img/${nsp.mainimage}" alt=""></a>
                        </div>
                        <div class="post-data">
                            <a href="#" class="post-title">
                                <h6>${nsp.title}</h6> 
                            </a>
                            <div class="post-meta">
                                <div class="post-date"><a href="#">${nsp.author} ${nsp.releaseDate}</a></div>
                            </div>
                        </div>
                    </div>

         </c:forEach>       

               

             

                </div>
            </div>
        </div>
    </div>
    <!-- ##### Editorial Post Area End ##### -->

  

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area">

        <!-- Main Footer Area -->
        <div class="main-footer-area">
            <div class="container">
                <div class="row">

                    <!-- Footer Widget Area -->
                    <div class="col-12 col-sm-6 col-lg-4">
                        <div class="footer-widget-area mt-80">
                            <!-- Footer Logo -->
                            <div class="footer-logo">
                                <a href="index.html"><img src="<%=request.getContextPath()%>/img/core-img/logo.png" alt=""></a>
                            </div>
                            <!-- List -->
                            <ul class="list">
                                <li><a href="mailto:contact@youremail.com">contact@youremail.com</a></li>
                                <li><a href="tel:+4352782883884">+43 5278 2883 884</a></li>
                                <li><a href="http://yoursitename.com">www.yoursitename.com</a></li>
                            </ul>
                        </div>
                    </div>

                    <!-- Footer Widget Area -->
                    <div class="col-12 col-sm-6 col-lg-2">
                        <div class="footer-widget-area mt-80">
                            <!-- Title -->
                            <h4 class="widget-title">Politics</h4>
                            <!-- List -->
                            <ul class="list">
                                <li><a href="#">Business</a></li>
                                <li><a href="#">Markets</a></li>
                                <li><a href="#">Tech</a></li>
                                <li><a href="#">Luxury</a></li>
                            </ul>
                        </div>
                    </div>

                    <!-- Footer Widget Area -->
                    <div class="col-12 col-sm-4 col-lg-2">
                        <div class="footer-widget-area mt-80">
                            <!-- Title -->
                            <h4 class="widget-title">Featured</h4>
                            <!-- List -->
                            <ul class="list">
                                <li><a href="#">Football</a></li>
                                <li><a href="#">Golf</a></li>
                                <li><a href="#">Tennis</a></li>
                                <li><a href="#">Motorsport</a></li>
                                <li><a href="#">Horseracing</a></li>
                                <li><a href="#">Equestrian</a></li>
                                <li><a href="#">Sailing</a></li>
                                <li><a href="#">Skiing</a></li>
                            </ul>
                        </div>
                    </div>

                    <!-- Footer Widget Area -->
                    <div class="col-12 col-sm-4 col-lg-2">
                        <div class="footer-widget-area mt-80">
                            <!-- Title -->
                            <h4 class="widget-title">FAQ</h4>
                            <!-- List -->
                            <ul class="list">
                                <li><a href="#">Aviation</a></li>
                                <li><a href="#">Business</a></li>
                                <li><a href="#">Traveller</a></li>
                                <li><a href="#">Destinations</a></li>
                                <li><a href="#">Features</a></li>
                                <li><a href="#">Food/Drink</a></li>
                                <li><a href="#">Hotels</a></li>
                                <li><a href="#">Partner Hotels</a></li>
                            </ul>
                        </div>
                    </div>

                    <!-- Footer Widget Area -->
                    <div class="col-12 col-sm-4 col-lg-2">
                        <div class="footer-widget-area mt-80">
                            <!-- Title -->
                            <h4 class="widget-title">+More</h4>
                            <!-- List -->
                            <ul class="list">
                                <li><a href="#">Fashion</a></li>
                                <li><a href="#">Design</a></li>
                                <li><a href="#">Architecture</a></li>
                                <li><a href="#">Arts</a></li>
                                <li><a href="#">Autos</a></li>
                                <li><a href="#">Luxury</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bottom Footer Area -->
        <div class="bottom-footer-area">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <!-- Copywrite -->
                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area Start ##### -->

    <!-- ##### All Javascript Files ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="<%=request.getContextPath()%>/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="<%=request.getContextPath()%>/js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="<%=request.getContextPath()%>/js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="<%=request.getContextPath()%>/js/active.js"></script>
</body>

</html>