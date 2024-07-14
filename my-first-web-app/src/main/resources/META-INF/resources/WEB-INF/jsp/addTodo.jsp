<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <%--@elvariable id="todo" type="com.in28minutes.springboot.my_first_web_app.todo.Todo"--%>
    <form:form action="/add-todo" method="post" modelAttribute="todo">
        <div class="mb-3">
            <label for="desc" class="form-label">Description</label>
            <form:input class="form-control" id="desc" name="desc" path="description" required="required"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
</html>
