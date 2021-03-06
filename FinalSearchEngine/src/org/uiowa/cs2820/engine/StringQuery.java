package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class StringQuery {
	private ParsedString ps;
	
	public StringQuery(ParsedString myPS) {
		this.ps = myPS;
	}
	
	/*
	 * Executes the query on the given parsed string
	 */
	public String[] executeQueries() {
		String[] result;
		ArrayList<String> tempResults = new ArrayList<String>();
		
		Field[] fields = this.ps.getFields();
		String[] operators = this.ps.getOperators();
		for (int i = 0; i < this.ps.numberOfQueries; i++) {
			boolean isAnd = false;
			String op = operators[i];
			
			if (this.ps.getCombinators() != null) {
				if (i != 0) {
					if (this.ps.getCombinators().get(i-1).equals("and")) {
						isAnd = true; 
					}
				}
			}
			
			Field field = fields[i];
			/* For individual results */
			String[] temp = null;
			

			if(field == null) { break; }
			
			/* Determine which kind of search to conduct */
			if (op.equals("prefix")) {
				/* Perform prefix search */
				FieldSearch fs= new FieldSearch(field);
				temp = fs.findPrefix();
			}
			else if (op.equals("suffix")) {
				/* Perform suffix search */
				FieldSearch fs= new FieldSearch(field);
				temp = fs.findSuffix();
			}
			else if (op.equals("equals")) {
				/* Perform equals search */
				FieldSearch fs = new FieldSearch(field);
				temp = fs.findEquals();
				//System.out.println(1);
			}
			else if (op.equals("greater than")) {
				/* Perform 'greater than' search */
				FieldSearch fs= new FieldSearch(field);
				temp = fs.findGreaterThan();
			}
			else if (op.equals("less than")) {
				/* Perform 'less than' search */
				FieldSearch fs= new FieldSearch(field);
				temp = fs.findLessThan();
			}
			
			/* Compile the results! */
			
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
		/* Convert tempResults into a normal array */
		result = new String[tempResults.size()];
		for (int i = 0; i < tempResults.size(); i++) {
			result[i] = tempResults.get(i);
		}
		
		/* Return the final compile results */
		return result;
	}
}
