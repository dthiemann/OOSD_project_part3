package org.uiowa.cs2820.engine;

public interface Item {
	  // Item represents one element in a linked list
	  // getLocation() returns location of Item
	  public int getLocation(); 
	  public void setLocation(int location);
	  // getNext() returns the location of the next Item
	  // in the list, or -1 to mean there is no next
	  public int getNext(); 
	  public void setNext(int location);
	  }
