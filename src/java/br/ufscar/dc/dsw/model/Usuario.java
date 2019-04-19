package br.ufscar.dc.dsw.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Usuario {

    private String email;
    private String nome;
    private int papel_id;
    private String senha;
    private Date data_criacao;
    private boolean ativo;
    private String token;

    public Usuario(String email, String nome, int papel_id, String senha, Date data_criacao) throws NoSuchAlgorithmException {
        this.email = email;
        this.nome = nome;
        this.papel_id = papel_id;
        this.senha = senha;
        this.data_criacao = data_criacao;
        this.ativo = false;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(email.getBytes(StandardCharsets.UTF_8));
        this.token = encodedhash.toString();
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nome=" + nome + ", papel_id=" + papel_id + ", senha=" + senha + ", data_criacao=" + data_criacao + ", ativo=" + ativo + ", token=" + token + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String nickname) {
        this.email = nickname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPapel_id() {
        return papel_id;
    }

    public void setPapel_id(int papel_id) {
        this.papel_id = papel_id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
