package edu.neu.ccs.cs5004.Spring2018Final;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class StringTreeIterator implements Iterator<String> {
  private List<String> stringList;
  private int listIndex = 0;
  private Comparator<String> value = new Comparator<String>() {
    @Override
    public int compare(String string, String t1) {
      if (string == null && t1 == null) {
        return 0;
      } else if (string == null) {
        return -1;
      } else if (t1 == null) {
        return 1;
      } else {
        return string.compareTo(t1);
      }
    }
  };

  public StringTreeIterator(StringTreeNode root) {
    populateStringList(root);
    stringList.sort(value);
  }

  public void populateStringList(StringTreeNode root) {
    if (!root.isEmpty()) {
      stringList.add(root.getData());
      populateStringList(root.getLeft());
      populateStringList(root.getRight());
    }
  }

  @Override
  public boolean hasNext() {
    return listIndex < stringList.size() ;
  }

  @Override
  public String next() {
    if (hasNext()) {
      listIndex ++;
      return stringList.get(listIndex - 1);
    } else {
      return null;
    }
  }


}
