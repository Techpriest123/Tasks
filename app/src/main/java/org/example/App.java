package org.example;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

import org.example.tasks.Task_1;
import org.example.util.Task;

public class App {

  private static final LinkedList<Task> tasks = new LinkedList<Task>();

  public static void main(String[] args) {

    tasks.add(new Task_1());

    boolean programShouldHalt = false;

    int prompt = 0;

    Task task = null;

    Scanner scan = new Scanner(System.in);

    while (!programShouldHalt) {
      clearScreen();
      System.out.println("Выберите таск:");
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println(i + 1 + ": " + tasks.get(i).getTitle());
      }
      System.out.println("0: Выход");

      prompt = scan.nextInt();

      if (prompt == -1) {
        programShouldHalt = true;
        continue;
      } else if (prompt >= tasks.size() || prompt < 0) {
        System.out.println("No task found");
      } else {
        try {
          task = tasks.get(prompt);
        } catch (Exception e) {
          System.out.println("Что-то пошло не так:\n" + e + "\nЗавершение");
          programShouldHalt = true;
          continue;
        }
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
      scan.nextLine();
      prompt = scan.nextInt() - 1;
      clearScreen();
      if (prompt == -1) {
        programShouldHalt = true;
        continue;
      }
      if (prompt == 0) {
        System.out.println(task.getTitle() + "\n");
        System.out.println(task.getDescription() + "\n");
        System.out.println("0: Выход");
        scan.nextLine();
        String p = scan.nextLine();
        while (!Objects.equals(p, "0")) {
          int cnt = p.length();
          System.out.println('\b' * cnt);
          scan.nextLine();
          p = scan.nextLine();
        }
      }
      if (prompt == 1) {
        assert task != null;
        task.run(scan);
      }
    }
    scan.close();
  }

  public static void clearScreen() {
    System.out.print("\u001b[2J" + "\u001b[H");
  }
}
