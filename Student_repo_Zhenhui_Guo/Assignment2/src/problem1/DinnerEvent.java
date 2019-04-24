package problem1;

/**
 * Represents details about a dinner event, including number of vegetarian entrees and
 * non-vegetarian entrees.
 *
 * @author Alfred
 */
public class DinnerEvent extends Event {
  private int numberOfVegetarianEntrees;
  private int numberOfNonVegetarianEntrees;

  /**
   * Creates a dinner event.
   *
   * @param clientName the name of the client.
   * @param numberOfPeople the number of attendees.
   */
  public DinnerEvent(String clientName, int numberOfPeople) {
    super(clientName, numberOfPeople);
    this.numberOfVegetarianEntrees = (int) Math.round(0.8 * super.getNumberOfPeople());
    this.numberOfNonVegetarianEntrees = (int) Math.round(0.2 * super.getNumberOfPeople());
  }

  /**
   * @return the number of vegetarian entrees.
   */
  public int getNumberOfVegetarianEntrees() {
    return numberOfVegetarianEntrees;
  }

  /**
   * @return the number of non-vegetarian entrees.
   */
  public int getNumberOfNonVegetarianEntrees() {
    return numberOfNonVegetarianEntrees;
  }
}
