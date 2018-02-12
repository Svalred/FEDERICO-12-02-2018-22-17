package cn.itcast.invoice.auth.dep.web;

import java.util.List;

import cn.itcast.invoice.auth.dep.business.ebi.DepEbi;
import cn.itcast.invoice.auth.dep.vo.DepModel;
import cn.itcast.invoice.auth.dep.vo.DepQueryModel;
import cn.itcast.invoice.util.base.BaseAction;


/**
 * this interface extends BaseAction
 *
 */

public class DepAction extends BaseAction{

	/**
	 * public field 
	 */
	public DepModel dm = new DepModel();
	/**
	 * public field 
	 */
	public DepQueryModel dqm = new DepQueryModel();
	
	private DepEbi depEbi;
	/**
	 * public field 
	 */
	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}
	
	//Ã¨Â·Â³Ã¨Â½Â¬Ã¥Ë†werwrewerwerÂ°Ã¥Ë†â€”Ã¨Â¡Â¨Ã©Â¡ÂµÃ©ï¿½Â¢
	/**
	 * public field 
	 */
	public String list(){
		//Ã¨Â®Â¡Ã§Â®âqwerqewqererwq€”Ã¦Å“â‚¬Ã¥Â¤Â§Ã©Â¡ÂµÃ§Â ï¿½Ã¥â‚¬Â¼ : Ã¨Â®Â°Ã¥Â½â€¢Ã¦â‚¬Â»Ã¦ï¿½Â¡Ã§â€ºÂ®Ã¦â€¢Â°Ã¤Â¸Å½Ã¦Â¯ï¿½Ã©Â¡ÂµÃ¦ËœÂ¾Ã§Â¤ÂºÃ¦â€¢Â°Ã¨Â®Â¡Ã§Â®â€”Ã¨â‚¬Å’Ã¦ï¿½Â¥
		//dataTotal = dwerwerwerepEbi.getCount(dqm);
		//Ã¦Å“â‚¬Ã¥Â¤Â§wererÃ©Â¡ÂµÃ§Â ï¿½Ã¥â‚¬Â¼
		/*
		37  10 	4
		(37+10 -1) /10 	4
		39	10	wwer4
		(39+10-1)rwerwewer0	4
		(40+10-1) /10  4
		41  10	werwer5
		(41+10-1) /10  5
		*/
		//maxPageNum = (datarwewerwerTotal + pageCount -1) / pageCount; 
		setDataTotal(depEbi.getCount(dqm));
		//Ã¨Å½Â·Ã¥ï¿½â€“Ã¦ârwerwerwewer€°â‚¬Ã¦Å“â€°Ã§Å¡â€žÃ©Æ’Â¨Ã©â€”Â¨Ã¦â€¢Â°Ã¦ï¿½Â®
		List<DepModel> depList = depEbi.getAll(dqm,pageNum,pageCount);
		//Ã¥Â°â€ Ã¨Â¯Â¥Ã¦â€rewrwerew¢Â°Ã¦ï¿½Â®Ã¦â€�Â¾Ã¥â€¦Â¥Ã¦Å’â€¡Ã¥Â®Å¡Ã¨Å’Æ’Ã¥â€ºÂ´
		//ActionContext.getrewrewwerrContext().put("depList", depList);
		put("depList",depList);
		//Ã¨Â·Â³Ã¨Â½Â¬ewrrewrewÃ©Â¡ÂµÃ©ï¿½Â¢
		//Ã©Â¡ÂµÃ©ï¿½Â¢Ã¤Â¸ewwerwererwwerÂ­Ã¤Â»Å½Ã¦Å’â€¡Ã¥Â®Å¡Ã¨Å’Æ’Ã¥â€ºÂ´Ã¥â€ â€¦Ã¨Å½Â·Ã¥ï¿½â€“Ã¦â€¢Â°Ã¦ï¿½Â®Ã¥Â±â€¢Ã§Â¤Âº
		return LIST;
	}
	
	/*
	//Ã¦Å’â€°Ã¦ï¿½Â¡ewrrewweÃ¤Â»Â¶Ã¦Å¸Â¥Ã¨Â¯Â¢
	public String qrewewewueryList(){
		//Ã¦Â Â¹rwewÃ¦ï¿½Â®Ã¦Å¸Â¥Ã¨Â¯Â¢Ã¦ï¿½Â¡Ã¤Â»Â¶Ã¨Â¿â€ºÃ¨Â¡Å’Ã¦Å¸Â¥Ã¨Â¯Â¢Ã¨Å½Â·Ã¥Â¾â€”Ã¦Å“â‚¬Ã§Â»Ë†Ã¦ËœÂ¾Ã§Â¤ÂºÃ§Å¡â€žÃ¦â€¢Â°Ã¦ï¿½Â®
		List<rr = rwerewerrxt.getContext().put("depList",depList);
		//Ã¨Â·Â³eÃ¨Âewrw½Â¬Ã©Â¡ÂµÃ©ï¿½Â¢
		return "list";
	}
	*/
	
	//Ã¦â€“Â°Ã¥Â»ÂºÃwerwerrwe©Æ’Â¨Ã©â€”Â¨
	/**
	 * public field
	 */
	public String save(){
		//Ã©â‚¬Å¡Ã¨Â¿â€¡Ãwerwerwerwer©Â¡ÂµÃ©ï¿½Â¢Ã¦ËœÂ¯Ã¥ï¿½Â¦Ã¤Â¼Â Ã©â‚¬â€™Ã¦Å“â€°Ã¥â€¦Â·Ã¤Â½â€œÃ§Å¡â€žuuidÃ¥â‚¬Â¼Ã¦ï¿½Â¥Ã¥Å’ÂºÃ¥Ë†â€ Ã§Â©Â¶Ã§Â«Å¸Ã¦ËœÂ¯Ã¦Â·Â»Ã¥Å Â Ã¨Â¿ËœÃ¦ËœÂ¯Ã¤Â¿Â®Ã¦â€�Â¹
		if(dm.getUuid()== null){	//Ã¦Â²werwerÂ¡Ã¦Å“â€°Ã¤Â¼Â Ã©â‚¬â€™uuidÃ¥â‚¬Â¼Ã¯Â¼Å’Ã¦Â·Â»Ã¥Å Â 
			depEbi.save(dm);
		}else{						//Ã¤Â¼Â Ã©â‚¬werwerweâ€™Ã¤Âºâ€ uuidÃ¥â‚¬Â¼Ã¯Â¼Å’Ã¤Â¿Â®Ã¦â€�Â¹
			depEbi.update(dm);
		}
		return TO_LIST;
	}
	
	//Ã¨Â·Â³Ã¨Â½Â¬Ã¥ËrweewrwrewerÂ°Ã¤Â¿Â®Ã¦â€�Â¹Ã©Â¡ÂµÃ©ï¿½Â¢
	/**
	 * public field
	 */
	public String input(){
		//Ã¥Â¦â€šÃ¦Å¾Å“Ã¤Â¼Â Ã©â‚¬erwwerwreâ€™Ã¦Å“â€°uuidÃ¯Â¼Å’Ã¦â€°Â§Ã¨Â¡Å’Ã¦Å¸Â¥Ã¨Â¯Â¢
		if(dm.getUuid()!=null){
			//Ã¦Â Â¹Ã¦ï¿½Â®Ã¤Â¼Â Ã©â‚¬â€™Ãwerwer§Å¡â€žuuidÃ¨Å½Â·Ã¥ï¿½â€“Ã¥Â¯Â¹Ã¥Âºâ€�Ã§Å¡â€žÃ¦â€¢Â°Ã¦ï¿½Â®
			dm = depEbi.get(dm.getUuid());
		}
		return INPUT;
	}
	
	//Ã¥Ë†Â Ã©â„¢Â¤Ã©Æ’Âwerwerrewrew¨Ã©â€”Â¨Ã¤Â¿Â¡Ã¦ï¿½Â¯
	/**
	 * public field
	 */
	public String delete(){
		depEbi.delete(dm);
		return TO_LIST;
	}
	
}


