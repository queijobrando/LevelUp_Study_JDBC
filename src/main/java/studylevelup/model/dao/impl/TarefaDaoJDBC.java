package studylevelup.model.dao.impl;

import studylevelup.bancodedados.DB;
import studylevelup.bancodedados.DbException;
import studylevelup.model.dao.TarefaDao;
import studylevelup.model.entities.Tarefa;
import studylevelup.model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDaoJDBC implements TarefaDao {
    private Connection conn;

    public TarefaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Tarefa tarefa, Usuario usuario) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "INSERT INTO tarefas "
                            +"(Nome, Descricao, IdUsuario) "
                            +"VALUES "
                            +"(?, ?, ?)");
            ps.setString(1, tarefa.getNome());
            ps.setString(2, tarefa.getDescricao());
            ps.setInt(3, usuario.getId());

            ps.executeUpdate();
            System.out.println("Tarefa adicionada com sucesso!");

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }


    }

    @Override
    public void excluir(Tarefa tarefa) {

    }

    @Override
    public List<Tarefa> exibirTodas(Usuario usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                        "SELECT tarefas.* "
                                + "FROM tarefas INNER JOIN usuario "
                                + "ON tarefas.IdUsuario = usuario.Id "
                                + "WHERE IdUsuario = ? "
                                + "AND tarefas.Status = 'Ativa' "
                                + "ORDER BY Nome"
            );

            ps.setInt(1, usuario.getId());
            rs = ps.executeQuery();

            List<Tarefa> lista = new ArrayList<>();
            while (rs.next()){
                Tarefa tarefa  = new Tarefa();
                tarefa.setId(rs.getInt("Id"));
                tarefa.setNome(rs.getString("Nome"));
                tarefa.setDescricao(rs.getString("Descricao"));
                lista.add(tarefa);
            }
            return lista;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }
}
