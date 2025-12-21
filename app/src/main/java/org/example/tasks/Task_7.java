package org.example.tasks;

import org.example.util.Task;

import java.util.Scanner;

public class Task_7 implements Task {
    @Override
    public void run(Scanner scan) {
        System.out.print("N: ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        System.out.println("Элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int firstPrimeIndex = -1;
        int lastPrimeIndex = -1;
        int sum = 0;
        boolean cnt = false;

        for (int i = 0; i < arr.length; i++) {
            if (isPrime(Math.abs(arr[i])) && firstPrimeIndex == -1) {
                firstPrimeIndex = i;
                cnt = true;
            }
            if (isPrime(Math.abs(arr[arr.length - 1 - i])) && lastPrimeIndex == -1) {
                lastPrimeIndex = arr.length - 1 - i;
            }
            if (lastPrimeIndex == i) cnt = false;

            if (cnt && arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }

        System.out.println("Сумма: " + sum);
    }

    public static boolean isPrime(int n)
    {
        n = Math.abs(n);
        if (n >= 0 && n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    @Override
    public String getTitle() {
        return "Сумма четных элементов массива";
    }

    @Override
    public String getDescription() {
        return """
                Находит сумму четных элементов массива, расположенных
                между первым простым (по модулю) элементом массива и последним простым (по
                модулю) элементом. Для проверки простоты числа реализовать отдельную функцию.
                Ноль считать простым числом.""";
    }

    @Override
    public String getTaskIndex() {
        return "7";
    }
}
