package edu.neu.ccs.cs5004;

public interface Play extends Action {
  default void play() {
    System.out.println("Play");
  }
}
