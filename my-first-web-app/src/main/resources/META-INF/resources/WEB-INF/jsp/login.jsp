<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
${error? "":error}
<form action="/login" method="post">
    <input type="text" name="name">
    <input type="password" name="password">
    <input type="submit" value="Login">
</form>
</body>
</html>