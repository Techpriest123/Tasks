package org.example.tasks;

import java.util.Scanner;
import org.example.util.Task;

public class Task_2 implements Task {
  @Override
  public String getTitle() {
    return "Максимальное количество тортов двух типов";
  }

  @Override
  public String getDescription() {
    return """
        Программа находит максиманое количество тортов,
        которое можно купить в количестве N1 и N2 за
        цену P1 и P2 соответственно, располагая M денег,
        причём обязательно нужно купить торты каждого вида,
        и если такое невозможно, вообще не покупать
        """;
  }

  @Override
  public String getTaskIndex() {
    return "2";
  }

  @Override
  public void run(Scanner scan) {
    System.out.println("P1: ");
    float p1 = scan.nextFloat();
    System.out.println("P2: ");
    float p2 = scan.nextFloat();
    System.out.println("N1: ");
    int n1 = scan.nextInt();
    System.out.println("N2: ");
    int n2 = scan.nextInt();
    System.out.println("M: ");
    float m = scan.nextFloat();

    if (m < p1 + p2 || n1 < 1 || n2 < 1) {
      System.out.println("Невозможно купить обы видов тортов");
      return;
    }

    int n = 0;

    for (int i = 0; i < n1; i++) {
        float cost1 = i * p1;
        if (cost1 > m) break;

        float rem = m - cost1;
        if (rem < p2) break;

        int max2 = Math.min(n2, (int)Math.floor(rem / p2));
        n = Math.max(n, i + max2);
    }

    System.out.println("Максимальное число тортов: " + n);
  }
}
