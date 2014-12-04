package org.uiowa.cs2820.engine;

import java.util.*;

public class Storage {
  // This class provides database storage of Field objects
  // with associated Identifiers.  There are two cases for
  // a Field object with respect to the existing database.
  // (1) There is no other Field stored in the database with
  //     the same content (name and value). In this case, the
  //     new Field should be stored along with the single 
  //     identifier.
  // (2) There is another Field already stored in the database
  //     that has the same content (name and value).  The  
  //     thing to do here is find that existing Field, then
  //     add the identifier to the existing list of identifiers
  //     for that Field.  
  public static void add(Field f, String id) { 
    Node E = Node.findNode(f); 
    if (E == null) { // case (1)
       E = Node.newNode(f);
       // build and save Identifier
       Identifier I = new Identifier(id);
       I.setLocation(Allocate.allocate());
       I.save();
       E.identlist = I.getLocation();
       E.save();
       return;
       }
    // for existing node, need to add identifier
    Identifier I = new Identifier(id); 
    I.setLocation(Allocate.allocate());
    I.add(E.identlist);  // insert new Identier in existing list
    E.identlist = I.getLocation();  // new head of list
    E.save();
    }

  // Remove an identifier from the database
  public static void remove( String identifier ) {
	// Node does this for us
	Node.remove(identifier);
    }
  }