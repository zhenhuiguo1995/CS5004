package edu.neu.ccs.cs5004.game.model.mode;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.player.Player;
import edu.neu.ccs.cs5004.game.model.strategy.Strategy;
import edu.neu.ccs.cs5004.game.view.observable.AttackResultUpdate;
import edu.neu.ccs.cs5004.game.view.observable.MapUpdate;
import edu.neu.ccs.cs5004.game.view.observer.ComputerBattleMapPrinter;
import edu.neu.ccs.cs5004.game.view.observer.ComputerResultPrinter;

/**
 * Represents the fleet configuration is determined by default.
 */
class GameMode extends AbstractMode {
  /**
   * Creates a new mode mode by the mode rules (the number and type of ships).
   */
  public GameMode() {
    for (int i = 0; i < numsOfShips.length; i++) {
      numsOfShips[i] = i + 1;
    }
    player = Player.createNewPlayer(numsOfShips);
    computer = Player.createNewPlayer(numsOfShips);
  }

  @Override
  public void easyBattle() {
    mapUpdate = new MapUpdate(computer.getBattleMap());
    mapPrinter = new ComputerBattleMapPrinter();
    mapUpdate.registerObserver(mapPrinter);

    resultUpdate = new AttackResultUpdate(AttackResult.createHit());
    resultPrinter = new ComputerResultPrinter();
    resultUpdate.registerObserver(resultPrinter);
    AttackResult result;
    do {    // computer's turn
      result = Strategy.createRandomStrategy().hitResult(computer, player);
      resultUpdate.resultChange(result);
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

    resultUpdate = new AttackResultUpdate(AttackResult.createHit());
    resultPrinter = new ComputerResultPrinter();
    resultUpdate.registerObserver(resultPrinter);
    AttackResult result;
    do {    // computer's turn
      result = Strategy.createSmartStrategy().hitResult(computer, player);
      resultUpdate.resultChange(result);
      if (endGame(computer)) {  // check if the computer win or not
        System.out.println("Computer won!");
        return;
      }
    } while (result.getClass() != AttackResult.createMiss().getClass());  // continue attacking
  }
}
