package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import java.io.*;

 /* R is an Arraylist that contains all the values that are less than the given value.*/

public class LessThanTest {



	 @Test
	  public void test0() {	
		CheckPoint.reset();
		DiskSpace.reset();
		Field f = new Field("word","saturday");
		Indexer I = new Indexer("first.db");
		I.addField(f);
		Field g = new Field("word","zzz");
		I.addField(g);;
		I.addField(new Field("word","a"));
		LessThan F = new LessThan(f);
		F.find();
		ArrayList<String> R = F.GetLlst();  
		assertEquals(R.size(),1);
		assertEquals(R.get(0),"a");		 
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
			  BufferedReader B = new BufferedReader(new FileReader("Resources/list.txt"));
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
			    System.out.println("Added "+N+' '+f);
		
			    }
			  }
		    }
	 @Test
	  public void test2() {	
		Field f = new Field("word","example");
		LessThan F = new LessThan(f);
		F.find();
		ArrayList<String> R = F.GetLlst();
		
		assertEquals(R.size(),0);
		Field e = new Field("animal","shark");
		LessThan Y = new LessThan(e);
		Y.find();
		ArrayList<String> T = Y.GetLlst();
		assertEquals(T.size(),2);
		
		assertFalse(T.contains("movie"));
		assertTrue(T.contains("ant"));
		
	    }

}
