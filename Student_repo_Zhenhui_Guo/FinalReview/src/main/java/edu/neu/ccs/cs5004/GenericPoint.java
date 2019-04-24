package edu.neu.ccs.cs5004;

public class GenericPoint<T> implements GenericInterface<T> {
  private T x;
  private T y;

  public GenericPoint(T x, T y) {
    this.x = x;
    this.y = y;
  }

  public T getX() {
    return x;
  }

  public T getY() {
    return y;
  }

  @Override
  public GenericPoint<T> reset(T x, T y) {
    return new GenericPoint<>(x, y);
  }
}
