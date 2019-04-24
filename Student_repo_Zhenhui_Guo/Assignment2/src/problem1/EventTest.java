package problem1;

import static org.junit.Assert.*;

public class EventTest {
  private String clientName;
  private int numberOfPeople;
  private Event event;

  @org.junit.Before
  public void setUp() throws Exception {
    this.clientName = "Alfred";
    this.numberOfPeople = 30;
    this.event = new Event(clientName, numberOfPeople);
  }

  @org.junit.Test
  public void getClientName() throws Exception {
    assertEquals(this.clientName, this.event.getClientName());
  }

  @org.junit.Test
  public void getNumberOfPeople() throws Exception {
    assertEquals(this.numberOfPeople, this.event.getNumberOfPeople());
  }

}