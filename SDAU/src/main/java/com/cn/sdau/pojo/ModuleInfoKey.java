package com.cn.sdau.pojo;

public class ModuleInfoKey {
    private String moduleNo;

    private String parentModuleNo;

    public String getModuleNo() {
        return moduleNo;
    }

    public void setModuleNo(String moduleNo) {
        this.moduleNo = moduleNo == null ? null : moduleNo.trim();
    }

    public String getParentModuleNo() {
        return parentModuleNo;
    }

    public void setParentModuleNo(String parentModuleNo) {
        this.parentModuleNo = parentModuleNo == null ? null : parentModuleNo.trim();
    }
}