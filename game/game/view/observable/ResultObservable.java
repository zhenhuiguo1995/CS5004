package edu.neu.ccs.cs5004.game.view.observable;

import edu.neu.ccs.cs5004.game.view.observer.ResultObserver;

/**
 * Represents a result observable.
 */
public interface ResultObservable {
  /**
   * Add observer to a list of observers.
   * @param observer to register to the observable
   */
  void registerObserver(ResultObserver observer);

  /**
   * Remove observer from a list of observers.
   * @param observer to remove
   */
  void removeObserver(ResultObserver observer);


  /**
   * Notify observer if a model was changed.
   */
  void notifyObservers();
}
