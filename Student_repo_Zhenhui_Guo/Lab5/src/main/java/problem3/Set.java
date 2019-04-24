package problem3;

import java.util.ArrayList;

public class Set implements ISet {
  private int size;
  private ArrayList<Integer> arrayList;

  public Set() {
    this.size = 0;
    this.arrayList = new ArrayList<>();
  }

  public Set(int size, ArrayList<Integer> arrayList) {
    this.size = size;
    this.arrayList = arrayList;
  }

  @Override
  public ISet emptySet() {
    return new Set();
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public ISet add(Integer n) {
    if (this.contains(n)) {
      return this;
    } else {
      this.size += 1;
      this.arrayList.add(n);
      return new Set(this.size, this.arrayList);
    }
  }

  @Override
  public boolean contains(Integer n) {
    if (this.size == 0) {
      return false;
    } else {
      for (Integer i: this.arrayList) {
        if (i.equals(n)) {
          return true;
        }
      }
      return false;
    }
  }

  @Override
  public ISet remove(Integer element) {
    if (!this.contains(element)) {
      return this;
    } else {
      this.size -= 1;
      this.arrayList.remove(element);
      return new Set(this.size, this.arrayList);
    }
  }

  @Override
  public Integer size() {
    return this.size;
  }
}
