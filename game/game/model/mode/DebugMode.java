package edu.neu.ccs.cs5004.game.model.mode;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.player.Player;
import edu.neu.ccs.cs5004.game.model.strategy.Strategy;
import edu.neu.ccs.cs5004.game.view.Interaction;
import edu.neu.ccs.cs5004.game.view.observable.AttackResultUpdate;
import edu.neu.ccs.cs5004.game.view.observable.MapUpdate;
import edu.neu.ccs.cs5004.game.view.observer.ComputerBattleMapPrinter;
import edu.neu.ccs.cs5004.game.view.observer.ComputerFleetMapPrinter;
import edu.neu.ccs.cs5004.game.view.observer.ComputerResultPrinter;
import edu.neu.ccs.cs5004.game.view.observer.MapObserver;

/**
 * Represents debug mode.
 */
class DebugMode extends AbstractMode {
  private MapUpdate fleetMapUpdate;
  private MapObserver fleetMapPrinter;

  /**
   * Creates a new debug mode.
   */
  public DebugMode() {
    super();
    this.inputNumberOfShips();
    player = Player.createNewPlayer(numsOfShips);
    computer = Player.createNewPlayer(numsOfShips);
  }

  /**
   * Read the ships.
   */
  private void inputNumberOfShips() {
    numsOfShips = Interaction.readShips();
  }

  @Override
  public void easyBattle() {
    mapUpdate = new MapUpdate(computer.getBattleMap());
    mapPrinter = new ComputerBattleMapPrinter();
    mapUpdate.registerObserver(mapPrinter);
    fleetMapUpdate = new MapUpdate(computer.getFleetMap());
    fleetMapPrinter = new ComputerFleetMapPrinter();
    fleetMapUpdate.registerObserver(fleetMapPrinter);

    resultUpdate = new AttackResultUpdate(AttackResult.createHit());
    resultPrinter = new ComputerResultPrinter();
    resultUpdate.registerObserver(resultPrinter);
    AttackResult result;
    do {    // computer's turn
      fleetMapUpdate.mapChange(computer.getFleetMap());
      result = Strategy.createRandomStrategy().hitResult(computer, player);
      resultUpdate.resultChange(result);
      mapUpdate.mapChange(computer.getBattleMap());
      if (endGame(computer)) {  // check if the computer win or not
        System.out.println("Computer won!");
        return;
      }
    } while (result.getClass() != AttackResult.createMiss().getClass());  // continue attacking
  }

  @Override
  public void normalBattle() {
    mapUpdate = new MapUpdate(computer.getBattleMap());
    mapPrinter = new ComputerBattleMapPrinter();
    mapUpdate.registerObserver(mapPrinter);
    fleetMapUpdate = new MapUpdate(computer.getFleetMap());
    fleetMapPrinter = new ComputerFleetMapPrinter();
    fleetMapUpdate.registerObserver(fleetMapPrinter);

    resultUpdate = new AttackResultUpdate(AttackResult.createHit());
    resultPrinter = new ComputerResultPrinter();
    resultUpdate.registerObserver(resultPrinter);
    AttackResult result;
    do {    // computer's turn
      fleetMapUpdate.mapChange(computer.getFleetMap());
      result = Strategy.createSmartStrategy().hitResult(computer, player);
      resultUpdate.resultChange(result);
      mapUpdate.mapChange(computer.getBattleMap());
      if (endGame(computer)) {  // check if the computer win or not
        System.out.println("Computer won!");
        return;
      }
    } while (result.getClass() != AttackResult.createMiss().getClass());  // continue attacking
  }
}
