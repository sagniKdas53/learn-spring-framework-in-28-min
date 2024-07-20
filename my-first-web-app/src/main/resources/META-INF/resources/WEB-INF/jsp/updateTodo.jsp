<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Todo App</title>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
    <link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	<a class="navbar-brand m-1" >Todo</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>
</nav>
<div class="container-fluid">
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
    <%--@elvariable id="todo" type="com.in28minutes.springboot.my_first_web_app.todo.Todo"--%>
    <form:form action="/update-todo" method="post" modelAttribute="todo">
        <div class="m-1 p-1">
            <form:hidden path="id"/>
            <form:hidden path="username"/>
            <form:label path="description" class="form-label">Task Description</form:label>
            <form:input path="description" class="form-control" id="description" name="description"
                        required="required"/>
            <form:errors path="description" cssClass="alert alert-danger" element="div"/>
            <form:label path="targetDate" class="form-label">Complete By</form:label>
            <form:input path="targetDate" class="form-control" id="targetDate" name="targetDate" required="required"
                        type="text"/>
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
<script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>
</body>
</html>
