package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BalanceTest {
  private int dollarAmount;
  private int centAmount;
  private Balance balance;

  @Before
  public void setUp() throws Exception {
    this.dollarAmount = 232;
    this.centAmount = 49;
    this.balance = new Balance(dollarAmount, centAmount);
  }

  @Test
  public void getDollarAmount() throws Exception {
    assertEquals(this.dollarAmount, this.balance.getDollarAmount());
  }

  @Test
  public void getCentAmount() throws Exception {
    assertEquals(this.centAmount, this.balance.getCentAmount());
  }

  @Test(expected = IllegalArgumentException.class)
  public void dollarLessThanZero() throws Exception{
    this.dollarAmount = -1;
    this.balance = new Balance(dollarAmount, centAmount);
  }

  @Test(expected = IllegalArgumentException.class)
  public void centLessThanZero() throws Exception{
    this.centAmount = -1;
    this.balance = new Balance(dollarAmount, centAmount);
  }

  @Test(expected = IllegalArgumentException.class)
  public void centTooLarge() throws Exception{
    this.centAmount = 100;
    this.balance = new Balance(dollarAmount, centAmount);
  }
}