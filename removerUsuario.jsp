<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Remoção de Usuário</title>
</head>
<body>
    <h1>Remoção de Usuário</h1>

    <form action="RemoverUsuarioServlet" method="post">
        <input type="hidden" name="id" value="${usuario.id}">

        <p>Você tem certeza que deseja remover o usuário com ID ${usuario.id}?</p>

        <input type="submit" value="Remover">
    </form>
</body>
</html>
