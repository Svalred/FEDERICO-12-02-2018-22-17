package cn.itcast.invoice.invoice.store.web;

import java.util.List;

import cn.itcast.invoice.auth.emp.business.ebi.EmpEbi;
import cn.itcast.invoice.auth.emp.vo.EmpModel;
import cn.itcast.invoice.invoice.order.vo.OrderDetailModel;
import cn.itcast.invoice.invoice.order.vo.OrderModel;
import cn.itcast.invoice.invoice.store.business.ebi.StoreEbi;
import cn.itcast.invoice.invoice.store.vo.StoreModel;
import cn.itcast.invoice.invoice.store.vo.StoreQueryModel;
import cn.itcast.invoice.util.base.BaseAction;
import cn.itcast.invoice.util.exception.AppException;
/**
 * this class extends BaseAction
 *
 */
public class StoreAction extends BaseAction{
	public StoreModel sm = new StoreModel();
	public StoreQueryModel sqm = new StoreQueryModel();
	
	private StoreEbi storeEbi;
	private EmpEbi empEbi;
	
	public void setEmpEbi(EmpEbi empEbi) {
		this.empEbi = empEbi;
	}

	public void setStoreEbi(StoreEbi storeEbi) {
		this.storeEbi = storeEbi;
	}

	//è·³è½¬åˆ°åˆ—è¡¨é¡µé�¢
	public String list(){
		setDataTotal(storeEbi.getCount(sqm));
		List<StoreModel> storeList = storeEbi.getAll(sqm,pageNum,pageCount);
		put("storeList",storeList);
		return LIST;
	}

	//ä¿�å­˜/ä¿®æ”¹
	public String save(){
		if(sm.getUuid()== null){
			storeEbi.save(sm);
		}else{
			storeEbi.update(sm);
		}
		return TO_LIST;
	}

	//è·³è½¬åˆ°æ·»åŠ /ä¿®æ”¹é¡µé�¢
	public String input(){
		List<EmpModel> empList = empEbi.getAll();
		put("empList",empList);
		if(sm.getUuid()!=null){
			sm = storeEbi.get(sm.getUuid());
		}
		return INPUT;
	}

	//åˆ é™¤
	public String delete(){
		storeEbi.delete(sm);
		return TO_LIST;
	}
	
	public Long goodsUuid;
	public Integer num;
	public Long storeUuid;
	public Long odmUuid;
	private OrderDetailModel odm;
	public OrderDetailModel getOdm() {
		return odm;
	}
	private boolean has;
	public boolean isHas() {
		return has;
	}
	private boolean msg;
	public boolean isMsg() {
		return msg;
	}

	public String ajaxInGoods(){
		try {
			odm = storeEbi.inGoods(odmUuid,goodsUuid,storeUuid,num,getLogin());
		} catch (AppException e) {
			if(e.getMessage().equals("aa")){
				msg = true;
				return "ajaxInGoods";
			}
		}
		
		OrderModel om = odm.getOm();
		int sum = 0;
		for(OrderDetailModel temp:om.getOdms()){
			sum += temp.getSurplus();
		}
		has = sum == 0;
		return "ajaxInGoods";
	}
}
