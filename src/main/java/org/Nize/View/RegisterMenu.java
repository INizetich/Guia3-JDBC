package org.Nize.View;

import org.Nize.Control.CredencialesController;
import org.Nize.Control.UserController;
import org.Nize.Models.User;
import org.Nize.Utils.MenuUtils;

import java.util.Scanner;

public class RegisterMenu {
private static CredencialesController credencialesController = new CredencialesController();
private static Scanner scanner = new Scanner(System.in);
    public static void mostrarRegister() throws InterruptedException {

        boolean loop = true;
        int opc = 0;

        do {
            MenuText();
            opc = scanner.nextInt();
            switch (opc) {
                case 1 -> {
                    User user = iniciarSesion();
                    if(user !=null){
                        MainMenu.Inicio(user);
                    }else{
                        System.out.println("Credenciales inválidas.");
                    }
                    MenuUtils.pausarMenu();
                    MenuUtils.clearConsole();
                    break;
                }
                case 2 -> {
                    if(registarUsuario() == -1){
                        System.out.println("Error. Usuario Inexistente.");
                    }
                    MenuUtils.clearConsole();
                    break;
                }
                case 0 -> {
                    loop = false;
                    MenuUtils.clearConsole();
                    System.out.println("Saliendo...");
                    MenuUtils.pausarMenu();
                    System.exit(0);
                }
            }
        } while (loop);
    }


    private static void MenuText() {
        System.out.println("------Gestión App - Login------");
        System.out.println("1- Iniciar Sesión");
        System.out.println("2- Registrarse");
        System.out.println("\n0- Salir");
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

    private static int registarUsuario() {
        UserController userController = new UserController();
        User user = formUsuario();
        return userController.insertarUser(user);
    }


    private static User iniciarSesion(){
        scanner.nextLine();
        System.out.println("ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("ingrese la contraseña de usuario: ");
        String pass = scanner.nextLine();
        User user = credencialesController.iniciarSesion(nombreUsuario,pass);
        return user;
    }


}