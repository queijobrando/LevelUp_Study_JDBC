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

    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public Usuario acharPorId(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                 "SELECT usuario.* "
                    + "FROM usuario "
                    + "WHERE usuario.Id = ?"
            );

            ps.setInt(1, id);
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
