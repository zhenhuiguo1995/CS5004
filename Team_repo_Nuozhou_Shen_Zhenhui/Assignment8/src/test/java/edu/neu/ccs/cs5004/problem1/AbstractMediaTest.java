package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AbstractMediaTest {
  private static final String TEST_ALIAS = "Pet Sematary";
  private static final String TEST_TITLE = "Pet Sematary";
  private static final String TEST_NEW_ALIAS = "Pet";
  private static final int TEST_YEAR = 2019;
  private Name testDirector1;
  private Name testDirector2;
  private Name testActor1;
  private Name testActor2;
  private List<Name> testDirectors;
  private List<Name> testActors;
  private AbstractMedia testMovie;
  private AbstractMedia testMovie2;
  private AbstractMedia testTVSeries;


  @Before
  public void setUp() throws Exception {
    testDirector1 = new Name("Kevin", "Kölsch");
    testDirector2 = new Name("Dennis", "Widmyer");
    testActor1 = new Name("Jason", "Clarke");
    testActor2 = new Name("Amy", "Seimetz");
    testDirectors = new LinkedList<>();
    testDirectors.add(testDirector1);
    testDirectors.add(testDirector2);
    testActors = new LinkedList<>();
    testActors.add(testActor1);
    testActors.add(testActor2);
    testMovie = new Movie(TEST_ALIAS, TEST_TITLE, TEST_YEAR, testDirectors, testActors);
    testMovie2 = new Movie(TEST_ALIAS, TEST_TITLE, TEST_YEAR, testDirectors, testActors);
    testTVSeries = new TvSeries(TEST_ALIAS, TEST_TITLE, TEST_YEAR, testDirectors, testActors);
  }

  @Test
  public void testGetAlias() {
    assertEquals(TEST_ALIAS, testMovie.getAlias());
  }

  @Test
  public void testGetYear() {
    assertEquals(TEST_YEAR, testMovie.getYear());
  }

  @Test
  public void testGetTitle() {
    assertEquals(TEST_TITLE, testMovie.getTitle());
  }

  @Test
  public void testGetDirectors() {
    assertEquals(testDirectors, testMovie.getDirectors());
  }

  @Test
  public void testGetActors() {
    assertEquals(testActors, testMovie.getActors());
  }

  @Test
  public void testSetAlias() {
    testMovie.setAlias(TEST_NEW_ALIAS);
    assertEquals(TEST_NEW_ALIAS, testMovie.getAlias());
  }

  @Test
  public void testHashCode(){
    assertEquals(testMovie.hashCode(), testMovie.hashCode());
    assertNotEquals(4, testMovie.hashCode());
  }

  @Test
  public void testEquals() {
    assertFalse(testMovie.equals(null));
    assertTrue(testMovie.equals(testMovie));
    assertTrue(testMovie.equals(testMovie2));
    assertFalse(testMovie.equals(testTVSeries));
  }

  @Test
  public void testToString() {
    String str = "Alias-" + TEST_ALIAS + "\n";
    str += "Title-" + TEST_TITLE + "\n";
    str += "Year-" + TEST_YEAR + "\n";
    str += "Directors-" + testDirectors.toString() + "\n";
    str += "Actors-" + testActors.toString() + "\n";
    assertEquals(str, testMovie.toString());
  }
}