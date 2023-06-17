package ucsal.br;
import java.io.IOException;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        // Verificar as credenciais de login no banco de dados
        boolean validCredentials = checkCredentials(login, senha);

        if (validCredentials) {
            // Criar a sessão do usuário
            HttpSession session = request.getSession();
            session.setAttribute("login", login);

            // Redirecionar para a página de sucesso do login
            response.sendRedirect("sucessoLogin.jsp");
        } else {
            // Redirecionar para a página de erro de login
            response.sendRedirect("erroLogin.jsp");
        }
    }

    private boolean checkCredentials(String login, String senha) {
        // Lógica para verificar as credenciais no banco de dados
        // Retorna true se as credenciais forem válidas, caso contrário, retorna false

        // Exemplo de validação simples
        if (login.equals("admin") && senha.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }
}
