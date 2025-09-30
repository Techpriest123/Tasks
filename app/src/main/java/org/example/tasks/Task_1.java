package org.example.tasks;

import java.util.Scanner;
import org.example.util.Task;

public class Task_1 implements Task {

  public String getTitle() {
    return "Площадь заштрихованой части фигуры (2.9)";
  }

  public String getDescription() {
    return """
        Находит площадь заштрихованой части фигуры (2.9)
        по трём радиусам: r1, r2 и r3
        """;
  }

  public String getTaskIndex() {
    return "1";
  }

  public void run(Scanner scan) {

    float PI = 3.14f;

    System.out.println("R1:");
    float r1 = scan.nextFloat();
    System.out.println("R2:");
    float r2 = scan.nextFloat();
    System.out.println("R3:");
    float r3 = scan.nextFloat();
    float partR1R2 = (PI * r2 * r2 - PI * r1 * r1) / 8;
    float partR3 = (r3 * 2 * r3 * 2 - PI * r3 * r3) / 8;
    System.out.println("S: " + (partR1R2 * 5 + partR3 * 6));
  }

}
