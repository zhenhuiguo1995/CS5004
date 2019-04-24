package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LunchEventTest {
  private String clientName;
  private int numberOfPeople;
  private LunchEvent lunchEVent;

  @Before
  public void setUp() throws Exception {
    this.clientName = "Jackie";
    this.numberOfPeople = 50;
    this.lunchEVent = new LunchEvent(clientName, numberOfPeople);
  }

  @Test
  public void getNumberOfSandwiches() throws Exception {
    assertEquals((int) Math.round(this.numberOfPeople * 1.05),
        this.lunchEVent.getNumberOfSandwiches());
  }

}