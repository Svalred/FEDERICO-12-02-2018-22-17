package cn.itcast.invoice.util.base;

import java.io.Serializable;
import java.util.List;
/**
 * this interface is the base for all the Daos classes of the project
 *
 */
public interface BaseDao<T> {
	public void save(T t);
	
	public void update(T t);

	public void delete(T t);
	
	public T get(Serializable uuid);
	
	public List<T> getAll();

	public List<T> getAll(BaseQueryModel qm, Integer pageNum,Integer pageCount);

	public Integer getCount(BaseQueryModel qm);
}
