<%-- 
    Document   : product
    Created on : Jun 25, 2025, 8:54:08 AM
    Author     : athuu
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Veggie Market</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
        <style>
            body {
                font-family: 'Roboto', sans-serif;
            }

            .footer {
                background-color: #4b8f3c;
                color: white;
                padding: 30px 0;
            }

            .footer a {
                color: #d0f0c0;
                text-decoration: none;
            }

            .navbar-nav-center {
                position: absolute;
                left: 50%;
                transform: translateX(-50%);
            }

            .navbar-nav .nav-link {
                color: #4b8f3c;
                font-weight: 500;
                font-size: 1.15rem;
                padding: 0.5rem 1rem;
                transition: all 0.3s ease;
            }

            .navbar-nav .nav-link:hover {
                color: orange;
                font-size: 1rem;
                text-decoration: underline;
            }

            .navbar-nav .nav-link.active {
                color: orange;
                font-weight: 700;
                border-bottom: 2px solid orange;
            }

            .cart-icon {
                position: relative;
            }

            .cart-icon .bi-cart3 {
                font-size: 2rem;
            }
            .cart-icon .badge {
                position: absolute;
                top: -5px;
                right: -10px;
                background-color: red;
                color: white;
                font-size: 0.7rem;
                border-radius: 50%;
                padding: 3px 6px;
            }
            .cart-dropdown-wrapper {
                position: relative;
                display: inline-block;
            }
            .cart-dropdown {
                display: none;
                position: absolute;
                right: 0;
                top: 150%;
                background-color: #fff;
                width: 300px;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                z-index: 1000;
                max-height: 300px;
                overflow-y: auto;
            }

            .cart-dropdown-wrapper:hover .cart-dropdown {
                display: block;
            }

            .cart-item {
                padding: 10px 0;
                display: flex;
                gap: 10px;
                align-items: center;
                border-bottom: 1px solid #e0e0e0;
            }

            .cart-item-image {
                width: 50px;
                height: 50px;
                object-fit: cover;
                border-radius: 6px;
            }

            .cart-item-info {
                display: flex;
                flex-direction: column;
                justify-content: center;
            }

            .cart-item-name {
                font-size: 14px;
                font-weight: 500;
            }


            .cart-item-quantity {
                font-size: 12px;
                color: gray;
            }
            .cart-icon:hover .cart-dropdown {
                display: block !important;
            }
            .user-dropdown {
                position: relative;
            }
            .user-dropdown .bi-person-circle {
                font-size: 1.7rem;
            }

            .user-dropdown:hover .dropdown-menu {
                display: block;
            }

            .dropdown-menu {
                right: 0;
                left: auto;
                display: none;
            }
            .sidebar {
                background-color: #f8f9fa;
                padding: 20px;
                border-right: 1px solid #ddd;
                height: 100%;
            }
            .sidebar h5 {
                color: #4b8f3c;
                font-weight: 600;
            }
            .product-section {
                padding: 50px 0;
            }
            .product-section h2 {
                color: #4b8f3c;
                font-weight: 700;
                margin-bottom: 30px;
            }
            .product-card {
                border: 1px solid #eee;
                border-radius: 8px;
                overflow: hidden;
                transition: box-shadow 0.3s ease;
                background: #fff;
            }
            .product-card:hover {
                box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            }
            .product-card .badge-discount {
                position: absolute;
                top: 10px;
                left: 10px;
                background: #2980b9;
                color: white;
                font-size: 0.8rem;
                padding: 4px 8px;
                border-radius: 4px;
            }
            .product-card .view-icon {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background: rgba(255,255,255,0.7);
                border-radius: 50%;
                padding: 8px;
                display: none;
            }
            .product-card:hover .view-icon {
                display: block;
            }
            .product-card .price {
                color: red;
                font-weight: bold;
            }
            .product-card img {
                width: 100%; /* Đảm bảo hình ảnh chiếm đầy card */
                height: 200px; /* Cố định chiều cao */
                object-fit: cover; /* Cắt ảnh cho phù hợp mà không bị biến dạng */
            }
            .product-card .original-price {
                text-decoration: line-through;
                color: #888;
                font-size: 0.9rem;
            }

            .product-card .add-cart {
                background: #fdd835;
                border: 1px solid #ccc;
                border-radius: 30px;
                padding: 8px 16px;
                font-weight: 600;
                display: flex;
                justify-content: center;
                align-items: center;
                gap: 5px;
                transition: 0.3s;
            }
            .product-card .add-cart:hover {
                background: #fbc02d;
            }
            .price {
                color: red;
                font-weight: bold;
            }
            .original-price {
                text-decoration: line-through;
                color: #888;
                font-size: 0.9rem;
            }
            .search-bar {
                display: flex;
                justify-content: flex-end;
                margin-bottom: 20px;
            }
            .form-check {
                margin-bottom: 10px;
            }
            .section-title {
                color: #4b8f3c;
                font-weight: bold;
                font-size: 1.5rem;
                margin-bottom: 20px;
            }
            .footer {
                background-color: #4b8f3c;
                color: white;
                padding: 30px 0;
            }
            .footer a {
                color: #d0f0c0;
                text-decoration: none;
            }

        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm position-relative">
            <div class="container position-relative">
                <a class="navbar-brand fw-bold text-success" href="#"><i class="bi bi-basket-fill"></i> Veggie Market</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
                    <ul class="navbar-nav navbar-nav-center">
                        <li class="nav-item"><a class="nav-link" href="HomeController">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="ProductController">Products</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">About</a></li>      
                    </ul> 
                </div>
            </div>
            <div class="d-flex align-items-center gap-4">
                <div class="d-flex align-items-center gap-4">
                    <c:choose>                       
                        <c:when test="${not empty sessionScope.LOGIN_USER}">    
                            <div class="user-dropdown dropdown">
                                <a href="#" class="text-dark d-flex align-items-center gap-1" data-bs-toggle="dropdown">
                                    <i class="bi bi-person-circle fs-5"></i> <span class="fw-medium">${sessionScope.LOGIN_USER.fullName}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="">Order History</a></li>                                       
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="">Logout</a></li>
                                </ul>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <a href="login.jsp" class="btn btn-outline-success">Login</a>
                            <a href="register.jsp" class="btn btn-success">Register</a>
                        </c:otherwise>
                    </c:choose>
                </div>            
            </div>
        </nav>

        <div class="container mt-4 px-4">
            <div class="row">
                <div class="col-md-3 sidebar">
                    <form action="ProductController" method = "get">
                        <!--price sort-->
                        <hr>
                        <h5>Sort by Price</h5>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sort" value="asc" 
                                   ${param.sort == 'asc' ? "checked" : ""}>
                            <label class="form-check-label">Low to High</label>       
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sort" value="desc" 
                                   ${param.sort == 'desc' ? "checked" : ""}>
                            <label class="form-check-label"> High to Low</label>       
                        </div>

                        <button type="submit" class="btn btn-success mt-3 w-100" name="action" value="" />Apply Filters</button>
                    </form>
                </div>

                <div class="col-md-9">
                    <div class="search-bar">
                        <form class="d-flex w-50" action="ProductController">
                            <input class="form-control me-2" type="search" name="search" placeholder="Search products..." value="${param.search}">
                            <button class="btn btn-outline-success" type="submit" name="action" value="">Search</button>
                        </form>
                    </div>

                    <div class="section-title">All Product</div>
                    <div class="row row-cols-1 row-cols-md-3 g-4">
                        <c:forEach var="p" items="${productList}">
                            <div class="col">
                                <div class="card product-card position-relative">
                                    <a href="MainController?action=ProductDetail&productID=${p.id}" class="text-decoration-none text-dark">

                                        <c:if test="${p.discountPercent != 0}">
                                            <span class="badge-discount">-${p.discountPercent}%</span>
                                        </c:if>
                                        <img src="${p.imageUrl}" class="card-img-top" alt="${p.name}">
                                        <div class="view-icon"><i class="bi bi-eye"></i></div>
                                        <div class="card-body">
                                            <small class="text-muted">${p.origin}</small>
                                            <h6 class="mt-1">${p.name}</h6>
                                            <p class="mb-1">
                                                <span class="price">${p.discountPrice}VND</span>
                                                <c:if test="${p.discountPercent != 0}">
                                                    <span class="original-price ms-2">${p.price}VND</span>
                                                </c:if>
                                            </p>
                                            <p class="mb-1">
                                                <span class="text-warning">
                                                    <c:forEach begin="1" end="${p.rating}">
                                                        <i class="bi bi-star-fill"></i>
                                                    </c:forEach>
                                                    <c:forEach begin="${p.rating + 1}" end="5">
                                                        <i class="bi bi-star"></i>
                                                    </c:forEach>
                                                </span>
                                                <span class="ms-1">${p.reviewCount} reviews</span>
                                            </p>
                                            <p class="text-muted">Sold: ${p.sold}</p>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>


            </div>
            <footer class="footer text-center">
                <div class="container">
                    <p class="mb-1">&copy; 2025 Veggie Market. All rights reserved.</p>
                    <small>Follow us on
                        <a href="#"><i class="bi bi-facebook"></i></a>
                        <a href="#"><i class="bi bi-instagram"></i></a>
                        <a href="#"><i class="bi bi-twitter"></i></a>
                    </small>
                </div>
            </footer>
    </body>
</html>

