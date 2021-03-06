package org.uiowa.cs2820.engine;

public class LinearDiskDatabase implements Database {

	  public void store(Field f, String id) {
	    Storage.add(f,id);
	    }

	  public void remove(String id) {
	    Node.remove(id);
	    }

	  public String[] fetch(Field f) {
	    Node n = Node.findNode(f);
	    if (n == null) return new String[0];
	    return Identifier.getAllIds(n.identlist);
	    }
	 public String[] fetchGreater(Field f) {
	    Node n = Node.findNodeGreater(f);
	    if (n == null) return new String[0];
	    return Identifier.getAllIds(n.identlist);
	    }
	 public String[] fetchLess(Field f){
	    Node n = Node.findNodeLess(f);
	    if (n == null) return new String[0];
	    return Identifier.getAllIds(n.identlist);
	 }
	  
	 public String[] fetchContains(Field f){
		Node n = Node.findNode_Contains(f);
		if (n == null) return new String[0];
		return Identifier.getAllIds(n.identlist);
		 }
		 
}
		  
