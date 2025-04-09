package studylevelup.services;

import studylevelup.model.dao.DaoFactory;
import studylevelup.model.dao.UsuarioDao;
import studylevelup.model.entities.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CadastrarUsuarioServices {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    UsuarioDao usuarioDao = DaoFactory.criarUsuarioDao();

    public String cadastrarNome(Scanner scanner){
        while (true) {
            System.out.print("Qual o seu nome: ");
            String nome = scanner.nextLine();

            if (nome.trim().isEmpty()){
                System.out.println("Insira um nome!");
            } else if (!nome.matches("[a-zA-Z ]+")){
                System.out.println("O nome deve conter apenas letras!");
            } else{
                return nome;
            }
        }
    }

    public String cadastrarEmail(Scanner scanner){
        while (true) {
            System.out.print("Qual o seu email: ");
            String email = scanner.nextLine();

            if (email.isEmpty()){
                System.out.println("Insira um nome!");
            } else{
                return email;
            }
        }
    }

    public Date cadastrarDataNascimento(Scanner scanner){
        while (true) {
            try {
                System.out.print("Qual sua data de nascimento? (dd/mm/yyyy): ");
                Date dataNascimento = sdf.parse(scanner.next());
                scanner.nextLine();

                return dataNascimento;
            }
            catch (ParseException e){
                System.out.println("Erro de formatção da data, tente novamente");
            }
        }
    }

    public String cadastrarLogin(Scanner scanner){
        while (true) {
            System.out.print("Crie um login para o seu usuario: ");
            String login = scanner.nextLine();

            if (login.isEmpty()){
                System.out.println("Insira um nome de usuário!");
            } else{
                return login;
            }
        }
    }

    public String cadastrarSenha(Scanner scanner){
        while (true) {
            System.out.print("Crie uma senha para o seu usuario: ");
            String senha = scanner.nextLine();

            if (senha.isEmpty()){
                System.out.println("Insira um nome de usuário!");
            } else if (senha.length() < 5){
                System.out.println("Insira uma senha com mais de 5 digitos");
            } else {
                return senha;
            }
        }
    }

    public void cadastrarUsuario(Scanner scanner) {
            String nome = cadastrarNome(scanner);
            String email = cadastrarEmail(scanner);
            Date data = cadastrarDataNascimento(scanner);
            String usuario = cadastrarLogin(scanner);
            String senha = cadastrarSenha(scanner);

            Usuario novousuario = new Usuario(nome, email, data, usuario, senha);
            usuarioDao.inserir(novousuario);
    }
}
