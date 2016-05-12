package com.kd.platform.web.demo.entity.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * <b>Application name:</b> PlatformMatterBom.java <br>
 * <b>Application describing: 物料Bom</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-2 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Entity
@Table(name = "PLATFORM_MATTER_BOM", schema = "PLATFORM")
public class PlatformMatterBom extends IdEntity {

    /** 编码 */
    private String code;

    /** 上级物料Bom */
    private PlatformMatterBom parent;

    /** 下级物料Bom */
    private List<PlatformMatterBom> children = new ArrayList<PlatformMatterBom>();

    /** 名称 */
    private String name;

    /** 单位 */
    private String unit;

    /** 大小 */
    private String weight;

    /** 价格 */
    private BigDecimal price;

    /** 库存 */
    private Integer stock = 0;

    /** 产地 */
    private String address;

    /** 生产日期 */
    private Date productionDate;

    /** 数量 */
    private Integer quantity = 0;

    /**
     * <li>方法名：getAddress <li>@return 产地 <li>返回类型：String <li>说明：获取产地 <li>创建人：温俊 <li>创建日期：2013-8-11
     * <li>修改人： <li>修改日期：
     */
    @Column(name = "ADDRESS", length = 255)
    public String getAddress() {
        return address;
    }

    /**
     * <li>方法名：setAddress <li>@param address 产地 <li>返回类型：void <li>说明：设置产地 <li>创建人：温俊 <li>
     * 创建日期：2013-8-11 <li>修改人： <li>修改日期：
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <li>方法名：getCode <li>@return 编码 <li>返回类型：String <li>说明：获取编码 <li>创建人：温俊 <li>创建日期：2013-8-11 <li>
     * 修改人： <li>修改日期：
     */
    @Column(name = "CODE", nullable = false, length = 50)
    public String getCode() {
        return code;
    }

    /**
     * <li>方法名：setCode <li>@param code 编码 <li>返回类型：void <li>说明：设置编码 <li>创建人：温俊 <li>创建日期：2013-8-11
     * <li>修改人： <li>修改日期：
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <li>方法名：getName <li>@return 名称 <li>返回类型：String <li>说明：获取名称 <li>创建人：温俊 <li>创建日期：2013-8-11 <li>
     * 修改人： <li>修改日期：
     */
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    /**
     * <li>方法名：setName <li>@param name 名称 <li>返回类型：void <li>说明：设置名称 <li>创建人：温俊 <li>创建日期：2013-8-11
     * <li>修改人： <li>修改日期：
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <li>方法名：getParent <li>@return 上级物料Bom <li>返回类型：PlatformMatterBom <li>说明：获取上级物料Bom <li>创建人：温俊
     * <li>创建日期：2013-8-12 <li>修改人： <li>修改日期：
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    public PlatformMatterBom getParent() {
        return parent;
    }

    /**
     * <li>方法名：setParent <li>@param parent 上级物料Bom <li>返回类型：void <li>说明：设置上级物料Bom <li>创建人：温俊 <li>
     * 创建日期：2013-8-12 <li>修改人： <li>修改日期：
     */
    public void setParent(PlatformMatterBom parent) {
        this.parent = parent;
    }

    /**
     * <li>方法名：getChildren <li>@return 下级物料Bom <li>返回类型：Set<PlatformMatterBom> <li>说明：获取下级物料Bom <li>
     * 创建人：温俊 <li>创建日期：2013-8-12 <li>修改人： <li>修改日期：
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.LAZY)
    @OrderBy("code asc")
    public List<PlatformMatterBom> getChildren() {
        return children;
    }

    /**
     * <li>方法名：setChildren <li>@param children 下级物料Bom <li>返回类型：void <li>说明：设置下级物料Bom <li>创建人：温俊 <li>
     * 创建日期：2013-8-12 <li>修改人： <li>修改日期：
     */
    public void setChildren(List<PlatformMatterBom> children) {
        this.children = children;
    }

    /**
     * <li>方法名：getPrice <li>@return 价格 <li>返回类型：BigDecimal <li>说明：获取价格 <li>创建人：温俊 <li>创建日期：2013-8-12
     * <li>修改人： <li>修改日期：
     */
    @Column(name = "PRICE", nullable = false, precision = 21, scale = 6)
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * <li>方法名：setPrice <li>@param price 价格 <li>返回类型：void <li>说明：设置价格 <li>创建人：温俊 <li>创建日期：2013-8-12
     * <li>修改人： <li>修改日期：
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * <li>方法名：getProductionDate <li>@return 生产日期 <li>返回类型：Date <li>说明：获取生产日期 <li>创建人：温俊 <li>
     * 创建日期：2013-8-12 <li>修改人： <li>修改日期：
     */
    @Column(name = "PRODUCTIONDATE")
    public Date getProductionDate() {
        return productionDate;
    }

    /**
     * <li>方法名：setProductionDate <li>@param productionDate 生产日期 <li>返回类型：void <li>说明：设置生产日期 <li>
     * 创建人：温俊 <li>创建日期：2013-8-12 <li>修改人： <li>修改日期：
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * <li>方法名：getQuantity <li>@return 数量 <li>返回类型：Integer <li>说明：获取数量 <li>创建人：温俊 <li>创建日期：2013-8-12
     * <li>修改人： <li>修改日期：
     */
    @Column(name = "QUANTITY", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * <li>方法名：setQuantity <li>@param quantity 数量 <li>返回类型：void <li>说明：设置数量 <li>创建人：温俊 <li>
     * 创建日期：2013-8-12 <li>修改人： <li>修改日期：
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * <li>方法名：getStock <li>@return 库存 <li>返回类型：Integer <li>说明：获取库存 <li>创建人：温俊 <li>创建日期：2013-8-12
     * <li>修改人： <li>修改日期：
     */
    @Column(name = "STOCK", nullable = false)
    public Integer getStock() {
        return stock;
    }

    /**
     * <li>方法名：setStock <li>@param stock 库存 <li>返回类型：void <li>说明：设置库存 <li>创建人：温俊 <li>创建日期：2013-8-12
     * <li>修改人： <li>修改日期：
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * <li>方法名：getUnit <li>@return 单位 <li>返回类型：String <li>说明：获取单位 <li>创建人：温俊 <li>创建日期：2013-8-12 <li>
     * 修改人： <li>修改日期：
     */
    @Column(name = "UNIT", length = 50)
    public String getUnit() {
        return unit;
    }

    /**
     * <li>方法名：setUnit <li>@param unit 单位 <li>返回类型：void <li>说明：设置单位 <li>创建人：温俊 <li>创建日期：2013-8-12
     * <li>修改人： <li>修改日期：
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * <li>方法名：getWeight <li>@return 大小 <li>返回类型：String <li>说明：获取大小 <li>创建人：温俊 <li>创建日期：2013-8-12
     * <li>修改人： <li>修改日期：
     */
    @Column(name = "WEIGHT", length = 50)
    public String getWeight() {
        return weight;
    }

    /**
     * <li>方法名：setWeight <li>@param weight 大小 <li>返回类型：void <li>说明：设置大小 <li>创建人：温俊 <li>
     * 创建日期：2013-8-12 <li>修改人： <li>修改日期：
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }
}
