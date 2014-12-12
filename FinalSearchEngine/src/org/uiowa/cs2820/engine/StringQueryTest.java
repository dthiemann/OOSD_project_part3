package org.uiowa.cs2820.engine;

import org.junit.*;

public class StringQueryTest {
	
	/* 
	 * Test that appropriate data is transfered to StringQuery object
	 * even if we return null
	 * 
	 * This test also represents how all the pieces interact with 
	 * each other
	 */
	@Test
	public void test1() {
		//String equation = "Search (prefix (Word,pre)) and (equals (Temperature,85)) or (suffix (anotherWord,friend))";
		String equation = "Search (equals (golden,rumex))";
		ParsedString myPS = StringParserUtility.parse(equation);
		
		StringQuery query = new StringQuery(myPS); 
		String[] results = query.executeQueries();
		
		assert(results == null);
	}
	
	/*
	 * Test that the StringQuery class can actually return 
	 * the correct results
	 */
	@Test
	public void test2() {
		CheckPoint.reset();
		DiskSpace.reset();
		Field f = new Field("test", "other_test");
		Indexer I = new Indexer("my_file.txt");
		I.addField(f);
		
		String equation = "Search (equals (test, other_test))";
		
		ParsedString myPS = StringParserUtility.parse(equation);
		
		StringQuery query = new StringQuery(myPS);
		String[] results = query.executeQueries();
		assert(results[0].equals("my_file.txt"));
	}
}
