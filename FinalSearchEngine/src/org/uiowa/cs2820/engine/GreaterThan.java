package org.uiowa.cs2820.engine;
import java.util.*;

public class GreaterThan {
	Field target;
	Database D;
	public GreaterThan(Field f) { 
		D = new LinearDiskDatabase();
		target = f; 
					}
	public String[] find() {
		String [] R = D.fetchGreater(target);
		if (R == null) R = new String[0];
			return R;
				
					}
	/*
	* Returns an ArrayList containing values greater than the given value
	*/
	public ArrayList<String> GetNodes(){
		ArrayList<String> A = SearchGreaterThan.GetList();
			return A;
		}
	
}
