package studylevelup.menu;

import studylevelup.model.entities.Usuario;

import java.util.Scanner;

public class MenuLogado extends Menu{
    public Integer opcao;
    public Usuario usuario;

    Scanner sc = new Scanner(System.in);
    MenuPrincipal chamarMenu = new MenuPrincipal();

    public MenuLogado() {
    }

    public MenuLogado(Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrarOpcoes2(Usuario usuario) {
        System.out.println("SEJA BEM VINDO(A) "+usuario.getNome());
        System.out.println("""
                \n1.Perfil
                \n2.Tarefas
                \n3.Logout
                """);
        System.out.print("\nInsira a opção: ");
    }

    public void inserirEntradas2(Usuario usuario) {
        do {
            this.usuario = usuario;
            mostrarOpcoes2(usuario);
            try {

                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao){
                    case 1 -> mostrarPerfil(sc);
                    case 2 -> System.out.println("EM BREVE");
                    case 3 -> {
                        System.out.println("Saindo...");
                        this.usuario = null; //apaga da memoria o usuario logado para não ocupar espaço
                        return;
                    }
                    default -> System.out.println("Erro: Insira uma opção válida!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Erro: Entrada inválida! Digite um número!");
            }
        }while (opcao != 3);
    }

    public void mostrarPerfil(Scanner scan){
        do {
            try {
                System.out.println(usuario);
                System.out.println("\n3.Voltar");
                System.out.println("\nInsira a opção: ");
                int voltar = Integer.parseInt(scan.nextLine());
                if (voltar == 3){
                    return;
                }else {
                    System.out.println("Erro: Insira uma opção válida!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Erro: Entrada inválida! Digite um número!");
            }
        }while (true);
    }
}
