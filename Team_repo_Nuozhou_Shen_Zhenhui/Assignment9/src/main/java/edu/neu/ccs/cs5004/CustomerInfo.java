package edu.neu.ccs.cs5004;


import java.util.List;
import java.util.Map;

/**
 * The class Customer info.
 */
public class CustomerInfo {

  private List<String[]> contactInfo;
  private Map<String, Integer> map;
  private int colNum;

  /**
   * Instantiates a new Customer info.
   *
   * @param contactInfo the contact info
   * @param map the map
   * @param colNum the col num
   */
  public CustomerInfo(List<String[]> contactInfo, Map<String, Integer> map, int colNum) {
    this.contactInfo = contactInfo;
    this.map = map;
    this.colNum = colNum;
  }

  /**
   * Gets contact info.
   *
   * @return the contact info
   */
  public List<String[]> getContactInfo() {
    return contactInfo;
  }

  /**
   * Gets map.
   *
   * @return the map
   */
  public Map<String, Integer> getMap() {
    return map;
  }

  /**
   * Gets col num.
   *
   * @return the col num
   */
  public int getColNum() {
    return colNum;
  }

  @Override
  public String toString() {
    return "CustomerInfo{"
        + ", map=" + map.toString()
        + ", colNum=" + colNum
        + '}';
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    CustomerInfo that = (CustomerInfo) object;

    if (getColNum() != that.getColNum()) {
      return false;
    }
    if (!getContactInfo().equals(that.getContactInfo())) {
      return false;
    }
    return getMap().equals(that.getMap());
  }

  @Override
  public int hashCode() {
    int result = getContactInfo().hashCode();
    result = 31 * result + getMap().hashCode();
    result = 31 * result + getColNum();
    return result;
  }
}
