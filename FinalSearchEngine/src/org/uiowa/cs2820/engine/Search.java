package org.uiowa.cs2820.engine;

public class Search {
	Field target;
	Database D;
	public Search(Field f) { 
		D = new LinearDiskDatabase();
		target = f; 
				}
	public String[] find() {
		String [] R = D.fetch(target);
		if (R == null) R = new String[0];
		return R;
				}
	@Override
	public void Search(Field f) {
		// TODO Auto-generated method stub
		
	}
	
}
