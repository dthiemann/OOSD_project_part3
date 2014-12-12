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
			
		}
		
		return result;
	}
}
