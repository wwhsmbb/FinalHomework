
package com.conference.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.entity.ConferenceEmployee;
import com.conference.mapper.EmployeeMapper;
import com.conference.service.IEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	//查询所有员工的信息
	public PageInfo<ConferenceEmployee> queryListEmployee(int pageNum, int pageSize, String parameter) {
		PageHelper.startPage(pageNum, pageSize);// 开始分页
		Map<String, String> map = new HashMap<String, String>();
		map.put("parameter", parameter);
		List<ConferenceEmployee> list = employeeMapper.queryListEmployee(map);
		for (ConferenceEmployee conferenceEmployee : list) {
			if(conferenceEmployee.getEmployeeStatic().equals("1")) {
				conferenceEmployee.setEmployeeStatic("在职");
			}else {
				conferenceEmployee.setEmployeeStatic("离职");
			}
		}
		PageInfo<ConferenceEmployee> pageInfo = new PageInfo<ConferenceEmployee>(list);
		return pageInfo;
	}

	//用来判断新增或删除的
	public ConferenceEmployee employeeBySno(String employeeSno){
		return employeeMapper.employeeBySno(employeeSno);
	}
	
	//添加员工信息
	public int insertEmployee(ConferenceEmployee conferenceEmployee) {
		return employeeMapper.insertEmployee(conferenceEmployee);
	}

	//修改员工信息
	public int updateEmployee(ConferenceEmployee conferenceEmployee) {
		return employeeMapper.updateEmployee(conferenceEmployee);
	}

	//批量删除员工
	public long deleteEmployees(String employeeSno) {
		String[] ss = employeeSno.split(",");
		long count = 0;
		for (String s : ss) {
			employeeMapper.deleteEmployees(s);
			count++;
		}
		return count;
	}

	
	
}
