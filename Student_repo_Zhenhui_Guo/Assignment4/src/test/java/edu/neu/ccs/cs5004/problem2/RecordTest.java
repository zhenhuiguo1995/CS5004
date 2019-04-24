package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Before;
import org.junit.Test;

public class RecordTest {
  private int wins;
  private int losses;
  private int draws;
  private static final int INITIAL_SCORE = 0;
  private Record record;


  @Before
  public void setUp() throws Exception {
    this.wins = 2;
    this.losses = 1;
    this.draws = 0;
    this.record = new Record(this.wins, this.losses, this.draws);
  }

  @Test
  public void getWins() throws Exception {
    assertEquals(this.wins, this.record.getWins());
  }

  @Test
  public void getLosses() throws Exception {
    assertEquals(this.losses, this.record.getLosses());
  }

  @Test
  public void getDraws() throws Exception {
    assertEquals(this.draws, this.record.getDraws());
  }

  @Test
  public void testVoidConstructor() {
    this.record = new Record();
    assertEquals(INITIAL_SCORE, this.record.getWins());
    assertEquals(INITIAL_SCORE, this.record.getDraws());
    assertEquals(INITIAL_SCORE, this.record.getLosses());
  }

}