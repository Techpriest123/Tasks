package org.example.util;

import java.util.Scanner;

public interface Task {

  public void run(Scanner scan);

  public String getTitel();

  public String getDescription();

  public String getTaskIndex();
}
