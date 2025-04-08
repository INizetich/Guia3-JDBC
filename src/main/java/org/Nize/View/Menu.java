package org.Nize.View;

import org.Nize.Control.UserController;
import org.Nize.Models.User;

import java.util.Scanner;

public class Menu {
    private UserController userController;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        userController = new UserController();
    }

    public void llamarController() {
        userController.insertarUser(crearUsuario());
    }

    public User crearUsuario() {
        System.out.println("--CREAR NUEVO USUARIO--");
        System.out.println("Ingrese Nombre: ");
        String Nombre = scanner.nextLine();
        System.out.println("Ingrese Apellido: ");
        String Apellido = scanner.nextLine();
        System.out.println("Ingrese DNI: ");
        String DNI = scanner.nextLine();
        System.out.println("Ingrese Email: ");
        String email = scanner.nextLine();

        return new User(Nombre,Apellido,DNI,email, "NN", 7);
    }

}
