package org.uiowa.cs2820.engine;

public interface Traverser {
	  // Traverser method is called on each item 
	  // of a linked list, like searching the list
	  // or summing items in a list, etc. 
	  // 
	  // process returns true if the traversal 
	  // through the linked list should continue
	  // (false means quit the traversal)
	  public boolean process(Item I); 
	  }
