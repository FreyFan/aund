package com.kd.platform.web.system.pojo.base;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * TLog entity.
 * @author Frey.Fan
 */
@Entity
@Table(name = "T_S_FILENO", schema = "PLATFORM")
public class TSFileno extends IdEntity implements java.io.Serializable {
    private String filenoBefore;

    private int filenoNum;

    private Date filenoYear;

    private String filenoType;

    @Column(name = "FILENOBEFORE", length = 32)
    public String getFilenoBefore() {
        return filenoBefore;
    }

    public void setFilenoBefore(String filenoBefore) {
        this.filenoBefore = filenoBefore;
    }

    @Column(name = "FILENONUM")
    public int getFilenoNum() {
        return filenoNum;
    }

    public void setFilenoNum(int filenoNum) {
        this.filenoNum = filenoNum;
    }

    @Column(name = "FILENOTYPE", length = 32)
    public String getFilenoType() {
        return filenoType;
    }

    public void setFilenoType(String filenoType) {
        this.filenoType = filenoType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FILENOYEAR", length = 13)
    public Date getFilenoYear() {
        return filenoYear;
    }

    public void setFilenoYear(Date filenoYear) {
        this.filenoYear = filenoYear;
    }
}
