package agenda;

// BÁSICO GETTERS E SETTERS PARA ENCAPSULAR OS ATRIBUTOS/VARIAVEIS

public class Contato {
    private String telefone_ctt;
    private String nome_ctt;
    private String email_ctt;
    private int id_ctt;

    public String getTelefone_ctt() {
        return telefone_ctt;
    }

    public void setTelefone_ctt(String telefone_ctt) {
        this.telefone_ctt = telefone_ctt;
    }

    public String getNome_ctt() {
        return nome_ctt;
    }

    public void setNome_ctt(String nome_ctt) {
        this.nome_ctt = nome_ctt;
    }

    public String getEmail_ctt() {
        return email_ctt;
    }

    public void setEmail_ctt(String email_ctt) {
        this.email_ctt = email_ctt;
    }

    public int getId_ctt() {
        return id_ctt;
    }

    public void setId_ctt(int id_ctt) {
        this.id_ctt = id_ctt;
    }



}
