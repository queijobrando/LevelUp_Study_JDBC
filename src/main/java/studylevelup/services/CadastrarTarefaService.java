package studylevelup.services;

import studylevelup.bancodedados.DB;
import studylevelup.model.dao.DaoFactory;
import studylevelup.model.dao.TarefaDao;
import studylevelup.model.entities.Tarefa;
import studylevelup.model.entities.Usuario;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class CadastrarTarefaService {
    TarefaDao tarefadao = DaoFactory.criarTarefaJDBC();

    private String cadastrarNome(Scanner scanner){
        while (true) {
            System.out.print("Digite um nome para a Tarefa: ");
            String nome = scanner.nextLine();

            if (nome.trim().isEmpty()){
                System.out.println("Insira um nome!");
            } else{
                return nome;
            }
        }
    }

    private String cadastrarDescricao(Scanner scanner){
            System.out.print("Adicione uma descrição para sua tarefa (opcional):");
            String descricao = scanner.nextLine();

            return descricao;
    }


    public void cadastrarTarefa(Scanner scanner, Usuario usuario) {
        String nome = cadastrarNome(scanner);
        String descricao = cadastrarDescricao(scanner);

        Tarefa novatarefa = new Tarefa(nome, descricao, usuario);
        tarefadao.inserir(novatarefa, usuario);
    }
}
