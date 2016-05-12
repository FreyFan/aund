package com.kd.platform.web.cgform.entity.generate;

import java.util.List;

import com.kd.platform.codegenerate.pojo.onetomany.SubTableEntity;

/**
 * <b>Application name:</b> GenerateSubListEntity.java <br>
 * <b>Application describing: 代码生成一对多模型</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-7 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class GenerateSubListEntity {
    private String projectPath;

    private String packageStyle;

    /**
     * 代码生成的物理配置
     */
    private List<SubTableEntity> subTabParamIn;

    public List<SubTableEntity> getSubTabParamIn() {
        return subTabParamIn;
    }

    public void setSubTabParamIn(List<SubTableEntity> subTabParamIn) {
        this.subTabParamIn = subTabParamIn;
    }

    public String getProjectPath() {
        String pt = projectPath;
        if (pt != null) {
            pt = pt.replace("\\", "/");
            if (!pt.endsWith("/")) {
                pt = pt + "/";
            }
        }
        return pt;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getPackageStyle() {
        return packageStyle;
    }

    public void setPackageStyle(String packageStyle) {
        this.packageStyle = packageStyle;
    }
}
