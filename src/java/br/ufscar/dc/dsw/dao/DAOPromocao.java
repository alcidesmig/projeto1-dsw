package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Promocao;
import br.ufscar.dc.dsw.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class DAOPromocao extends DBConnection {

    public DAOPromocao() {
        super();
    }

    public void insert(Promocao promocao) {
        String sql = "INSERT INTO Promocao (nome_peca, preco, datetime, endereco_url, cnpj_teatro) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getNome_peca());
            statement.setDouble(2, promocao.getPreco());
            statement.setString(3, promocao.getDatetime());
            statement.setString(4, promocao.getEndereco_url());
            statement.setString(5, promocao.getCnpj_teatro());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Promocao> getAll() {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM Promocao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_promocao = resultSet.getInt("id_promocao");
                String nome_peca = resultSet.getString("nome_peca");
                Double preco = resultSet.getDouble("preco");
                String datetime = resultSet.getString("datetime");
                String endereco_url = resultSet.getString("endereco_url");
                String cnpj_teatro = resultSet.getString("cnpj_teatro");
                Promocao promocao = new Promocao(id_promocao, preco, datetime, endereco_url, cnpj_teatro, nome_peca);
                listaPromocao.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocao;
    }

    public void delete(Promocao promocao) {
        String sql = "DELETE FROM Promocao where id_promocao = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, promocao.getId_promocao());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET nome_peca = ?, preco = ?, datetime = ?, endereco_url = ?, cnpj_teatro = ?";
        sql += " WHERE id_promocao = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getNome_peca());
            statement.setDouble(2, promocao.getPreco());
            statement.setString(3, promocao.getDatetime());
            statement.setString(4, promocao.getEndereco_url());
            statement.setString(5, promocao.getCnpj_teatro());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Promocao get(int id_promocao) {
        Promocao promocao = null;
        String sql = "SELECT * FROM Promocao WHERE id_promocao = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id_promocao);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome_peca = resultSet.getString("nome_peca");
                double preco = resultSet.getDouble("preco");
                String datetime = resultSet.getString("datetime");
                String endereco_url = resultSet.getString("endereco_url");
                String cnpj_teatro = resultSet.getString("cnpj_teatro");
                promocao = new Promocao(id_promocao, preco, datetime, endereco_url, cnpj_teatro, nome_peca);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }
    public List<Promocao> getByName(String nome_peca) {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM Promocao where nome_peca like ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" +nome_peca + "%");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_promocao = resultSet.getInt("id_promocao");
                Double preco = resultSet.getDouble("preco");
                String datetime = resultSet.getString("datetime");
                String endereco_url = resultSet.getString("endereco_url");
                String cnpj_teatro = resultSet.getString("cnpj_teatro");
                Promocao promocao = new Promocao(id_promocao, preco, datetime, endereco_url, cnpj_teatro, nome_peca);
                listaPromocao.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocao;
    }
}
