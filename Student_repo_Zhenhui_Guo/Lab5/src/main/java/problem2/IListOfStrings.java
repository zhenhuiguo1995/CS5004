package problem2;

public interface IListOfStrings {
  boolean isEmpty();

  int size();

  boolean contains(String string);

  boolean containsAll(IListOfStrings listOfStrings);

  IListOfStrings filterLargerThan(int length);

  boolean hasDuplicates();

  IListOfStrings removeDuplicates();

}
