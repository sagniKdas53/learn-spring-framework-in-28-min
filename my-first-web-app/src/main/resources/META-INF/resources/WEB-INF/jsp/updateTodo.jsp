<%@ include file="common/header.jspf" %>
<%@ include file="common/navBar.jspf" %>
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
<%@ include file="common/footer.jspf" %>
