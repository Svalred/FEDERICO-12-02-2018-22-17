package cn.itcast.invoice.auth.dep.business.ebi;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.invoice.auth.dep.vo.DepModel;
import cn.itcast.invoice.util.base.BaseEbi;

/**
 * this is an interface based on BaseEbi 
 *
 **/
@Transactional
public interface DepEbi extends BaseEbi<DepModel> {
}
