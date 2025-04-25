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
}
