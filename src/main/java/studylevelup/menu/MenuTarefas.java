package studylevelup.menu;

import studylevelup.model.dao.DaoFactory;
import studylevelup.model.dao.TarefaDao;
import studylevelup.model.entities.Usuario;
import studylevelup.services.CadastrarTarefaService;

import java.util.Scanner;

public class MenuTarefas extends Menu {
    public Integer opcao;
    public Usuario usuario;

    Scanner sc = new Scanner(System.in);
    CadastrarTarefaService cadastrarTarefa = new CadastrarTarefaService();
    TarefaDao tarefadao = DaoFactory.criarTarefaJDBC();

    @Override
    public void mostrarOpcoes() {
        System.out.println("MENU TAREFAS");
        System.out.println("""
                \n1.Adicionar uma nova tarefa
                \n2.Listar tarefas
                \n3.Voltar
                """);
        System.out.print("\nInsira a opção: ");
    }

    public void inserirEntradas2(Usuario usuario) {
        do {
            this.usuario = usuario;
            mostrarOpcoes();
            try {

                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao){
                    case 1 -> cadastrarTarefa.cadastrarTarefa(sc, usuario);
                    case 2 -> System.out.println(tarefadao.exibirTodas(usuario));
                    case 3 -> {
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
