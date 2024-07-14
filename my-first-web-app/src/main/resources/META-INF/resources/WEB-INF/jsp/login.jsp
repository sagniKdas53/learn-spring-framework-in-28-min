<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Todo App</title>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">Todos</span>
    </div>
</nav>
<div class="container-fluid">
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
    <div class="col-6">
<form action="/login" method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Username</label>
        <input class="form-control" id="name" aria-describedby="nameHelp" name="name">
        <%--        <div id="nameHelp" class="form-text">Your username.</div>--%>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

    </div>
    <div class="col-6"></div>
</div>
</body>
</html>