package studylevelup.menu;

import studylevelup.model.entities.Usuario;
import studylevelup.services.PastaCadastrosService;

import java.util.Scanner;

public class MenuPrincipal extends Menu {
    public int opcao;

    MenuCadastro menucadastro = new MenuCadastro();
    MenuLogin menuLogin = new MenuLogin();
    PastaCadastrosService path = new PastaCadastrosService();

    @Override
    public void mostrarOpcoes() {
        System.out.println("""
                \n1.Criar conta
                \n2.Entrar
                \n3.Sair
                """);
        System.out.print("\nInsira a opção: ");
    }

    public Usuario inserirEntradas2(Scanner scanner) {
        do {
            mostrarOpcoes();
            try {

                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> menucadastro.inserirEntradas(scanner);
                    case 2 -> menuLogin.inserirEntradasLogin(scanner);
                    case 3 -> System.out.println("\n");
                    default -> System.out.println("Erro: Insira uma opção válida!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Erro: Entrada inválida! Digite um número!");
            }
        }while (opcao != 3);
        return null;
    }
}
