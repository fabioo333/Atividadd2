package ucsal.br;
public class Usuario {
    private int id;
    private String login;
    private String nome;
    private String email;
    private String senha;

    // Construtor vazio
    public Usuario() {
    }

    // Construtor com parâmetros
    public Usuario(int id, String login, String nome, String email, String senha) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Métodos getters e setters para os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
