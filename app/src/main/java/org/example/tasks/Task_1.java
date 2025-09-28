package org.example.tasks;

import java.util.Scanner;
import org.example.util.Task;

public class Task_1 implements Task {

  public String getTitel() {
    return "Четверть координатной плоскости";
  }

  public String getDescription() {
    return "Находит четверть координатной плоскости, в которой находится точка.\n"
        + "Если точка лежит на оси или в центре координатной плоскости,"
        + "программа выведет соответствующую информацию.";
  }

  public String getTaskIndex() {
    return "1";
  }

  public void run(Scanner scan) {

    System.out.println("X: ");
    float x = scan.nextFloat();
    System.out.println("Y: ");
    float y = scan.nextFloat();

    if (x > 0 && y > 0)
      System.out.println("Четверть 1");
    if (x < 0 && y > 0)
      System.out.println("Четверть 2");
    if (x < 0 && y < 0)
      System.out.println("Четверть 3");
    if (x > 0 && y < 0)
      System.out.println("Четверть 4");

    if (x == 0 && y != 0)
      System.out.println("Ось Y");
    if (y == 0 && x != 0)
      System.out.println("Ось X");
    if (x == 0 && y == 0)
      System.out.println("Центр");

  }

}
