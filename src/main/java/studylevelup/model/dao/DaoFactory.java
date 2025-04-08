package studylevelup.model.dao;

import studylevelup.model.dao.impl.UsuarioDaoJDBC;

public class DaoFactory {

    public static UsuarioDao criarUsuarioDao(){
        return new UsuarioDaoJDBC();

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
         */
    }
}
