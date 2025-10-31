package org.example.tasks;

import org.example.util.Task;

import java.util.Scanner;

public class Task_5 implements Task {
    @Override
    public String getTitle() {
        return "Фигура #29";
    }

    @Override
    public String getDescription() {
        return """
                Рисует фигуру #29.
                """;
    }

    @Override
    public String getTaskIndex() {
        return "5";
    }

    @Override
    public void run(Scanner scan) {
        System.out.println("W:");
        int w = scan.nextInt();
        System.out.println("H:");
        int h = scan.nextInt();

        if (w % 2 == 0 || h % 2 == 0) {
            System.out.println("Число не может быть нечётным");
            return;
        }
        if (w < 5) {
            System.out.println("Ширина не может быть ниже 5");
            return;
        }
        if (h < 5) {
            System.out.println("Высота не может быть ниже 5");
            return;
        }

        System.out.println("*" + "-".repeat(w/2-1) + "*");
        for (int i = 0; i < h/2-1; i++) {
            System.out.println("|" + " ".repeat(w/2-1) + "|");
        }
        System.out.println("*" + "-".repeat(w/2-1) + "*" + "-".repeat(w/2-1) + "*");
        for (int i = 0; i < h/2-1; i++) {
            System.out.println(" ".repeat(w/2) + "|" + " ".repeat(w/2-1) + "|");
        }
        System.out.println(" ".repeat(w/2) + "*" + "-".repeat(w/2-1) + "+");
    }
}
