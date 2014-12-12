package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class StringQuery {
	private ParsedString ps;
	
	public StringQuery(ParsedString myPS) {
		this.ps = myPS;
	}
	
	/*
	 * Executes teh query on the given parsed string
	 */
	public String[] executeQueries() {
		String[] result = null;
		ArrayList<String> tempResults = new ArrayList<String>();
		
		Field[] fields = this.ps.getFields();
		String[] operators = this.ps.getOperators();
		
		for (int i = 0; i < this.ps.numberOfQueries; i++) {
			boolean isAnd = false;
			String op = operators[i];
			if (op.equals("and")) {
				isAnd = true; 
			}
			
			Field field = fields[i];
			/* For individual results */
			String[] temp = null;
			
			/* Determine which kind of search to conduct */
			if (op.equals("prefix")) {
				
			}
			else if (op.equals("suffix")) {
				
			}
			else if (op.equals("equals")) {
				
			}
			else if (op.equals("greater than")) {
				
			}
			else if (op.equals("less than")) {
				
			}
			
			/* Compile the results */
			
			/* If not the first set */
			if (i != 0) {
				ArrayList<String> newRes = new ArrayList<String>();
				for (int j = 0; j < temp.length; j++) {
					/* perform a logical AND on our results */
					if (isAnd) {
						if(tempResults.contains(temp[i])) {
							newRes.add(temp[i]);
						}
					} 
					/* Perform a logical OR on our results */
					else {
						if (!tempResults.contains(temp[i])) {
							newRes.add(temp[i]);
						}
					}
				}
				/* Update our storage structure */
				if (isAnd) { tempResults = newRes; }
				else { 
					for (String e : newRes) {
						tempResults.add(e);
					}
				}
			} 
			/* First element */
			else {
				for (int j = 0; j < temp.length; j++) {
					tempResults.add(temp[j]);
				}
			}
		}
		
		return result;
	}
}
