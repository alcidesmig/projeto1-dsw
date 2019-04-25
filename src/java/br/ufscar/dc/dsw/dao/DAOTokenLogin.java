/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.TokenLogin;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author igor
 */
public class DAOTokenLogin extends DBConnection {
    public DAOTokenLogin() {
        super();
    }
    
    public void insert(TokenLogin token) throws NoSuchAlgorithmException {
        String sql = "INSERT INTO token_login (token, usuario, date) VALUES (?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, token.getToken());
            statement.setString(2, token.getUsuario().getEmail());
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            statement.setString(3, simpleDateFormat.format(token.getData_login()));
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public TokenLogin getToken(String token) {
        TokenLogin newToken = null;
        String sql = "SELECT * FROM token_login WHERE token = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String user = resultSet.getString("usuario");
                Date data = resultSet.getDate("data_login");
                newToken = new TokenLogin(token, user, data);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newToken;
    }
    
    public void delete(TokenLogin token) {
        String sql = "DELETE FROM token_login WHERE token = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, token.getToken());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
