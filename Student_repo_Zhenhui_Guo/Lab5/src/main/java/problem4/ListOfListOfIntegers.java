package problem4;

import java.util.ArrayList;

public class ListOfListOfIntegers implements IListOfListsOfIntegers {
  private int size;
  private ArrayList<ArrayList<Integer>> lists;

  public ListOfListOfIntegers() {
    this.size = 0;
    this.lists = new ArrayList<>();
  }

  public ListOfListOfIntegers(int size,
      ArrayList<ArrayList<Integer>> lists) {
    this.size = size;
    this.lists = lists;
  }

  @Override
  public int Size() {
    return this.size;
  }

  @Override
  public int length() {
    int length = 0;
    for (int i = 0; i < this.size; i ++) {
      length += this.lists.get(i).size();
    }
    return length;
  }

  @Override
  public int sum() {
    int sum = 0;
    for (int i = 0; i < this.size; i ++) {
      for (int j: this.lists.get(i)) {
        sum  += j;
      }
    }
    return sum;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public void add(ArrayList<Integer> arrayList) {
    this.lists.add(arrayList);
  }

  @Override
  public void remove(Integer integer) {
    for (int i = 0; i < this.size; i ++) {
      for (int j : this.lists.get(i)) {
        if (j == integer) {
          this.lists.get(i).remove(integer);
          break;
        }
      }
    }
  }

  @Override
  public void removeAllInteger(Integer integer) {
    for (int i = 0 ; i < this.size; i ++) {
      ArrayList<Integer> temp = (ArrayList<Integer>) this.lists.get(i).clone();
      for (int j : temp) {
        if (j == integer) {
          temp.remove(j);
        }
      }
      this.lists.set(i, temp);
    }
  }
}
