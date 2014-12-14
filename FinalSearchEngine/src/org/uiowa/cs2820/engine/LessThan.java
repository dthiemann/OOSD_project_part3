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
	public Object GetLlst(){
		ArrayList<String> A = SearchLessThan.GetLL();
			return A;
		}
	
}
