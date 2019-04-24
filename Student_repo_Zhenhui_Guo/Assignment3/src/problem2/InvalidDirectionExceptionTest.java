package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InvalidDirectionExceptionTest {
  private DIRECTION currentDirection;
  private DIRECTION nextDirection;
  private InvalidDirectionException invalidDirectionException;
  @Before
  public void setUp() throws Exception {
    this.currentDirection = DIRECTION.EASTBOUND;
    this.nextDirection = DIRECTION.SOUTHBOUND;
    this.invalidDirectionException = new InvalidDirectionException(
        this.currentDirection, this.nextDirection);
  }

  @Test
  public void getCurrentDirection() throws Exception {
    assertEquals(this.currentDirection, this.invalidDirectionException.getCurrentDirection());
  }

  @Test
  public void getNextDirection() throws Exception {
    assertEquals(this.nextDirection, this.invalidDirectionException.getNextDirection());
  }

}