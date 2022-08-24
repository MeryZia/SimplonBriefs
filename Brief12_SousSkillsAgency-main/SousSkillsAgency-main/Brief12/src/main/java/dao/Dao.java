package dao;

import java.util.List;

public interface Dao <T> {

	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(Long id);
	
	public List<T> listAll();
	
	public T listOne(Long id);
}
