package org.uiowa.cs2820.engine;

public class AdditionalSearches {
  Database D;
  Field target;
  ArrayList<String> List;
  public AdditionalSearcher(Field x){
    String name1 = x.getFieldName();
    String value1 = (String) f.getFieldValue();;
    D = new LinearDiskDatabase();
    target = x;
    
 
  }
  public String[] greater_than(){
   List = new ArrayList<String>();
    
    
    For(Field x:D){
      String name2 = x.Key.getFieldName();
      String value2 = (String) x.Key.getFieldValue();
      if (name2.equals(name1) & value2.compareTo(value1)>0){
        List.add(x);
  }
    }
}
    return List;
  }
  
  public String[] less_than(Field x){
  
  }
  public String[] contains(Field x){
  
  }
}
