package com.kd.platform.web.demo.service.test;

import com.kd.platform.web.demo.entity.test.WebOfficeEntity;

import com.kd.platform.core.common.service.CommonService;
import org.springframework.web.multipart.MultipartFile;

public interface WebOfficeServiceI extends CommonService{
	public void saveObj(WebOfficeEntity docObj, MultipartFile file);
}
