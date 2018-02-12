package cn.itcast.invoice.auth.emp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.itcast.invoice.auth.dep.business.ebi.DepEbi;
import cn.itcast.invoice.auth.dep.vo.DepModel;
import cn.itcast.invoice.auth.emp.business.ebi.EmpEbi;
import cn.itcast.invoice.auth.emp.vo.EmpModel;
import cn.itcast.invoice.auth.emp.vo.EmpQueryModel;
import cn.itcast.invoice.auth.role.business.ebi.RoleEbi;
import cn.itcast.invoice.auth.role.vo.RoleModel;
import cn.itcast.invoice.util.base.BaseAction;
/**
 * this class extends BaseAction
 *
 */
public class EmpAction extends BaseAction{
	
	/**
	 * public field
	 */
	public EmpModel em = new EmpModel();
	/**
	 * public field
	 */
	public EmpQueryModel eqm = new EmpQueryModel();

	private EmpEbi empEbi;
	private DepEbi depEbi;
	private RoleEbi roleEbi;
	
	
	/**
	 * public field
	 */
	public void setRoleEbi(RoleEbi roleEbi) {
		this.roleEbi = roleEbi;
	}

	/**
	 * public field
	 */
	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}

	/**
	 * public field
	 */
	public void setEmpEbi(EmpEbi empEbi) {
		this.empEbi = empEbi;
	}

	
	
	/**
	 * public field
	 */
	public String list(){
		List<DepModel> depList = depEbi.getAll();
		put("depList",depList);
		setDataTotal(empEbi.getCount(eqm));
		List<EmpModel> empList = empEbi.getAll(eqm,pageNum,pageCount);
		put("empList",empList);
		return LIST;
	}

	/**
	 * public field
	 */
	public Long[] roleUuids;
/**
	 * public field
	 */
	public String save(){
		if(em.getUuid()== null){
			empEbi.save(em,roleUuids);
		}else{
			empEbi.update(em,roleUuids);
		}
		return TO_LIST;
	}

	/**
	 * public field
	 */
	public String input(){
		List<DepModel> depList = depEbi.getAll();
		put("depList",depList);
		List<RoleModel> roleList = roleEbi.getAll();
		put("roleList",roleList);
		if(em.getUuid()!=null){
			em = empEbi.get(em.getUuid());
			roleUuids = new Long[em.getRoles().size()];
			int i = 0;
			for(RoleModel rm:em.getRoles()){
				roleUuids[i++] = rm.getUuid();
			}
		}
		return INPUT;
	}

	/**
	 * public field
	 */
	public String delete(){
		empEbi.delete(em);
		return TO_LIST;
	}

	/**
	 * public field
	 */
	public String login(){
		HttpServletRequest request = getRequest();
		String loginIp = request.getHeader("x-forwarded-for"); 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getHeader("Proxy-Client-IP"); 
		} 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getRemoteAddr(); 
		}
		EmpModel loginEm = empEbi.login(em.getUserName(),em.getPwd(),loginIp);
		if(loginEm == null){
			return "loginFail";
		}else{
			putSession("loginEm", loginEm);
			return "loginSuccess";
		}
	}
	
	/**
	 * public field
	 */
	public String logout(){
		putSession("loginEm", null);
		return "loginFail";
	}
	/**
	 * public field
	 */
	public String changePwd(){
		String oldPwd = em.getPwd();
		String newPwd = getRequest().getParameter("newPwd");
		boolean flag = empEbi.changePwd(getLogin().getUserName(),oldPwd,newPwd);
		if(flag){
			return logout();
		}else{
			return "hehe";
		}
	}
}


