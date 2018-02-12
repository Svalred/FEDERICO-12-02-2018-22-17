package cn.itcast.invoice.invoice.order.business.ebo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.itcast.invoice.auth.emp.vo.EmpModel;
import cn.itcast.invoice.invoice.goods.vo.GoodsModel;
import cn.itcast.invoice.invoice.order.business.ebi.OrderEbi;
import cn.itcast.invoice.invoice.order.dao.dao.OrderDao;
import cn.itcast.invoice.invoice.order.vo.OrderDetailModel;
import cn.itcast.invoice.invoice.order.vo.OrderModel;
import cn.itcast.invoice.invoice.order.vo.OrderQueryModel;
import cn.itcast.invoice.util.base.BaseQueryModel;
import cn.itcast.invoice.util.exception.AppException;
import cn.itcast.invoice.util.format.MD5Utils;
/**
 * this class implements OrderEbi
 *
 */
public class OrderEbo implements OrderEbi{
	private OrderDao orderDao;
	/**
	 * this public element is a public element
	 *
	 */
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	/**
	 * this public element is a public element
	 *
	 */
	
	public void save(OrderModel om) {
		orderDao.save(om);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void delete(OrderModel om) {
		orderDao.delete(om);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void update(OrderModel om) {
		orderDao.update(om);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public OrderModel get(Serializable uuid) {
		return orderDao.get(uuid);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public List<OrderModel> getAll() {
		return orderDao.getAll();
	}

	/**
	 * this public element is a public element
	 *
	 */
	public List<OrderModel> getAll(BaseQueryModel qm, Integer pageNum,Integer pageCount) {
		return orderDao.getAll(qm,pageNum,pageCount);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public Integer getCount(BaseQueryModel qm) {
		return orderDao.getCount(qm);
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public void save(EmpModel em,OrderModel om, Long[] goodsUuids, Integer[] nums,Double[] prices) {
		String orderNum = System.currentTimeMillis()+""+em.getUuid();
		om.setOrderNum(MD5Utils.sha256(orderNum));
		om.setOrderType(OrderModel.ORDER_ORDERTYPE_OF_BUY);
		om.setType(OrderModel.ORDER_TYPE_OF_BUY_NO_CHECK);
		om.setCreateTime(System.currentTimeMillis());
		om.setCreater(em);
		
		Integer totalNum = 0;
		Double totalPrice = 0.0d;
		OrderDetailModel odm = new OrderDetailModel();
		GoodsModel gm = new GoodsModel();
		Set<OrderDetailModel> odms = new HashSet<OrderDetailModel>();
		for(int i = 0;i<goodsUuids.length;i++){
			Long goodsUuid = goodsUuids[i];
			Integer num = nums[i];
			Double price = prices[i];
			
			totalNum+=num;
			totalPrice+=num*price;
			
			
			odm.setNum(num);
			odm.setSurplus(num);
			odm.setPrice(price);
			
			
			gm.setSegreto(goodsUuid);
			odm.setGm(gm);
			odm.setOm(om);
			odms.add(odm);
		}
		om.setOdms(odms);
		om.setTotalNum(totalNum);
		om.setTotalPrice(totalPrice);
		orderDao.save(om);
	}

	
	private Integer[] buyCheckTypes = {
			OrderModel.ORDER_TYPE_OF_BUY_NO_CHECK,
			};
	/**
	 * this public element is a public element
	 *
	 */
	public List<OrderModel> getAllNoCheckOrder(OrderQueryModel oqm,Integer pageNum, Integer pageCount) {
		return orderDao.getAllByTypes(oqm,pageNum,pageCount,buyCheckTypes);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public Integer getCountByTypes(OrderQueryModel oqm) {
		return orderDao.getCountByTypes(oqm,buyCheckTypes);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void buyCheckPass(Long uuid,EmpModel em) {
		OrderModel om = orderDao.get(uuid);
		if(!Arrays.asList(buyCheckTypes).contains(om.getType())){
			try {
				throw new AppException("å¯¹ä¸�èµ·,è¯·ä¸�è¦�è¿›è¡Œé�žæ³•æ“�ä½œï¼�");
			} catch (AppException e) {
				System.out.println("Something was wrong!");
			}
		}
		om.setType(OrderModel.ORDER_TYPE_OF_BUY_CHECK_PASS);
		om.setCheckTime(System.currentTimeMillis());
		om.setChecker(em);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void buyCheckNoPass(Long uuid,EmpModel em) {
		OrderModel om = orderDao.get(uuid);
		if(!Arrays.asList(buyCheckTypes).contains(om.getType())){
			try {
				throw new AppException("å¯¹ä¸�èµ·,è¯·ä¸�è¦�è¿›è¡Œé�žæ³•æ“�ä½œï¼�");
			} catch (AppException e) {
				System.out.println("Something was wrong!");
			}
		}
		om.setType(OrderModel.ORDER_TYPE_OF_BUY_CHECK_NO_PASS);
		om.setCheckTime(System.currentTimeMillis());
		om.setChecker(em);
	}
	/**
	 * this public element is a public element
	 *
	 */
	private Integer[] taskTypes = {
			OrderModel.ORDER_TYPE_OF_BUY_CHECK_PASS,
			OrderModel.ORDER_TYPE_OF_BUY_BUYING,
			OrderModel.ORDER_TYPE_OF_BUY_IN_STORE,
			OrderModel.ORDER_TYPE_OF_BUY_END,
			};
	/**
	 * this public element is a public element
	 *
	 */
	public List<OrderModel> getAllTasks(OrderQueryModel oqm, Integer pageNum,Integer pageCount) {
		return orderDao.getAllByTypes(oqm, pageNum, pageCount, taskTypes);
	}
	
	/**
	 * this public element is a public element
	 *
	 */
	public static Integer[] taskTypes2 = {
			OrderModel.ORDER_TYPE_OF_BUY_CHECK_PASS,
			};
	
	/**
	 * this public element is a public element
	 *
	 */
	public static final Set<Integer> taskTypesSet = new HashSet<Integer>();
	static{
		taskTypesSet.add(OrderModel.ORDER_TYPE_OF_BUY_CHECK_PASS);
		}
	
	/**
	 * this public element is a public element
	 *
	 */
	public void assignTask(OrderModel om) {
		OrderModel temp = orderDao.get(om.getUuid());
		if(!Arrays.asList(taskTypes2).contains(temp.getType())){
			try {
				throw new AppException("å¯¹ä¸�èµ·,è¯·ä¸�è¦�è¿›è¡Œé�žæ³•æ“�ä½œï¼�");
			} catch (AppException e) {
				System.out.println("Something was wrong!");
			}
		}
		temp.setType(OrderModel.ORDER_TYPE_OF_BUY_BUYING);
		temp.setCompleter(om.getCompleter());
	}

	/**
	 * this public element is a public element
	 *
	 */
	public List<OrderModel> getAllByCompleter(OrderQueryModel oqm,Integer pageNum, Integer pageCount, EmpModel login) {
		oqm.setCompleter(login);
		return orderDao.getAll(oqm, pageNum, pageCount);
	}

	/**
	 * this public element is a public element
	 *
	 */
	public void endTask(Long uuid) {
		OrderModel om = orderDao.get(uuid);
		om.setType(OrderModel.ORDER_TYPE_OF_BUY_IN_STORE);
	}

	/**
	 * this public element is a public element
	 *
	 */
	private Integer[] inTypes = {
			OrderModel.ORDER_TYPE_OF_BUY_IN_STORE,
			};
	/**
	 * this public element is a public element
	 *
	 */
	public List<OrderModel> getAllNotIn(OrderQueryModel oqm, Integer pageNum,Integer pageCount) {
		return orderDao.getAllByTypes(oqm, pageNum, pageCount, inTypes);
	}

}
