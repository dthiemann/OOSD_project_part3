package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;
import java.io.*;
import java.util.*;


public class GreaterThanTest {

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
		GreaterThan F = new GreaterThan(f);
		F.find();
		ArrayList<String> R = F.GetNodes();  //compares the value saturday to the values a and zzz
		assertEquals(R.size(),1);
		assertEquals(R.get(0),"zzz");		//only zzz is greater than saturday
		Field e = new Field("word","kite");
		GreaterThan T = new GreaterThan(e);		//comparing new value to all the previous values
		T.find();
		ArrayList<String> Second = new ArrayList<String>();
		Second = T.GetNodes();
		assertEquals(Second.size(),2);  //Adds the value Saturday
		}
	 //copy from integrationTest
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
		GreaterThan F = new GreaterThan(f);
		F.find();
		ArrayList<String> R = F.GetNodes();
		assertEquals(R.size(),5);
		assertTrue(R.contains("movie"));
		assertFalse(R.contains("six"));
	    }

}
