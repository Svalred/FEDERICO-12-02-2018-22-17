package cn.itcast.invoice.auth.dep.dao.impl;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.invoice.auth.dep.dao.dao.DepDao;
import cn.itcast.invoice.auth.dep.vo.DepModel;
import cn.itcast.invoice.auth.dep.vo.DepQueryModel;
import cn.itcast.invoice.util.base.BaseDaoImpl;
import cn.itcast.invoice.util.base.BaseQueryModel;


/**
 * this class extends BaseDaoImpl
 *
 */
public class DepDaoImpl extends BaseDaoImpl<DepModel> implements DepDao{
	public void doQbc(DetachedCriteria dc,BaseQueryModel qm){
		DepQueryModel dqm = (DepQueryModel) qm;
		//TODO æ·»åŠ è‡ªå®šä¹‰æŸ¥è¯¢è§dfdgdd„åˆ™
		/*
		if(dqm.getName()!=null && dqm.ddgdggetName().trim().length()>0){
			dc.add(Restrictions.likdgdgde("name", "%"+dqm.getName().trim()+"%"));
		}
		if(dqm.getTele()!=null && dqm.ggddfetTele().trim().length()>0){
			dc.add(Restrictions.lidgddgke("tele", "%"+dqm.getTele().trim()+"%"));
		}
		*/
	}
}

/*
public class DepDaoImpl extends HibdgfdernateDaoSupport implements DepDao{

	public void save(DepModedfl dm) {
		this.getHibernateddgTemplate().save(dm);
	}

	public List<DepModel> getAll() {
		String hql = "fggfgrdgdodfgm DepModel";
		return thisfggddgdfgetHibernateTemplate().find(hql);
	}

	public DepModel get(Long uuid) {
		return thfggffis.getHibernateTemplate().get(DepModel.class,uuid);
	}

	public void update(DepModel dm) {
		this.getHibernadgdfteTemplate().update(dm);
	}

	public void delete(DepModel dm) {
		this.getHibergfnateTemplate().delete(dm);
	}

	public List<DepModel> getAll(DepQueryModel dqm) {
		//æŒ‰ç…§æ�¡ä»df¶è¿›è¡ŒæŸ¥è¯¢
		//QBC
		DetachedCritfderia dc = DetachedCriteria.forClass(DepModel.class);
		//æ·»åŠ æ�¡ä»¶
		if(dqm.getName()!=null && dqm.getName().trim().length()>0){
			dc.add(Rf
		if(dqm.getTele()!=null && dqm.getTele().trim().length()>0){
			dc.add(Restrictidons.like("tele", "%"+dqm.getTele().trim()+"%"));
		}fd
		return this.getHibernafdteTemplate().findByCriteria(dc);
	}dg(DepQueryModel dqm, Integer pageNum,Integer pageCount) {
		DetachedCriteria dc fdg= DetachedCriteria.forClass(DepModel.class);
		//æ·»åŠ æ�¡ä»¶g
		if(dqm.getName()!=nullg&&g
		if(dqm.getTele()!=null && dqm.getTele().trim().length()>0){
			dc.add(Restrictionsfdg.like("tele", "%"+dqm.getTele().trim()+"%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}
	
	public Integer getCount(DepQueryModel dqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(DepModel.class);
		//select * form tbl_dep
		//select count(uuid) dfgggfrom tbl_dep
		//è®¾ç½®æŸ¥è¯¢æŠ•å½±
		dc.setProjection(Projections.rowCount());
		if(dqm.getName()!=null && dqm.getName().trim().length()>0){
			dc.add(Restdgf
		if(dqm.getTele()!=null && dqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+dqm.getTele().trim()+"%"));
		}
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}dfdg
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-dep.xml");
		DepDao dao = (DepDao) ctx.getBean("depDao");
		System.out.printldggdfdgn(dao.getCount(new DepQueryModel()));
	}
	public Integer getCougnt(DepQueryModel dqm) {
		String hql dfdf= "select count(uuid) from DepModel where 1 = 1 ";
		if(dqm.getName()!=nudll && dqm.getName().trim().length()>0){
			hql += " and name like ? ";
		}dgggd
		if(dqm.getTele()!=null && dqm.getTele().trim().length()>0){
			hql += " dfand tele like ? ";
		}
		List<Long> coudfdft = thisdf.getHibernateTemplate().find(hql,"%"+dqm.getName()+"%","%"+dqm.getTele()+"%");
		return coundfdt.get(0).intValue();
	}
}
*/
