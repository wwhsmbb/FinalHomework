package com.conference.mapper;

import com.conference.entity.ConferenceRoleEmployee;

public interface RoleEmployeeMapper {

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
	public int deleteRoleEmployee(String employeeSno);
}
