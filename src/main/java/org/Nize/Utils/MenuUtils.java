package org.Nize.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuUtils {

    public static void clearConsole(){
        for (int i = 0; i<15;i++){
            System.out.println("\n");
        }
    }

    public static void pausarMenu(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fechaActual(){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaActual = LocalDateTime.now();

        return fechaActual.format(formateador);
    }


    public static void mostrarCerrando() {
        String[] animacion = {"|", "/", "-", "\\"};  // Barras giratorias
        int i = 0;

        // Simula el proceso de carga

        try {
            for (int j = 0; j < 10; j++) {  // 10 ciclos de la animación
                System.out.print("saliendo-> "+animacion[i] + "\r");  // Sobrescribe la línea anterior
                i = (i + 1) % animacion.length;  // Cambia al siguiente símbolo en el arreglo
                Thread.sleep(250);  // Pausa de 250ms entre cada cambio
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
