<%@ include file="common/header.jspf" %>
<%@ include file="common/navBar.jspf" %>
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
<%@ include file="common/footer.jspf" %>
