package com.kd.platform.web.demo.service.impl.test;

import java.io.IOException;
import java.sql.Blob;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kd.platform.web.demo.entity.test.PlatformBlobDataEntity;
import com.kd.platform.web.demo.service.test.PlatformBlobDataServiceI;

import org.hibernate.LobHelper;
import com.kd.platform.core.common.service.impl.CommonServiceImpl;

@Service("platformBlobDataService")
@Transactional
public class PlatformBlobDataServiceImpl extends CommonServiceImpl implements PlatformBlobDataServiceI {

    public void saveObj(String documentTitle, MultipartFile file) {
        PlatformBlobDataEntity obj = new PlatformBlobDataEntity();
        LobHelper lobHelper = commonDao.getSession().getLobHelper();
        Blob data;
        try {
            data = lobHelper.createBlob(file.getInputStream(), 0);
            obj.setAttachmentcontent(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        obj.setAttachmenttitle(documentTitle);
        String sFileName = file.getOriginalFilename();
        int iPos = sFileName.lastIndexOf('.');
        if (iPos >= 0) {
            obj.setExtend(sFileName.substring(iPos + 1));
        }
        super.save(obj);
    }
}
