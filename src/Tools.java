/* ###################################
Title: Tools
Author: Draedn Groves
Date: Mar.21st/2024
Purpose: Tools file for all program requirements
################################### */

import java.util.Scanner;

public class Tools {

    // simple end program method
    public static void endProgram() {
        System.exit(0);
    }

    // simple pause program method
    public static void pauseProgram() {
        System.out.println("Press Enter to continue...");
        new Scanner(System.in).nextLine();
    }

    // simple int form console validation
    public static int getIntFromConsole() throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!isValidInt(input)) {
            throw new Exception("Invalid input. Please enter an integer.");
        }
        return Integer.parseInt(input);
    }

    // simple int form console validation + min and max parameters
    public static int getIntFromConsole(String prompt, int minValue, int maxValue) throws Exception {
        int value = getIntFromConsole();
        if (value < minValue || value > maxValue) {
            throw new Exception("Invalid input. Please enter an integer between " + minValue + " and " + maxValue + ".");
        }
        return value;
    }

    public static double getDblFromConsole(String prompt) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String input = sc.nextLine();
        if (!isValidDbl(input)) {
            throw new Exception("Invalid input. Please enter a double.");
        }
        return Double.parseDouble(input);
    }

    // get float value with min and max method
    public static double getDblFromConsole(String prompt, double minValue, double maxValue) throws Exception {
        double value = getDblFromConsole(prompt);
        if (value < minValue || value > maxValue) {
            throw new Exception("Invalid input. Please enter a double between " + minValue + " and " + maxValue + ".");
        }
        return value;
    }

    public static String getStringFromConsole(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }

    private static boolean isValidInt(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidDbl(String inputString) {
        try {
            Double.parseDouble(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}




