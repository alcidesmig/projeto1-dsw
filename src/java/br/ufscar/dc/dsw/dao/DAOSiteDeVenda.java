package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.SiteDeVenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class DAOSiteDeVenda extends DBConnection {

    public DAOSiteDeVenda() {
        super();
    }

    public boolean insert(SiteDeVenda site) {
        String sql = "INSERT INTO SiteDeVenda (email, senha, url, nome, telefone) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getUrl());
            statement.setString(4, site.getNome());
            statement.setString(5, site.getTelefone());
            statement.executeUpdate();
            statement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }
    }

    public List<SiteDeVenda> getAll() {
        List<SiteDeVenda> listaSites = new ArrayList<>();
        String sql = "SELECT email,url,nome,telefone FROM SiteDeVenda";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                String url = resultSet.getString("url");
                String telefone = resultSet.getString("telefone");
                SiteDeVenda teatro = new SiteDeVenda(email,"", url, nome, telefone);
                listaSites.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSites;
    }

    public boolean delete(SiteDeVenda site) {
        String sql = "DELETE FROM SiteDeVenda where email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEmail());
            statement.executeUpdate();
            statement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

//    public void update(SalaDeTeatro teatro) {
//        String sql = "UPDATE SalaDeTeatro SET nome = ?, grupo = ?, ano = ?, preco = ?";
//        sql += " WHERE id = ?";
//        try {
//            Connection conn = this.getConnection();
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, livro.getTitulo());
//            statement.setString(2, livro.getAutor());
//            statement.setInt(3, livro.getAno());
//            statement.setFloat(4, livro.getPreco());
//            statement.setInt(5, livro.getId());
//            statement.executeUpdate();
//            statement.close();
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public SiteDeVenda get(String id) {
        SiteDeVenda site = null;
        String sql = "SELECT email,url,nome,telefone FROM SiteDeVenda WHERE email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                site = new SiteDeVenda(email,"", url, nome, telefone);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }

    public List<SiteDeVenda> getByName(String nome_peca) {
        List<SiteDeVenda> listaSite = new ArrayList<>();
        String sql = "SELECT * FROM SiteDeVenda where nome like '%" + nome_peca + "%'";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                SiteDeVenda site = new SiteDeVenda(
                        email,
                        senha,
                        url, 
                        nome,
                        telefone);
                listaSite.add(site);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSite;
    }

    public void update(SiteDeVenda site) {
        String sql = "UPDATE SiteDeVenda SET "
                + "email = ?,"
                + "senha = ?,"
                + " url = ?,"
                + " nome = ?,"
                + " telefone = ?";
        sql += " WHERE email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getUrl());
            statement.setString(4, site.getNome());
            statement.setString(5, site.getTelefone());
            statement.setString(6, site.getEmail());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
