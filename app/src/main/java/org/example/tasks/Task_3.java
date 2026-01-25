package org.example.tasks;

import org.example.util.Task;

import java.util.Scanner;

public class Task_3 implements Task {

    public enum SimpleColor {
        BLACK,
        WHITE,
        GRAY,
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        UNDEFINED
    }

    private static final Line L1 = new Line(-6.2, 0, -2.5);
    private static final Line L2 = new Line(0, -5, 0);
    private static final HorizontalParabola P1 = new HorizontalParabola(-1, -3, -0.25);

    public static SimpleColor getColor(double x, double y) {
        if (L1.isPointAboveLine(x, y) && L2.isPointAboveLine(x, y)
        && P1.isPointRightOfParabola(x, y) || L1.isPointAboveLine(x, y)
        && !L2.isPointAboveLine(x, y) && !P1.isPointRightOfParabola(x, y))
        {
            return SimpleColor.GREEN;
        }
        if (L1.isPointAboveLine(x, y) && L2.isPointAboveLine(x, y)
        && !P1.isPointRightOfParabola(x, y) || L1.isPointAboveLine(x, y)
        && !L2.isPointAboveLine(x, y) && P1.isPointRightOfParabola(x, y))
        {
            return SimpleColor.ORANGE;
        }
        if (!L1.isPointAboveLine(x, y) && !P1.isPointRightOfParabola(x, y)
        || !L1.isPointAboveLine(x, y) && L2.isPointAboveLine(x, y))
        {
            return SimpleColor.GRAY;
        }
        if (!L1.isPointAboveLine(x, y) && !L2.isPointAboveLine(x, y)
        && P1.isPointRightOfParabola(x, y))
        {
            return SimpleColor.YELLOW;
        }
        else return SimpleColor.UNDEFINED;
    }

    public static void printColorForPoint(double x, double y) {
        System.out.println(getColor(x, y));
    }

    @Override
    public void run(Scanner scan) {
        System.out.println("X: ");
        double x = scan.nextDouble();
        System.out.println("Y: ");
        double y = scan.nextDouble();

        printColorForPoint(x, y);
    }

    @Override
    public String getTitle() {
        return "Цвет в точке";
    }

    @Override
    public String getDescription() {
        return "Выводит цвет точки по заданным координатам";
    }

    @Override
    public String getTaskIndex() {
        return "3";
    }
}
