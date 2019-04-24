package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GenericPointTest {


  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void intTest () throws Exception {
    int x;
    int y;
    GenericPoint<Integer> point;
    x = 1;
    y = 2;
    point = new GenericPoint<>(x, y);
    assertEquals(x, (int)point.getX());
    assertEquals(y, (int)point.getY());
  }

  @Test
  public void doubleTest() throws Exception {
    double x;
    double y;
    GenericPoint<Double> point;
    x = 1;
    y = 2;
    point = new GenericPoint<>(x, y);
    assertEquals(x, (double)point.getX(), 0.0001);
    assertEquals(y, (double)point.getY(), 0.0001);
  }

  @Test
  public void testGenerics() throws Exception {
    int x = 1;
    int y = 2;
    GenericPoint point = new GenericPoint(x, y);
    assertEquals(x, (int)point.getX());
    assertEquals(y, (int)point.getY());
  }

  @Test
  public void resetTest() throws Exception {
    GenericPoint point = new GenericPoint(1, 2);
    int x = 3;
    int y = 4;
    point = point.reset(x, y);
    assertEquals(3, (int)point.getX());
    assertEquals(4, (int)point.getY());
  }

}