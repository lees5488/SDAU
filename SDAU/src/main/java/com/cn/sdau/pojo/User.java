package com.cn.sdau.pojo;

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
}