<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
</head>
<body>
    <h1>Cadastro de Usuário</h1>

    <form action="RegistrarUsuarioServlet" method="post">
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" required><br>

        <label for="nome">Nome completo:</label>
        <input type="text" name="nome" id="nome" required><br>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required><br>

        <label for="confirmarEmail">Confirmar Email:</label>
        <input type="email" name="confirmarEmail" id="confirmarEmail" required><br>

        <label for="senha">Senha:</label>
        <input type="password" name="senha" id="senha" required><br>

        <label for="confirmarSenha">Confirmar Senha:</label>
        <input type="password" name="confirmarSenha" id="confirmarSenha" required><br>

        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
