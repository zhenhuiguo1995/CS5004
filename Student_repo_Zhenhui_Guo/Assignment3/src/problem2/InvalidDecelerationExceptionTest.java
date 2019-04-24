package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InvalidDecelerationExceptionTest {
  private double velocity;
  private InvalidDecelerationException invalidDecelerationException;

  @Before
  public void setUp() throws Exception {
    this.velocity = 40;
    this.invalidDecelerationException = new InvalidDecelerationException(this.velocity);
  }

  @Test
  public void getVelocity() throws Exception {
    assertEquals(this.velocity, this.invalidDecelerationException.getVelocity(), 0);
  }

}