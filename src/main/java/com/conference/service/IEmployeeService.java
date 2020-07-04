package com.conference.service;

import com.conference.entity.ConferenceEmployee;
import com.github.pagehelper.PageInfo;

public interface IEmployeeService {
	
	/**
	 * 查询所有员工的信息  实现分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<ConferenceEmployee> queryListEmployee(int pageNum, int pageSize, String parameter);
	
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
	 * @param idList
	 * @return
	 */
	public long deleteEmployees(String employeeSno);
}
