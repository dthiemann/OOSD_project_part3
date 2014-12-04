package org.uiowa.cs2820.engine;

public class Indexer {
  Database D;
  String document;
	  
  public Indexer(String id) {
	D = new LinearDiskDatabase();
	document = id;
	}
  public void addField(Field f) {
	D.store(f,document);
	}
  public void remove() {
	D.remove(document);
	document = null;  // Indexer now meaningless
    }
  public String toString() {
	return "{"+document+"}";
    }
  }