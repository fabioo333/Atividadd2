package ucsal.br;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AtualizarUsuarioServlet")
public class AtualizarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        // Atualizar os dados do usuário no banco de dados
        boolean updateSuccessful = updateUser(id, login, nome, email);

        if (updateSuccessful) {
            // Redirecionar para a página de sucesso da atualização
            response.sendRedirect("sucessoAtualizacao.jsp");
        } else {
            // Redirecionar para a página de erro da atualização
            response.sendRedirect("erroAtualizacao.jsp");
        }
    }

    private boolean updateUser(int id, String login, String nome, String email) {
        // Conexão com o banco de dados
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "12345";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Atualiza os dados do usuário na tabela
            String sql = "UPDATE usuario SET login=?, nome=?, email=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, nome);
            statement.setString(3, email);
            statement.setInt(4, id);

            int rowsUpdated = statement.executeUpdate();

            // Fecha a conexão com o banco de dados
            statement.close();
            connection.close();

            // Retorna true se a atualização foi bem-sucedida (pelo menos uma linha afetada)
            return rowsUpdated > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Retorna false em caso de erro na atualização
        return false;
    }
}
