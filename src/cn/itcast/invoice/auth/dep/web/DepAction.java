package cn.itcast.invoice.auth.dep.web;

import java.util.List;

import cn.itcast.invoice.auth.dep.business.ebi.DepEbi;
import cn.itcast.invoice.auth.dep.vo.DepModel;
import cn.itcast.invoice.auth.dep.vo.DepQueryModel;
import cn.itcast.invoice.util.base.BaseAction;


/**
 * this interface extends BaseAction
 *
 */

public class DepAction extends BaseAction{

	/**
	 * public field 
	 */
	public DepModel dm = new DepModel();
	/**
	 * public field 
	 */
	public DepQueryModel dqm = new DepQueryModel();
	
	private DepEbi depEbi;
	/**
	 * public field 
	 */
	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}
	
	/**
	 * public field 
	 */
	public String list(){
		setDataTotal(depEbi.getCount(dqm));
		List<DepModel> depList = depEbi.getAll(dqm,pageNum,pageCount);
		put("depList",depList);
		return LIST;
	}
	
	/**
	 * public field
	 */
	public String save(){
		if(dm.getUuid()== null){ 
			depEbi.save(dm);
		}else{				
			depEbi.update(dm);
		}
		return TO_LIST;
	}
	
	/**
	 * public field
	 */
	public String input(){
		if(dm.getUuid()!=null){
			dm = depEbi.get(dm.getUuid());
		}
		return INPUT;
	}
	
	/**
	 * public field
	 */
	public String delete(){
		depEbi.delete(dm);
		return TO_LIST;
	}
	
}

