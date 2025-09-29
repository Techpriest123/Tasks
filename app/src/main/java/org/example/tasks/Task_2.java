package org.example.tasks;

import java.util.Scanner;
import org.example.util.Task;

public class Task_2 implements Task {
  public String getTitle() {
    return "Максимальное количество тортов двух типов";
  }

  public String getDescription() {
    return """
        Программа находит максиманое количество тортов,
        которое можно купить в количестве N1 и N2 за
        цену P1 и P2 соответственно, располагая M денег,
        причём обязательно нужно купить торты каждого вида,
        и если такое невозможно, вообще не покупать
        """;
  }

  public String getTaskIndex() {
    return "2";
  }

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

    if (m < p1 + p2) {
      System.out.println("Невозможно купить обы видов тортов");
      return;
    }

    float sum1 = p1 * n1;
    float sum2 = p2 * n2;

  }
}
