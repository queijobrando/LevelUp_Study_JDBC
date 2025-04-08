package studylevelup.menu;

import studylevelup.model.dao.DaoFactory;
import studylevelup.model.dao.UsuarioDao;
import studylevelup.model.entities.Usuario;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MenuLogin extends Menu {
    UsuarioDao usuarioDao = DaoFactory.criarUsuarioDao();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void inserirEntradasLogin(Scanner scanner) {
        System.out.print("\nDigite seu usuario: ");
        String inserirusuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String inserirsenha = scanner.nextLine();

        Usuario usuario = usuarioDao.acharLogin(inserirusuario, inserirsenha);
        if (usuario != null){
            MenuLogado menuLogado = new MenuLogado(usuario);
            menuLogado.inserirEntradas2(usuario);
        } else {
            System.out.println("Login Incorreto! Tente novamente!");
        }

    }
}
