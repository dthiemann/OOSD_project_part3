package org.uiowa.cs2820.engine;

import java.util.ArrayList;

import org.junit.*;

public class StringParserUtilityTest {
	
	/*
	 * Test that the utility can handle a simple query
	 */
	@Test
	public void test1() {
		String equation = "Search (prefix (Word,pre)) and (equals (Temperature,85)) or (suffix (anotherWord,friend))";
		
		/* Objects for testing */
		ArrayList<String> argsTest = new ArrayList<String>();
		ArrayList<String> opsTest = new ArrayList<String>();
		
		argsTest.add("prefix");
		argsTest.add("Word,pre");
		argsTest.add("equals");
		argsTest.add("Temperature,85");
		argsTest.add("suffix");
		argsTest.add("anotherWord,friend");
		
		opsTest.add("and");
		opsTest.add("or");
		
		ParsedString testPS = new ParsedString(argsTest, opsTest);
		
		/* Begin test */
		
		ParsedString newPS = StringParserUtility.parse(equation);
		
		/* Test equality between arguments and combinators */
		assert(testPS.arguments.equals(newPS.arguments));
		assert(testPS.combinators.equals(newPS.combinators));
		
		assert(testPS.equals(newPS));

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
		String equation = "";
		assert(StringParserUtility.parse(equation) == null);
	}
	
	/*
	 * Test that it parses the string correctly
	 */
	@Test
	public void test5() {
		String equation = "Search (prefix (Word,pre)) and (equals (Temperature,85)) or (suffix (anotherWord,friend))";
		ArrayList<String> argsTest = new ArrayList<String>();
		ArrayList<String> opsTest = new ArrayList<String>();
		
		argsTest.add("prefix");
		argsTest.add("Word,pre");
		argsTest.add("equals");
		argsTest.add("Temperature,85");
		argsTest.add("suffix");
		argsTest.add("anotherWord,friend");
		
		opsTest.add("and");
		opsTest.add("or");
		
		int numQueries = StringParserUtility.getNumberOfQueries(equation);
		ArrayList<String> args = StringParserUtility.getQueryArguments(equation, numQueries);
		int parenCount = StringParserUtility.getCharCount(equation, '(');
		ArrayList<String> ops = StringParserUtility.getQueryCombinators(equation, parenCount);
		
		for(int i = 0; i < args.size(); i++) {
			assert(args.get(i).equals(argsTest.get(i)));
		}
		
		for (int i = 0; i < ops.size(); i++) {
			assert(ops.get(i).equals(opsTest.get(i)));
		}
	}
	
	/*
	 * Test for proper handling of Null values
	 */
	@Test
	public void test6() {
		String equation = null;
		assert(StringParserUtility.parse(equation) == null);
	}
	
	
	
}
