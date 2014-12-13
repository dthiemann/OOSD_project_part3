package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

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
	
	/*
	 * Test that we can handle a larger string query
	 */
	@Test
	public void test3() {
		CheckPoint.reset();
		DiskSpace.reset();
		Indexer I1 = new Indexer("my_file1.txt");
		Indexer I2 = new Indexer("my_file2.txt");
		
		Field f0 = new Field("test", "other_test");
		Field f1 = new Field("test1", "other_test1");
		Field f2 = new Field("test2", "other_test2");
		Field f3 = new Field("test3", "other_test3");
		
		I1.addField(f0);
		I1.addField(f1);
		I2.addField(f2);
		I2.addField(f3);
		
		String equation = "Search (equals (test0, other_test0)) or (equals (test2,other_test2))";
		
		ParsedString myPS = StringParserUtility.parse(equation);
		StringQuery query = new StringQuery(myPS);
		String[] results = query.executeQueries();
		
		String[] testResults = new String[2];
		testResults[0] = "my_file1.txt";
		testResults[1] = "my_file2.txt";
		
		//System.out.println(results[0] + results[1]);
		assertEquals(results[0], "my_file2.txt");
	}
	
	
	
	
	
	
	
	
}
