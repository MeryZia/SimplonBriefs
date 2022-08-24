package Classes;

public class Category {
	protected int idc ;
	protected String namec;
	
	
	public Category() {}
	

	public Category(String namec) {
	  	
	       this.namec=namec;
	    		   }
	public Category(int idc, String namec) {
       this.idc=idc;	
       this.namec=namec;
    		   }
	public Category(int idc) {
	       this.idc=idc;	
	    		   }
	
	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}
	public String getNamec() {
		return namec;
	}
	public void setNamec(String namec) {
		this.namec = namec;
	}
	
	@Override
	public String toString() {
		return "La catégorie:"+ idc + "| " + namec;
	}
}
