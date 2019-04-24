package edu.neu.ccs.cs5004.game.view.observer;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;

/**
 * Represents a result observer.
 */
public interface ResultObserver {
  void update(AttackResult result);
}
