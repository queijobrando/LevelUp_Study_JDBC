package studylevelup.model.dao.impl;

import studylevelup.model.dao.UsuarioDao;
import studylevelup.model.entities.Usuario;

import java.util.List;

public class UsuarioDaoJDBC implements UsuarioDao {
    @Override
    public void inserir(Usuario usuario) {

    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public Usuario acharPorId(Integer id) {
        return null;
    }

    @Override
    public List<Usuario> exibirTodos() {
        return List.of();
    }
}
