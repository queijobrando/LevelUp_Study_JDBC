package studylevelup.model.dao.impl;

import studylevelup.bancodedados.DB;
import studylevelup.bancodedados.DbException;
import studylevelup.model.dao.UsuarioDao;
import studylevelup.model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDaoJDBC implements UsuarioDao {
    private Connection conn;

    public UsuarioDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void inserir(Usuario usuario) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "INSERT INTO usuario "
                            +"(Nome, Email, DataNascimento, NickName, Senha) "
                            +"VALUES "
                            +"(?, ?, ?, ?, ?)");

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setDate(3, new java.sql.Date(usuario.getDataNascimento().getTime()));
            ps.setString(4, usuario.getNickname());
            ps.setString(5, usuario.getSenha());

            ps.executeUpdate();

            System.out.println("Usuario adicionado com sucesso!");
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public Usuario acharLogin(String nickname, String senha) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                 "SELECT usuario.* "
                    + "FROM usuario "
                    + "WHERE NickName = ? "
                    + "AND Senha = ?"
            );

            ps.setString(1, nickname);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (rs.next()){
                Usuario usuario = new Usuario(rs.getInt("Id"), rs.getString("Nome"), rs.getString("Email"), rs.getDate("DataNascimento"), rs.getString("NickName"), rs.getString("Senha"));
                return usuario;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Usuario> exibirTodos() {
        return List.of();
    }
}
