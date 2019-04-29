package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.SalaDeTeatro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class DAOSalaDeTeatro extends DBConnection {

    public DAOSalaDeTeatro() {
        super();
    }

    public void insert(SalaDeTeatro teatro) {
        String sql = "INSERT INTO SalaDeTeatro (email, senha, cnpj, nome, cidade, teatro_email) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(3, teatro.getCnpj());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCidade());
            statement.setString(6, teatro.getSite_de_venda_email());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SalaDeTeatro> getAll() {
        List<SalaDeTeatro> listaTeatros = new ArrayList<>();
        String sql = "SELECT email,cnpj,nome,cidade,teatro_email FROM SalaDeTeatro";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String site_de_venda_email = resultSet.getString("teatro_email");
                SalaDeTeatro teatro = new SalaDeTeatro(email, "", cnpj, nome, cidade, site_de_venda_email);
                listaTeatros.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatros;
    }

    public boolean delete(String teatro) {
        String sql = "DELETE FROM SalaDeTeatro where cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teatro);
            statement.executeUpdate();
            statement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

//    public void update(Usuario usuario) {
//        String sql = "UPDATE Livro SET nome = ?, grupo = ?, ano = ?, preco = ?";
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
    public SalaDeTeatro get(String id) {
        SalaDeTeatro teatro = null;
        String sql = "SELECT email,cnpj,nome,cidade,senha FROM SalaDeTeatro WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String senha = resultSet.getString("senha");
                String site_de_venda_email = resultSet.getString("email");
                teatro = new SalaDeTeatro(email, senha, cnpj, nome, cidade, site_de_venda_email);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teatro;
    }

    public List<SalaDeTeatro> getByName(String nome_peca) {
        List<SalaDeTeatro> listaTeatro = new ArrayList<>();
        String sql = "SELECT email,cnpj,nome,cidade FROM SalaDeTeatro WHERE nome == ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nome_peca);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                listaTeatro.add(new SalaDeTeatro(email, "", cnpj, nome, cidade, ""));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatro;
    }

    public List<SalaDeTeatro> getByEmail(String email) {
        List<SalaDeTeatro> listaTeatro = new ArrayList<>();
        String sql = "SELECT email,cnpj,nome,cidade FROM SalaDeTeatro WHERE email like '%" + email + "%'";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                email = resultSet.getString("email");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                listaTeatro.add(new SalaDeTeatro(email, "", cnpj, nome, cidade, ""));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatro;
    }

    public void update(SalaDeTeatro sala) {
        String sql = "UPDATE SalaDeTeatro SET cnpj = ?,"
                + " email = ?,"
                + " senha = ?,"
                + " nome = ?,"
                + " cidade = ?,"
                + " teatro_email = ?";
        sql += " WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, sala.getCnpj());
            statement.setString(2, sala.getEmail());
            statement.setString(3, sala.getSenha());
            statement.setString(4, sala.getNome());
            statement.setString(5, sala.getCidade());
            statement.setString(6, sala.getSite_de_venda_email());
            statement.setString(7, sala.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
