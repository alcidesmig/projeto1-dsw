/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Usuario;
import br.ufscar.dc.dsw.model.PapelUsuario;
import br.ufscar.dc.dsw.model.Papel;
import java.sql.Connection;
import java.sql.Date;
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
public class DAOPapelUsuario extends DBConnection {
    
    public DAOPapelUsuario() {
        super();
    }
    
    public void insert(PapelUsuario papel_usuario) {
        String sql = "INSERT INTO papel_usuario (usuario, papel) VALUES (?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, papel_usuario.getUsuario());
            statement.setInt(2, papel_usuario.getPapel());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Papel> getPapelByUser(Usuario user) {
        List<Papel> listaPapelUsuario = new ArrayList<>();
        String sql = "SELECT Papel.nome as papel FROM papel_usuario WHERE usuario = ? "
                + "LEFT JOIN Papel on Papel.id = papel ";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaPapelUsuario.add(new Papel(resultSet.getString("papel")));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPapelUsuario;
    }
    
    public void deletePapel(PapelUsuario papel_usuario) {
        String sql = "DELETE FROM papel_usuario WHERE usuario = ? AND papel = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, papel_usuario.getUsuario());
            statement.setInt(2, papel_usuario.getPapel());
            statement.executeQuery();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
