package edu.neu.ccs.cs5004.game.view.observable;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.view.observer.ResultObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Update the attack result.
 */
public class AttackResultUpdate implements ResultObservable {
  private AttackResult result;
  private List<ResultObserver> observers;

  /**
   * Construct for attack result update.
   *
   * @param result the attack result
   */
  public AttackResultUpdate(AttackResult result) {
    this.result = result;
    observers = new ArrayList<>();
  }

  /**
   * Getter for the attack result.
   *
   * @return the attack result
   */
  public AttackResult getResult() {
    return result;
  }

  /**
   * Add observer to a list of observers.
   *
   * @param observer to register to the observable
   */
  public void registerObserver(ResultObserver observer) {
    observers.add(observer);
  }

  /**
   * Remove observer from a list of observers.
   *
   * @param observer to remove
   */
  public void removeObserver(ResultObserver observer) {
    observers.remove(observer);
  }

  /**
   * Setter for the result.
   *
   * @param result the result we want to set
   */
  public void resultChange(AttackResult result) {
    this.result = result;
    notifyObservers();
  }

  /**
   * Notify observer if a model was changed.
   */
  public void notifyObservers() {
    for (ResultObserver obs : observers) {
      obs.update(this.result);
    }
  }

  /**
   * Getter for the list of observers.
   *
   * @return the list of observers
   */
  public List<ResultObserver> getObservers() {
    return observers;
  }

}
