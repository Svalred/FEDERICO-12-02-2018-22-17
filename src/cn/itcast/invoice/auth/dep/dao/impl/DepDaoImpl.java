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
	
	}
}
