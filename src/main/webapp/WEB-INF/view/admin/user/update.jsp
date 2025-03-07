<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>update user</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Update a user</h3>
                            <hr />
                            <form:form method="post" action="/admin/user/update" modelAttribute="newUser">
                                <div class="mb-3" style="display: none;">
                                    <label class="form-label">ID:</label>
                                    <form:input class="form-control" path="id" type="number" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Email address:</label>
                                    <form:input class="form-control" path="email" type="email" disabled="true" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Full name:</label>
                                    <form:input class="form-control" path="fullName" type="text" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address:</label>
                                    <form:input class="form-control" path="address" type="text" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Phone number:</label>
                                    <form:input class="form-control" path="phone" type="text" />
                                </div>
                                <button type="submit" class="btn btn-success">update</button>
                                <a href="/admin/user" class="btn btn-success">Back</a>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>