package problem2;

public class Cons implements IListOfStrings {
  private String string;
  private Cons rest;

  public Cons(String string, Cons rest) {
    this.string = string;
    this.rest = rest;
  }

  @Override
  public boolean isEmpty() {
    if (this.string == null) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int size() {
    if (this.string == null) {
      return 0;
    } else {
      return 1 + this.rest.size();
    }
  }

  @Override
  public boolean contains(String string) {
    if (this.string == null) {
      return false;
    } else if (this.string.equals(string)) {
      return true;
    } else {
      return this.rest.contains(string);
    }
  }

  @Override
  public boolean containsAll(IListOfStrings listOfStrings) {
    Cons temp = this;
    while (temp.string != null) {
      if (!listOfStrings.contains(temp.string)) {
        return false;
      }
      temp = temp.rest;
    }
    return true;
  }

  @Override
  public IListOfStrings filterLargerThan(int length) {
    Cons newCons = new Cons("dummy", null);
    Cons p = newCons;
    Cons temp = this;
    while (temp.string != null) {
      if (temp.string.length() > length) {
        p.string = temp.string;
        p = p.rest;
      }
      temp = temp.rest;
    }
    return newCons;
  }

  @Override
  public boolean hasDuplicates() {
    return false;
  }

  @Override
  public IListOfStrings removeDuplicates() {
    return null;
  }
}
