package studylevelup.menu;

import studylevelup.model.entities.Usuario;
import studylevelup.services.PastaCadastrosService;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MenuLogin extends Menu {
    PastaCadastrosService path = new PastaCadastrosService();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);

    public void inserirEntradasLogin(Scanner scanner) {
        System.out.print("\nDigite seu usuario: ");
        String inserirusuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String inserirsenha = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path.getCadastrosPath()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] espacos = linha.split(",");
                String nome = espacos[0];
                String email = espacos[1];
                String data = espacos[2];
                String nomeUsuario = espacos[3];
                String senhaUsuario = espacos[4];

                if (nomeUsuario.equals(inserirusuario) && senhaUsuario.equals(inserirsenha)) {
                    try {
                        Usuario usuariologado = new Usuario(nome, email, sdf.parse(data), nomeUsuario, senhaUsuario );
                        MenuLogado menuLogado = new MenuLogado(usuariologado);
                        menuLogado.inserirEntradas2(usuariologado, usuariologado.getNome());
                        break;
                    }
                    catch (ParseException e){
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Senha Incorreta! Tente novamente!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
