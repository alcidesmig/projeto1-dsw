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

    public boolean insert(SalaDeTeatro teatro) {
        String sql = "INSERT INTO SalaDeTeatro (email, senha, cnpj, nome, cidade) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(3, teatro.getCnpj());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCidade());
            statement.executeUpdate();
            statement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }
    }

    public List<SalaDeTeatro> getAll() {
        List<SalaDeTeatro> listaTeatros = new ArrayList<>();
        String sql = "SELECT email,cnpj,nome,cidade FROM SalaDeTeatro";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                SalaDeTeatro teatro = new SalaDeTeatro(email,"", cnpj, nome, cidade);
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

    public boolean delete(SalaDeTeatro teatro) {
        String sql = "DELETE FROM SalaDeTeatro where cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getCnpj());
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
        String sql = "SELECT email,cnpj,nome,cidade FROM SalaDeTeatro WHERE cnpj = ?";
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
                teatro = new SalaDeTeatro(email,"", cnpj, nome, cidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teatro;
    }
}
