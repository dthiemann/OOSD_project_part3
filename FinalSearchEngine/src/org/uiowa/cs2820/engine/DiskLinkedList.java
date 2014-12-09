package org.uiowa.cs2820.engine;

import java.util.*;
import java.io.*;

// This class is like java.util.List, but adapted to 
// using DiskSpace instead of just memory. An interface
// "Item" is used for each element in the linked list.
public class DiskLinkedList {

  private int first;  // area of first in linked list

  // constructors
  public DiskLinkedList() { first = -1; }
  public DiskLinkedList(int location) { first = location; }

  // return item at particular location
  public Item fetch(int location) { 
    byte[] raw = DiskSpace.read(location);
    Item R = (Item) Utility.revert(raw);
    return R;
    }
  // save item back to DiskSpace
  public void save(Item S) {
    DiskSpace.write(S.getLocation(),Utility.convert(S));
    }

  // get/set first disk area in list
  public int getFirst() { return first; }
  public void setFirst(int location) { first = location; }

  // insert item at beginning of list
  // warning: changes "first"
  public void insert(Item p) {
    int newarea = Allocate.allocate(); 
    p.setNext(first);
    p.setLocation(newarea);
    DiskSpace.write(newarea,Utility.convert(p));
    first = newarea;
    }

  // remove an item from list
  // warning: may change "first"
  public void remove(Item p) {
    int toremove = p.getLocation();
    // special case is first in list
    if (first == toremove) {
      first = p.getNext();
      Allocate.free(toremove);
      return;
      }
    // traverse list to find item
    Item Old = null;
    int previous = first;
    int c;
    while (previous >= 0) {
      Old = (Item) Utility.revert( DiskSpace.read(previous) ); 
      c = Old.getNext();
      if (c == toremove) {
        Old.setNext( p.getNext() );  // remove item from list	     
	    Allocate.free( toremove );
	    DiskSpace.write(Old.getLocation(),Utility.convert(Old));
	    return;
        }
      previous = c;
      }
    // reaching here in the program is
    // technically an error, because Item not found
    }

  // traverse the linked list so long as Traverser says
  // to carry on with more items
  public void traverse(Traverser T) {
    if (first < 0) return;  // nothing to do if no list exists
    Item D = (Item) Utility.revert( DiskSpace.read(first) ); 
    boolean carry = T.process(D); 
    int next = D.getNext();
    while (carry && next >= 0) {
      D = (Item) Utility.revert( DiskSpace.read(next) ); 
      carry = T.process(D); 
      next = D.getNext();
      }
    }
  }
