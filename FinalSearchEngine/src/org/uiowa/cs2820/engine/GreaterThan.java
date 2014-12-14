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
	public Object GetNodes(){
		ArrayList<String> A = SearchGreaterThan.GetList();
			return A;
		}
	
}
