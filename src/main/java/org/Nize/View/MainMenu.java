package org.Nize.View;

import org.Nize.Control.CredencialesController;
import org.Nize.Control.CuentaCorrienteController;
import org.Nize.Models.CuentaCorriente;
import org.Nize.Models.User;
import org.Nize.Utils.MenuUtils;

import java.util.Scanner;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void Inicio(User user) {
        boolean loop = user.getID_Usuario() != -1;

        while (loop) {
            menuText(user);
            int opc = 0;
            opc = scanner.nextInt();

            switch (opc) {
                case 1 ->{
                    mostrarCuentaCorriente(user);
                    break;
                }
                case 2 -> {
                    abrirCuentaCorriente(user);
                    break;
                }
                case 3 -> {

                    break;
                }

                case 4 -> {
                    cambiarPassword(user);
                    break;
                }
                case 0 -> {
                    loop = false;
                    System.out.println("Sesión cerrada.");
                    MenuUtils.pausarMenu();
                    MenuUtils.clearConsole();
                    break;
                }
                default -> {
                    System.out.println("Ingrese una opción válida.");
                    MenuUtils.pausarMenu();
                    MenuUtils.clearConsole();
                }
            }
        }
    }

    private static void menuText(User user) {
        System.out.println("--------Gestión App, Menú Principal--------");
        System.out.println("1- Ver caja de ahorro.");
        System.out.println("2- Abrir cuenta corriente.");
        System.out.println("3- Ver mis cuentas corrientes.");
        System.out.println("4- Cambiar contraseña.");
        System.out.println("0- Cerrar sesión.");
        System.out.println("\nSesión iniciada como: " + user.getApellido() + ", " + user.getNombre() + ".");

    }


    private static void abrirCuentaCorriente(User user){
        CuentaCorrienteController cuentaCorrienteController = new CuentaCorrienteController();
        cuentaCorrienteController.abrirCuentaCorriente(user.getID_Usuario());
    }

    private static void mostrarCuentaCorriente(User user){
        CuentaCorrienteController cuentaCorrienteController = new CuentaCorrienteController();
        CuentaCorriente cuentaCorriente = cuentaCorrienteController.mostrarCuentaCorriente(user.getID_Usuario());
        System.out.println("DATOS DE LA CUENTA CORRIENTE: ");
        System.out.println(cuentaCorriente);
    }


    private static void cambiarPassword(User user){
        CredencialesController credencialesController = new CredencialesController();
        System.out.println("ingrese su contraseña actual: ");
        scanner.nextLine();
        String actualPassword = scanner.nextLine();
      boolean validacion =  credencialesController.validarPassword(actualPassword,user.getID_Usuario());

      if(validacion){
          System.out.println("ingrese su nueva password: ");
          String newPassword = scanner.nextLine();
         boolean exito = credencialesController.cambiarPass(newPassword,user.getID_Usuario());

         if(exito){
             System.out.println("password actualizada correctamente.");
         }else {
             System.out.println("Ocurrio un error al cambiar el password.");
         }
      }else {
          System.out.println("Password incorrecta, por favor introduce su contraseña actual para continuar.");
      }


    }





}
