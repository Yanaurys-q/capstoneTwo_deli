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
                        "              `--...--~\n";

        for (char c : logo.toCharArray()) {
            System.out.print(ORANGE + c + RESET);
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}