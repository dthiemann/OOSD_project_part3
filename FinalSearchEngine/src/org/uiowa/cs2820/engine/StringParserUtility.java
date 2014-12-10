package org.uiowa.cs2820.engine;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author dthiemann
 * 
 * This class is a utility that will parse a string into 
 * its sub-queries and then return the individual queries
 *
 */

/* 
 * The only function of the utility class that is public facing
 */
public class StringParserUtility {
	/*
	 * Only public function that is used to parse and execute a 
	 * query in the form of a string
	 */
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
	
	/*
	 * Finds the number of characters 
	 */
	private static int getCharCount(String my_string, char my_char) {
		int count = 0;
		
		for (int i = 0; i < my_string.length(); i++) {
			if (my_string.charAt(i) == my_char) {
				count++;
			}
		}
		return count;
	}
	
	/*
	 * Extracts the combinators (AND OR)
	 */
	private static ArrayList<String> getQueryCombinators(String equation, int numberOfQueries) {
		ArrayList<String> combinators = new ArrayList<String>();
		int closedParenPerQuery = 2;
		
		/* No combinators if we only have 1 query */
		if (numberOfQueries <= 1) {
			return null;
		}
		
		int wordIndex = 0;
		for (int i = 0; i < numberOfQueries-1; i++) {
			String combinator = "";
			int closedParenPassed = 0;
			while (wordIndex < equation.length()) {
				if (equation.charAt(wordIndex) == ')') {
					closedParenPassed++;
				}
				/* Start recording the string value */
				if (closedParenPassed == closedParenPerQuery) {
					wordIndex++;
					while(wordIndex >= equation.length() || equation.charAt(wordIndex) != '(') {
						if (equation.charAt(wordIndex) != ' ') {
							combinator += equation.charAt(wordIndex);
						}
						wordIndex++;
					}
					wordIndex++;
					combinators.add(combinator);
					break;
				}
				wordIndex++;
			}
		}
		
		return combinators;
	}
	
	/*
	 * Get the arguments for each query, in sequential order
	 */
	public static ArrayList<String> getQueryArguments(String equation, int open_count, int close_count) {
		ArrayList<String> my_equation = new ArrayList<String>();
		
		int running_count = open_count;
		while (running_count > 0) {
			int paren_count = 0;
			int i = 0;
			while(i < equation.length() ) {
				if (equation.charAt(i) == '(') {
					paren_count++;
				}
				if (paren_count == running_count) {
					i = i + 1;
					String expression = "";
					while ((equation.charAt(i) != ')') && (equation.charAt(i) != '(')) {
						expression = expression + equation.charAt(i);
						i = i + 1;
					}
					my_equation.add(expression);
					break;
				}
				i++;
			}
			running_count--;
		}
		Collections.reverse(my_equation);
		return my_equation;
	}
}
