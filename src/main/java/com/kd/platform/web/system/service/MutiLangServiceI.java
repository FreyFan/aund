package com.kd.platform.web.system.service;

import com.kd.platform.core.common.service.CommonService;
import com.kd.platform.web.system.pojo.base.MutiLangEntity;

public interface MutiLangServiceI extends CommonService {

    public void initAllMutiLang();

    public String getLang(String lang_key);

    public String getLang(String lang_key, String args);

    public void refleshMutiLangCach();

    /**
     * 更新缓存，插入缓存
     */
    public void putMutiLang(MutiLangEntity mutiLangEntity);

    /**
     * 更新缓存，插入缓存
     */
    public void putMutiLang(String langKey, String langCode, String langContext);
}