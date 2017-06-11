package com.cn.sdau.pojo;

public class SystemRegion {
    private Integer regionId;

    private Integer parentId;

    private String regionName;

    private Byte regionType;

    private Byte isDelete;

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Byte getRegionType() {
        return regionType;
    }

    public void setRegionType(Byte regionType) {
        this.regionType = regionType;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}