package edu.neu.ccs.cs5004;


/**
 * The type Book.
 */
public class Book {

  private String name;
  private int publishYear;

  /**
   * The type People.
   */
  public class People {
    private String characterName;
    private String bookName;
    private int age;

    /**
     * Instantiates a new People.
     *
     * @param characterName the character name
     */
    public People(String characterName) {
      this.characterName = characterName;
      this.bookName = name;
      //this.age = getYear();
    }
  }

  /**
   * The type Story.
   */
  public static class Story {
    private String storyName;
    private boolean flag;
    private int year;

    /**
     * Instantiates a new Story.
     *
     * @param storyName the story name
     * @param flag the flag
     */
    public Story(String storyName, boolean flag) {
      this.storyName = storyName;
      this.flag = flag;
    }
  }

  /**
   * Instantiates a new Book.
   *
   * @param name the name
   * @param publishYear the publish year
   */
  public Book(String name, int publishYear) {
    this.name = name;
    this.publishYear = publishYear;
  }

  /**
   * Gets year.
   *
   * @param x the x
   * @return the year
   * @throws Exception the exception
   */
  public int getYear(int x) throws Exception {
    return this.publishYear;
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Book book = new Book("Allan", 1995);
    Book.Story story = new Book.Story("Adventure", true);
    People people = book.new People("adsa");
  }

}
