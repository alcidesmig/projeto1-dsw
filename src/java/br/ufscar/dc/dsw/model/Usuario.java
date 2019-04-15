/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Usuario {

    private String nickname;
    private String nome;
    private int papel_id;
    private String senha;
    private Date data_criacao;
    private boolean ativo;
    private String token;

    public Usuario(String nickname, String nome, int papel_id, String senha, Date data_criacao) throws NoSuchAlgorithmException {
        this.nickname = nickname;
        this.nome = nome;
        this.papel_id = papel_id;
        this.senha = senha;
        this.data_criacao = data_criacao;
        this.ativo = false;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(nickname.getBytes(StandardCharsets.UTF_8));
        this.token = encodedhash.toString();
        this.ativo = false;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
