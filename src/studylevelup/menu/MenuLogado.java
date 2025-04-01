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

    public void mostrarOpcoes2(String nome) {
        System.out.println("SEJA BEM VINDO(A) "+nome);
        System.out.println("""
                \n1.Perfil
                \n2.Tarefas
                \n3.Logout
                """);
        System.out.print("\nInsira a opção: ");
    }

    public void inserirEntradas2(Usuario usuario, String nome) {
        do {
            this.usuario = usuario;
            mostrarOpcoes2(nome);
            try {

                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao){
                    case 1 -> chamarMenu.inserirEntradas2(sc);
                    case 2 -> chamarMenu.inserirEntradas2(sc);
                    case 3 -> {
                        System.out.println("Saindo...");
                        usuario = null; //apaga da memoria o usuario logado para não ocupar espaço
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
}
