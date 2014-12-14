package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class ContainsTest {

	
	
	 //copy from integrationTest
	 @Test
	 public void test0() {	
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
	  public void test1() {	
		Field f = new Field("word","school");
		Contains F = new Contains(f);
		F.find();
		ArrayList<String> R = F.GetFields();
	
		assertEquals(R.size(),5);
		assertTrue(R.contains("building"));
		assertFalse(R.contains("animal"));
	    }
	 @Test
	  public void test2() {	
		CheckPoint.reset();
		DiskSpace.reset();
		Field f = new Field("finals","school");
		Indexer I = new Indexer("first.db");
		I.addField(f);
		Field g = new Field("animal","bear");
		I.addField(g);;
		I.addField(new Field("month","December"));
		Contains F = new Contains(f);
		F.find();
		ArrayList<String> R = F.GetFields();  
		assertEquals(R.size(),1);
		assertEquals(R.get(0),"finals");
	 }
		

}
