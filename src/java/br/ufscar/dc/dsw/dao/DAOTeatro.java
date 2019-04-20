package br.ufscar.dc.dsw.dao;

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

public class DAOTeatro extends DBConnection {

    public DAOTeatro() {
        super();
    }

    public void insert(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nickname, nome, grupo, senha, data_criacao) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getNickname());
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

    public List<Usuario> getAll() {
        List<Usuario> listaLivros = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nickname = resultSet.getString("nickname");
                String nome = resultSet.getString("nome");
                int grupo = resultSet.getInt("grupo");
                String senha = resultSet.getString("senha");
                Date data = resultSet.getDate("data_criacao");
                Usuario usuario = new Usuario(nickname, nome, grupo, senha, data);
                listaLivros.add(usuario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLivros;
    }

    public void delete(Usuario user) {
        String sql = "DELETE FROM Usuario where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getNickname());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    public Usuario get(String nickname) {
        Usuario user = null;
        String sql = "SELECT * FROM Usuario WHERE nickname = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nickname);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int grupo = resultSet.getInt("grupo");
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
