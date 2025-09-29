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

  }

}
