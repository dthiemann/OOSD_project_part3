package org.uiowa.cs2820.engine;

import java.util.ArrayList;

/**
 * 
 * @author Dylan Thiemann
 *
 *	Class used for creating queries. A ParsedString object
 *	is returned by StringParserUtility to a calling function
 *	which will construct the appropriate fields
 *
 */
public class ParsedString {
	int numberOfQueries;
	ArrayList<String> arguments;
	ArrayList<String> combinators;
	
	/* 
	 * This class allows the user to easily gain access to all the 
	 * necessary information for constructing a query around a 
	 * natural string
	 */
	public ParsedString(ArrayList<String> args, ArrayList<String> ops) {
		this.numberOfQueries = args.size()/2;
		this.arguments = args;
		this.combinators = ops;
	}
	
	/*
	 * Create field objects from the ParsedString object
	 */
	public Field[] getFields() {
		Field[] parsedFields = new Field[this.numberOfQueries];
		
		/* Create a new field object for each query we have */
		for (int i = 0; i < this.numberOfQueries; i++) {
			/* extract the arguments from our arguments array */
			String[] args = this.arguments.get(2*i + 1).split(",");
			Field temp = new Field(args[0], args[1]);
			parsedFields[0] = temp;
		}
		
		return parsedFields;
	}
	
	/*
	 * Extracts the operators for each key 
	 */
	public String[] getOperators() {
		String[] ops = new String[this.numberOfQueries];
		
		for (int i = 0; i < this.numberOfQueries; i++) {
			/* extract the arguments from our arguments array */
			ops[i] = this.arguments.get(2*i);
		}
		
		return ops;
	}
	
	/*
	 * Get the number of queries
	 */
	public int getNumberOfQueries() {
		return this.numberOfQueries;
	}
	
	/*
	 * Get the arguments list
	 */
	public ArrayList<String> getArguments() {
		return this.arguments;
	}
	
	/*
	 * Get the operators list
	 */
	public ArrayList<String> getCombinators() {
		return this.combinators;
	}
	
	/*
	 * Tests if two ParsedStrings are equal
	 */
	public boolean equals(ParsedString ps) {
		
		if(!this.arguments.equals(ps.arguments)) { return false; }
		if(!this.combinators.equals(ps.combinators)) { return false; }
		if(this.numberOfQueries != ps.numberOfQueries) { return false; }
		
		return true;
	}
}
