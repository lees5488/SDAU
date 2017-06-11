package com.cn.sdau.pojo;

import java.util.Date;

import com.cn.sdau.vo.BaseVo;

public class DepartmentInfo  extends BaseVo{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8665087860904544059L;

	private Integer id;
	//部门负责人
    private Integer parentId;
    //等级编号
    private String rankNo;
    //部门简称
    private String shortName;
    //部门全称
    private String fullName;
    //部门负责人名称
    private String parentName;
    //部门等级
    private Byte level;
    //使用标志
    private Byte isuse;

    private String remark;

    private Integer createUser;

    private Date createDate;

    private Integer updateUser;

    private Date updateDate;
    
    private int page;
    
    private int rows;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRankNo() {
        return rankNo;
    }

    public void setRankNo(String rankNo) {
        this.rankNo = rankNo == null ? null : rankNo.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getIsuse() {
        return isuse;
    }

    public void setIsuse(Byte isuse) {
        this.isuse = isuse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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



	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}