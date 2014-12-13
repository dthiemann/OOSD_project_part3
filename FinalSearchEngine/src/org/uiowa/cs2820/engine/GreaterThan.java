public class GreaterThan {
	Field target;
	Database D;
	public GreaterThan(Field f) { 
		D = new LinearDiskDatabase();
		target = f; 
					}
	public String[] find() {
		String [] R = D.fetchOther(target);
		if (R == null) R = new String[0];
				return R;
					}
		}
	public Object GetNodes(){
		ArrayList<Nodes> A = SearchGreaterThan.GetList();
		List<Nodes> B =A;
		//**Iterator<node> iterator = B.iterator();
		return B;	
			
	}
	
}
