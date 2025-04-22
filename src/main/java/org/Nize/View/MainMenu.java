package org.Nize.View;

import org.Nize.Control.CredencialesController;
import org.Nize.Control.CuentaCorrienteController;
import org.Nize.Control.UserController;

import java.util.Scanner;

public class MainMenu {
    private UserController userController;
    private CredencialesController credencialesController;
    private Scanner scanner = new Scanner(System.in);
    private CuentaCorrienteController ccontroller;

    public MainMenu() {
        ccontroller = new CuentaCorrienteController();
        userController = new UserController();
        credencialesController = new CredencialesController();


    }

    public void menuText() {
        System.out.println("--------Gestión Usuarios--------");
        System.out.println("1-");
    }


}
