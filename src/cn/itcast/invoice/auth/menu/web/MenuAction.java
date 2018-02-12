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

	//Ã¨Â·Â³Ã¨Â½Â¬Ã¥Ë†Âsdfgsdfg°Ã¥Ë†â€”Ã¨Â¡Â¨Ã©Â¡ÂµÃ©ï¿½Â¢
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

	//Ã¤Â¿ï¿½Ã¥Â­Ëœ/Ãsdfsdfsdf¤Â¿Â®Ã¦â€�Â¹
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

	//Ã¨Â·Â³Ã¨Â½Â¬Ã¥sdfsdfsdfgË†Â°Ã¦Â·Â»Ã¥Å Â /Ã¤Â¿Â®Ã¦â€�Â¹Ã©Â¡ÂµÃ©ï¿½Â¢
	/**
	 * public field
	 */
	public String input(){
		//Ã¥Å Â Ã¨Â½Â½Ã¦â€°â‚¬sdfsdgÃ¦Å“â€°Ã§Å¡â€žÃ§Ë†Â¶Ã¨ï¿½Å“Ã¥ï¿½â€¢
		List<MenuModel> menuList = menuEbi.getParentMenu();
		put("menuList",menuList);
		if(mm.getUuid()!=null){
			mm = menuEbi.get(mm.getUuid());
		}
		return INPUT;
	}

	//Ã¥Ë†Â Ã©â„¢Â¤
	/**
	 * public field
	 */
	public String delete(){
		//Ã¨Â¿â€ºÃ¨Â¡Å’Ã¥Ë†Â Ã©â„¢Â¤sdfgfdsgsÃ¦â€”Â¶Ã¯Â¼Å’Ã¥Â¦â€šÃ¦Å¾Å“Ã¥Â­ËœÃ¥Å“Â¨Ã¦Å“â€°Ã¤Â¸â‚¬Ã¥Â¯Â¹Ã¥Â¤Å¡Ã¥â€¦Â³Ã§Â³Â»
		//Ã¥Ë†Â Ã©dgÅ½dsfg¥Ë†Â Ãgfdsgfds©â„¢fgdsgfdsÂ¤Ã¥Â¤Å¡Ã¦â€“Â¹Ã¥Â¯Â¹Ã¨Â±Â¡
		//Ã§â€žÂ¶Ã¥ï¿½Å½Ã¥Ë†Â Ã©â„¢Â¤Ã¤Â¸â‚¬Ã¦â€“Â¹Ã¥Â¯Â¹Ã¨Â±Â¡
		
		menuEbi.delete(mm);
		return TO_LIST;
	}

	//----------------
	/**
	 * public field
	 */
	public String showMenu() throws IOException{
		//Ã¦Â Â¹Ã¦ï¿½Â®phpÃ§Å¡â€žÃ¥â€ â€¦Ã¥Â®Â¹Ã¯Â¼Å’Ã¦Å’â€°Ã§â€¦Â§Ã¥Å½Å¸Ã¥Â§â€¹Ã¦Â Â¼Ã¥Â¼ï¿½Ã¨Â¿â€�Ã¥â€ºÅ¾phpÃ§Å¡â€žÃ¦â€¢Â°Ã¦ï¿½Â®
		//Ã¥Â­Â¦Ã¤Â¹Â sourcssdfgsdfe.phpÃ¥â€ â€¦Ã¥Â®Â¹Ã¯Â¼Å’Ã§Â¿Â»Ã¨Â¯â€˜Ã¦Ë†ï¿½actionÃ¥â€ â€¦Ã¥Â®Â¹
		//Ã¥Â°â€ phpÃ¤Â»Â£Ã§Âdg¨Â§Â£Ã¦Å¾ï¿½Ã¥ï¿½Å½Ã¥Â¾â€”Ã¥Ë†Â°Ã§Â»â€œÃ¨Â®Âº
		//Ã¨Â¯Â·Ã¦Â±â€šgsdfg
		/*
		//Ã¦Âµâ€¹Ã¨Â¯dsgžÃ¨Â¿â€�Ã¥â€ºÅ¾Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¤Â½Â¿Ã§â€�Â¨response
		PrintWriter pw = getResponse().getWriter();
		
		pw.write("[");
		pw.wrsdfgdf
		
		pw.flush();
		return null;
		*/
		
		/*
		//Ã¦Âµâ€¹Ã¨Â¯â€¢Ã¤ÂºÅ’:
		//Ã©Â¡ÂµÃ©ïdsgdfgdfgdfÃ¦Å“â€°Ã§Å¡â€žÃ§Ë†Â¶Ã¨ï¿½Å“Ã¥ï¿½â€¢Ã¦â€¢Â°Ã¦ï¿½Â®Ã¯Â¼Ë†Ã¤Â¸ï¿½Ã¥Å’â€¦Ã¥ï¿½Â«Ã§Â³Â»Ã§Â»Å¸Ã¨ï¿½Å“Ã¥ï¿½â€¢Ã¯Â¼â€°
		List<MenuModel> menuList = menuEbi.getParentMenu2();
		PrintWriter pw = getResponse().getWriter();
		
		StringBuilder jsonStr = new StringBuilder();
		
		jsonStr.append("[");
		for(MenuModel temp:menuList){
			jsonStr.append("{\"text\":\"");
			jsonStgdfgdf
		//jsonStr.substring(0, jsonStr.length()-1);
		jsonStr.dedgarAt(jsonStr.length()-1);
		jsonStr.append("]");
		
		pw.write(jsonStr.toString());
		
		pw.flush();
		return null;
		*/
		
		/*
		//Ã¦Âµâ€¹Ã¨Â¯â€¢Ã¤Â¸â€°:
		//Ã¥Â½â€œÃ§Â³Âfgfdgarameter("root");
		
		getResponse().setContentType("text/html;charset=utf-8");
		dfgdfgdfStr = new StringBuilder();
		jsonStr.append("[");
		
		List<MenuModel> menuList = null;
		
		if(root.equals("source")){
			menuList = dgfdgdfgdappend("{\"text\":\"");
				jsonStr.append(temp.getName());
				jsonStr.ad‚¬â€™Ã§Å¡â€žÃ¨ï¿½Å“Ã¥ï¿½â€¢Ã©Â¡Â¹Ã§â€ºÂ®Ã§Å¡â€žuuidÃ¨Å½Â·Ã¥ï¿½â€“Ã¥â€¦Â¶Ã¥Â­ï¿½Ã©Â¡Â¹Ã§Å¡â€žÃ¨ï¿½Å“Ã¥ï¿½â€¢Ã©â€ºâ€ Ã¥ï¿½Ë†
			Long puuid = new Long(root); 
			menuList = menuEbi.getMenusByPuuid(puuid);
			//jsonStr.append(df
		pw.write(jsonStr.toString());
		
		pw.flush();
		return null;
		*/
		
		//Ã¦â€“dfgdfgºÃ¯Â¼Å¡Ã¥Å¸ÂºÃ¤ÂºÅ½Ã§â„¢Â»Ã©â„¢â€ Ã§â€�Â¨Ã¦Ë†Â·Ã¨Â¿â€ºÃ¨Â¡Å’Ã¨ï¿½Å“Ã¥ï¿½â€¢Ã¥Å Â Ã¨Â½Â½
		
		String root = getRequest().getParameter("root");
		
		getResponse().setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = getResponse().getWriter();
		
		StringBuilder jsonStr = new StringBuilder();
		jsonStr.append("[");
		
		List<MenuModel> menuList = null;
		
		if(root.equals("source")){
			//Ã¦Â Â¹Ã¦ï¿½Â®Ã§â„¢Â»Ã©â„sdfgsdfggs¢â€ Ã¤ÂºÂºÃ¨Å½Â·Ã¥ï¿½â€“Ã¥Â¯Â¹Ã¥Âºâ€�Ã§Å¡â€žÃ¨ï¿½Å“Ã¥ï¿½â€¢Ã©Â¡Â¹
			menuList = menuEbi.getParentMenuByEmp(getLogin().getUuid());
			for(MenuModel temp:menuList){
				jsonStr.append("{\"text\":\"");
				jsonStr.append(temp.getName());
				jsonStr.append("\",\"expanded\":false,\"hasChildren\":true,\"classes\":\"folder\",\"id\":\"");
				jsonStr.append(temp.getUuid().toString());
				jsonStr.append("\"},");
			}
		}else{
			//Ã¦Â Â¹Ã¦ï¿½Â®Ã¤Â¼Â Ã©ssdfggsdsâ‚¬â€™Ã§Å¡â€žÃ¨ï¿½Å“Ã¥ï¿½â€¢Ã©Â¡Â¹Ã§â€ºÂ®Ã§Å¡â€žuuidÃ¥â€™Å’Ã§â„¢Â»Ã©â„¢â€ Ã¤ÂºÂºÃ¤Â¿Â¡Ã¦ï¿½Â¯Ã¨Å½Â·Ã¥ï¿½â€“Ã¥â€¦Â¶Ã¥Â­ï¿½Ã©Â¡Â¹Ã§Å¡â€žÃ¨ï¿½Å“Ã¥ï¿½â€¢Ã©â€ºâ€ Ã¥ï¿½Ë†
			Long puuid = new Long(root); 
			menuList = menuEbi.getMenusByPuuidAndEmp(puuid,getLogin().getUuid());
			//jsonStr.append("{\"text\":\"bbb\",\"hasChildren\":false,\"classes\":\"file\",\"id\":\"2\"},");
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
/*
[
 	{"text":"bb","expsdgdgsdfgsdfgsded":false,"hasChildren":true,"classes":"folder","id":"8"}
 	,
 ]
*/		
		
		
		
		
		
		
		
		
		
		
