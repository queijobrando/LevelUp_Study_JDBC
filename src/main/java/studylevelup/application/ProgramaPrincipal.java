package studylevelup.application;

import studylevelup.menu.MenuPrincipal;
import studylevelup.model.entities.Usuario;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuPrincipal chamarMenu = new MenuPrincipal();

        System.out.println("-- LEVELUP STUDY --");
        System.out.println("Seja bem vindo(a)!");

        chamarMenu.inserirEntradas2(sc);

        System.out.println("Encerrando programa...");
        sc.close();


    }
}
