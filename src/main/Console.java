package main;

import java.util.Scanner;

public class Console {
    public static String readStringFromStdin(String text) {
        Scanner scanner = new Scanner(System.in);
        String someText;
        System.out.print(text);
        someText = scanner.nextLine();
        return someText;
    }
}
