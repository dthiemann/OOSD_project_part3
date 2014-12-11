package org.uiowa.cs2820.engine;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Dylan Thiemann
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
	public static ParsedString parse(String equation) {
		
		if (equation == null) { return null; }
		if (equation.equals("")) { return null; }
				
		int count_open = getCharCount(equation, '(');

		ArrayList<String> arguments = getQueryArguments(equation, count_open);
		
		/* Each query has 2 arguments */
		int numberOfQueries = arguments.size()/2;		
		ArrayList<String> combinators = getQueryCombinators(equation, numberOfQueries);
		for (int i = 0; i < combinators.size(); i++) {
			/* check for proper combinators */
			if (!combinators.get(i).equals("and") && !combinators.get(i).equals("or")) {
				return null;
			}
		}
		
		ParsedString newPS = new ParsedString(arguments, combinators);
		return newPS;
	}
	
	/*
	 * Finds the number of characters 
	 */
	public static int getCharCount(String my_string, char my_char) {
		int count = 0;
		
		for (int i = 0; i < my_string.length(); i++) {
			if (my_string.charAt(i) == my_char) {
				count++;
			}
		}
		return count;
	}
	
	/*
	 * Checks to see if the number of parentheses lines up
	 */
	public static boolean checkParenCount(String equation) {
		if (getCharCount(equation, '(') == getCharCount(equation,')')){
			return true;
		}
		return false;
	}
	
	/*
	 * Extracts the combinators (AND OR)
	 */
	public static ArrayList<String> getQueryCombinators(String equation, int numberOfQueries) {
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
					
					while(wordIndex < equation.length() && equation.charAt(wordIndex) != '(') {
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
	public static ArrayList<String> getQueryArguments(String equation, int parenCount) {
		ArrayList<String> my_equation = new ArrayList<String>();
		
		int running_count = parenCount;
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
	
	/*
	 * Returns the operation (Should always be "Search")
	 */
	public static String getOperation(String equation) {
		String []operatorSplit = equation.split(" ");
		
		if (!operatorSplit[0].equals("Search")) {
			return null;
		}
		
		return operatorSplit[0];
	}
	
	/*
	 * Calculates the number of queries given the string
	 */
	public static int getNumberOfQueries(String equation) {
		
		ArrayList<String> arguments = getQueryArguments(equation, getCharCount(equation, '('));
		int numberOfQueries = arguments.size()/2;
		
		return numberOfQueries;
	}
}
