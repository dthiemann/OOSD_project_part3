package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class StringQuery {
	private ParsedString ps;
	
	public StringQuery(ParsedString myPS) {
		this.ps = myPS;
	}
	
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
			
			/* Construct the results */
			for (int j = 0; j < temp.length; j++) {
				if ()
			}
		}
		
		return result;
	}
}
