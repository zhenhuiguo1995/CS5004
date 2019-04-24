package problem1;

/**
 * Represents the details about an event, including the client name and number of people.
 *
 * @author Alfred
 */
public class Event {
  private String clientName;
  private int numberOfPeople;

  /**
   * Creates a event.
   * @param clientName the name of the client.
   * @param numberOfPeople the number of attendees.
   */
  public Event(String clientName, int numberOfPeople) {
    this.clientName = clientName;
    this.numberOfPeople = numberOfPeople;
  }

  /**
   * @return the client name.
   */
  public String getClientName() {
    return clientName;
  }

  /**
   * @return the number of people.
   */
  public int getNumberOfPeople() {
    return numberOfPeople;
  }
}
