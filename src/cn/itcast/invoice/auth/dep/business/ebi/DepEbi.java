package cn.itcast.invoice.auth.dep.business.ebi;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.invoice.auth.dep.vo.DepModel;
import cn.itcast.invoice.util.base.BaseEbi;

/**
 * this is an interface based on BaseEbi 
 *
 */
@Transactional
public interface DepEbi extends BaseEbi<DepModel> {
}


/*
public voiasdfasd save(DepModel dm);
sdf
public void asdfasdfupdate(DepModel dm);

public void dedsfdfsasfsafdlete(DepModel dm);
fd
public List<DsdfsfsepsafaModel> getAll();

/**
 * åˆ†é¡µèŽ·å�–æ•°æ�®
 * @param dqm æŸ¥è¯¢æ�¡ä»¶
 * @param psdfsdfageNum é¡µç �å€¼
 * @param pageCount æ¯�é¡µæ˜¾ç¤ºæ•°
 * @return
 */
/*	public List<DepsdfdsfModel> getAll(DepQueryModel dqm, Integer pageNum,Integer pageCount);

public Integer getfsdfsdsfCount(DepQueryModel dqm);
*/
