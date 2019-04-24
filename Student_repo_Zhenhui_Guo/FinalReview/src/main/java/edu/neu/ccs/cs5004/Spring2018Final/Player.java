package edu.neu.ccs.cs5004.Spring2018Final;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {

  private String name;
  private Integer age;
  private Double height;
  private String club;

  public Player(String name, Integer age, Double height, String club) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.club = club;
  }

  /**
   * Getter for property ’name’.
   *
   * @return Value for property ’firstname’.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for property ’age’.
   *
   * @return Value for property ’age’.
   */
  public Integer getAge() {
    return age;
  }

  /**
   * Getter for property ’height’.
   *
   * @return Value for property ’height’.
   */
  public Double getHeight() {
    return height;
  }

  /**
   * Getter for property ’club’.
   *
   * @return Value for property ’club’.
   */
  public String getClub() {
    return club;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other)
      return true;
    if (other == null || getClass() != other.getClass())
      return false;
    Player player = (Player) other;
    return Objects.equals(name, player.name)
        && Objects.equals(age, player.age)
        && Objects.equals(height, player.height)
        && Objects.equals(club, player.club);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, height, club);
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", club='" + club + '}';
  }

  public static void main(String[] args) {
    List<Player> players = new ArrayList<>();
    players.add(new Player("LeBron James", 33, 6.8, "Cleveland Cavaliers"));
    players.add(new Player("Kevin Durant", 29, 6.9, "Golden State Warriors"));
    players.add(new Player("Stephen Curry", 30, 6.3, "Golden State Warriors"));
    Comparator<Player> name = new Comparator<Player>() {
      @Override
      public int compare(Player o1, Player o2) {
        return o1.getName().compareTo(o2.getName());
      }
    };
    // print out each player according to the toString method
    System.out.println("Players:" + players);
    players.sort(name); // sort by player name and mutate the players list
    System.out.println("Players again: " + players.stream().map(Player::getClub).collect
        (Collectors.toList()));

    Map<Integer, Double> map = new HashMap<>();
    for (int i = 1; i < 10; i ++) {
      map.put(i, (double)i);
    }
    for (Map.Entry<Integer, Double> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " " +  entry.getValue());
    }
  }

}
