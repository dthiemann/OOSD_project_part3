package org.uiowa.cs2820.engine;
import java.util.*;

public class LessThan {
	Field target;
	Database D;
	public LessThan(Field f) { 
		D = new LinearDiskDatabase();
		target = f; 
					}
	public String[] find() {
		String [] R = D.fetchLess(target);
		if (R == null) R = new String[0];
			return R;
				
					}
	/*
	* Returns an ArrayList containing values less than the given value
	*/
	public ArrayList<String> GetLlst(){
		ArrayList<String> A = SearchlessThan.GetLL();
			return A;
		}
	
}
