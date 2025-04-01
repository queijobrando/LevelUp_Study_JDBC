package studylevelup.application;

import studylevelup.menu.MenuPrincipal;
import studylevelup.model.entities.Usuario;
import studylevelup.services.PastaCadastrosService;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuPrincipal chamarMenu = new MenuPrincipal();
        PastaCadastrosService gerarpasta = new PastaCadastrosService();

        System.out.println("-- LEVELUP STUDY --");
        System.out.println("Seja bem vindo(a)!");

        gerarpasta.geraPasta();
        String entrada = chamarMenu.inserirEntradas2(sc);

        if (entrada == null){
            System.out.println("Encerrando programa...");
            sc.close();
        } else {
            System.out.println("SEJA BEM VINDO(A)"+entrada);
            Usuario usuariologado = new Usuario();
            System.out.println(entrada);
            System.out.println(usuariologado.getIdade(entrada));
        }


    }
}
