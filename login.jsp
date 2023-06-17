<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>

    <form action="LoginServlet" method="post">
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" required><br>

        <label for="senha">Senha:</label>
        <input type="password" name="senha" id="senha" required><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>
