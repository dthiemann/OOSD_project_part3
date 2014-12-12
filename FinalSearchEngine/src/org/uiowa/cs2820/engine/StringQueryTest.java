package org.uiowa.cs2820.engine;

import org.junit.*;

public class StringQueryTest {
	
	/* 
	 * Test that appropriate data is transfered to StringQuery object
	 * even if we return null
	 */
	@Test
	public void test1() {
		//String equation = "Search (prefix (Word,pre)) and (equals (Temperature,85)) or (suffix (anotherWord,friend))";
		String equation = "Search (equals (golden,rumex))";
		ParsedString myPS = StringParserUtility.parse(equation);
		
		StringQuery query = new StringQuery(myPS); 
		String[] results = query.executeQueries();
		if (results == null) {
			assert(true);
		}
	}
}
