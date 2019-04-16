package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class DAOUsuario {

    public DAOUsuario() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/dsw_1", "root", "root");
    }

    public void insert(Usuario usuario) {
        String sql = "INSERT INTO Usuario (email, nome, papel_id, senha, data_criacao) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getNome());
            statement.setInt(3, 1);
            statement.setString(4, usuario.getSenha());
            statement.setDate(5, new Date(System.currentTimeMillis()));
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> getAll() throws NoSuchAlgorithmException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nickname = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                int grupo = resultSet.getInt("grupo");
                Date data = resultSet.getDate("data_criacao");
                Usuario usuario = new Usuario(nickname, nome, grupo, "", data);
                listaUsuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }
//
//    public void delete(Usuario user) {
//        String sql = "DELETE FROM Usuario where id = ?";
//        try {
//            Connection conn = this.getConnection();
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, user.getNickname());
//            statement.executeUpdate();
//            statement.close();
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


    public Usuario get(String nickname) throws NoSuchAlgorithmException {
        Usuario user = null;
        String sql = "SELECT * FROM Usuario WHERE email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nickname);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int grupo = resultSet.getInt("papel_id");
                String senha = resultSet.getString("senha");
                Date data = resultSet.getDate("data_criacao");
                user = new Usuario(nickname, nome, grupo, senha, data);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
