package com.kd.platform.codegenerate.pojo;

/**
 * <b>Application name:</b> CreateFileProperty.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CreateFileProperty {
    private boolean actionFlag;

    private boolean serviceIFlag;

    private boolean entityFlag;

    private boolean pageFlag;

    private boolean serviceImplFlag;

    private boolean jspFlag;

    private String jspMode;

    public boolean isActionFlag() {
        return this.actionFlag;
    }

    public boolean isServiceIFlag() {
        return this.serviceIFlag;
    }

    public boolean isEntityFlag() {
        return this.entityFlag;
    }

    public boolean isPageFlag() {
        return this.pageFlag;
    }

    public boolean isServiceImplFlag() {
        return this.serviceImplFlag;
    }

    public void setActionFlag(boolean actionFlag) {
        this.actionFlag = actionFlag;
    }

    public void setServiceIFlag(boolean serviceIFlag) {
        this.serviceIFlag = serviceIFlag;
    }

    public void setEntityFlag(boolean entityFlag) {
        this.entityFlag = entityFlag;
    }

    public void setPageFlag(boolean pageFlag) {
        this.pageFlag = pageFlag;
    }

    public void setServiceImplFlag(boolean serviceImplFlag) {
        this.serviceImplFlag = serviceImplFlag;
    }

    public boolean isJspFlag() {
        return this.jspFlag;
    }

    public void setJspFlag(boolean jspFlag) {
        this.jspFlag = jspFlag;
    }

    public String getJspMode() {
        return this.jspMode;
    }

    public void setJspMode(String jspMode) {
        this.jspMode = jspMode;
    }
}
