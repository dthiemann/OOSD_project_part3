package org.uiowa.cs2820.engine;

public class AdditionalSearches {
  Database D;
  Field target;
  public AdditionalSearcher(Field x){
    String name1 = x.getFieldName();
    Object value1 = x.getFieldValue();
    D = new LinearDiskDatabase();
    target = x;
  }
  public String[] greater_than(Field x){
  
  }
  
  public String[] less_than(Field x){
  
  }
  public String[] contains(Field x){
  
  }
}
