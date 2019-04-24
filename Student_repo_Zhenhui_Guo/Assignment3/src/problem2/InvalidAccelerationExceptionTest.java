package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InvalidAccelerationExceptionTest {
  private double velocity;
  private InvalidAccelerationException invalidAccelerationException;

  @Before
  public void setUp() throws Exception {
    this.velocity = 80;
    this.invalidAccelerationException = new InvalidAccelerationException(this.velocity);
  }


  @Test
  public void getVelocity() throws Exception {
    assertEquals(this.velocity, this.invalidAccelerationException.getVelocity(), 0);
  }

}