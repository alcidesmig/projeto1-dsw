package br.ufscar.dc.dsw.model;

public class SalaDeTeatro {

    private String email;
    private String senha;
    private String site_de_venda_email;
    private String cnpj;
    private String nome;
    private String cidade;

    public SalaDeTeatro(String email, String senha, String cnpj, String nome, String cidade, String site_de_venda_email) {
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cidade = cidade;
        this.site_de_venda_email = site_de_venda_email;
    }

    public String getSite_de_venda_email() {
        return site_de_venda_email;
    }

    public void setSite_de_venda_email(String site_de_venda_email) {
        this.site_de_venda_email = site_de_venda_email;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
