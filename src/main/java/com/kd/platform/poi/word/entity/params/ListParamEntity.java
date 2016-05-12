package com.kd.platform.poi.word.entity.params;

/**
 * <b>Application name:</b> ListParamEntity.java <br>
 * <b>Application describing: Excel 对象导出结构</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ListParamEntity {
    // 唯一值,在遍历中重复使用
    public static final String SINGLE = "single";

    // 属于数组类型
    public static final String LIST = "list";

    /**
     * 属性名称
     */
    private String name;

    /**
     * 目标
     */
    private String target;

    /**
     * 当是唯一值的时候直接求出值
     */
    private Object value;

    /**
     * 数据类型,SINGLE || LIST
     */
    private String type;

    public ListParamEntity() {

    }

    public ListParamEntity(String name, Object value) {
        this.name = name;
        this.value = value;
        this.type = LIST;
    }

    public ListParamEntity(String name, String target) {
        this.name = name;
        this.target = target;
        this.type = LIST;
    }

    public String getName() {
        return name;
    }

    public String getTarget() {
        return target;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
