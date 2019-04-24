package edu.neu.ccs.cs5004.game.view.observable;

import edu.neu.ccs.cs5004.game.view.observer.MapObserver;

/**
 * Defines the interface of observable subject by map observers.
 */
public interface MapObservable {
  /**
   * Add observer to a list of observers.
   *
   * @param observer to register to the observable
   */
  void registerObserver(MapObserver observer);

  /**
   * Remove observer from a list of observers.
   *
   * @param observer to remove
   */
  void removeObserver(MapObserver observer);


  /**
   * Notify observer if a model was changed.
   */
  void notifyObservers();

}
