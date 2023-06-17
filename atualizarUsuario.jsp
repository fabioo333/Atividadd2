<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualização de Usuário</title>
</head>
<body>
    <h1>Atualização de Usuário</h1>

    <form action="AtualizarUsuarioServlet" method="post">
        <input type="hidden" name="id" value="${usuario.id}">

        <label for="login">Login:</label>
        <input type="text" name="login" id="login" value="${usuario.login}" required><br>

        <label for="nome">Nome completo:</label>
        <input type="text" name="nome" id="nome" value="${usuario.nome}" required><br>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" value="${usuario.email}" required><br>

        <input type="submit" value="Atualizar">
    </form>
</body>
</html>
