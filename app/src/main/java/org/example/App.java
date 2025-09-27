package org.techwizrd.tasks;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.println("X: ");
    float x = scan.nextFloat();
    System.out.println("Y: ");
    float y = scan.nextFloat();

    if (x > 0 && y > 0)
      System.out.println("Quad 1");
    if (x < 0 && y > 0)
      System.out.println("Quad 2");
    if (x < 0 && y < 0)
      System.out.println("Quad 3");
    if (x > 0 && y < 0)
      System.out.println("Quad 4");

    if (x == 0 && y != 0)
      System.out.println("Axis Y");
    if (y == 0 && x != 0)
      System.out.println("Axis X");
    scan.close();
    if (x == 0 && y == 0)
      System.out.println("Center");
  }
}
