package org.Nize.View;

import org.Nize.Control.CredencialesController;
import org.Nize.Control.CuentaCorrienteController;
import org.Nize.Control.UserController;
import org.Nize.Models.CredencialesDAO;
import org.Nize.Models.User;
import org.Nize.Utils.MenuUtils;

import java.util.Scanner;

public class RegisterMenu {

    public static void mostrarRegister() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        int opc = 0;

        do {
            MenuText();
            opc = scanner.nextInt();
            switch (opc) {
                case 1 -> {
                    MenuUtils.clearConsole();
                    break;
                }
                case 2 -> {
                    registarUsuario();
                    MenuUtils.clearConsole();
                    break;
                }
                case 0 -> {
                    loop = false;
                    MenuUtils.clearConsole();
                    System.out.println("Saliendo...");
                    System.exit(0);
                }
            }
        } while (loop);
    }


    private static void MenuText() {
        System.out.println("------Gestión App------");
        System.out.println("1- Iniciar Sesión");
        System.out.println("2- Registrarse");
        System.out.println("\n 0- Salir");
    }

    private static User formUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--CREAR NUEVO USUARIO--");
        System.out.println("Ingrese Nombre: ");
        String Nombre = scanner.nextLine();
        System.out.println("Ingrese Apellido: ");
        String Apellido = scanner.nextLine();
        System.out.println("Ingrese DNI: ");
        String DNI = scanner.nextLine();
        System.out.println("Ingrese Email: ");
        String email = scanner.nextLine();

        return new User(Nombre, Apellido, DNI, email);
    }

    private static void registarUsuario() {
        UserController userController = new UserController();
        CuentaCorrienteController cuentacontroller = new CuentaCorrienteController();
        CredencialesController ccontroller = new CredencialesController();
        User user = formUsuario();
        int id = userController.insertarUser(user);
        ccontroller.crearCredenciales(user);
        cuentacontroller.abrirCajaAhorro(id);
    }


}