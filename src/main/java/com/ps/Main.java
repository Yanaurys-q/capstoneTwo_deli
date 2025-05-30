package com.ps;

import java.util.Scanner;

import static com.ps.KeanuEffect.printKeanuLogo;
import static com.ps.TextEffects.blinkingText;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        printKeanuLogo();
        System.out.println("Press Enter to continue...");
        new Scanner(System.in).nextLine();
        blinkingText("Loading...");
        System.out.println("Complete");
        System.out.println("");
        UserInterface.init();

    }

}
