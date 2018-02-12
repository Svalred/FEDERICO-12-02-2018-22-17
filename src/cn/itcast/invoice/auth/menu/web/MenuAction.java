package cn.itcast.invoice.auth.menu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import cn.itcast.invoice.auth.menu.business.ebi.MenuEbi;
import cn.itcast.invoice.auth.menu.vo.MenuModel;
import cn.itcast.invoice.auth.menu.vo.MenuQueryModel;
import cn.itcast.invoice.util.base.BaseAction;
/**
 * this class extends BaseActions
 *
 */
public class MenuAction extends BaseAction{
	/**
	 * public field
	 */
	public MenuModel mm = new MenuModel();
	/**
	 * public field
	 */
	public MenuQueryModel mqm = new MenuQueryModel();

	private MenuEbi menuEbi;
	/**
	 * public field
	 */
	public void setMenuEbi(MenuEbi menuEbi) {
		this.menuEbi = menuEbi;
	}

	/**
	 * public field
	 */
	public String list(){
		//Ã¥Å Â Ã¨Â½Â½Ã¦âsdfgsdf€°â‚¬Ã¦Å“â€°Ã§Å¡â€žÃ§Ë†Â¶Ã¨ï¿½Å“Ã¥ï¿½â€¢Ã¦â€¢Â°Ã¦ï¿½Â®
		List<MenuModel> parentList = menuEbi.getParentMenu();
		put("parentList",parentList);
		setDataTotal(menuEbi.getCount(mqm));
		List<MenuModel> menuList = menuEbi.getAll(mqm,pageNum,pageCount);
		put("menuList",menuList);
		return LIST;
	}

	/**
	 * public field
	 */
	public String save(){
		if(mm.getUuid()== null){
			menuEbi.save(mm);
		}else{
			menuEbi.update(mm);
		}
		return TO_LIST;
	}

	/**
	 * public field
	 */
	public String input(){
		List<MenuModel> menuList = menuEbi.getParentMenu();
		put("menuList",menuList);
		if(mm.getUuid()!=null){
			mm = menuEbi.get(mm.getUuid());
		}
		return INPUT;
	}

	/**
	 * public field
	 */
	public String delete(){	
		menuEbi.delete(mm);
		return TO_LIST;
	}

	/**
	 * public field
	 */
	public String showMenu() throws IOException{
	
		String root = getRequest().getParameter("root");
		
		getResponse().setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = getResponse().getWriter();
		
		StringBuilder jsonStr = new StringBuilder();
		jsonStr.append("[");
		
		List<MenuModel> menuList = null;
		
		if(root.equals("source")){
			menuList = menuEbi.getParentMenuByEmp(getLogin().getUuid());
			for(MenuModel temp:menuList){
				jsonStr.append("{\"text\":\"");
				jsonStr.append(temp.getName());
				jsonStr.append("\",\"expanded\":false,\"hasChildren\":true,\"classes\":\"folder\",\"id\":\"");
				jsonStr.append(temp.getUuid().toString());
				jsonStr.append("\"},");
			}
		}else{
			Long puuid = new Long(root); 
			menuList = menuEbi.getMenusByPuuidAndEmp(puuid,getLogin().getUuid());
			for(MenuModel temp:menuList){
				jsonStr.append("{\"text\":\"");
				jsonStr.append("<a target='main' href='");
				jsonStr.append(temp.getUrl());
				jsonStr.append("'>");
				jsonStr.append(temp.getName());
				jsonStr.append("</a>");
				jsonStr.append("\",\"classes\":\"file\"},");
			}
		}
		
		jsonStr.deleteCharAt(jsonStr.length()-1);
		jsonStr.append("]");
		
		pw.write(jsonStr.toString());
		
		pw.flush();
		return null;
	}
	
}
