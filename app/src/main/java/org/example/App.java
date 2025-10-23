package org.example;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

import org.example.tasks.Task_1;
import org.example.tasks.Task_2;
import org.example.tasks.Task_4;
import org.example.util.Task;

public class App {

  private static final LinkedList<Task> tasks = new LinkedList<>();

  public static void main(String[] args) {

    tasks.add(new Task_1());
    tasks.add(new Task_2());
    tasks.add(new Task_4());

    boolean programShouldHalt = false;

    String prompt = "0";

    Task task = null;

    Scanner scan = new Scanner(System.in);

    while (!programShouldHalt) {
      clearScreen();
      System.out.println("Выберите таск:");
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println(i + 1 + ": " + tasks.get(i).getTitle());
      }
      System.out.println("0: Выход");

      prompt = scan.nextLine();

      try {
        int p = Integer.parseInt(prompt) - 1;
        if (p == -1) {
          programShouldHalt = true;
          continue;
        } else if (p >= tasks.size() || p < 0) {
          System.out.println("No task found");
        } else {
          try {
            task = tasks.get(p);
          } catch (Exception e) {
            System.out.println("Что-то пошло не так:\n" + e + "\nЗавершение");
            programShouldHalt = true;
            continue;
          }
        }
      } catch (Exception e) {
        continue;
      }
      if (task == null) {
        System.out.println("Что-то пошло не так\nЗавершение");
      }
      clearScreen();
      System.out.println("""
          Выберите действие:
          1: Описание
          2: Демо
          0: Выход
          """);
      prompt = scan.nextLine();
      clearScreen();
      try {
        int p = Integer.parseInt(prompt) - 1;
        if (p == -1) {
          continue;
        }
        if (p == 0) {
          do {
            clearScreen();
            assert task != null;
            System.out.println(task.getTitle() + "\n");
            System.out.println(task.getDescription() + "\n");
            System.out.println("0: Выход");
          } while (!Objects.equals(scan.nextLine(), "0"));
        }
        if (p == 1) {
          assert task != null;
          task.run(scan);
        }
      } catch (Exception e) {
        continue;
      }
    }
    clearScreen();
    scan.close();
  }

  public static void clearScreen() {
    System.out.print("\u001b[2J" + "\u001b[H");
  }

}
