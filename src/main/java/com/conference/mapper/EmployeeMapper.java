package com.conference.mapper;

import java.util.List;
import java.util.Map;

import com.conference.entity.ConferenceEmployee;

public interface EmployeeMapper {
	/**
	 * 查询所有员工的信息
	 * @param map
	 * @return
	 */
	public List<ConferenceEmployee> queryListEmployee(Map<String, String> map);
	
	/**
	 * 用来判断新增或删除的
	 * @param employeeSno
	 * @return
	 */
	public ConferenceEmployee employeeBySno(String employeeSno);
	
	/**
	 * 添加员工信息
	 * @param conferenceEmployee
	 * @return
	 */
	public int insertEmployee(ConferenceEmployee conferenceEmployee);
	
	/**
	 * 修改员工信息
	 * @param conferenceEmployee
	 * @return
	 */
	public int updateEmployee(ConferenceEmployee conferenceEmployee);
	
	/**
	 * 批量删除员工
	 * @param employeeSon
	 * @return
	 */
	public int deleteEmployees(String employeeSno);
}
