package com.kd.platform.core.common.model.json;

/**
 * <b>Application name:</b> ValidForm.java <br>
 * <b>Application describing: $.ajax后需要接受的JSON</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan  版权所有。<br>
 * <b>Company:</b> Frey.Fan  <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ValidForm {

    private String status = "y";// 是否成功

    private String info = "验证通过";// 提示信息

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
