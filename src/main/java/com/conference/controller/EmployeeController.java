package com.conference.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.conference.entity.ConferenceEmployee;
import com.conference.entity.ConferenceRoleEmployee;
import com.conference.service.IEmployeeService;
import com.conference.service.IRoleEmployeeService;
import com.github.pagehelper.PageInfo;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IRoleEmployeeService roleEmployeeService;
	
	@GetMapping("/view")
	public ModelAndView view(ModelAndView modelAndView) {
		modelAndView.setViewName("base/employee_view");
		return modelAndView;
	}
	
	@PostMapping("/page")
	public PageInfo<ConferenceEmployee> queryListEmployee(HttpServletRequest request) throws Exception{
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String parameter = request.getParameter("parameter");
		PageInfo<ConferenceEmployee> employeePage = (PageInfo<ConferenceEmployee>) employeeService.queryListEmployee(pageNum, pageSize,parameter);
		return employeePage;
	}
	
	@PostMapping("/add")
	public int insertEmployee(ConferenceEmployee conferenceEmployee) {
		
		ConferenceEmployee employee = employeeService.employeeBySno(conferenceEmployee.getEmployeeSno());
		if(employee != null) {
			System.out.println("修改");
			return employeeService.updateEmployee(conferenceEmployee);
		}else {
			System.out.println("添加");
			ConferenceRoleEmployee conferenceRoleEmployee = new ConferenceRoleEmployee();
			conferenceRoleEmployee.setRoleId("RID002");
			conferenceRoleEmployee.setEmployeeSno(conferenceEmployee.getEmployeeSno());
			roleEmployeeService.insertRoleEmployee(conferenceRoleEmployee);
			return employeeService.insertEmployee(conferenceEmployee);
		}
	}
	
	@PostMapping("/delete")
	public ConferenceEmployee deleteEmployees(String employeeSno) {
		ConferenceEmployee conferenceEmployee = new ConferenceEmployee();
		long count = employeeService.deleteEmployees(employeeSno);
		if(count > 0) {
			roleEmployeeService.deleteRoleEmployee(employeeSno);
			conferenceEmployee.setResult("删除成功");
			conferenceEmployee.setMsg("您已成功删除了"+count+"名员工。");
			conferenceEmployee.setHint("success");
		}else {
			conferenceEmployee.setResult("删除失败");
			conferenceEmployee.setMsg("对不起，出了点意外的小问题，请耐心等待。。。。");
			conferenceEmployee.setHint("error");
		}
		return conferenceEmployee;
	}
	
}
