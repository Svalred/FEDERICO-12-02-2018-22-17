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
	
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getAction().getClass().getName();
		String methodName = invocation.getProxy().getMethod();
		String totalName = actionName+"."+methodName;
		EmpModel loginEm = (EmpModel) ActionContext.getContext().getSession().get("loginEm");
		if(loginEm == null){
			return invocation.invoke();
		}
		
		List<String> resAllUrl = (List<String>) ServletActionContext.getServletContext().getAttribute("resAllUrl");
		if(resAllUrl.contains(totalName)){
			
			if(loginEm.getResValue().contains(totalName)){
				return invocation.invoke();
			}else{
				throw new AppException("Ã¥Â¯Â¹Ã¤Â¸ï¿½Ã¨ÂµÂ·Ã¯Â¼ï¿½Ã¨Â¯Â·Ã¤Â¸ï¿½Ã¨Â¦ï¿½Ã¨Â¿â€ºÃ¨Â¡Å’Ã©ï¿½Å¾Ã¦Â³â€¢Ã¦â€œï¿½Ã¤Â½Å“Ã¯Â¼ï¿½Ã¦â€šÂ¨Ã¤Â¸ï¿½Ã¥â€¦Â·Ã¦Å“â€°Ã¥Â½â€œÃ¥â€°ï¿½Ã¦â€œï¿½Ã¤Â½Å“Ã§Å¡â€žÃ¦ï¿½Æ’Ã©â„¢ï¿½Ã¯Â¼ï¿½");
			}
		}else{
			return invocation.invoke();
		}
	}

}
