package com.cn.sdau.pojo;

public class ModulePageKey {
    private String moduleNo;

    private String pageNo;

    public String getModuleNo() {
        return moduleNo;
    }

    public void setModuleNo(String moduleNo) {
        this.moduleNo = moduleNo == null ? null : moduleNo.trim();
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo == null ? null : pageNo.trim();
    }
}