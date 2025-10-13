package org.example.tasks;

import org.example.util.Task;

import java.util.Scanner;

public class Task_4 implements Task {

    @Override
    public String getTitle() {
        return "k-ая цифра последовательности 123456789101112...";
    }

    @Override
    public String getDescription() {
        return """
                Находит k-ую цифру последовательности 123456789101112...,
                в которой выписаны все натуральные числа. Если было
                введено отрицательное число, программа надайдёт abs(k)-ую
                цифру последовательности. Если был введён 0, программа
                выведет 0.
                """;
    }

    @Override
    public String getTaskIndex() {
        return "4";
    }

    @Override
    public void run(Scanner scan) {
        System.out.println("K: ");
        int k = Math.abs(scan.nextInt());

        int d = 1;
        int s = 1;
        int c = 9;

        while (k > d * c) {
            k -= d * c;
            d += 1;
            s *= 10;
            c *= 10;
        }

        int num = s + (k - 1) / d;
        int pos = (k - 1) % d;

        int pw = (int) Math.pow(10, (d - 1 - pos));
        int ans = (num / pw) % 10;
        System.out.println("k-ая цифра: " + ans);
    }
}
