package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class Contains {
	Field target;
	Database D;
	public Contains(Field f) { 
		D = new LinearDiskDatabase();
		target = f; 
				}
	public String[] find() {
		String [] R = D.fetchContains(target);
		if (R == null) R = new String[0];
			return R;
				}
	/*
	* Returns an ArrayList containing fields that had the same value as the Field target
	*/
	public ArrayList<String> GetFields(){
		ArrayList<String> A = SearchContains.GetClst();
		return A;
	}
}
