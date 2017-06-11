package com.cn.sdau.pojo;

import java.util.Date;

public class EventConsummation {
    private String consummationNo;

    private String eventNo;

    private String remark;

    private Date createDate;

    private Integer createUser;

    private Integer updateUser;

    private Date updateDate;

    public String getConsummationNo() {
        return consummationNo;
    }

    public void setConsummationNo(String consummationNo) {
        this.consummationNo = consummationNo == null ? null : consummationNo.trim();
    }

    public String getEventNo() {
        return eventNo;
    }

    public void setEventNo(String eventNo) {
        this.eventNo = eventNo == null ? null : eventNo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}