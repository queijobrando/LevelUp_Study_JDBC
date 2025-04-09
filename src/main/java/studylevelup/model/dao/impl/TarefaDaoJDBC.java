package studylevelup.model.dao.impl;

import studylevelup.bancodedados.DB;
import studylevelup.bancodedados.DbException;
import studylevelup.model.dao.TarefaDao;
import studylevelup.model.entities.Tarefa;
import studylevelup.model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public List<Tarefa> exibirTodas() {
        return List.of();
    }
}
