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

@WebServlet("/RemoverUsuarioServlet")
public class RemoverUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // Remover o usuário do banco de dados
        boolean removalSuccessful = removeUser(id);

        if (removalSuccessful) {
            // Redirecionar para a página de sucesso da remoção
            response.sendRedirect("sucessoRemocao.jsp");
        } else {
            // Redirecionar para a página de erro da remoção
            response.sendRedirect("erroRemocao.jsp");
        }
    }

    private boolean removeUser(int id) {
        // Conexão com o banco de dados
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "12345";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Remove o usuário da tabela
            String sql = "DELETE FROM usuario WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            // Fecha a conexão com o banco de dados
            statement.close();
            connection.close();

            // Retorna true se a remoção foi bem-sucedida (pelo menos uma linha afetada)
            return rowsDeleted > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Retorna false em caso de erro na remoção
        return false;
    }
}
