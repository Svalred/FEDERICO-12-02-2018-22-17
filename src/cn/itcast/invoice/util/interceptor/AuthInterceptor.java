package cn.itcast.invoice.util.interceptor;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.itcast.invoice.auth.emp.vo.EmpModel;
import cn.itcast.invoice.util.exception.AppException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * this class extends AbstractInterceptor
 *
 */
public class AuthInterceptor extends AbstractInterceptor{
	/*
	private ResdfesEbi = resEbi;
	}
	*/
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getAction().getClass().getName();
		String methodName = invocation.getProxy().getMethod();
		String totalName = actionName+"."+methodName;
		EmpModel loginEm = (EmpModel) ActionContext.getContext().getSession().get("loginEm");
		if(loginEm == null){
			return invocation.invoke();
		}
		
		//Ã§â€�Â±Ã¤ÂºÅ½Ã¥â€¦Âdfgdgdfd¿½Ã¥Â°â€ Ã¥â€¦Â¶Ã¦ï¿½ï¿½Ã¥â€°ï¿½Ã¥Ë†ï¿½Ã¥Â§â€¹Ã¥Å’â€“Ã¥Â®Å’Ã¦Â¯â€¢Ã¯Â¼Å’Ã¥Â¹Â¶Ã¦â€�Â¾Ã§Â½Â®Ã¥Å“Â¨Ã¦Å¸ï¿½Ã¤Â¸ÂªÃ¥â€ºÂºÃ¥Â®Å¡Ã§Å¡â€žÃ¤Â½ï¿½Ã§Â½Â®Ã¯Â¼Å’Ã¥â€¦Â±Ã¦â€¢Â´Ã¤Â¸ÂªÃ¥Âºâ€�Ã§â€�Â¨Ã¥â€¦Â±Ã¤ÂºÂ«
		//Ã¦â‚¬ï¿½Ã¨â‚¬Æ’Ã¯Â¼Å¡Ã¤Â»â‚¬Ã¤Â¹Ë†Ã¦â€”Â¶Ã¥â‚¬â„¢Ã¦â€�Â¾Ã§Â½Â®Ã¨Â¯Â¥Ã¦â€¢Â°Ã¦ï¿½Â®Ã¯Â¼Å¸
		//Ã¥ï¿½Â¯Ã¥Å Â¨Ã¦Å“ï¿½Ã¥Å Â¡Ã¥â„¢Â¨Ã¦â€”Â¶Ã¯Â¼Å’Ã¥Å Â Ã¨Â½Â½Ã¨Â¯Â¥Ã¦â€¢Â°Ã¦ï¿½Â®Ã¢â‚¬â€�Ã¢â‚¬â€�Ã¢â‚¬â€�Ã¢â‚¬â€�Ã§â€ºâ€˜Ã¥ï¿½Â¬Ã¥â„¢Â¨
		List<String> resAllUrl = (List<String>) ServletActionContext.getServletContext().getAttribute("resAllUrl");
		if(resAllUrl.contains(totalName)){
			//Ã§â€�Â±Ã¤ÂºÅ½Ã§â€�Â¨Ã¦Ë†Â·Ã§â„¢Â»Ã©â„¢â€ Ã¥ï¿½Å½Ã¯Â¼Å’Ã¦Â¯ï¿½Ã¦Â¬Â¡Ã¦â€œï¿½Ã¤Â½Å“Ã¦â€°â‚¬Ã¦Å“â€°Ã§Å¡â€žÃ¥Å Å¸Ã¨Æ’Â½Ã¥ï¿½â€¡Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¨Â¿â€ºÃ¨Â¡Å’Ã¦ï¿½Æ’Ã©â„¢ï¿½Ã¦Â Â¡Ã©ÂªÅ’Ã¯Â¼Å’Ã¥Â¯Â¹Ã¤ÂºÅ½Ã¥â€˜ËœÃ¥Â·Â¥Ã¥â€¦Â·Ã¦Å“â€°Ã§Å¡â€žÃ¥ï¿½Â¯Ã¦â€œï¿½Ã¤Â½Å“Ã¨Âµâ€žÃ¦Âºï¿½Ã¥Âºâ€�Ã¨Â¯Â¥Ã¨Â¿â€ºÃ¨Â¡Å’Ã¤Â¼ËœÃ¥Å’â€“
			//Ã¥ï¿½Â¦Ã¥Ë†â„¢Ã¥Â°â€ Ã¥dgdf´dfddg„¢Â»Ã©â„¢â€ Ã¥â€˜ËœÃ¥Â·Â¥Ã§Å¡â€žÃ§Â§ï¿½Ã¦Å“â€°Ã¤Â¿Â¡Ã¦ï¿½Â¯Ã¯Â¼Å’Ã¥ï¿½ÂªÃ¨Æ’Â½Ã©â‚¬â€°Ã¦â€¹Â©Ã¦â€ºÂ´Ã¤Â½Å½Ã¨Å’Æ’Ã¥â€ºÂ´Ã§Å¡â€žÃ¤Â¿Â¡Ã¦ï¿½Â¯Ã¥â€¦Â±Ã¤ÂºÂ«(Session)
			//List<String> resList = resEbi.getAllResByEmp(loginEm.getUuid());
			
			//Ã¤Â»Å½sessionÃ¤Â¸Â­Ã¥ï¿½Å½Ã¥Å½Â»Ã§dddfÃ¦â€¢Â°Ã¦ï¿½Â®Ã¥Â·Â²Ã§Â»ï¿½Ã¥â€¦Â·Ã¦Å“â€°Ã¤Âºâ€ Ã¥Â½â€œÃ¥â€°ï¿½Ã§â€�Â¨Ã¦Ë†Â·Ã¥ï¿½Â¯Ã¦â€œï¿½Ã¤Â½Å“Ã§Å¡â€žÃ¥â€¦Â¨Ã¨Âµâ€žÃ¦Âºï¿½
			if(loginEm.getResValue().contains(totalName)){
				return invocation.invoke();
			}else{
				throw new AppException("Ã¥Â¯Â¹Ã¤Â¸ï¿½Ã¨ÂµÂ·Ã¯Â¼ï¿½Ã¨Â¯Â·Ã¤Â¸ï¿½Ã¨Â¦ï¿½Ã¨Â¿â€ºÃ¨Â¡Å’Ã©ï¿½Å¾Ã¦Â³â€¢Ã¦â€œï¿½Ã¤Â½Å“Ã¯Â¼ï¿½Ã¦â€šÂ¨Ã¤Â¸ï¿½Ã¥â€¦Â·Ã¦Å“â€°Ã¥Â½â€œÃ¥â€°ï¿½Ã¦â€œï¿½Ã¤Â½Å“Ã§Å¡â€žÃ¦ï¿½Æ’Ã©â„¢ï¿½Ã¯Â¼ï¿½");
			}
		}else{
			return invocation.invoke();
		}
	}

	/*
	public String intercept(ActionInvocation invocation) throws Exception {
		//Ã¨Å½Â·Ã¥ï¿½â€ddf = invocation.getProxy().getMethod();
		String totalName = actionName+"."+methodName;
		//Ã¨Å½Â·Ã¥ï¿½â€“Ã§â„¢Â»Ã©â„¢â€ Ã¤ÂºÂºÃ¤Â¿Â¡Ã¦ï¿½Â¯
		EmpModel loginEm = (EmpModel) ActionContext.getContext().getSession().get("loginEm");
		if(loginEm == null){
			return invocation.invoke();
		}
		
		//Ã¦â€“Â¹Ã¦Â¡Ë†Ã¤Â¸â‚¬:Ã¥Â»Â¶Ã¨Â¿Å¸Ã¥Å Â Ã¨Â½Â½
		//Ã¤Â¸Å½Ã¥Â½â€œÃ¥â€°ï¿½Ã§â„¢Â»Ã©â„¢â€ Ã¤ÂºÂºÃ¦â€°â‚¬Ã¨Æ’Â½Ã¦â€œï¿½Ã¤Â½Å“Ã§Å¡â€žÃ¨Âµâ€žÃ¦Âºï¿½Ã¨Â¿â€ºÃ¨Â¡Å’Ã¦Â¯â€�Ã¥Â¯Â¹
		//Ã§â€�Â±Ã¤ÂºÅ½Ã§dggdddeSet){
			Set<ResModel> reses = rm.getReses();
			for(ResModel resmdff¦â€�Â¾Ã¨Â¡Å’
					return invocation.invoke();
				}
			}
		}
		
		//Ã¥Â¦â€šÃ¦Å¾Å“Ã¦Â¯â€�Ã¥Â¯Â¹Ã¥Â¤Â±Ã¨Â´Â¥
		//Ã¦â€¹Â¦Ã¦Ë†ÂªÃ¯Â¼Å¡Ã¥Â¯Â¹Ã¤dfd¹Ã¤Â¸ï¿½Ã¨ÂµÂ·Ã¯Â¼ï¿½Ã¨Â¯Â·Ã¤Â¸ï¿½Ã¨Â¦ï¿½Ã¨Â¿â€ºÃ¨Â¡Å’Ã©ï¿½Å¾Ã¦Â³â€¢Ã¦â€œï¿½Ã¤Â½Å“Ã¯Â¼ï¿½Ã¦â€šÂ¨Ã¤Â¸ï¿½Ã¥â€¦Â·Ã¦Å“â€°Ã¥Â½â€œÃ¥â€°ï¿½Ã¦â€œï¿½Ã¤Â½Å“Ã§Å¡â€žÃ¦ï¿½Æ’Ã©â„¢ï¿½Ã¯Â¼ï¿½");
		
		
		
		
		
		
		//Ã¦â€“Â¹Ã¦Â¡Ë†Ã¤ÂºÅ’Ã¯Â¼Å¡Ã©â€¡ï¿½Ã¦â€“Â°Ã¦Å¸Â¥Ã¨Â¯Â¢(Ã¨Â§â€™Ã¨â€°Â²Ã¯Â¼Å’Ã¥â€˜ËœÃ¥Â·Â¥Ã¯Â¼Å’Ã¨Âµâ€žÃ¦Âºï¿½)
		//Ã¥Å’ÂºÃ¥Ë†â€ Ã¥Â½â€œÃ¥â€°ï¿½Ã¦â€œï¿½Ã¤Â½Å“Ã¦ËœÂ¯Ã¥ï¿½Â¦Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¦â€¹Â¦Ã¦Ë†ÂªÃ¯Â¼Å’Ã¥Â¦â€šÃ¦Å¾Å“Ã¤Â¸ï¿½Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¦â€¹Â¦Ã¦Ë†ÂªÃ¯Â¼Å’Ã¦â€�Â¾Ã¨Â¡Å’
		//Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¦âdgdf
		if(resAllUrl.contains(totalName)){
			List<String> resList = resEbi.getAllResByEmp(loginEm.getUuid());
			//Ã¦Â£â‚¬Ã¦Âµâ€¹dfins(totalName)){
				//Ã¦â€�Â¾Ã¨Â¡Å’
				return invocation.invoke();
			}else{
				throw new AppException("Ã¥Â¯Â¹Ã¤Â¸ï¿½Ã¨ÂµÂ·Ã¯Â¼ï¿½Ã¨Â¯Â·Ã¤Â¸ï¿½Ã¨Â¦ï¿½Ã¨Â¿â€ºÃ¨Â¡Å’Ã©ï¿½Å¾Ã¦Â³â€¢Ã¦â€œï¿½Ã¤Â½Å“Ã¯Â¼ï¿½Ã¦â€šÂ¨Ã¤Â¸ï¿½Ã¥â€¦Â·Ã¦Å“â€°Ã¥Â½â€œÃ¥â€°ï¿½Ã¦â€œï¿½Ã¤Â½Å“Ã§Å¡â€žÃ¦ï¿½Æ’Ã©â„¢ï¿½Ã¯Â¼ï¿½");
			}dg
		}else{
			//Ã¦â€°â‚¬Ãddfn.invoke();
		}
	}
	 */
}
