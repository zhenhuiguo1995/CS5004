package edu.neu.ccs.cs5004.game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents the interaction between user and our game.
 */

public class Interaction {

  /**
   * Read the game mode from the console window.
   *
   * @return the game mode represented in the string format.
   */
  public static String readGameMode() {
    BufferedReader bufferedReader = null;
    String gameMode = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
      System.out.print("Please select the game mode (Debug/Regular) [D/R]: ");
      while (true) {
        gameMode = bufferedReader.readLine();
        if (gameMode == null) {
          break;
        }
        if (gameMode.equals("D") || gameMode.equals("R")) {
          break;
        } else {
          System.out.print("Invalid Input! "
              + "Please select the game mode (Debug/Regular) [D/R]: ");
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return gameMode;
  }

  /**
   * Read all ships numbers from the console window.
   *
   * @return a integer array that contains ships numbers.
   */
  public static int[] readShips() {
    BufferedReader bufferedReader = null;
    int[] numsOfShips = new int[4];
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
      System.out.print("Please input the number of BattleShip (0~1): "); // input battleship number
      while (true) {
        String str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        int number = Integer.parseInt(str);
        if (number >= 0 && number <= 1) {
          numsOfShips[0] = number;
          break;
        } else {
          System.out.print("Invalid Input! "
              + "Please input the number of BattleShip (0~1): ");
        }
      }
      System.out.print("Please input the number of Cruiser (0~2): ");  // input cruiser number
      while (true) {
        String str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        int number = Integer.parseInt(str);
        if (number >= 0 && number <= 2) {
          numsOfShips[1] = number;
          break;
        } else {
          System.out.print("Invalid Input! "
              + "Please input the number of Cruiser (0~2): ");
        }
      }
      System.out.print("Please input the number of Submarine (0~3): ");  // input Submarine number
      while (true) {
        String str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        int number = Integer.parseInt(str);
        if (number >= 0 && number <= 3) {
          numsOfShips[2] = number;
          break;
        } else {
          System.out.print("Invalid Input! "
              + "Please input the number of Submarine (0~3): ");
        }
      }
      System.out.print("Please input the number of Destroyer: (0~4): "); // input Destroyer number
      while (true) {
        String str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        int number = Integer.parseInt(str);
        if (number >= 0 && number <= 4) {
          numsOfShips[3] = number;
          break;
        } else {
          System.out.print("Invalid Input! "
              + "Please input the number of Destroyer: (0~4): ");
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return numsOfShips;
  }

  /**
   * Read how to place ships from the console window.
   *
   * @return the given string from the console window.
   */
  public static String readShipPlacement() {
    BufferedReader bufferedReader = null;
    String placement = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
      System.out.println();
      System.out.print("Please select how to place the ship (Random/User) [R/U]: ");
      while (true) {
        placement = bufferedReader.readLine();
        if (placement == null) {
          break;
        }
        if (placement.equals("R") || placement.equals("U")) {
          break;
        } else {
          System.out.print("Invalid input! "
              + "Please select how to place the ship (Random/User) [R/U]: ");
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return placement;
  }

  /**
   * Read the strategy from the console window.
   *
   * @return the strategy represented in the string format.
   */
  public static String readStrategy() {
    BufferedReader bufferedReader = null;
    String strategy = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
      System.out.print("Please select the strategy (Random/Smart/User) [R/S/U]: ");
      while (true) {
        strategy = bufferedReader.readLine();
        if (strategy == null) {
          break;
        }
        if (strategy.equals("R") || strategy.equals("S") || strategy.equals("U")) {
          break;
        } else {
          System.out.println("Invalid Input! "
              + "Please select the strategy (Random/Smart/User) [R/S/U]: ");
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return strategy;
  }

  /**
   * Read the game difficulty level from the console window.
   *
   * @return the game difficult represented in the string format.
   */
  public static String readDifficulty() {
    BufferedReader bufferedReader = null;
    String difficulty = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
      System.out.print("Please select the game difficulty (Easy/Normal) [E/N]: ");
      while (true) {
        difficulty = bufferedReader.readLine();
        if (difficulty == null) {
          break;
        }
        if (difficulty.equals("E") || difficulty.equals("N")) {
          break;
        } else {
          System.out.println("Invalid Input! "
              + "Please select the game difficulty (Easy/Normal) [E/N]: ");
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return difficulty;
  }

  /**
   * Read the top left cell's row from the console window.
   *
   * @return the row of the top left cell which represents in string format.
   */
  public static String getRowString() {
    BufferedReader bufferedReader = null;
    String str = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
      System.out.print("Please provide the row of the cell (1~10): ");
      while (true) {
        str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.length() == 1 && str.charAt(0) >= '1' && str.charAt(0) <= '9') {
          break;
        } else if (str.length() == 2 && str.charAt(0) == '1' && str.charAt(1) == '0') {
          break;
        } else {
          System.out.print("Invalid Input! "
              + "Please provide the row of the cell (1~10): ");
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return str;
  }

  /**
   * Read the top left cell's column from the console window.
   *
   * @return the column of the top left cell which represents in string format.
   */
  public static String getColumnString() {
    BufferedReader bufferedReader = null;
    String colString = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
      System.out.print("Please provide the column of the cell (A~J): ");
      while (true) {
        colString = bufferedReader.readLine();
        if (colString == null) {
          break;
        }
        if (colString.length() == 1 && colString.charAt(0) >= 'A' && colString.charAt(0) <= 'J') {
          break;
        } else {
          System.out.print("Invalid Input! "
              + "Please provide the column of the cell (A~J): ");
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return colString;
  }

  /**
   * Read the ship's direction from the console window.
   *
   * @return the direction of the ship which represents in string format.
   */
  public static String getDirectionString() {
    BufferedReader bufferedReader = null;
    String dirString = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
      System.out.print("Please provide the direction of the ship(Horizon/Vertical): ");
      while (true) {
        dirString = bufferedReader.readLine();
        if (dirString == null) {
          break;
        }
        if (dirString.equals("Horizon") || dirString.equals("Vertical")) {
          break;
        } else {
          System.out.print("Invalid input! "
              + "Please provide the direction of the ship(Horizon/Vertical): ");
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return dirString;
  }

}
