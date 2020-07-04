package com.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.entity.ConferenceRoleEmployee;
import com.conference.mapper.RoleEmployeeMapper;
import com.conference.service.IRoleEmployeeService;

@Service
public class RoleEmployeeServiceImpl implements IRoleEmployeeService {

	@Autowired
	private RoleEmployeeMapper roleEmployeeMapper;
	
	//添加员工的角色
	public int insertRoleEmployee(ConferenceRoleEmployee conferenceRoleEmployee) {
		return roleEmployeeMapper.insertRoleEmployee(conferenceRoleEmployee);
	}

	//删除对应员工的角色
	public long deleteRoleEmployee(String employeeSno) {
		String[] ss = employeeSno.split(",");
		long count = 0;
		for (String s : ss) {
			roleEmployeeMapper.deleteRoleEmployee(s);
			count++;
		}
		return count;
	}
	
}
