package com.kd.platform.web.sms.service.impl;

import java.io.Serializable;
import java.net.ConnectException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.mail.AuthenticationFailedException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kd.platform.core.common.service.impl.CommonServiceImpl;
import com.kd.platform.core.util.LogUtil;
import com.kd.platform.core.util.PropertiesUtil;
import com.kd.platform.web.sms.entity.TSSmsEntity;
import com.kd.platform.web.sms.service.TSSmsServiceI;
import com.kd.platform.web.sms.util.CMPPSenderUtil;
import com.kd.platform.web.sms.util.Constants;
import com.kd.platform.web.sms.util.MailUtil;
import com.sun.mail.smtp.SMTPAddressFailedException;

@Service("tSSmsService")
@Transactional
public class TSSmsServiceImpl extends CommonServiceImpl implements TSSmsServiceI {

    /**
     * 消息发送接口实现
     */
    @Transactional
    public void send() {
        LogUtil.info("===============消息发送扫描开始=================");
        // 对发送失败的信息重新发送
        // List<TSSmsEntity> smsSendList =
        // findHql("from TSSmsEntity e where e.esStatus = ? or e.esStatus = ? ",
        // Constants.SMS_SEND_STATUS_1, Constants.SMS_SEND_STATUS_3);
        List<TSSmsEntity> smsSendList = findHql("from TSSmsEntity e where e.esStatus = ?", Constants.SMS_SEND_STATUS_1);
        if (smsSendList == null || smsSendList.size() == 0) {
            return;
        }
        PropertiesUtil util = new PropertiesUtil("sysConfig.properties");
        for (TSSmsEntity tsSmsEntity : smsSendList) {
            String remark = "";
            if (Constants.SMS_SEND_TYPE_2.equals(tsSmsEntity.getEsType())) {
                // 邮件
                try {
                    MailUtil.sendEmail(util.readProperty("mail.smtpHost"), tsSmsEntity.getEsReceiver(), tsSmsEntity.getEsTitle(), tsSmsEntity.getEsContent(), util.readProperty("mail.sender"), util.readProperty("mail.user"), util.readProperty("mail.pwd"));
                    tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_2);
                    tsSmsEntity.setEsSendtime(new Date());
                    remark = "发送成功";
                    tsSmsEntity.setRemark(remark);
                    updateEntitie(tsSmsEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (e instanceof AuthenticationFailedException) {
                        remark = "认证失败错误的用户名或者密码";
                    } else if (e instanceof SMTPAddressFailedException) {
                        remark = "接受邮箱格式不对";
                    } else if (e instanceof ConnectException) {
                        remark = "邮件服务器连接失败";
                    } else {
                        remark = e.getMessage();
                    }
                    tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_3);
                    tsSmsEntity.setEsSendtime(new Date());
                    tsSmsEntity.setRemark(remark);
                    updateEntitie(tsSmsEntity);
                }
            } else if (Constants.SMS_SEND_TYPE_1.equals(tsSmsEntity.getEsType())) {
                // 短信
                String r = CMPPSenderUtil.sendMsg(tsSmsEntity.getEsReceiver(), tsSmsEntity.getEsContent());
                if ("0".equals(r)) {
                    tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_2);
                } else {
                    tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_3);
                }
            }
            // 更新发送状态
            tsSmsEntity.setRemark(remark);
            tsSmsEntity.setEsSendtime(new Date());
            updateEntitie(tsSmsEntity);
        }
        LogUtil.info("===============消息发送扫描结束=================");
    }
}
