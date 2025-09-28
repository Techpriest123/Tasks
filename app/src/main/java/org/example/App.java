package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

import org.example.tasks.Task_1;
import org.example.util.Task;

public class App {

  private static LinkedList<Task> tasks = new LinkedList<Task>();

  public static void main(String[] args) {

    tasks.add(new Task_1());

    boolean programShouldHalt = false;

    int prompt = 0;

    Task task = null;

    Scanner scan = new Scanner(System.in);

    while (programShouldHalt) {
      clearScreen();
      System.out.println("Выберите таск:");
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println(i + 1 + ": " + tasks.get(i).getTitel());
      }
      System.out.println("0: Выход");
      prompt = scan.nextInt() - 1;
      if (prompt == -1) {
        programShouldHalt = true;
        continue;
      } else if (prompt >= tasks.size() || prompt < 0) {
        System.out.println("No task found");
      } else {
        try {
          task = tasks.get(prompt - 1);
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
      System.out.println("Выберите действие:\n"
          + "1: Описание\n"
          + "2: Код"
          + "3: Демо\n"
          + "0: Выход\n");
      prompt = scan.nextInt() - 1;
      clearScreen();
      if (prompt == -1) {
          programShouldHalt = true;
        continue;
      }
      if (prompt == 0) {
        System.out.println(task.getTitel() + "\n");
        System.out.println(task.getDescription() + "\n");
        System.out.println("0: Выход");
        String p = scan.nextLine();
        while (p != "0") {
          int cnt = p.length();
          System.out.println('\b' * cnt);
          p = scan.nextLine();
        }
      }
      if (prompt == 1) {
        FileReader fr;
        try {
          fr = new FileReader("./tasks/Task_");
        } catch (Exception e) {
          System.out.println("Что-то пошло не так:\n" + e + "\nЗавершение");
          programShouldHalt = true;
          continue;
        }
        BufferedReader br = new BufferedReader(fr);
        try {
          StringBuilder sb = new StringBuilder();
          String line = br.readLine();

          while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
          }

          System.out.println(sb.toString());
        } catch (Exception e) {
          System.out.println("Что-то пошло не так:\n" + e + "\nЗавершение");
          programShouldHalt = true;
          continue;
        } finally {
          try {
            br.close();
          } catch (Exception e) {
            System.out.println("Что-то пошло не так:\n" + e + "\nЗавершение");
            programShouldHalt = true;
            continue;
          }
        }
        System.out.println("0: Выход");
        String p = scan.nextLine();
        while (p != "0") {
          int cnt = p.length();
          System.out.println('\b' * cnt);
          p = scan.nextLine();
        }
      }
      if (prompt == 2) {
        task.run(scan);
      }
    }
    scan.close();
  }

  public static void clearScreen() {
    System.out.println("\u001b[2J" + "\u001b[H");
  }
}
