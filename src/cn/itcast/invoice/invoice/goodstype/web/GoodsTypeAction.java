package cn.itcast.invoice.invoice.goodstype.web;

import java.util.List;

import cn.itcast.invoice.invoice.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.invoice.invoice.goodstype.vo.GoodsTypeModel;
import cn.itcast.invoice.invoice.goodstype.vo.GoodsTypeQueryModel;
import cn.itcast.invoice.invoice.supplier.business.ebi.SupplierEbi;
import cn.itcast.invoice.invoice.supplier.vo.SupplierModel;
import cn.itcast.invoice.util.base.BaseAction;
/**
 * this class extends BaseAction
 *
 */
public class GoodsTypeAction extends BaseAction{
	/**
	 * this public element is a public element
	 *
	 */
	public GoodsTypeModel gm = new GoodsTypeModel();
	/**
	 * this public element is a public element
	 *
	 */
	public GoodsTypeQueryModel gqm = new GoodsTypeQueryModel();

	/**
	 * this public element is a public element
	 *
	 */
	private GoodsTypeEbi goodsTypeEbi;
	/**
	 * this public element is a public element
	 *
	 */
	private SupplierEbi supplierEbi;
	
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
	public void setGoodsTypeEbi(GoodsTypeEbi goodsTypeEbi) {
		this.goodsTypeEbi = goodsTypeEbi;
	}

	
	/**
	 * this public element is a public element
	 *
	 */
	public String list(){
		setDataTotal(goodsTypeEbi.getCount(gqm));
		List<GoodsTypeModel> goodsTypeList = goodsTypeEbi.getAll(gqm,pageNum,pageCount);
		put("goodsTypeList",goodsTypeList);
		return LIST;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String save(){
		if(gm.getUuid()== null){
			goodsTypeEbi.save(gm);
		}else{
			goodsTypeEbi.update(gm);
		}
		return TO_LIST;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String input(){
		List<SupplierModel> supplierList = supplierEbi.getAll();
		put("supplierList",supplierList);
		if(gm.getUuid()!=null){
			gm = goodsTypeEbi.get(gm.getUuid());
		}
		return INPUT;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String delete(){
		goodsTypeEbi.delete(gm);
		return TO_LIST;
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public Long supplierUuid;
	
	private List<GoodsTypeModel> gtmList;
	/**
	 * this public element is a public element
	 *
	 */
	public List<GoodsTypeModel> getGtmList(){
		return gtmList;
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public String ajaxGetGtmBySupplier(){
		gtmList = goodsTypeEbi.getAllBySupplier(supplierUuid);
		return "ajaxGetGtmBySupplier";
	}
}
