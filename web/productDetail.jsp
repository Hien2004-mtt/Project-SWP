<%-- 
    Document   : productDetail
    Created on : Jun 29, 2025, 11:15:46 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${product.productName}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
        <style>
            .thumb-img{
                width: 80px;
                cursor: pointer;
                border: 2px solid transparent;
            }
            .thumb-img:hover{
                border-color: orange;

            }
            .selected-thumb{
                border-color: red !important;
            }
            .discount-badge{
                position: absolute;
                top: 0;
                left: 0;
                background: red;
                color: #fff;
                padding: 2px 8px;
                font-size: 0.8rem;
                border-radius: 0 0 8px 0;
            }
            .price{
                font-size: 1.5rem;
                fort-weight: bold;
                color:red;

            }
            .original-price{
                text-decoration: line-through;
                color: #888;
                margin-left: 10px;
            }
            .benefits i{
                font-size: 1.5rem;
                color: green;
            }
            .bth-orange{
                background-color: orange;
                border: none;
                color: white;
            }
            .navbar-nav-center{
                position: absolute;
                left: 50%;
                transform: translateX(-50%);
            }
            .navbar-nav .nav-link{
                color: #4b8f3c;
                font-weight: 500;
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
            .footer {
                background-color: #4b8f3c;
                color: white;
                padding: 30px 0;
            }
            .footer a {
                color: #d0f0c0;
                text-decoration: none;
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
            .product-card .original-price {
                text-decoration: line-through;
                color: #888;
                font-size: 0.9rem;
            }
            .product-card img {
                width: 100%; /* Đảm bảo hình ảnh chiếm đầy card */
                height: 200px; /* Cố định chiều cao */
                object-fit: cover; /* Cắt ảnh cho phù hợp mà không bị biến dạng */
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
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm position-relative">
            <div class="container position-relative">
                <a class="navbar-brand fw-bold text-success" href="#"><i class="bi bi-basket-fill"></i>
                    Veggie Market</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
                    <ul class="navbar-nav navbar-nav-center">
                        <li class="nav-item"><a class="nav-link" href="MainController?action=Home">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="MainController?action=Product">Products</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
