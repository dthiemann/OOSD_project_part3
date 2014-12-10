package org.uiowa.cs2820.engine;

import java.util.ArrayList;

/**
 * 
 * @author dthiemann
 * 
 * This class is a utility that will parse a string into 
 * its sub-queries and then return the individual queries
 *
 */
public class StringParserUtility {
	public static void parse(String equation) {
		int count_open = getCharCount(equation, '(');
		int count_close = getCharCount(equation, ')');

		ArrayList<String> arguments = getQueryArguments(equation, count_open, count_close);
		
		int numberOfQueries = arguments.size()/3;
		
		ArrayList<String> combinators = getQueryCombinators(equation, numberOfQueries);

		for (int i = 0; i < arguments.size(); i++) {
			System.out.println(arguments.get(i));
		}
		
		for(int i = 0; i < combinators.size(); i++) {
			System.out.println(combinators.get(i));
		}
	}
}
