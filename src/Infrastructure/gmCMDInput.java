package Infrastructure;

import java.util.Scanner;

public class gmCMDInput {
    private static Scanner gmScanner = new Scanner(System.in);

    public static String gmLeerInput(String gmPrompt) {
        System.out.print(gmPrompt);
        return gmScanner.nextLine();
    }

    public static String gmLeerInput() {
        return gmScanner.nextLine();
    }
}
