<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="" />
                <meta name="author" content="" />
                <title>Update Product</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />

                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Product</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="/admin/product">Product</a></li>
                                    <li class="breadcrumb-item active">Update product</li>
                                </ol>
                                <div class="row">
                                    <div class="col-md-6 col-12 mx-auto">
                                        <h3>Update a product</h3>
                                        <hr />
                                        <form:form method="post" action="/admin/product/update"
                                            modelAttribute="newProduct" class="row" enctype="multipart/form-data">
                                            <div class="mb-3" style="display: none;">
                                                <label class="form-label">ID:</label>
                                                <form:input class="form-control" path="id" type="number" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <c:set var="nameHasBindError">
                                                    <form:errors path="name" cssClass="valid-feedback" />
                                                </c:set>
                                                <label class="form-label">Name:</label>
                                                <form:input
                                                    class="form-control ${not empty nameHasBindError? 'is-invalid':''}"
                                                    path="name" type="text" />
                                                <form:errors path="name" cssClass="invalid-feedback" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <c:set var="nameHasBindError">
                                                    <form:errors path="price" cssClass="valid-feedback" />
                                                </c:set>
                                                <label class="form-label">Price:</label>
                                                <form:input
                                                    class="form-control ${not empty nameHasBindError? 'is-invalid':''}"
                                                    path="price" type="number" />
                                                <form:errors path="price" cssClass="invalid-feedback" />
                                            </div>
                                            <div class="mb-3">
                                                <c:set var="nameHasBindError">
                                                    <form:errors path="detailDesc" cssClass="valid-feedback" />
                                                </c:set>
                                                <label class="form-label">Detail Desc:</label>
                                                <form:input
                                                    class="form-control ${not empty nameHasBindError? 'is-invalid':''}"
                                                    path="detailDesc" type="text" />
                                                <form:errors path="detailDesc" cssClass="invalid-feedback" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <c:set var="nameHasBindError">
                                                    <form:errors path="shortDesc" cssClass="valid-feedback" />
                                                </c:set>
                                                <label class="form-label">Short Desc:</label>
                                                <form:input
                                                    class="form-control ${not empty nameHasBindError? 'is-invalid':''}"
                                                    path="shortDesc" type="text" />
                                                <form:errors path="shortDesc" cssClass="invalid-feedback" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <c:set var="nameHasBindError">
                                                    <form:errors path="quantity" cssClass="valid-feedback" />
                                                </c:set>
                                                <label class="form-label">Quantity:</label>
                                                <form:input
                                                    class="form-control ${not empty nameHasBindError? 'is-invalid':''}"
                                                    path="quantity" type="number" />
                                                <form:errors path="quantity" cssClass="invalid-feedback" />
                                            </div>

                                            <div class="mb-3 col-12 col-md-6">
                                                <label class="form-label">Factory</label>
                                                <form:select class="form-select" path="factory">
                                                    <form:option value="dell">Dell</form:option>
                                                    <form:option value="lenovo">Lenovo</form:option>
                                                    <form:option value="hp">HP</form:option>
                                                    <form:option value="asus">ASUS</form:option>
                                                    <form:option value="apple">Apple</form:option>
                                                </form:select>
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <label class="form-label">Target:</label>
                                                <form:select class="form-select" path="target">
                                                    <form:option value="gaming">Gaming</form:option>
                                                    <form:option value="tram">Máy Trạm</form:option>
                                                    <form:option value="do-hoa">Đồ Họa</form:option>
                                                    <form:option value="van-phong">Văn Phòng</form:option>
                                                </form:select>
                                            </div>

                                            <div class="mb-3 col-12 col-md-6">
                                                <label for="avatarFile" class="form-label">image:</label>
                                                <input class="form-control" type="file" id="avatarFile"
                                                    accept=".png, .jpg, .jpeg" name="imgFile" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <img style="max-height: 250px; display: none;" alt="avatar preview"
                                                    id="avatarPreview" />
                                            </div>
                                            <div class="col-12 mb-5">
                                                <button type="submit" class="btn btn-success">create</button>
                                                <a href="/admin/product" class="btn btn-primary">back</a>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>

                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js"></script>
            </body>

            </html>