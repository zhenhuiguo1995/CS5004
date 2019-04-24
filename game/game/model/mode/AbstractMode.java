package edu.neu.ccs.cs5004.game.model.mode;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.cell.Cell;
import edu.neu.ccs.cs5004.game.model.cell.ShipCell;
import edu.neu.ccs.cs5004.game.model.map.Column;
import edu.neu.ccs.cs5004.game.model.map.Row;
import edu.neu.ccs.cs5004.game.model.place.Place;
import edu.neu.ccs.cs5004.game.model.player.Player;
import edu.neu.ccs.cs5004.game.model.strategy.Strategy;
import edu.neu.ccs.cs5004.game.view.Interaction;
import edu.neu.ccs.cs5004.game.view.observable.AttackResultUpdate;
import edu.neu.ccs.cs5004.game.view.observable.MapUpdate;
import edu.neu.ccs.cs5004.game.view.observer.ComputerFleetMapPrinter;
import edu.neu.ccs.cs5004.game.view.observer.MapObserver;
import edu.neu.ccs.cs5004.game.view.observer.ResultObserver;
import edu.neu.ccs.cs5004.game.view.observer.UserBattleMapPrinter;
import edu.neu.ccs.cs5004.game.view.observer.UserFleetMapPrinter;
import edu.neu.ccs.cs5004.game.view.observer.UserResultPrinter;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents an abstract Mode in the game.
 */
abstract class AbstractMode implements Mode {
  protected Player player;
  protected Player computer;
  protected int[] numsOfShips;
  private static final int FOUR = 4;
  protected MapObserver mapPrinter;
  protected ResultObserver resultPrinter;
  protected MapUpdate mapUpdate;
  protected AttackResultUpdate resultUpdate;

  /**
   * Constructs an abstract mode.
   */
  public AbstractMode() {
    numsOfShips = new int[FOUR];
  }

  /**
   * Set up the player's ships.
   */
  public void setUpPlayerShips() {
    mapUpdate = new MapUpdate(player.getFleetMap());
    mapPrinter = new UserFleetMapPrinter();
    mapUpdate.registerObserver(mapPrinter);
    String placement = Interaction.readShipPlacement();
    if (placement.equals("R")) {
      player.placeShip(Place.createRandomPlace());
    } else {
      player.placeShip(Place.createUserPlace());
    }
    System.out.println();
    mapUpdate.mapChange(player.getFleetMap());
  }

  /**
   * Set up the computer's ships.
   */
  public void setUpComputerShips() {
    mapUpdate = new MapUpdate(computer.getFleetMap());
    mapPrinter = new ComputerFleetMapPrinter();
    mapUpdate.registerObserver(mapPrinter);
    computer.placeShip(Place.createRandomPlace());
    mapUpdate.mapChange(computer.getFleetMap());
  }

  /**
   * Start the game.
   */
  public void startBattle() {
    String strategy = Interaction.readStrategy();
    String difficulty = Interaction.readDifficulty();

    while (!endGame(player) && !endGame(computer)) {
      // user's turn
      if (strategy.equals("R")) {
        randomBattle();
      } else if (strategy.equals("S")) {
        smartBattle();
      } else {
        userBattle();
      }
      if (endGame(player)) {
        break;
      }
      // computer's turn
      if (difficulty.equals("E")) {
        easyBattle();
      } else {
        normalBattle();
      }
    }
  }

  /**
   * Randomly start the game.
   */
  public void randomBattle() {
    mapUpdate = new MapUpdate(player.getBattleMap());
    mapPrinter = new UserBattleMapPrinter();
    mapUpdate.registerObserver(mapPrinter);

    resultUpdate = new AttackResultUpdate(AttackResult.createHit());
    resultPrinter = new UserResultPrinter();
    resultUpdate.registerObserver(resultPrinter);
    AttackResult result;

    do {    // user's turn
      result = Strategy.createRandomStrategy().hitResult(player, computer);
      resultUpdate.resultChange(result);
      mapUpdate.mapChange(player.getBattleMap());
      if (endGame(player)) {  // check if the player win or not
        System.out.println("You won!");
        return;
      }
    } while (result.getClass() != AttackResult.createMiss().getClass()); // continue attacking
  }

  /**
   * Smartly play the game.
   */
  public void smartBattle() {
    mapUpdate = new MapUpdate(player.getBattleMap());
    mapPrinter = new UserBattleMapPrinter();
    mapUpdate.registerObserver(mapPrinter);

    resultUpdate = new AttackResultUpdate(AttackResult.createHit());
    resultPrinter = new UserResultPrinter();
    resultUpdate.registerObserver(resultPrinter);
    AttackResult result;
    do {    // user's turn
      result = Strategy.createSmartStrategy().hitResult(player, computer);
      resultUpdate.resultChange(result);
      mapUpdate.mapChange(player.getBattleMap());
      if (endGame(player)) {  // check if the player win or not
        System.out.println("You won!");
        return;
      }
    } while (result.getClass() != AttackResult.createMiss().getClass()); // continue attacking
  }

  /**
   * Start the game via user's input.
   */
  public void userBattle() {
    mapUpdate = new MapUpdate(player.getBattleMap());
    mapPrinter = new UserBattleMapPrinter();
    mapUpdate.registerObserver(mapPrinter);

    resultUpdate = new AttackResultUpdate(AttackResult.createHit());
    resultPrinter = new UserResultPrinter();
    resultUpdate.registerObserver(resultPrinter);
    AttackResult result;
    do {    // user's turn
      result = Strategy.createUserStrategy().hitResult(player, computer);
      resultUpdate.resultChange(result);
      mapUpdate.mapChange(player.getBattleMap());
      if (endGame(player)) {  // check if the player win or not
        System.out.println("You won!");
        return;
      }
    } while (result.getClass() != AttackResult.createMiss().getClass()); // continue attacking
  }

  /**
   * Check if the game is over.
   *
   * @param player1 the player in the game
   * @return true if all the ships have been sunk and false otherwise
   */
  public boolean endGame(Player player1) {
    int ships = 0;
    for (int i = 0; i < FOUR; i++) {
      ships = numsOfShips[i] * (FOUR - i) + ships;
    }
    int hitCells = 0;
    for (Row row : Row.values()) {
      for (Column column : Column.values()) {
        Cell current = player1.getBattleMap().getCell(row, column);
        if (current instanceof ShipCell && current.isHited() || current.isSunked()) {
          hitCells++;
        }
      }
    }
    return hitCells == ships;
  }

  /**
   * Easy mode.
   */
  public abstract void easyBattle();

  /**
   * Smart mode.
   */
  public abstract void normalBattle();

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractMode that = (AbstractMode) obj;
    return Objects.equals(player, that.player)
        && Objects.equals(computer, that.computer)
        && Arrays.equals(numsOfShips, that.numsOfShips)
        && Objects.equals(mapPrinter, that.mapPrinter)
        && Objects.equals(resultPrinter, that.resultPrinter)
        && Objects.equals(mapUpdate, that.mapUpdate)
        && Objects.equals(resultUpdate, that.resultUpdate);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(player, computer, mapPrinter, resultPrinter, mapUpdate, resultUpdate);
    result = 31 * result + Arrays.hashCode(numsOfShips);
    return result;
  }
}
