package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.Book.People;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class BookTest {

  @Before
  public void setUp() throws Exception {
    Book book = new Book("Fantastic beasts", 2010);
    People people = book.new People("asdda");
  }

  @Test
  public void getYear() throws Exception {
    System.out.println("ABC".compareTo("abc"));
    List<Integer> list = new ArrayList<>();
    for (int i = 0 ; i < 10; i ++) {
      list.add(i);
    }
    System.out.println(list);
  }

  @Test
  public void main() throws Exception {
    Pattern splitAtSpaces = Pattern.compile("\\s+");
    String someStrings[] = {"one row", "some more words", "any other words" };
    Object list = Stream.of(someStrings)
        .flatMap(line -> splitAtSpaces.splitAsStream(line))
        .collect(Collectors.toList());
    System.out.println(list);
  }

  @Test
  public void regex() throws Exception {
    Pattern pattern = Pattern.compile(".*(password|pswd|pass|pa\\$\\$).*");
    Matcher matcher = pattern.matcher("apswd");
    assertTrue(matcher.matches());
  }

}