package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Read {

  public static void main(String[] args) {
    String fileName = "readme.txt";
    String outputFile = "output.txt";
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    try {
      bufferedReader = new BufferedReader(new FileReader(fileName));
      bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
      String s = null;
      while ((s = bufferedReader.readLine()) != null) {
        System.out.println(s);
        bufferedWriter.write(s + "oh my god!" + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bufferedReader != null &&bufferedWriter != null){
        try {
          bufferedReader.close();
          bufferedWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }
}
