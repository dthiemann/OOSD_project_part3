package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class IntegrationTest {

  @Test
  public void test0() {	
	CheckPoint.reset();
	DiskSpace.reset();
	Field f = new Field("citizen",true);
	Indexer I = new Indexer("first.db");
	I.addField(f);
	Field g = new Field("two",2);
	I.addField(g);
	I = new Indexer("second.db");
	I.addField(f);
	I.addField(new Field("three",3));
	FieldSearch F = new FieldSearch(f);
	String[] S = F.findEquals();
	assertEquals(S.length,2);
	assertEquals(S[0],"second.db");
	assertEquals(S[1],"first.db");
	I.remove();
	S = F.findEquals();
	assertEquals(S.length,1);
	}

  @Test
  public void test1() {	
	CheckPoint.reset();
	DiskSpace.reset();
	// load some dummy data from a testing file
	HashMap<String,ArrayList<Field>> H = new HashMap<String,ArrayList<Field>>();
	String CurrentIndex = null;
	ArrayList<Field> CurrentFields = null;
 	try {
	  BufferedReader B = new BufferedReader(new FileReader("Resources/fielddata.txt"));
	  String line;
	  String[] tokens;
	  // NOTE: has a bug (EOF not handled well); use extra fake input line at end
	  while ((line = B.readLine()) != null) {
		tokens = line.split("\\s+");
		if (CurrentIndex == null || !CurrentIndex.equals(tokens[0])) {
		  if (CurrentIndex != null) H.put(CurrentIndex,CurrentFields);
		  CurrentIndex = tokens[0];
		  CurrentFields = new ArrayList<Field>();
		  }
		CurrentFields.add(new Field(tokens[1],tokens[2]));
		}
	  B.close();
	  }
	catch (Exception e) { }
	// put dummy data into the database
	java.util.Iterator<Entry<String, ArrayList<Field>>> I = H.entrySet().iterator();
	while (I.hasNext()) {
	  Map.Entry pairs = (Map.Entry)I.next();
	  Indexer N = new Indexer((String)pairs.getKey());
	  CurrentFields = (ArrayList<Field>)pairs.getValue();
	  for (Field f: CurrentFields) {
	    N.addField(f);
	    // System.out.println("Added "+N+' '+f);
	    }
	  }
    }
  
  @Test
  public void test2() {	
	Field f = new Field("golden","rumex");
	FieldSearch F = new FieldSearch(f);
	String[] S = F.findEquals();
	assertEquals(S.length,1);
	assertTrue(Arrays.asList(S).contains("2.txt"));
	f = new Field("not","riparia");
	F = new FieldSearch(f);
	S = F.findEquals();
	assertTrue(Arrays.asList(S).contains("1.txt"));
    }
  
  @Test
  public void test3() {
	Field f = new Field("many","times");
	FieldSearch F = new FieldSearch(f);
	String [] S = F.findEquals();
	assertEquals(S.length,30);
	for (String s: S) System.out.println(s);
    } 
  }
