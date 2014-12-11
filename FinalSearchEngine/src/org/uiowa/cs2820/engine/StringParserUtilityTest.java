package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.*;

public class StringParserUtilityTest {
	
	/*
	 * Test that the utility can handle a simple query
	 */
	@Test
	public void test1() {
		assertEquals(1,1);
	}
	
	/*
	 * Test that it sends the correct error when 
	 * the keyword Search is missing
	 */
	@Test
	public void test2() {
		String equation = "Search (prefix (Word,pre)) and (equals (Temperature,85)) or (suffix (anotherWord,friend))";
		String operation = StringParserUtility.getOperation(equation);
		
		assert(operation.equals("Search"));
	}
	
	/*
	 * Test that it sends the correct error when the
	 * parentheses don't match up
	 */
	@Test
	public void test3() {
		String equation = "Search (prefix (Word,pre)) and (equals (Temperature,85)) or (suffix (anotherWord,friend))";
		
		assert(StringParserUtility.checkParenCount(equation));
	}
	
	/*
	 * Test that it sends the correct error when there
	 * is an empty query
	 */
	@Test
	public void test4() {
		
	}
	
	/*
	 * Test that it parses the string correctly
	 */
	
	@Test
	public void test5() {
		
	}
	
	/*
	 * Test for proper handling of Null values
	 */
	
	@Test
	public void test6() {
		
	}
	
	
	
}
