package org.example.util;

import java.util.Scanner;

public interface Task {

  public void run(Scanner scan);

  public String getTitle();

  public String getDescription();

  public String getTaskIndex();
}
