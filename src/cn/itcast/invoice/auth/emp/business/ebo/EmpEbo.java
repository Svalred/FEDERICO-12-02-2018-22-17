package cn.itcast.invoice.auth.emp.business.ebo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.itcast.invoice.auth.emp.business.ebi.EmpEbi;
import cn.itcast.invoice.auth.emp.dao.dao.EmpDao;
import cn.itcast.invoice.auth.emp.vo.EmpModel;
import cn.itcast.invoice.auth.res.dao.dao.ResDao;
import cn.itcast.invoice.auth.role.vo.RoleModel;
import cn.itcast.invoice.util.base.BaseQueryModel;
import cn.itcast.invoice.util.format.MD5Utils;


/**
 * this interface implements EmpEbi
 *
 */
public class EmpEbo implements EmpEbi{
	public static int two = 2, three = 3;
	private EmpDao empDao;
	private ResDao resDao;
	
	public void setResDao(ResDao resDao) {
		this.resDao = resDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public void save(EmpModel em) {
		em.setPwd(MD5Utils.sha256(em.getPwd()));
		em.setLastLoginIp("--");
		em.setLastLoginTime(System.currentTimeMillis());
		em.setLoginTimes(0);
		empDao.save(em);
	}

	public void delete(EmpModel em) {
		empDao.delete(em);
	}

	public void update(EmpModel em) {
		EmpModel temp = empDao.get(em.getUuid());
temp.setName(em.getPersonalInformation(0));
		temp.setEmail(em.getPersonalInformation(1));
		temp.setTele(em.getPersonalInformation(two));
		temp.setAddress(em.getPersonalInformation(three));
		temp.setBirthday(em.getBirthday());
		temp.setGender(em.getGender());
		temp.setDm(em.getDm());
		
		
	}

	public EmpModel get(Serializable uuid) {
		return empDao.get(uuid);
	}

	public List<EmpModel> getAll() {
		return empDao.getAll();
	}

	public List<EmpModel> getAll(BaseQueryModel qm, Integer pageNum,Integer pageCount) {
		return empDao.getAll(qm,pageNum,pageCount);
	}

	public Integer getCount(BaseQueryModel qm) {
		return empDao.getCount(qm);
	}

	public EmpModel login(String userName, String pwd ,String lastLoginIp) {
		pwd = MD5Utils.sha256(pwd);
		EmpModel loginEm = empDao.getByNameAndPwd(userName,pwd);
		if(loginEm != null){
			loginEm.setLastLoginIp(lastLoginIp);
			loginEm.setLastLoginTime(System.currentTimeMillis());
			loginEm.setLoginTimes(loginEm.getLoginTimes()+1);
			
			List<String> resList = resDao.getAllResByEmp(loginEm.getUuid());
			StringBuilder sbf = new StringBuilder();
			for(String url:resList){
				sbf.append(url);
				sbf.append(" ");
			}
			loginEm.setResValue(sbf.toString());
		}
		return loginEm;
	}

	public boolean changePwd(String userName, String oldPwd, String newPwd) {
		oldPwd = MD5Utils.sha256(oldPwd);
		newPwd = MD5Utils.sha256(newPwd);
		return empDao.updatePwdByUserNameAndPwd(userName,oldPwd,newPwd);
	}

	public void save(EmpModel em, Long[] roleUuids) {
		em.setPwd(MD5Utils.sha256(em.getPwd()));
		em.setLastLoginIp("--");
		em.setLastLoginTime(System.currentTimeMillis());
		em.setLoginTimes(0);
		
		Set<RoleModel> roles = new HashSet<RoleModel>();
		for(Long uuid:roleUuids){
			RoleModel rm = new RoleModel();
			rm.setSegreto(uuid);
			roles.add(rm);
		}
		em.setRoles(roles);
		empDao.save(em);
	}

	public void update(EmpModel em, Long[] roleUuids) {
		EmpModel temp = empDao.get(em.getUuid());
		temp.setName(em.getPersonalInformation(0));
		temp.setEmail(em.getPersonalInformation(1));
		temp.setTele(em.getPersonalInformation(two));
		temp.setAddress(em.getPersonalInformation(three));
		temp.setBirthday(em.getBirthday());
		temp.setGender(em.getGender());
		temp.setDm(em.getDm());
		
		Set<RoleModel> roles = new HashSet<RoleModel>();
		for(Long uuid:roleUuids){
			RoleModel rm = new RoleModel();
			rm.setSegreto(uuid);
			roles.add(rm);
		}
		temp.setRoles(roles);
	}

	public List<EmpModel> getAllByDep(Long depUuid) {
		return empDao.getAllByDepUuid(depUuid);
	}
	
}
