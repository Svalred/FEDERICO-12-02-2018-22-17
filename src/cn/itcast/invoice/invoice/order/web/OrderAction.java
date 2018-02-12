package cn.itcast.invoice.invoice.order.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.itcast.invoice.auth.emp.business.ebi.EmpEbi;
import cn.itcast.invoice.auth.emp.vo.EmpModel;
import cn.itcast.invoice.invoice.goods.business.ebi.GoodsEbi;
import cn.itcast.invoice.invoice.goods.vo.GoodsModel;
import cn.itcast.invoice.invoice.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.invoice.invoice.goodstype.vo.GoodsTypeModel;
import cn.itcast.invoice.invoice.order.business.ebi.OrderDetailEbi;
import cn.itcast.invoice.invoice.order.business.ebi.OrderEbi;
import cn.itcast.invoice.invoice.order.vo.OrderDetailModel;
import cn.itcast.invoice.invoice.order.vo.OrderModel;
import cn.itcast.invoice.invoice.order.vo.OrderQueryModel;
import cn.itcast.invoice.invoice.store.business.ebi.StoreEbi;
import cn.itcast.invoice.invoice.store.vo.StoreModel;
import cn.itcast.invoice.invoice.supplier.business.ebi.SupplierEbi;
import cn.itcast.invoice.invoice.supplier.vo.SupplierModel;
import cn.itcast.invoice.util.base.BaseAction;
/**
 * this class extends BaseAction
 *
 */
public class OrderAction extends BaseAction{
	/**
	 * this public element is a public element
	 *
	 */
	public OrderModel om = new OrderModel();
	/**
	 * this public element is a public element
	 *
	 */
	public OrderQueryModel oqm = new OrderQueryModel();

	private OrderEbi orderEbi;
	private SupplierEbi supplierEbi;
	private GoodsTypeEbi goodsTypeEbi;
	private GoodsEbi goodsEbi;
	private EmpEbi empEbi;
	private StoreEbi storeEbi;
	private OrderDetailEbi orderDetailEbi;
	
