package org.Nize.Utils;

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
}
