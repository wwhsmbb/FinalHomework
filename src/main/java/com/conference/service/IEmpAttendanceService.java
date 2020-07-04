package com.conference.service;

import java.util.List;

import com.conference.entity.EmpAttendance;
import com.github.pagehelper.PageInfo;

public interface IEmpAttendanceService {
	
	/**
	 * 查询所有的考勤信息 实现分页
	 * @param pageNum
	 * @param pageSize
	 * @param employeeSno
	 * @param present_date
	 * @return
	 */
	public PageInfo<EmpAttendance> queryListAttendance(int pageNum, int pageSize, String parameter, String presentDate);
	
	/**
	 * 查询某个员工的考勤信息
	 * @param pageNum
	 * @param pageSize
	 * @param employeeSno
	 * @param presentDate
	 * @return
	 */
	public PageInfo<EmpAttendance> queryAttendanceBySno(int pageNum, int pageSize, String employeeSno, String presentDate);
	
	/**
	 * 签到
	 * @param empAttendance
	 * @return
	 */
	public int signIn(EmpAttendance empAttendance);
	
	
	/**
	 * 签退
	 * @param empAttendance
	 * @return
	 */
	public int signOut(EmpAttendance empAttendance);
	
	/**
	 * 判断今天签到了没有
	 * @param presentDate
	 * @return
	 */
	public EmpAttendance attendanceByDate(String presentDate);
	
	/**
	 * 查询所有的员工考勤信息
	 * @return
	 */
	public List<EmpAttendance> selectAttendance();
	
}
