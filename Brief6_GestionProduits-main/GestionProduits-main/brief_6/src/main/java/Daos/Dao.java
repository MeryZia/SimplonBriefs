package Daos;



public interface Dao <T> {
	
 
	public void add(T item ); 
	
	public void edit(T item);
	
	public void delete(T item);
	
	public void listAll(T item);
	
	public void ListProductByCategory(int idc);
	
	
}
