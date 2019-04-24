package problem1;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

public class DailyEventsTest {
  private DailyEvents dailyEvents;
  private int numberOfPeople;
  private String clientName;
  private String eventType;
  private static final String LUNCH_TYPE = "LunchEvent";
  private static final String DINNER_TYPE = "DinnerEvent";

  @Before
  public void setUp() throws Exception {
    this.numberOfPeople = 20;
    this.clientName = "Alexa";
    this.eventType = LUNCH_TYPE;
    this.dailyEvents = new DailyEvents();
  }

  @Test(expected = IllegalArgumentException.class)
  public void createEventEventTypeIllegal() throws Exception {
    this.eventType = "ChristmasEvent";
    this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createEventLunchEventExists() throws Exception {
    this.eventType = LUNCH_TYPE;
    this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    this.eventType = LUNCH_TYPE;
    this.numberOfPeople = 30;
    this.clientName = "Alfred";
    this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createEventDinnerEventExists() throws Exception {
    this.eventType = DINNER_TYPE;
    this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    this.eventType = DINNER_TYPE;
    this.numberOfPeople = 30;
    this.clientName = "Alfred";
    this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
  }


  @Test(expected = IllegalArgumentException.class)
  public void createLunchEventPeopleNotEnough() throws Exception {
    this.eventType = LUNCH_TYPE;
    this.numberOfPeople = 14;
    this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createLunchEventPeopleTooMany() throws Exception {
    this.eventType = LUNCH_TYPE;
    this.numberOfPeople = 91;
    this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createDinnerEventPeopleNotEnough() throws Exception {
    this.numberOfPeople = 9;
    this.eventType = DINNER_TYPE;
    this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createDinnerEventPeopleTooMany() throws Exception {
    this.numberOfPeople = 51;
    this.eventType = DINNER_TYPE;
    this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
  }

}