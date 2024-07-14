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
    <div class="col-6">
    <h1>Hello ${name}</h1>

        Click here to see your password: <button type="button" class="btn btn-primary" onclick="alert('${password}')">Click Me</button>
        <br>
        Click this link to see your Todos: <a href="list-todos">Todos</a>

    </div>
</div>
</body>
</html>
