package com.conference.service;

import com.conference.entity.ConferenceRoleEmployee;

public interface IRoleEmployeeService {
	
	/**
	 * 添加员工的角色
	 * @param employeeSno
	 * @param roleId
	 * @return
	 */
	public int insertRoleEmployee(ConferenceRoleEmployee conferenceRoleEmployee);
	
	/**
	 * 删除对应员工的角色
	 * @param employeeSno
	 * @return
	 */
	public long deleteRoleEmployee(String employeeSno);
}