	/**
	 * this public element is a public element
	 *
	 */
	public void setOrderDetailEbi(OrderDetailEbi orderDetailEbi) {
		this.orderDetailEbi = orderDetailEbi;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void setStoreEbi(StoreEbi storeEbi) {
		this.storeEbi = storeEbi;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void setEmpEbi(EmpEbi empEbi) {
		this.empEbi = empEbi;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void setGoodsEbi(GoodsEbi goodsEbi) {
		this.goodsEbi = goodsEbi;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void setGoodsTypeEbi(GoodsTypeEbi goodsTypeEbi) {
		this.goodsTypeEbi = goodsTypeEbi;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void setSupplierEbi(SupplierEbi supplierEbi) {
		this.supplierEbi = supplierEbi;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void setOrderEbi(OrderEbi orderEbi) {
		this.orderEbi = orderEbi;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String list(){
		setDataTotal(orderEbi.getCount(oqm));
		List<OrderModel> orderList = orderEbi.getAll(oqm,pageNum,pageCount);
		put("orderList",orderList);
		return LIST;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String save(){
		if(om.getUuid()== null){
			orderEbi.save(om);
		}else{
			orderEbi.update(om);
		}
		return TO_LIST;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String input(){
		if(om.getUuid()!=null){
			om = orderEbi.get(om.getUuid());
		}
		return INPUT;
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public String buyInput(){
		List<SupplierModel> supplierList = supplierEbi.getAll();
			
		int flag=0;
		for(int i = supplierList.size()-1;i>=0;i--){
			flag=0;
			SupplierModel sm = supplierList.get(i);
			List<GoodsTypeModel> gtms = goodsTypeEbi.getAllBySupplier(sm.getUuid());
			for(int j = gtms.size()-1;j>=0;j--){
				GoodsTypeModel gtm = gtms.get(j);
				if(gtm.getGms().size() > 0){
					flag=1;
					continue;
				}
			}
			if(flag==1) {
				continue;
		    }else supplierList.remove(i);
		}

		List<GoodsTypeModel> gtmList = goodsTypeEbi.getAllUnionBySupplier(supplierList.get(0).getUuid());
		List<GoodsModel> gmList = goodsEbi.getAllByGtmUuid(gtmList.get(0).getUuid());
		put("supplierList",supplierList);
		put("gtmList",gtmList);
		put("gmList",gmList);
		return "buyInput";
	}
	

	/**
	 * this public element is a public element
	 *
	 */
	public String delete(){
		orderEbi.delete(om);
		return TO_LIST;
	}
	
	/**
	 * this public elfgjhement is a public element
	 *
	 */
	public Long supplierUuid;
	/**
	 * this public element is a public element
	 *
	 */
	public Long goodsTypeUuid;
	/**
	 * this public element is a public element
	 *
	 */
	public Long goodsUuid;
	/**
	 * this public element is a public element
	 *
	 */
	public String used;
	/**
	 * this public element is a public element
	 *
	 */
	
	private List<GoodsTypeModel> gtmList;
	private List<GoodsModel> gmList;
	private GoodsModel gm;
	
	/**
	 * this public element is a public element
	 *
	 */
	public GoodsModel getGm() {
		return gm;
	}
	/**
	 * this public element is a public element
	 *
	 */
	public List<GoodsTypeModel> getGtmList() {
		return gtmList;
	}
	/**
	 * this public element is a public element
	 *
	 */
	public List<GoodsModel> getGmList() {
		return gmList;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String ajaxGetGtmAndGm(){
		gtmList = goodsTypeEbi.getAllUnionBySupplier(supplierUuid);
		gmList = goodsEbi.getAllByGtmUuid(gtmList.get(0).getUuid());
		gm = gmList.get(0);
		return "ajaxGetGtmAndGm";
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public String ajaxGetGtmAndGm2(){
		String[] uuidsArr = used.split(",");
		Set<Long> uuids = new HashSet<Long>();
		for(String uuidStr:uuidsArr){
			uuids.add(new Long(uuidStr));
		}
		gtmList = goodsTypeEbi.getAllUnionBySupplier(supplierUuid);
		int flag=0;
		for(int i = gtmList.size()-1;i>=0;i--){
			flag = 0;
			GoodsTypeModel gtm = gtmList.get(i);
			gmList = goodsEbi.getAllByGtmUuid(gtm.getUuid());
			for(GoodsModel temp:gmList){
				if(!uuids.contains(temp.getUuid())){
					flag = 1;
					continue;
				}
			}
			if(flag ==1){
				continue;
			} else gtmList.remove(i);
		}

		
		gmList = goodsEbi.getAllByGtmUuid(gtmList.get(0).getUuid());
		for(int i = gmList.size()-1;i>=0;i--){
			GoodsModel gm = gmList.get(i);
			if(uuids.contains(gm.getUuid())){
				gmList.remove(i);
			}
		}
		
		gm = gmList.get(0);
		return "ajaxGetGtmAndGm";
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public String ajaxGetGm(){
		gmList = goodsEbi.getAllByGtmUuid(goodsTypeUuid);
		gm = gmList.get(0);
		return "ajaxGetGm";
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public String ajaxGetOne(){
		gm = goodsEbi.get(goodsUuid);
		return "ajaxGetOne";
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public Long[] goodsUuids;
	/**
	 * this public element is a public element
	 *
	 */
	public Integer[] nums;
	/**
	 * this public element is a public element
	 *
	 */
	public Double[] prices;
	
	/**
	 * this public element is a public element
	 *
	 */
	public String buyOrder(){
			orderEbi.save(getLogin(),om,goodsUuids,nums,prices);
		return TO_LIST;
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public String buyDetailList(){
		om = orderEbi.get(om.getUuid());
		return "buyDetailList";
	}
	
	/**
	 * 
	 * @param check insert 0 to get buyCheck, 1 to get toBuyCheckDetail, 2 to get buyCheckPass, 3 to get buyCheckNoPass
	 * @return a string with the desidered value
	 */
	public String Check(int check){
		String toReturn = null;
		if (check==0) {
		setDataTotal(orderEbi.getCountByTypes(oqm));
		List<OrderModel> orderList = orderEbi.getAllNoCheckOrder(oqm,pageNum,pageCount);
		put("orderList",orderList);
		toReturn= "buyCheck";
		}
		else if (check==1) {
			om = orderEbi.get(om.getUuid());
			toReturn = "toBuyCheckDetail";
		}
		else if (check==2) {
			orderEbi.buyCheckPass(om.getUuid(),getLogin());
			toReturn = "toBuyCheck";
		}
		else if (check==3) {
			orderEbi.buyCheckNoPass(om.getUuid(),getLogin());
			toReturn = "toBuyCheck";
		}
		else {
			toReturn = "The Value is not correct, please read documentation!";
		}
		return toReturn;
	}

	/**
	 * 
	 * @param check insert 0 to get assignTask, 1 to get assignTaskList, 2 to get assignTaskDetail
	 * @return a string with the desidered value
	 */
	public String assignTask(int check){
		String toReturn = null;
		if (check==0) {
		orderEbi.assignTask(om);
		toReturn = "toAssignTaskList";
		} else
		if (check ==1) {
			List<OrderModel> orderList = orderEbi.getAllTasks(oqm,pageNum,pageCount);
			put("orderList",orderList);
			return "assignTaskList";
		}
		else if (check ==2) {
			Long depUuid = getLogin().getDm().getUuid();
			List<EmpModel> empList = empEbi.getAllByDep(depUuid);
			put("empList",empList);
			om = orderEbi.get(om.getUuid());
			return "assignTaskDetail";
		}
		else {
			toReturn = "The Value is not correct, please read documentation!";
		}
		return toReturn;
	}
	/**
	 * this public element is a public element
	 *
	 */
	
	public String queryTask(){
		List<OrderModel> orderList = orderEbi.getAllByCompleter(oqm,pageNum,pageCount,getLogin());
		put("orderList",orderList);
		return "queryTask";
	}
	/**
	 * this public element is a public element
	 *
	 */
	
	public String toTaskDetail(){
		om = orderEbi.get(om.getUuid());
		return "toTaskDetail";
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public String completeTask(){
		orderEbi.endTask(om.getUuid());
		return "toQueryTask";
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public String inGoodsList(){
		List<OrderModel> orderList = orderEbi.getAllNotIn(oqm,pageNum,pageCount);
		put("orderList",orderList);
		return "inGoodsList";
	}
	/**
	 * this public element is a public element
	 *
	 */
	public String inGoodsDetail(){
		List<StoreModel> storeList = storeEbi.getAll();
		put("storeList",storeList);
		om = orderEbi.get(om.getUuid());
		return "inGoodsDetail";
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public Long odmUuid;
	private OrderDetailModel odm;
	
	/**
	 * this public element is a public element
	 *
	 */
	public OrderDetailModel getOdm() {
		return odm;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String ajaxGetSurplusByOdmUuid(){
		//ÃƒÂ¦Ã‚Â Ã‚Â¹ÃƒÂ¦Ãdgjhdfgj¯Â¿Â½Ã‚Â®odmUuidÃƒÂ¨Ã…Â½Ã‚Â·ÃƒÂ¥Ã¯Â¿Â½Ã¢â‚¬â€œÃƒÂ¥Ã‚Â¯Ã‚Â¹ÃƒÂ¥Ã‚ÂºÃ¢â‚¬ï¿½ÃƒÂ§Ã…Â¡Ã¢â‚¬Å¾ÃƒÂ¨Ã‚Â´Ã‚Â§ÃƒÂ§Ã¢â‚¬Â°Ã‚Â©ÃƒÂ¥Ã¢â‚¬Â°Ã‚Â©ÃƒÂ¤Ã‚Â½Ã¢â€žÂ¢ÃƒÂ¦Ã¢â‚¬Â¢Ã‚Â°ÃƒÂ©Ã¢â‚¬Â¡Ã¯Â¿Â½
		odm = orderDetailEbi.get(odmUuid);
		return "ajaxGetSurplusByOdmUuid";
	}
}
