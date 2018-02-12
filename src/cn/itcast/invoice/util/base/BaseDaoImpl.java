package cn.itcast.invoice.util.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * this Abstract class is the base for the DaoImpl classes and extends HibernateDaoSupport
 *
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport{
	//Ã¥Â½â€œÃ¥â€°ï¿½Ã§Â±Â»sdsdfdsfdsÃ¤Â¸Â­Ã¦Â³â€ºÃ¥Å¾â€¹Ã§Å¡â€žÃ§Â±Â»Ã¥Å¾â€¹
	private Class<T> entityClass;
	
	//Ã¤Â½â€¢Ã¦â€”Â¶Ã¥Ë†ï¿½dfsdfsdsffsddsfsdfsdfsdfÃ¥Â§â€¹Ã¥Å’â€“:Ã¥Â½â€œÃ¥â€°ï¿½Ã§Â±Â»Ã§Å¡â€žÃ¥Â¯Â¹Ã¨Â±Â¡Ã¥Ë†â€ºÃ¥Â»ÂºÃ¥Â®Å’Ã¦Â¯â€¢Ã¤Â¹â€¹Ã¥â€°ï¿½
	public BaseDaoImpl(){
		Class clazz = this.getClass();
		Type type = clazz.getGenericSuperclass();
		ParameterizedType pType =(ParameterizedType)type;
		Type[] types = pType.getActualTypeArguments(); 
		entityClass = (Class) types[0];
	}
	
	public void save(T t) {
		this.getHibernateTemplate().save(t);
		/*try {
		} catch (Excepdsfsdfsdfsdfsdfsdfw AppException("Ã¥Â¯Â¹Ã¤Â¸ï¿½Ã¨ÂµÂ·Ã¯Â¼Å’Ã¦â€¢Â°Ã¦ï¿½Â®Ã¥Âºâ€œÃ¦Å“ï¿½Ã¥Å Â¡Ã¥â„¢Â¨Ã¦Â²Â¡Ã¦Å“â€°Ã¥ï¿½Â¯Ã¥Å Â¨Ã¯Â¼Å’Ã¨Â¯Â·Ã¨ï¿½â€�Ã§Â³Â»Ã§Â®Â¡Ã§ï¿½â€ Ã¥â€˜ËœÃ¯Â¼ï¿½",e);
		}*/
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	public T get(Serializable uuid) {
		return this.getHibernateTemplate().get(entityClass,uuid);
	}
	
	public List<T> getAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		return this.getHibernateTemplate().findByCriteria(dc);
	}

	public List<T> getAll(BaseQueryModel qm, Integer pageNum,Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		doQbc(dc,qm);
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}
	
	public Integer getCount(BaseQueryModel qm) {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.setProjection(Projections.rowCount());
		doQbc(dc,qm);
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}
	
	//Ã¥Â¼ÂºÃ¥Ë†Â¶fsdsdfsdfdsfsdfÃ¥Â­ï¿½Ã§Â±Â»Ã¨Â¦â€ Ã§â€ºâ€“doQbcÃ¦â€“Â¹Ã¦Â³â€¢
	protected abstract void doQbc(DetachedCriteria dc,BaseQueryModel qm);
}
/*
public static void main(String[] args) {
	Applicationsdfsdfdsfdsfdsf (DepDao) ctx.getBean("depDao");
	System.out.println(dao.getCount(new DepQueryModel()));
}
*/
/*
public Integer getCount(DepQueryModel dqm) {
	String hql = "dsfsdand name like ? ";
	}sdfsdfdsfsdf
	List<Long> count = this.getHibernateTemplate().find(hql,"%"+dqm.getName()+"%","%"+dqm.getTele()+"%");
	return count.get(0fsdsdf.intValue();
}
*/
