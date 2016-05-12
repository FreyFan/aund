package com.kd.platform.web.demo.service.test;

import com.kd.platform.core.common.service.CommonService;
import org.springframework.web.multipart.MultipartFile;

public interface PlatformBlobDataServiceI extends CommonService{
	public void saveObj(String documentTitle, MultipartFile file);

}
