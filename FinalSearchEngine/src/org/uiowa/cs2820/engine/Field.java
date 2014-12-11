package org.uiowa.cs2820.engine;

import java.io.*;

public class Field implements Serializable {
  // Field has a name and an associated value
  private String FieldName; 
  private Object FieldValue;
  // constructor for Field 
  public Field(String FieldName, Object Value) {
    this.FieldName = FieldName;
    this.FieldValue = Value;
    }
  public String getFieldName() { return FieldName; }
  public Object getFieldValue() { return FieldValue; }
  // this compares two Field objects for equality 
  public boolean equals(Field other) {
    return FieldName.equals(other.FieldName) & 
	   FieldValue.equals(other.FieldValue);
    }
  
  public boolean hasPrefix(Field other) {
	  String myFieldValue = (String) other.getFieldValue().toString();
	  return FieldName.equals(other.FieldName) &
			  FieldValue.toString().startsWith(myFieldValue);
  }
  public boolean hasSuffix(Field other) {
	  String myFieldValue = (String) other.getFieldValue().toString();
	  return FieldName.equals(other.FieldName) &
			  FieldValue.toString().endsWith(myFieldValue);
  }
  public boolean isGreaterThan(Field other){
  	String myFieldValue = (String) other.getFieldValue().toString();
  	return (FieldName.equal(other.FieldName) & (FieldValue.toString().compareTo(myFieldValue)>0));
 
  	}
  public boolean isLessThan(Field other){
  	String myFieldValue = (String) other.getFieldValue().toString();
  	return (FieldName.equal(other.FieldName) & (FieldValue.toString().compareTo(myFieldValue)<0));
 
  	}
  public String toString() {
    return FieldName + ':' + FieldValue.toString();
    }
  }
