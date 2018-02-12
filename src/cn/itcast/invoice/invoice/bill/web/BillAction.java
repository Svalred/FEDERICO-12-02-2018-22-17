package cn.itcast.invoice.invoice.bill.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import cn.itcast.invoice.invoice.bill.business.ebi.BillEbi;
import cn.itcast.invoice.invoice.bill.vo.BillQueryModel;
import cn.itcast.invoice.invoice.order.vo.OrderDetailModel;
import cn.itcast.invoice.invoice.supplier.business.ebi.SupplierEbi;
import cn.itcast.invoice.invoice.supplier.vo.SupplierModel;
import cn.itcast.invoice.util.base.BaseAction;
import cn.itcast.invoice.util.format.FormatUtil;
/**
 * this class extends BaseAction
 *
 */
public class BillAction extends BaseAction{
	/**
	 * this public element is a public element
	 *
	 */
	public BillQueryModel bqm = new BillQueryModel();

	private BillEbi billEbi;
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
	public void setBillEbi(BillEbi billEbi) {
		this.billEbi = billEbi;
	}

	/**
	 * this public element is a public element
	 *
	 */
	public String buyBill(){
		
		List<Object[]> billList = billEbi.getBillByGoods(bqm);
		
		put("billList",billList);
		List<SupplierModel> supplierList = supplierEbi.getAll();
		put("supplierList",supplierList);
		return "buyBill";
	}
	private List<OrderDetailModel> odmList;
	/**
	 * this public element is a public element
	 *
	 */
	public List<OrderDetailModel> getOdmList() {
		return odmList;
	}
	/**
	 * this public element is a public element
	 *
	 */
	public String ajaxBillDetailByGoods(){
		odmList = billEbi.getBillDetailByGoods(bqm);
		return "ajaxBillDetailByGoods";
	}
	/**
	 * this public element is a public element
	 *
	 */
	public void billForPie() throws IOException{
		List<Object[]> billList = billEbi.getBillByGoods(bqm);
		OutputStream os = getResponse().getOutputStream();
		billEbi.getBillForPie(os,billList);
		os.flush();
	}
	private InputStream downloadExcel;
	
	public InputStream getDownloadExcel() {
		return downloadExcel;
	}
	private String xlsName;
	
	public String getXlsName() throws UnsupportedEncodingException {
		System.out.println(xlsName);
		return new String(xlsName.getBytes("UTF-8"),"ISO8859-1");
	}

	
	public String downloadExcelBill() throws Exception{
		xlsName = "Ã¨Â´Â§Ã§â€°Â©Ã§Â»Å¸Ã¨Â®Â¡Ã¦Å Â¥Ã¨Â¡Â¨Ã¯Â¼Â»"+FormatUtil.formatDate(System.currentTimeMillis())+"Ã¯Â¼Â½.xls";
		List<Object[]> billList = billEbi.getBillByGoods(bqm);
		downloadExcel = billEbi.getExcelBill(billList);
		return "downloadExcelBill";
	}
}
