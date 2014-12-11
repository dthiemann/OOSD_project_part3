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
	ArrayList<String> operators;
	
	/* 
	 * This class allows the user to easily gain access to all the 
	 * necessary information for constructing a query around a 
	 * natural string
	 */
	public ParsedString(ArrayList<String> args, ArrayList<String> ops) {
		this.numberOfQueries = args.size()/2;
		this.arguments = args;
		this.operators = ops;
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
	public ArrayList<String> getOperators() {
		return this.operators;
	}
}
