package com.conference.entity;

public class ConferenceRole {
	private String roleId;

	private String roleName;

	private String createUser;

	private String updateUser;

	private int roleLevel;

	private String updateTime;

	private ConferenceUser createUserInfo;

	private ConferenceUser updateUserInfo;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getCreateUser() {
		return createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the createUserInfo
	 */
	public ConferenceUser getCreateUserInfo() {
		return createUserInfo;
	}

	/**
	 * @param createUserInfo
	 *            the createUserInfo to set
	 */
	public void setCreateUserInfo(ConferenceUser createUserInfo) {
		this.createUserInfo = createUserInfo;
	}

	/**
	 * @return the updateUserInfo
	 */
	public ConferenceUser getUpdateUserInfo() {
		return updateUserInfo;
	}

	/**
	 * @param updateUserInfo
	 *            the updateUserInfo to set
	 */
	public void setUpdateUserInfo(ConferenceUser updateUserInfo) {
		this.updateUserInfo = updateUserInfo;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}

	public int getRoleLevel() {
		return roleLevel;
	}
}