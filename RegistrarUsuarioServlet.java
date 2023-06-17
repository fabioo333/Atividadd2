package ucsal.br;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrarUsuarioServlet")
public class RegistrarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém os parâmetros do formulário
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String confirmarEmail = request.getParameter("confirmarEmail");
        String senha = request.getParameter("senha");
        String confirmarSenha = request.getParameter("confirmarSenha");

        // Validações dos campos
        if (login.isEmpty() || nome.isEmpty() || email.isEmpty() || confirmarEmail.isEmpty() || senha.isEmpty()
                || confirmarSenha.isEmpty()) {
            // Redireciona de volta ao formulário se algum campo estiver vazio
            response.sendRedirect("cadastro.jsp");
            return;
        }

        if (!email.equals(confirmarEmail) || !senha.equals(confirmarSenha)) {
            // Redireciona de volta ao formulário se o email ou senha não forem confirmados corretamente
            response.sendRedirect("cadastro.jsp");
            return;
        }

        if (senha.equals(login)) {
            // Redireciona de volta ao formulário se a senha for igual ao login
            response.sendRedirect("cadastro.jsp");
            return;
        }

        if (senha.length() < 4 || senha.length() > 8) {
            // Redireciona de volta ao formulário se a senha não estiver dentro dos limites permitidos
            response.sendRedirect("cadastro.jsp");
            return;
        }

        // Conexão com o banco de dados
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "12345";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Verifica se o login já está cadastrado na tabela
            String verificaLoginSql = "SELECT * FROM usuario WHERE login = ?";
            PreparedStatement verificaLoginStatement = connection.prepareStatement(verificaLoginSql);
            verificaLoginStatement.setString(1, login);
            ResultSet resultadoLogin = verificaLoginStatement.executeQuery();

            if (resultadoLogin.next()) {
                // Redireciona de volta ao formulário se o login já estiver sendo utilizado
                response.sendRedirect("cadastro.jsp");
                return;
            }

            // Insere os dados do usuário na tabela
            String sql = "INSERT INTO usuario (login, nome, email, senha) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, nome);
            statement.setString(3, email);
            statement.setString(4, senha);
            statement.executeUpdate();

            // Fecha a conexão com o banco de dados
            resultadoLogin.close();
            verificaLoginStatement.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Redireciona para a página de sucesso após o cadastro
        response.sendRedirect("login.jsp");
    }
}
