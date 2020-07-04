package com.conference.entity;

public class ConferenceEmployee {
	private String employeeSno;
	private String loginName;
	private String loginPwd;
	private String employeeName;
	private String employeePhone;
	private String employeeStatic;
	private String result;
	private String msg;
	private String hint;
	/**
	 * 角色
	 */
	private ConferenceRole role;
	
	public ConferenceRole getRole() {
		return role;
	}
	public void setRole(ConferenceRole role) {
		this.role = role;
	}
	public String getEmployeeSno() {
		return employeeSno;
	}
	public void setEmployeeSno(String employeeSno) {
		this.employeeSno = employeeSno;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeStatic() {
		return employeeStatic;
	}
	public void setEmployeeStatic(String employeeStatic) {
		this.employeeStatic = employeeStatic;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	@Override
	public String toString() {
		return "ConferenceEmployee [employeeSno=" + employeeSno + ", loginName=" + loginName + ", loginPwd=" + loginPwd
				+ ", employeeName=" + employeeName + ", employeePhone=" + employeePhone + ", employeeStatic="
				+ employeeStatic + ", result=" + result + ", msg=" + msg + ", hint=" + hint + "]";
	}
}
