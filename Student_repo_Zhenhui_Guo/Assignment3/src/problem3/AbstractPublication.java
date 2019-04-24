package problem3;

/**
 * Represents details of a publication.
 *
 * @author alfred
 */
public abstract class AbstractPublication {
  private String title;
  private Author author;
  private Integer year;

  /**
   * Creates a publication.
   *
   * @param title the title of the publication.
   * @param author the author of the publication.
   * @param year the year of the publication.
   */
  public AbstractPublication(String title, Author author, Integer year) throws Exception {
    if (year.toString().length() != 4) {
      throw new IllegalArgumentException("Year must be a 4-digit calender year.");
    } else {
      this.title = title;
      this.author = author;
      this.year = year;
    }
  }

  /**
   * @return the title of the publication.
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return the author of the publication.
   */
  public Author getAuthor() {
    return author;
  }

  /**
   * @return the year of the publication.
   */
  public Integer getYear() {
    return year;
  }
}
