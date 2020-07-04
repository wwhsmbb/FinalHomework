package com.conference.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.entity.EmpAttendance;
import com.conference.mapper.EmpAttendanceMapper;
import com.conference.service.IEmpAttendanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EmpAttendanceServiceImpl implements IEmpAttendanceService {

	@Autowired
	private EmpAttendanceMapper empAttendanceMapper;

	//查询所有的考勤信息
	public PageInfo<EmpAttendance> queryListAttendance(int pageNum, int pageSize, String parameter, String presentDate) {
		PageHelper.startPage(pageNum, pageSize);// 开始分页
		Map<String, String> map = new HashMap<String, String>();
		map.put("parameter", parameter);
		map.put("presentDate", presentDate);
		List<EmpAttendance> list = empAttendanceMapper.queryListAttendance(map);
		for (EmpAttendance empAttendance : list) {
			if(empAttendance.getArriveLate()==1) {
				empAttendance.setStrArriveLate("是");
			}else {
				empAttendance.setStrArriveLate("否");
			}
			if(empAttendance.getLeaveEarly()==1) {
				empAttendance.setStrLeaveEarly("是");
			}else {
				empAttendance.setStrLeaveEarly("否");
			}
			if(empAttendance.getHalfAbsenteeism()==1) {
				empAttendance.setStrHalfAbsenteeism("是");
			}else {
				empAttendance.setStrHalfAbsenteeism("否");
			}
			if(empAttendance.getAbsenteeism()==1) {
				empAttendance.setStrAbsenteeism("是");
			}else {
				empAttendance.setStrAbsenteeism("否");
			}
		}
		PageInfo<EmpAttendance> pageInfo = new PageInfo<EmpAttendance>(list);
		return pageInfo;
	}
	
	//查询某个员工的考勤信息
	public PageInfo<EmpAttendance> queryAttendanceBySno(int pageNum, int pageSize, String employeeSno, String presentDate) {
		PageHelper.startPage(pageNum, pageSize);// 开始分页
		Map<String, String> map = new HashMap<String, String>();
		map.put("employeeSno", employeeSno);
		map.put("presentDate", presentDate);
		List<EmpAttendance> list = empAttendanceMapper.queryAttendanceBySno(map);
		for (EmpAttendance empAttendance : list) {
			if(empAttendance.getArriveLate()==1) {
				empAttendance.setStrArriveLate("是");
			}else {
				empAttendance.setStrArriveLate("否");
			}
			if(empAttendance.getLeaveEarly()==1) {
				empAttendance.setStrLeaveEarly("是");
			}else {
				empAttendance.setStrLeaveEarly("否");
			}
			if(empAttendance.getHalfAbsenteeism()==1) {
				empAttendance.setStrHalfAbsenteeism("是");
			}else {
				empAttendance.setStrHalfAbsenteeism("否");
			}
			if(empAttendance.getAbsenteeism()==1) {
				empAttendance.setStrAbsenteeism("是");
			}else {
				empAttendance.setStrAbsenteeism("否");
			}
		}
		PageInfo<EmpAttendance> pageInfo = new PageInfo<EmpAttendance>(list);
		return pageInfo;
	}

	//签到
	public int signIn(EmpAttendance empAttendance) {
		return empAttendanceMapper.signIn(empAttendance);
	}

	//签退
	public int signOut(EmpAttendance empAttendance) {
		return empAttendanceMapper.signOut(empAttendance);
	}

	//判断今签到了没有
	public EmpAttendance attendanceByDate(String presentDate) {
		return empAttendanceMapper.attendanceByDate(presentDate);
	}

	//查询所有的员工考勤信息
	public List<EmpAttendance> selectAttendance() {
		return empAttendanceMapper.selectAttendance();
	}
	
}
