package com.kd.platform.web.demo.service.impl.test;

import java.util.List;
import com.kd.platform.web.demo.dao.test.PlatformMinidaoDao;
import com.kd.platform.web.demo.entity.test.PlatformMinidaoEntity;
import com.kd.platform.web.demo.service.test.PlatformMinidaoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>Application name:</b> PlatformMinidaoServiceImpl.java <br>
 * <b>Application describing: Minidao例子</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-2 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Service("platformMinidaoService")
@Transactional
public class PlatformMinidaoServiceImpl implements PlatformMinidaoServiceI {
    @Autowired
    private PlatformMinidaoDao platformMinidaoDao;

    public List<PlatformMinidaoEntity> listAll(PlatformMinidaoEntity platformMinidao, int page, int rows) {
        List<PlatformMinidaoEntity> entities = platformMinidaoDao.getAllEntities2(platformMinidao, page, rows);
        return entities;
    }

    public PlatformMinidaoEntity getEntity(Class clazz, String id) {
        PlatformMinidaoEntity platformMinidao = (PlatformMinidaoEntity) platformMinidaoDao.getByIdHiber(clazz, id);
        return platformMinidao;
    }

    public void insert(PlatformMinidaoEntity platformMinidao) {
        platformMinidaoDao.saveByHiber(platformMinidao);
    }

    public void update(PlatformMinidaoEntity platformMinidao) {
        platformMinidaoDao.updateByHiber(platformMinidao);
    }

    public void delete(PlatformMinidaoEntity platformMinidao) {
        platformMinidaoDao.deleteByHiber(platformMinidao);
    }

    public void deleteAllEntitie(List<PlatformMinidaoEntity> entities) {
        for (PlatformMinidaoEntity entity : entities) {
            platformMinidaoDao.deleteByHiber(entity);
        }
    }

    public Integer getCount() {
        return platformMinidaoDao.getCount();
    }

    public Integer getSumSalary() {
        return platformMinidaoDao.getSumSalary();
    }
}
