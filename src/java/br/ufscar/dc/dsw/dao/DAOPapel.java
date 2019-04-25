/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Papel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igor
 */
public class DAOPapel extends DBConnection {
    public DAOPapel() {
        super();
    }
    
    public void insert(Papel papel) {
        String sql = "INSERT INTO Papel (nome) VALUES (?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, papel.getNome());
            int i = statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Papel> getAll() throws SQLException {
        String sql = "SELECT * FROM Papel";
        List<Papel> papeis = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Papel papel = new Papel(resultSet.getString("nome"));
                papel.setId(resultSet.getInt("id"));
                papeis.add(papel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return papeis;
    }
    
    public void delete(Papel papel) throws SQLException {
        String sql = "DELETE FROM Papel where nome = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, papel.getNome());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
}
