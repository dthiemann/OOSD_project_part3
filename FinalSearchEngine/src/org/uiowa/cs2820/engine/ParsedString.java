package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class ParsedString {
	int numberOfQueries;
	ArrayList<String> arguments;
	ArrayList<String> operators;
	
	public ParsedString(ArrayList<String> args, ArrayList<String> ops) {
		this.numberOfQueries = args.size()/2;
		this.arguments = args;
		this.operators = ops;
	}
	
	public int getNumberOfQueries() {
		return this.numberOfQueries;
	}
	
	public ArrayList<String> getArguments() {
		return this.arguments;
	}
	
	public ArrayList<String> getOperators() {
		return this.operators;
	}
}
