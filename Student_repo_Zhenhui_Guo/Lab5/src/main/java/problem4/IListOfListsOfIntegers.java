package problem4;

import edu.neu.ccs.cs5004.listOfIntegers.List;
import java.util.ArrayList;

public interface IListOfListsOfIntegers {
  int Size();

  int length();

  int sum();

  boolean isEmpty();

  void add(ArrayList<Integer> arrayList);

  void remove(Integer integer);

  void removeAllInteger(Integer integer);
}
