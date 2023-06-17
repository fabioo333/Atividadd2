package ucsal.br;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarUsuariosServlet")
public class ListarUsuariosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Conexão com o banco de dados
        String jdbcUrl = "jdbc:postgresql://localhost:5432/spostgres";
        String username = "postgres";
        String password = "12345";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Consulta todos os usuários cadastrados na tabela
            String sql = "SELECT * FROM usuario";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();

            // Itera sobre o resultado da consulta e cria objetos Usuario
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));

                usuarios.add(usuario);
            }

            // Fecha a conexão com o banco de dados
            resultSet.close();
            statement.close();
            connection.close();

            // Define os usuários como atributo da requisição
            request.setAttribute("usuarios", usuarios);

            // Encaminha a requisição para o JSP listarUsuarios.jsp
            request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
