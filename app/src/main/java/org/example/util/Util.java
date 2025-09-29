package org.example.util;

import java.util.Scanner;

public class Util {
    public static int getIntInput(Scanner scan) {
        int prompt = 0;
        while (scan.hasNext()){
            prompt = scan.nextInt() - 1;
        }
        return prompt;
    }

    public static String getLineInput(Scanner scan) {
        String prompt = "0";
        while (scan.hasNext()){
            prompt = scan.nextLine();
        }
        return prompt;
    }
}
