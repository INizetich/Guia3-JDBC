package org.Nize.View;

import org.Nize.Control.CredencialesController;
import org.Nize.Control.UserController;
import org.Nize.Models.CuentaCorriente;
import org.Nize.Models.User;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private UserController userController;
    private CredencialesController credencialesController;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        userController = new UserController();
        credencialesController = new CredencialesController();
    }

    public void llamarController() {
//        User user = crearUsuario();
////        userController.insertarUser(user);
//        user = userController.getUser(user.getDni());
//        credencialesController.crearCredenciales(user);
        mostrarLista(userController.listarCuentasCorrientes(1));
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

    private void mostrarLista(List<CuentaCorriente> lista){
        for(CuentaCorriente cuentaCorriente : lista){
            System.out.println(cuentaCorriente);
        }
    }

}
