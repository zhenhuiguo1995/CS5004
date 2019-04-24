package problem1;

/**
 * Represents details of daily events, including lunch event and dinner event.
 *
 * @author Alfred
 */
public class   DailyEvents {
  private int minLunchPeople = 15;
  private int maxLunchPeople = 90;
  private int minDinnerPeople = 10;
  private int maxDinnerPeople = 50;
  private static final String LUNCH_TYPE = "LunchEvent";
  private static final String DINNER_TYPE = "DinnerEvent";
  private LunchEvent lunchEvent;
  private DinnerEvent dinnerEvent;

  /**
   * Creates a daily event object.
   */
  public DailyEvents() {
    this.lunchEvent = null;
    this.dinnerEvent = null;
  }

  /**
   * Creates a daily event object.
   * @param lunchEvent the lunch event of daily events.
   * @param dinnerEvent the dinner event of daily events.
   */
  public DailyEvents(LunchEvent lunchEvent, DinnerEvent dinnerEvent) {
    this.lunchEvent = lunchEvent;
    this.dinnerEvent = dinnerEvent;
  }

  /**
   * Creates a new event.
   * @param eventType the type of the event: lunch or dinner.
   * @param numberOfPeople the number of people to attend the event.
   * @param clientName the name of the client.
   * @throws Exception IllegalArgument exception.
   * @return a new daily event
   */
  public DailyEvents createEvent(String eventType, int numberOfPeople, String clientName)
      throws Exception{
    switch (eventType) {
      case LUNCH_TYPE:
        if (this.lunchEvent != null) {
          throw new IllegalArgumentException("LunchEvent already exists");
        } else if (numberOfPeople < this.minLunchPeople || numberOfPeople > this.maxLunchPeople) {
          throw new IllegalArgumentException("Number of attendees for LunchEvent must be from "
              + minLunchPeople + "to" + maxLunchPeople);
        } else {
          return new DailyEvents(new LunchEvent(clientName, numberOfPeople), this.dinnerEvent);
        }

      case DINNER_TYPE:
        if (this.dinnerEvent != null) {
          throw new IllegalArgumentException("DinnerEvent already exists");
        } else if (numberOfPeople < minDinnerPeople || numberOfPeople > maxDinnerPeople) {
          throw new IllegalArgumentException("Number of attendees for DinnerEvent must be from"
              +  minDinnerPeople + "to" + maxDinnerPeople);
        } else {
          return new DailyEvents(this.lunchEvent, new DinnerEvent(clientName, numberOfPeople));
        }

      default:
        throw new IllegalArgumentException("EventType must be either LunchEvent or DinnerEvent");
    }
  }
}
