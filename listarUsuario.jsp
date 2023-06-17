<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuários</title>
</head>
<body>
    <h1>Lista de Usuários Cadastrados</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Nome</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.login}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
