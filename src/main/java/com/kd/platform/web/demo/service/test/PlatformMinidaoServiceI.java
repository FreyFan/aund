package com.kd.platform.web.demo.service.test;

import java.util.List;

import com.kd.platform.web.demo.entity.test.PlatformMinidaoEntity;

/**
 * Minidao例子
 * @author fancq
 *
 */
public interface PlatformMinidaoServiceI {
	public List<PlatformMinidaoEntity> listAll(PlatformMinidaoEntity platformMinidao, int page, int rows);
	
	public PlatformMinidaoEntity getEntity(Class clazz, String id);
	
	public void insert(PlatformMinidaoEntity platformMinidao);
	
	public void update(PlatformMinidaoEntity platformMinidao);
	
	public void delete(PlatformMinidaoEntity platformMinidao);
	
	public void deleteAllEntitie(List<PlatformMinidaoEntity> entities);
	
	public Integer getCount();
	
	public Integer getSumSalary();
}
