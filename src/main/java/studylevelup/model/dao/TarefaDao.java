package studylevelup.model.dao;

import studylevelup.model.entities.Tarefa;
import studylevelup.model.entities.Usuario;

import java.util.List;

public interface TarefaDao {
    void inserir (Tarefa tarefa, Usuario usuario);
    void excluir (Tarefa tarefa);
    List<Tarefa> exibirTodas(Usuario usuario);
}
