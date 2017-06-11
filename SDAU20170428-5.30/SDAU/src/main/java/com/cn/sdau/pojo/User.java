package com.cn.sdau.pojo;

import java.util.Date;

import com.cn.sdau.vo.BaseVo;

public class User extends BaseVo{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6806811548482990454L;

	private Integer id;

    private String userName;

    private String password;

    private Integer age;
    
    private String address;
    
    private String phone;
    
    private int createUser;
    
    private int updateUser;
    
    private String createUserStr;
    
    private String updateUserStr;
    
    private Date createDate;
    
    private Date updateDate;
    
    private String createDateStr;
    
    private String updateDateStr;
    
	private int page;
	
	private int rows;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCreateUser() {
		return createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public int getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}

	public String getCreateUserStr() {
		return createUserStr;
	}

	public void setCreateUserStr(String createUserStr) {
		this.createUserStr = createUserStr;
	}

	public String getUpdateUserStr() {
		return updateUserStr;
	}

	public void setUpdateUserStr(String updateUserStr) {
		this.updateUserStr = updateUserStr;
	}
	
}