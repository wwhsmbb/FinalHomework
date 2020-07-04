package com.conference.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.conference.entity.ConferenceEmployee;
import com.conference.entity.EmpAttendance;
import com.conference.service.IEmpAttendanceService;
import com.conference.utils.ExportExcelUtil;
import com.conference.utils.ExportExcelWrapper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/attendance")
@RestController
public class EmpAttendanceController {
	
	@Autowired
	private IEmpAttendanceService empAttendanceService;
	
	@GetMapping("/view")
	public ModelAndView view(ModelAndView modelAndView) {
		modelAndView.setViewName("base/attendance_view");
		return modelAndView;
	}
	
	@PostMapping("/page")
	public PageInfo<EmpAttendance> queryListEmployee(HttpServletRequest request) throws Exception{
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String parameter = request.getParameter("parameter");
		String presentDate = request.getParameter("presentDate");
		PageInfo<EmpAttendance> attendancePage = empAttendanceService.queryListAttendance(pageNum, pageSize, parameter, presentDate);
		return attendancePage;
	}
	
	@GetMapping("/employeeView")
	public ModelAndView EmployeeView(ModelAndView modelAndView) {
		modelAndView.setViewName("base/attendance_employeeView");
		return modelAndView;
	}
	
	@PostMapping("/employeePage")
	public PageInfo<EmpAttendance> queryAttendanceBySno(HttpServletRequest request) throws Exception{
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		ConferenceEmployee employee = (ConferenceEmployee) request.getSession().getAttribute("employee");
		String employeeSno = employee.getEmployeeSno();
		String presentDate = request.getParameter("presentDate");
		PageInfo<EmpAttendance> attendancePage = empAttendanceService.queryAttendanceBySno(pageNum, pageSize, employeeSno, presentDate);
		return attendancePage;
	}
	
	@PostMapping("/attendance")
	public EmpAttendance attendance(HttpServletRequest request) {
		EmpAttendance empAttendance = new EmpAttendance();
		ConferenceEmployee employee = (ConferenceEmployee) request.getSession().getAttribute("employee");
		//获取今天的日期 START
		Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 0);//如果把0修改为-1就代表昨天
        date = calendar.getTime();
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        String presentDate = format.format(date);
        SimpleDateFormat format1= new SimpleDateFormat("HH:mm:ss");
        String nowTime = format1.format(date);
        //***********  END

        EmpAttendance attendance = empAttendanceService.attendanceByDate(presentDate);
            empAttendance.setEmployeeSno(employee.getEmployeeSno());
            empAttendance.setEmployeeName(employee.getEmployeeName());
            empAttendance.setPresentDate(presentDate);
            if(attendance != null) {
            	if(attendance.getCheckOut()!=null && attendance.getCheckIn()!=null) {
            		empAttendance.setResult("签到/签退失败");
                 	empAttendance.setMsg("今日已签");
                 	empAttendance.setHint("error");
             
             	}else {
             		empAttendance.setCheckOut(nowTime);
                 	int numTime = Integer.parseInt(nowTime.substring(0,2));
                 	if(numTime<20) {  // 数字为几点
                 		empAttendance.setLeaveEarly(1);
                 		if(attendance.getArriveLate()==empAttendance.getLeaveEarly()) {
                 			if(attendance.getArriveLate()==1) {
                 				empAttendance.setAbsenteeism(1);
                 			}
                 		}else {
                 			empAttendance.setHalfAbsenteeism(1);
                 		}
                 		
                 	}
                 	empAttendanceService.signOut(empAttendance);
                 	empAttendance.setResult("签退成功");
                 	empAttendance.setMsg("今日已签退");
                 	empAttendance.setHint("success");
             	}
            }else {
            	empAttendance.setCheckIn(nowTime);
            	int numTime = Integer.parseInt(nowTime.substring(0,2));
            	if(numTime>8) {  //数字为几点
            		empAttendance.setArriveLate(1);
            		empAttendance.setHalfAbsenteeism(1);
            	}
            	empAttendanceService.signIn(empAttendance);
            	empAttendance.setResult("签到成功");
            	empAttendance.setMsg("今日已签到");
            	empAttendance.setHint("success");
            }
    
		return empAttendance;
	}
	
	@GetMapping("/export")
	public @ResponseBody String exportExcel(HttpServletResponse response,HttpServletRequest request) {
		 response.setContentType("application/binary;charset=UTF-8");
	     String[] titles = {"员工工号", "姓名", "日期", "上班签到时间","下班签到时间","迟到","早退","旷工半天","旷工一天"};
	     try {
	            String fileName="员工考勤信息";
	            List<EmpAttendance> empAttendanceList = empAttendanceService.selectAttendance();
	            ExportExcelWrapper<EmpAttendance> util = new ExportExcelWrapper<EmpAttendance>();
	            util.exportExcel(fileName, fileName, titles, empAttendanceList, response, ExportExcelUtil.EXCEl_FILE_2007);
	              //第一个参数是:生成的文件名
				//  第二个参数:生成Excle表格的标题
				 // 第三个参数:内容标题的集合
				  //第四个参数:你要导出的数据集合
				 // 第五个参数:输出流对象
				  //第六个参数:你要生成Excel的版本
	            return "导出成功";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "导出信息失败";
	        }
	}
}
