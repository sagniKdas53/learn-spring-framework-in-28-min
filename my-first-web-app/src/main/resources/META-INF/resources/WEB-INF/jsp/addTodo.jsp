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
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
    <%--@elvariable id="todo" type="com.in28minutes.springboot.my_first_web_app.todo.Todo"--%>
    <form:form action="/add-todo" method="post" modelAttribute="todo">
        <div class="m-1 p-1">
            <form:label path="description" class="form-label">Task Description</form:label>
            <form:input path="description" class="form-control" id="description" name="description"
                        required="required"/>
            <form:label path="targetDate" class="form-label">Complete By</form:label>
            <form:input path="targetDate" class="form-control" id="targetDate" name="targetDate" required="required"
                        type="date"/>
            <form:label path="priority" class="form-label">Priority</form:label>
            <form:select path="priority" id="priority" name="priority" class="form-select" required="required">
                <form:option selected="selected" value="LOW">LOW</form:option>
                <form:option value="HIGH">HIGH</form:option>
                <form:option value="MEDIUM">MEDIUM</form:option>
            </form:select>
            <form:label path="done" class="form-label">Done?</form:label>
            <form:checkbox path="done" id="done" name="done" class="form-check-input"/><br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form:form>
</div>
</body>
</html>
