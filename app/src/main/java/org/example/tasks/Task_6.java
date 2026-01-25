package org.example.tasks;

import java.util.Scanner;

import org.example.util.*;

public class Task_6 implements Task {

  private final double R = 1;

  @Override
  public void run(Scanner scan) {
    System.out.println("X:");
    double x = scan.nextDouble();
    while (x > R || x < -R) {
      System.out.println("Недопустимое значение");
      x = scan.nextDouble();
    }
    System.out.println("N:");
    int n = scan.nextInt();
    System.out.println("E:");
    double e = scan.nextDouble();

    double sumn = 0;
    double gte = 0;
    double gte10 = 0;

    for (int i = 0; i < n; i++) {
      double fact = factorial(i);
      double a = (fact / factorial(i - 1) * 2) / (fact * 2) * Math.pow(x, i);
      sumn += a;
      if (Math.abs(a) > e)
        gte += a;
      if (Math.abs(a) > e / 10)
        gte10 += 1;
    }

    System.out.println("Суммма слагаемых: " + sumn);
    System.out.println("Сумма слагаемых, больше чем e: " + gte);
    System.out.println("Сумма слагаемых, больше чем е/10: " + gte10);
    System.out.println("Значение функции с помощью Math: " +
        Math.pow(1 + x, 0.5));
  }

  public long factorial(int n) {
    if (n <= 2) {
      return n;
    }
    return n * factorial(n - 1);
  }

  @Override
  public String getTitle() {
    return "Сумма слагаемых по x, n и e";
  }

  @Override
  public String getDescription() {
    return """
        Находит сумму n слагаемых, сумму слагаемых больше е,
        сумму слагаемых больше е/10 и значение функции
        с помощью Math.
        """;
  }

  @Override
  public String getTaskIndex() {
    return "6";
  }
}
