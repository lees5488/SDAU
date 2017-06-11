package com.cn.sdau.pojo;

public class RoleResourceKey {
    private String roleNo;

    private String pageNo;

    private String functionNo;

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo == null ? null : roleNo.trim();
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo == null ? null : pageNo.trim();
    }

    public String getFunctionNo() {
        return functionNo;
    }

    public void setFunctionNo(String functionNo) {
        this.functionNo = functionNo == null ? null : functionNo.trim();
    }
}