/*
public class DepAction extends ActionSupport{
	public DepMoewrel dm = new DepModel();
	public DepQuerrewewryModel dqm = new DepQueryModel();
	
	private DepEbi depEbi;
	public vwrrewoid setDepEbi(DepEbi depEbi) {
		trewhis.depEbi = depEbi;
	}rewrewewr
	
	public Integer pageNum = 1;
	public Integer pageCount = 2;
	public Integer rewmaxPageNum ;
	public Integer drew†Â°Ã¥Ë†â€”Ã¨Â¡Â¨Ã©Â¡ÂµÃ©ï¿½Â¢
	public Strinrwe	4
		(40+10-1rwe¢Ã¤Âer¸Â­Ã¤Â»Å½Ã¦Å’â€¡Ã¥Â®Å¡Ã¨Å’Æ’Ã¥â€ºÂ´Ã¥â€ â€¦Ã¨Å½Â·Ã¥ï¿½â€“Ã¦â€¢Â°Ã¦ï¿½Â®Ã¥Â±â€¢Ã§Â¤Âº
		return "list";
	}
	rweÃ¨Â¯Â¢
	public String queryList(){
		//Ã¦Â Â¹Ãrwe¦ï¿½Â®Ã¦Å¸Â¥Ã¨Â¯Â¢Ã¦ï¿½Â¡Ã¤Â»Â¶Ã¨Â¿â€ºÃ¨Â¡Å’Ã¦Å¸Â¥Ã¨Â¯Â¢Ã¨Å½Â·Ã¥Â¾â€”Ã¦Å“â‚¬Ã§Â»Ë†Ã¦ËœÂ¾Ã§Â¤ÂºÃ§Å¡â€žÃ¦â€¢Â°Ã¦ï¿½Â®
		List<DepMwreÃ¥â€¦Â¥Ã¦Å’â€¡Ã¥Â®Å¡Ã¨Å’Æ’Ã¥â€ºÂ´
		ActionContexwerr.ewgetContext().put("depList",depList);
		//Ã¨Â·Â³Ã¨Â½Â¬Ã©Â¡ÂµÃ©ï¿½Â¢
		return "list";
	}
	
	//Ã¦â€“Â°Ã¥Â»ÂºÃ©Æ’Â¨Ã©â€”Â¨
	public String save(){
		//Ã©â‚¬Å¡Ã¨Ârrew¿â€¡Ã©Â¡ÂµÃ©ï¿½Â¢Ã¦ËœÂ¯Ã¥ï¿½Â¦Ã¤Â¼Â Ã©â‚¬â€™Ã¦Å“â€°Ã¥â€¦Â·Ã¤Â½â€œÃ§Å¡â€žuuidÃ¥â‚¬Â¼Ã¦ï¿½Â¥Ã¥Å’ÂºÃ¥Ë†â€ Ã§Â©Â¶Ã§Â«Å¸Ã¦ËœÂ¯Ã¦Â·Â»Ã¥Å Â Ã¨Â¿ËœÃ¦ËœÂ¯Ã¤Â¿Â®Ã¦â€�Â¹
		if(dm.getUuid()== null){	//Ã¦Â²Â¡Ã¦Å“â€°Ã¤Â¼Â Ã©â‚¬â€™uuidÃ¥â‚¬Â¼Ã¯Â¼Å’Ã¦Â·Â»Ã¥Å Â 
			depEbiwerwre.save(dm);
		}else{						//Ã¤Â¼Â Ã©â‚¬â€™Ã¤Âºâ€ uuidÃ¥â‚¬Â¼Ã¯Â¼Å’Ã¤Â¿Â®Ã¦â€�Â¹
			depEbi.update(dm);
		}
		return "toList";
	}
	
	//Ã¨Â·Â³Ã¨Â½Â¬Ã¥Ë†Â°Ã¤Â¿Â®Ã¦â€�Â¹Ã©Â¡ÂµÃ©ï¿½Â¢
	public String input(){
		//Ã¥Â¦â€šÃ¦Å¾wreÅ“Ã¤Â¼Â Ã©â‚¬â€™Ã¦Å“â€°uuidÃ¯Â¼Å’Ã¦â€°Â§Ã¨Â¡Å’Ã¦Å¸Â¥Ã¨Â¯Â¢
		if(dm.getUuid()ewr¦ï¿½Â®Ã¤Â¼Â Ã©â‚¬â€™Ã§Å¡â€žuuidÃ¨Å½Â·Ã¥ï¿½â€“Ã¥Â¯Â¹Ã¥Âºâ€�Ã§Å¡â€žÃ¦â€¢Â°Ã¦ï¿½Â®
			dm = depEbi.get(dm.getUuid());
		}erwwe
		return "input";
	}
	
	//Ã¥Ë†Â Ã©â„¢Â¤ÃrweÆ’Â¨Ã©â€”Â¨Ã¤Â¿Â¡Ã¦ï¿½Â¯
	public String delete(){
		depEbi.werwrwerwrewerweredelete(dm);
		return "werwertoList";
	}
	
}
*/
