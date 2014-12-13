package org.uiowa.cs2820.engine;

import java.io.*;
import java.util.*;

// local Traverser to collect all Ids in linked list  
class CollectIds implements Traverser {
  ArrayList<String> C;
  ArrayList<Identifier> saveall;
  public CollectIds() { 
    C = new ArrayList<String>(); 
    saveall = new ArrayList<Identifier>();
    } 
  public boolean process(Item I) { 
    Identifier Id = (Identifier) I;  // traversing Identifiers 
    C.add(Id.getName());
    saveall.add(Id);
    return true;
    }
  }

// local Traverser to find an identifier  
class Finder implements Traverser {
  Identifier found = null;
  String name;
  public Finder(String target) { name = target; } 
  public boolean process(Item I) { 
    Identifier Id = (Identifier) I;  // traversing Identifiers 
    if (name.equals(Id.getName())) {
      found = Id; 
      return false;
      }
    return true;
    }
  }

public class Identifier implements Item, Serializable {
  // Identifier just has a String
  private String name; 
  private int location;  // area location on DiskSpace
  private int next;      // area of next Identifier

  // constructor 
  public Identifier (String name) { 
    this.name = name; 
    next = location = -1;  // default value is no next
    }

  // save Identifier to DiskSpace
  public void save() {
    DiskSpace.write(location,Utility.convert(this));
    }

  // insert Identifier into Linked List
  public void add( int head ) { // head is current first in linked list
    DiskLinkedList D = new DiskLinkedList(head);
    D.insert(this); 
    save();
    // WARNING - this changes head of list do this.location
    }

  // Item methods
  public int getLocation() { return location; }
  public void setLocation(int p) { location = p; }
  public int getNext() { return next; }
  public void setNext(int p) { next = p; }
  public String getName() { return name; }
  
  // find a particular identifier in linked list
  public static Identifier find( int head, String id ) {
    // head is the disk area of the first Identifier in linked list
    DiskLinkedList D = new DiskLinkedList(head);
    Finder F = new Finder(id);
    D.traverse(F);
    return F.found;
    }

  // remove an identifier from a linked list
  public static int remove( int head, String id ) {
    // returns new area number for head of list
    DiskLinkedList D = new DiskLinkedList(head);
    Identifier I;
    while (true) {  // remove all occurrences
      I = find(head,id);
      if (I == null) break;
      D.remove(I);  // removes one occurrence 
      head = D.getFirst(); 
      }
    return head;
    }

  // Return all identifiers 
  public static String [] getAllIds( int head ) {
    // head is the disk area of the first Identifier in linked list
    DiskLinkedList D = new DiskLinkedList(head);
    CollectIds idlist = new CollectIds();  
    D.traverse(idlist);
    String [] R = (idlist.C).toArray(new String[idlist.C.size()]);
    return R;
    }

  // Free entire linked list of identifiers
  public static void freeAll( int head ) {
    DiskLinkedList D = new DiskLinkedList(head);
    CollectIds idlist = new CollectIds();  
    D.traverse(idlist);
    for (Identifier e: idlist.saveall) Allocate.free(e.getLocation());
    }

  }

