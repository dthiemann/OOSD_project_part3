package org.uiowa.cs2820.engine;

public class FieldSearch {
  Field target;
  Database D;
  public FieldSearch(Field f) { 
	D = new LinearDiskDatabase();
	target = f; 
	}
  public String[] findEquals() {
	String [] R = D.fetch(target);
	if (R == null) R = new String[0];
	return R;
	}
  
  /* 
   * Method definitions added by Dylan 
   * in for my code to compile  
   */
  public String[] findGreaterThan() {
	  String[] R = null;
	  return R;
  }
  public String[] findLessThanThan() {
	  String[] R = null;
	  return R;
  }
  public String[] findSuffix() {
	  String[] R = null;
	  return R;
  }
  public String[] findPrefix() {
	  String[] R = null;
	  return R;
  }
  }
