package edu.neu.ccs.cs5004.lab03.shapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import sun.nio.cs.ext.MacThai;

public class Point2DTest {
  private double x;
  private double y;
  private Point2D point2D;

  @Before
  public void setUp() throws Exception {
    this.x = 3;
    this.y = 4;
    this.point2D = new Point2D(x, y);
  }

  @Test
  public void distToOrigin() throws Exception {
    assertEquals(Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)), this.point2D.distToOrigin(), 0.001);
  }

  @Test
  public void getX() throws Exception {
    assertEquals(this.x, this.point2D.getX(), 0.001);
  }

  @Test
  public void getY() throws Exception {
    assertEquals(this.y, this.point2D.getY(), 0.001);
  }

}