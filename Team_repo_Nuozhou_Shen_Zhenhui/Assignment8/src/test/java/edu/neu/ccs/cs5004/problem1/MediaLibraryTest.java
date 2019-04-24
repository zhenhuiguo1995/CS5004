package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class MediaLibraryTest {

  //movie 1
  private static final String TEST_ALIAS_1 = "Pet Sematary";
  private static final String TEST_TITLE_1 = "Pet Sematary";
  private static final int TEST_YEAR_1 = 2019;
  private Name testDirector1_1;
  private Name testDirector1_2;
  private Name testActor1;
  private List<Name> testDirectors1;
  private List<Name> testActors1;
  private AbstractMedia testMovie1;
  //movie 2
  private static final String TEST_ALIAS_2 = "Dumbo";
  private static final String TEST_TITLE_2 = "Dumbo";
  private static final int TEST_YEAR_2 = 2018;
  private Name testDirector2_1;
  private Name testActor2;
  private List<Name> testDirectors2;
  private List<Name> testActors2;
  private AbstractMedia testMovie2;
  //movie 3
  private static final String TEST_ALIAS_3 = "Dumbo";
  private static final String TEST_TITLE_3 = "Dumbo2";
  private static final int TEST_YEAR_3 = 2020;
  private Name testDirector3_1;
  private Name testActor3;
  private List<Name> testDirectors3;
  private List<Name> testActors3;
  private AbstractMedia testMovie3;
  //indexByMedia
  private Map<String, AbstractMedia> testIndexByAlias;
  //mediaByDirector
  private Map<Name, List<String>> testMediaByDirector;
  //mediaStream
  private Map<String, Integer> testMediaStream;
  //media library
  private MediaLibrary testMediaLibrary;
  private MediaLibrary testMediaLibrary2;
  private MediaLibrary testMediaLibrary3;

  @Before
  public void setUp() {
    //movie 1
    testDirector1_1 = new Name("Kevin", "Kölsch");
    testDirector1_2 = new Name("Dennis", "Widmyer");
    testDirectors1 = new LinkedList<>();
    testDirectors1.add(testDirector1_1);
    testDirectors1.add(testDirector1_2);
    testActor1 = new Name("Jason", "Clarke");
    testActors1 = new LinkedList<>();
    testActors1.add(testActor1);
    testMovie1 = new Movie(TEST_ALIAS_1, TEST_TITLE_1, TEST_YEAR_1, testDirectors1, testActors1);
    //movie 2
    testDirector2_1 = new Name("Kevin", "Kölsch");
    testDirectors2 = new LinkedList<>();
    testDirectors2.add(testDirector2_1);
    testActor2 = new Name("Alice", "Green");
    testActors2 = new LinkedList<>();
    testActors2.add(testActor2);
    testMovie2 = new Movie(TEST_ALIAS_2, TEST_TITLE_2, TEST_YEAR_2, testDirectors2, testActors2);
    //movie 3
    testDirector3_1 = new Name("Banana", "Blue");
    testDirectors3 = new LinkedList<>();
    testDirectors3.add(testDirector3_1);
    testActor3 = new Name("Alice", "Green");
    testActors3 = new LinkedList<>();
    testActors3.add(testActor3);
    testMovie3 = new Movie(TEST_ALIAS_3, TEST_TITLE_3, TEST_YEAR_3, testDirectors3, testActors3);
    //indexByMedia
    testIndexByAlias = new HashMap<>();
    testIndexByAlias.put(TEST_ALIAS_1, testMovie1);
    //mediaByDirector
    testMediaByDirector = new HashMap<>();
    List<String> l1 = new LinkedList<>();
    l1.add(TEST_ALIAS_1);
    List<String> l2 = new LinkedList<>();
    l2.add(TEST_ALIAS_1);
    testMediaByDirector.put(testDirector1_1, l1);
    testMediaByDirector.put(testDirector1_2, l2);
    //mediaStream
    testMediaStream = new HashMap<>();
    testMediaStream.put(TEST_ALIAS_1, 2);
    //media library
    testMediaLibrary = new MediaLibrary(testIndexByAlias, testMediaByDirector, testMediaStream);
    testMediaLibrary2 = new MediaLibrary(testIndexByAlias, testMediaByDirector, testMediaStream);
    testMediaLibrary3 = new MediaLibrary();
  }

  @Test
  public void testGetIndexByAlias() {
    assertEquals(testIndexByAlias, testMediaLibrary.getIndexByAlias());
  }

  @Test
  public void testGetMediaStream() {
    assertEquals(testMediaStream, testMediaLibrary.getMediaStream());
  }

  @Test
  public void testGetMediasByDirector() {
    assertEquals(testMediaByDirector, testMediaLibrary.getMediasByDirector());
  }

  @Test
  public void testAddMedia() {
    assertTrue(testMediaLibrary.addMedia(testMovie2));
    assertEquals(testMovie2, testMediaLibrary.getIndexByAlias().get(TEST_ALIAS_2));
    List<AbstractMedia> actualMovies = testMediaLibrary.getMediaByDirector(testDirector2_1);
    assertEquals(testMovie2, actualMovies.get(1));
    for (int i = 0; i < actualMovies.size() - 1; i++) {
      assertTrue(actualMovies.get(i).getYear() >= actualMovies.get(i + 1).getYear());
    }
    assertFalse(testMediaLibrary.addMedia(testMovie3));
    testMovie3.setAlias("Dumbo2");
    assertTrue(testMediaLibrary.addMedia(testMovie3));
  }

  @Test
  public void testGetMediaByDirector() {
    testMovie3.setAlias("Dumbo2");
    testMediaLibrary.addMedia(testMovie2);
    testMediaLibrary.addMedia(testMovie3);
    List<AbstractMedia> expectedList1 = new LinkedList<>();
    List<AbstractMedia> expectedList2 = new LinkedList<>();
    List<AbstractMedia> expectedList3 = new LinkedList<>();
    expectedList1.add(testMovie1);
    expectedList1.add(testMovie2);
    expectedList2.add(testMovie1);
    expectedList3.add(testMovie3);
    assertEquals(expectedList1, testMediaLibrary.getMediaByDirector(testDirector1_1));
    assertEquals(expectedList2, testMediaLibrary.getMediaByDirector(testDirector1_2));
    assertEquals(expectedList3, testMediaLibrary.getMediaByDirector(testDirector3_1));
  }

  @Test
  public void testRequestStreaming() {
    testMediaLibrary.addMedia(testMovie2);
    testMediaLibrary.requestStreaming(TEST_ALIAS_2);
    assertEquals(1, testMediaLibrary.getStream(TEST_ALIAS_2));
    assertEquals(2, testMediaLibrary.getStream(TEST_ALIAS_1));
    testMediaLibrary.requestStreaming(TEST_ALIAS_1);
    assertEquals(3, testMediaLibrary.getStream(TEST_ALIAS_1));
  }

  @Test
  public void testAliasNotExistException() {
    try {
      testMediaLibrary.requestStreaming(TEST_ALIAS_2);
      fail("An exception should be thrown.");
    } catch (AliasNotExistException e) {
    }
  }

  @Test
  public void testGetStream() {
    assertEquals(2, testMediaLibrary.getStream(TEST_ALIAS_1));
    assertEquals(0, testMediaLibrary.getStream(TEST_ALIAS_2));
  }

  @Test
  public void testGetMostStreamedMedia() {
    testMediaLibrary.addMedia(testMovie2);
    testMediaLibrary.requestStreaming(TEST_ALIAS_2);
    assertEquals(testMovie1, testMediaLibrary.getMostStreamedMedia());
    testMediaLibrary.requestStreaming(TEST_ALIAS_2);
    testMediaLibrary.requestStreaming(TEST_ALIAS_2);
    assertEquals(testMovie2, testMediaLibrary.getMostStreamedMedia());
    assertEquals(null, testMediaLibrary3.getMostStreamedMedia());
  }

  @Test
  public void testEquals(){
    assertTrue(testMediaLibrary.equals(testMediaLibrary));
    assertFalse(testMediaLibrary.equals(null));
    assertTrue(testMediaLibrary.equals(testMediaLibrary2));
    assertFalse(testMediaLibrary.equals(testActor1));
    assertTrue(testMediaLibrary.equals(testMediaLibrary3));
  }

  @Test
  public void testHashCode(){
    assertEquals(testMediaLibrary.hashCode(), testMediaLibrary.hashCode());
  }

  @Test
  public void testToString(){
    assertEquals("This is a media library.", testMediaLibrary.toString());
  }


}