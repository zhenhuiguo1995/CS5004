package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CustomerInfoTest {
  private List<String[]> contactInfo;
  private Map<String, Integer> map;
  private int colNum;
  private CustomerInfo customerInfo;
  private String[] s1;
  private String[] s2;

  @Before
  public void setUp() throws Exception {
    this.colNum = 2;
    this.map = new HashMap<>();
    this.map.put("first_name", 0);
    this.map.put("last_name", 1);
    this.contactInfo = new ArrayList<>();
    this.s1 = new String[]{"Katie", "Mcgill"};
    this.contactInfo.add(s1);
    this.s2 = new String[]{"Alfred", "Will"};
    this.contactInfo.add(s2);
    this.customerInfo = new CustomerInfo(this.contactInfo, this.map, this.colNum);
  }

  @Test
  public void getContactInfo() throws Exception {
    assertEquals(this.customerInfo.getContactInfo(), this.contactInfo);
  }

  @Test
  public void getMap() throws Exception {
    assertEquals(this.customerInfo.getMap(), this.map);
  }

  @Test
  public void getColNum() throws Exception {
    assertEquals(this.customerInfo.getColNum(), 2);
  }

  @Test
  public void toStringTest() throws Exception {
    assertEquals("CustomerInfo{, map={last_name=1, first_name=0}, colNum=2}",
        this.customerInfo.toString());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.customerInfo.equals(this.customerInfo));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.customerInfo.equals(null));
  }

  @Test
  public void columnsNotEqual() throws Exception {
    CustomerInfo testCustomerInfo = new CustomerInfo(this.contactInfo, this.map, 3);
    assertFalse(this.customerInfo.equals(testCustomerInfo));
  }

  @Test
  public void contactInfoNotEqual() throws Exception {
    List<String[]> testContactInfo = new ArrayList<>();
    testContactInfo.add(new String[] {"Lilyan", "Lannister"});
    CustomerInfo testCustomerInfo = new CustomerInfo(testContactInfo, this.map, this.colNum);
    assertFalse(this.customerInfo.equals(testCustomerInfo));
  }

  @Test
  public void mapNotEqual() throws Exception {
    Map<String, Integer> testMap = new HashMap<>();
    testMap.put("last_name", 0);
    testMap.put("first_name", 1);
    CustomerInfo testCustomerInfo = new CustomerInfo(this.contactInfo, testMap, this.colNum);
    assertFalse(this.customerInfo.equals(testCustomerInfo));
  }

  @Test
  public void classNotEqual() throws Exception {
    assertFalse(this.customerInfo.equals(new CsvParser()));
  }


}