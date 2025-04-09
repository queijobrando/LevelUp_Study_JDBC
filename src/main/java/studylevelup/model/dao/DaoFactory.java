package studylevelup.model.dao;

import studylevelup.bancodedados.DB;
import studylevelup.model.dao.impl.TarefaDaoJDBC;
import studylevelup.model.dao.impl.UsuarioDaoJDBC;

public class DaoFactory {

    public static UsuarioDao criarUsuarioDao(){
        return new UsuarioDaoJDBC(DB.getConnection());

        /*
        CREATE TABLE usuario (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  DataNascimento datetime NOT NULL,
  NickName varchar(30) NOT NULL,
  Senha varchar(60) NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE tarefas(
Id int(11) NOT NULL AUTO_INCREMENT,
Nome varchar(60) NOT NULL,
Descricao varchar(100),
IdUsuario int(11) NOT NULL,
Status ENUM('Ativa', 'Concluída') DEFAULT 'Ativa',
PRIMARY KEY (Id),
FOREIGN KEY (IdUsuario) REFERENCES usuario (Id)
);
         */
    }

    public static TarefaDao criarTarefaJDBC(){
        return new TarefaDaoJDBC(DB.getConnection());
    }
}
