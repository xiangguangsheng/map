package com.xgs.userManager.vo;

import java.util.Date;

import com.xgs.core.domain.BaseDomain;

public class UserVo extends BaseDomain{
	/**姓名*/
	private String name;
	/**密码*/
	private String password;
	/**邮件*/
	private String email;
	/**身份证*/
	private String idCard;
	/**电话*/
	private String mobile;
	/**地址*/
	private String address;
	/**全拼*/
	private String fullPinyin;
	/**简拼*/
	private String simplePinyin; 
	/**生日*/
	private Date  birthday;
	/**是否为农历生日*/
	private boolean isLunarBirthday;
	/**农历生日*/
	private Date  lunarBirthday;
	/**最后登陆时间*/
	private Date lastLoginTime;
	/**最后登陆IP*/
	private String lastLoginIp;
	/**上一次登陆时间*/
	private Date preLoginTime;
	/**上一次登陆的IP*/
	private String preLoginIp;
	/**是否可用*/
	private boolean enable;
	/**是否激活*/
	private boolean isActivate;
	/**激活时间*/
	private Date activateDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFullPinyin() {
		return fullPinyin;
	}
	public void setFullPinyin(String fullPinyin) {
		this.fullPinyin = fullPinyin;
	}
	public String getSimplePinyin() {
		return simplePinyin;
	}
	public void setSimplePinyin(String simplePinyin) {
		this.simplePinyin = simplePinyin;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isLunarBirthday() {
		return isLunarBirthday;
	}
	public void setLunarBirthday(boolean isLunarBirthday) {
		this.isLunarBirthday = isLunarBirthday;
	}
	public Date getLunarBirthday() {
		return lunarBirthday;
	}
	public void setLunarBirthday(Date lunarBirthday) {
		this.lunarBirthday = lunarBirthday;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Date getPreLoginTime() {
		return preLoginTime;
	}
	public void setPreLoginTime(Date preLoginTime) {
		this.preLoginTime = preLoginTime;
	}
	public String getPreLoginIp() {
		return preLoginIp;
	}
	public void setPreLoginIp(String preLoginIp) {
		this.preLoginIp = preLoginIp;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public boolean isActivate() {
		return isActivate;
	}
	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}
	public Date getActivateDate() {
		return activateDate;
	}
	public void setActivateDate(Date activateDate) {
		this.activateDate = activateDate;
	}
	
	
	
	
}
