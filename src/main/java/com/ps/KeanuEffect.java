package com.ps;
import java.util.Random;

public class KeanuEffect
{
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\u001B[38;5;208m";

    public static void printKeanuLogo() {
        Random random = new Random();
        String logo =
                "                                                           _\n" +
                        "                                                          //\n" +
                        "                                                         //\n" +
                        "                                         _______________//__\n" +
                        "                                       .(______________//___).\n" +
                        "                                       |    The Grub Hub    |\n" +
                        "                                       |. . . . . . . . . . |\n" +
                        "                                       \\ . . . . . . . . . /\n" +
                        "                                        |    We do food!    |\n" +
                        "                    _.---._             |::.......:::::::..|\n" +
                        "                _.-~       ~-._         |::::/::\\::/:\\:::::|\n" +
                        "            _.-~               ~-._     |::::\\::/::::::X/::|\n" +
                        "        _.-~                       ~---.;:::::::/::\\::/::::|\n" +
                        "    _.-~                                 ~\\::::::n:::::::::|\n" +
                        " .-~                                    _.;::/::::a:::::::/\n" +
                        " :-._                               _.-~ ./::::::::d::::::|\n" +
                        " `-._~-._                   _..__.-~ _.-~|::/:::::::::::::|\n" +
                        "  /  ~-._~-._              / .__..--~----.YWWWWWWWWWWWWWWP'\n" +
                        " \\_____(_;-._\\.        _.-~_/       ~).. . \\\n" +
                        "    /(_____  \\`--...--~_.-~______..-+_______)\n" +
                        "  .(_________/`--...--~/    _/           /\\\n" +
                        " /-._     \\_     (___./_..-~__.....__..-~./\n" +
                        " `-._~-._   ~\\--------~  .-~_..__.-~ _.-~\n" +
                        "     ~-._~-._ ~---------'  / .__..--~\n" +
                        "         ~-._\\.        _.-~_/\n" +
                        "             \\`--...--~_.-~\n" +
                        "              `--...--~\n" +
                        "                     \n ";

        for (char c : logo.toCharArray()) {
            System.out.print(ORANGE + c + RESET);
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// no more classes adding here :(((

class TextEffects {

    public static void typewriterEffect(String message) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(35);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void blinkingText(String message) {
        for (int i = 0; i < 4; i++) {
            System.out.print("\r" + message);
            try {
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length()));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\r" + message);
    }
}
