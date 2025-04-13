<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="vi">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>403 Forbidden</title>
            <style>
                * {
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                }

                body {
                    height: 100vh;
                    background: #f8f9fa;
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                }

                .container {
                    text-align: center;
                    padding: 40px;
                    background-color: white;
                    border-radius: 15px;
                    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
                }

                h1 {
                    font-size: 100px;
                    color: #dc3545;
                }

                h2 {
                    font-size: 28px;
                    color: #333;
                    margin-top: 10px;
                }

                p {
                    font-size: 18px;
                    color: #666;
                    margin: 20px 0;
                }

                .home-btn {
                    display: inline-block;
                    padding: 10px 20px;
                    background-color: #007bff;
                    color: white;
                    text-decoration: none;
                    border-radius: 8px;
                    transition: background-color 0.3s ease;
                }

                .home-btn:hover {
                    background-color: #0056b3;
                }
            </style>
        </head>

        <body>
            <div class="container">
                <h1>403</h1>
                <h2>Truy cập bị từ chối</h2>
                <p>Bạn không có quyền truy cập vào trang này.</p>
                <a href="/" class="home-btn">Quay về trang chủ</a>
            </div>
        </body>

        </html>