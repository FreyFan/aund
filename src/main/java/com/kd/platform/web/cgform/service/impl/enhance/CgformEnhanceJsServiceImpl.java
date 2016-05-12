package com.kd.platform.web.cgform.service.impl.enhance;

import java.util.List;

import com.kd.platform.web.cgform.entity.enhance.CgformEnhanceJsEntity;
import com.kd.platform.web.cgform.service.enhance.CgformEnhanceJsServiceI;

import com.kd.platform.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cgformenhanceJsService")
@Transactional
public class CgformEnhanceJsServiceImpl extends CommonServiceImpl implements CgformEnhanceJsServiceI {

	/**
	 * 根据cgJsType和formId查找数据
	 * @param cgJsType
	 * @param formId
	 * @return
	 */
	
	public CgformEnhanceJsEntity getCgformEnhanceJsByTypeFormId(String cgJsType, String formId) {
		StringBuilder hql = new StringBuilder("");
		hql.append(" from CgformEnhanceJsEntity t");
		hql.append(" where t.formId='").append(formId).append("'");
		hql.append(" and  t.cgJsType ='").append(cgJsType).append("'");
		List<CgformEnhanceJsEntity> list = this.findHql(hql.toString());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
}