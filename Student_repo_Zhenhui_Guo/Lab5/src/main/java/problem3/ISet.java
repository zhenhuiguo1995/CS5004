package problem3;

public interface ISet {
  ISet emptySet();

  boolean isEmpty();

  ISet add(Integer n);

  boolean contains(Integer n);

  ISet remove(Integer element);

  Integer size();
}
