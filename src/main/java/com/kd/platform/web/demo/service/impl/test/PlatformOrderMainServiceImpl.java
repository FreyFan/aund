package com.kd.platform.web.demo.service.impl.test;

import java.util.List;

import com.kd.platform.web.demo.entity.test.PlatformOrderCustomEntity;
import com.kd.platform.web.demo.entity.test.PlatformOrderMainEntity;
import com.kd.platform.web.demo.entity.test.PlatformOrderProductEntity;
import com.kd.platform.web.demo.service.test.PlatformOrderMainServiceI;

import com.kd.platform.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("platformOrderMainService")
@Transactional
public class PlatformOrderMainServiceImpl extends CommonServiceImpl implements PlatformOrderMainServiceI {

    public void addMain(PlatformOrderMainEntity platformOrderMain, List<PlatformOrderProductEntity> platformOrderProducList, List<PlatformOrderCustomEntity> platformOrderCustomList) {
        // 保存订单主信息
        this.save(platformOrderMain);
        // 保存订单产品明细
        for (PlatformOrderProductEntity product : platformOrderProducList) {
            // 外键设置
            product.setGoOrderCode(platformOrderMain.getGoOrderCode());
            this.save(product);
        }
        // 保存订单客户明细
        for (PlatformOrderCustomEntity custom : platformOrderCustomList) {
            // 外键设置
            custom.setGoOrderCode(platformOrderMain.getGoOrderCode());
            this.save(custom);
        }
    }

    public void updateMain(PlatformOrderMainEntity platformOrderMain, List<PlatformOrderProductEntity> platformOrderProducList, List<PlatformOrderCustomEntity> platformOrderCustomList, boolean platformOrderCustomShow) {
        // 保存订单主信息
        this.saveOrUpdate(platformOrderMain);
        // 删除订单产品明细
        this.commonDao.deleteAllEntitie(this.findByProperty(PlatformOrderProductEntity.class, "goOrderCode", platformOrderMain.getGoOrderCode()));
        // 保存订单产品明细
        for (PlatformOrderProductEntity product : platformOrderProducList) {
            // 外键设置
            product.setGoOrderCode(platformOrderMain.getGoOrderCode());
            this.save(product);
        }
        if (platformOrderCustomShow) {
            // 删除订单客户明细
            this.commonDao.deleteAllEntitie(this.findByProperty(PlatformOrderCustomEntity.class, "goOrderCode", platformOrderMain.getGoOrderCode()));
            // 保存订单客户明细
            for (PlatformOrderCustomEntity custom : platformOrderCustomList) {
                // 外键设置
                custom.setGoOrderCode(platformOrderMain.getGoOrderCode());
                this.save(custom);
            }
        }
    }

    public void delMain(PlatformOrderMainEntity platformOrderMain) {
        // 删除主表信息
        this.delete(platformOrderMain);
        // 删除订单产品明细
        this.deleteAllEntitie(this.findByProperty(PlatformOrderProductEntity.class, "goOrderCode", platformOrderMain.getGoOrderCode()));
        // 删除订单客户明细
        this.commonDao.deleteAllEntitie(this.findByProperty(PlatformOrderCustomEntity.class, "goOrderCode", platformOrderMain.getGoOrderCode()));
    }
}
