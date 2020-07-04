package com.conference.mapper;

import java.util.List;
import java.util.Map;

import com.conference.entity.EmpAttendance;

public interface EmpAttendanceMapper {
	
	/**
	 * 查询所有的考勤信息
	 * @param map
	 * @return
	 */
	public List<EmpAttendance> queryListAttendance(Map<String, String> map);
	
	/**
	 * 查询某个员工的考勤信息
	 * @param map
	 * @return
	 */
	public List<EmpAttendance> queryAttendanceBySno(Map<String, String> map);
	
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
