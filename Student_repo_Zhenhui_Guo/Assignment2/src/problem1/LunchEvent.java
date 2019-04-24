package problem1;

/**
 * Represents details of a lunch event, including the number of sandwiches to be served.
 *
 * @author Alfred
 */
public class LunchEvent extends Event {
  private int numberOfSandwiches;

  /**
   * Creates a lunch event.
   *
   * @param clientName the name of the client.
   * @param numberOfPeople the number of attendees.
   */
  public LunchEvent(String clientName, int numberOfPeople){
    super(clientName, numberOfPeople);
    this.numberOfSandwiches = (int) Math.round(1.05 * super.getNumberOfPeople());
  }

  /**
   * @return the number of sandwiches to be served.
   */
  public int getNumberOfSandwiches() {
    return numberOfSandwiches;
  }
}
