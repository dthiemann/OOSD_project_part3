package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import java.io.*;

// for testing purposes, define Item and Traverser
class localnode implements Item, Serializable {
  int location;
  int next;
  int x;  // just some value for testing purposes
  public localnode(int value) { x = value; }
  public int getLocation() { return location; }
  public void setLocation(int p) { location = p; }
  public int getNext() { return next; }
  public void setNext(int a) { next = a; }
  }

// for testing, a class to sum over all in list
class sum implements Traverser {
  int total;
  public sum() { total = 0; } 
  public boolean process(Item I) {
    localnode N = (localnode) I;
    total += N.x;
    return true;
    }
  }

public class DiskLinkedListTest {
 
  @Test
  public void test() {
    DiskSpace.reset();
    CheckPoint.reset();
    DiskLinkedList L = new DiskLinkedList();
    localnode g, h;
    g = h = null;
    for (int i = 0; i<10; i++) {
      g = new localnode(i);
      L.insert(g); 
      if (i == 7) h = g;
      }
    // now we have a linked list on disk
    sum V = new sum();     
    L.traverse(V); 
    assertEquals(V.total,45);
    L.remove(h);
    V = new sum();     
    L.traverse(V);  
    assertEquals(V.total,38);
    }

  }
