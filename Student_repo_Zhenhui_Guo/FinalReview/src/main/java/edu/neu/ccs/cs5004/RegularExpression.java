package edu.neu.ccs.cs5004;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile(".s");
    Matcher matcher = pattern.matcher("as");
    boolean b = matcher.matches();
    System.out.println(b);
    System.out.println(Pattern.compile(".s").matcher("as").matches());
    System.out.println(Pattern.matches(".s", "as"));
  }

}
