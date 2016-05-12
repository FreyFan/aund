package com.kd.platform.web.demo.page;

import java.util.ArrayList;
import java.util.List;

import com.kd.platform.web.demo.entity.test.PlatformOrderCustomEntity;
import com.kd.platform.web.demo.entity.test.PlatformOrderProductEntity;

/**   
 * @Title: Entity
 * @Description: 订单信息 VO
 * @author Frey.Fan
 * @date 2013-03-19 22:01:34
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class PlatformOrderMainPage implements java.io.Serializable {
	/**订单客户明细*/
	private List<PlatformOrderCustomEntity> platformOrderCustomList = new ArrayList<PlatformOrderCustomEntity>();
	public List<PlatformOrderCustomEntity> getPlatformOrderCustomList() {
		return platformOrderCustomList;
	}
	public void setPlatformOrderCustomList(List<PlatformOrderCustomEntity> platformOrderCustomList) {
		this.platformOrderCustomList = platformOrderCustomList;
	}
	/**订单产品明细*/
	private List<PlatformOrderProductEntity> platformOrderProductList = new ArrayList<PlatformOrderProductEntity>();
	public List<PlatformOrderProductEntity> getPlatformOrderProductList() {
		return platformOrderProductList;
	}
	public void setPlatformOrderProductList(List<PlatformOrderProductEntity> platformOrderProductList) {
		this.platformOrderProductList = platformOrderProductList;
	}
}
