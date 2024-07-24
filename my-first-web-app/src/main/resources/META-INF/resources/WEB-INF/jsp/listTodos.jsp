<%@ include file="common/header.jspf" %>
<%@ include file="common/navBar.jspf" %>
<div class="container-fluid">
    <h1>Hi! ${name==null?"name":name}, Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>User</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th>Priority</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.username}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td>${todo.priority}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-secondary">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add more todos</a>
</div>
<%@ include file="common/footer.jspf" %>
