package studylevelup.model.dao;

import studylevelup.model.entities.Usuario;

import java.util.List;

public interface UsuarioDao {
    void inserir (Usuario usuario);
    void update (Usuario usuario);
    Usuario acharLogin (String nome, String senha);
    List<Usuario> exibirTodos();
}
