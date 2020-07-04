package com.conference.entity;

public class EmpAttendance {
	private String employeeSno;
	private String employeeName;
	private String presentDate;
	private String checkIn;
	private String checkOut;
	private int arriveLate;
	private int leaveEarly;
	private int halfAbsenteeism;
	private int absenteeism;
	
	private String strArriveLate;
	private String strLeaveEarly;
	private String strHalfAbsenteeism;
	private String strAbsenteeism;
	
	
	private String result;
	private String msg;
	private String hint;
	
	
	public String getStrArriveLate() {
		return strArriveLate;
	}
	public void setStrArriveLate(String strArriveLate) {
		this.strArriveLate = strArriveLate;
	}
	public String getStrLeaveEarly() {
		return strLeaveEarly;
	}
	public void setStrLeaveEarly(String strLeaveEarly) {
		this.strLeaveEarly = strLeaveEarly;
	}
	public String getStrHalfAbsenteeism() {
		return strHalfAbsenteeism;
	}
	public void setStrHalfAbsenteeism(String strHalfAbsenteeism) {
		this.strHalfAbsenteeism = strHalfAbsenteeism;
	}
	public String getStrAbsenteeism() {
		return strAbsenteeism;
	}
	public void setStrAbsenteeism(String strAbsenteeism) {
		this.strAbsenteeism = strAbsenteeism;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getEmployeeSno() {
		return employeeSno;
	}
	public void setEmployeeSno(String employeeSno) {
		this.employeeSno = employeeSno;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPresentDate() {
		return presentDate;
	}
	public void setPresentDate(String presentDate) {
		this.presentDate = presentDate;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public int getArriveLate() {
		return arriveLate;
	}
	public void setArriveLate(int arriveLate) {
		this.arriveLate = arriveLate;
	}
	public int getLeaveEarly() {
		return leaveEarly;
	}
	public void setLeaveEarly(int leaveEarly) {
		this.leaveEarly = leaveEarly;
	}
	public int getHalfAbsenteeism() {
		return halfAbsenteeism;
	}
	public void setHalfAbsenteeism(int halfAbsenteeism) {
		this.halfAbsenteeism = halfAbsenteeism;
	}
	public int getAbsenteeism() {
		return absenteeism;
	}
	public void setAbsenteeism(int absenteeism) {
		this.absenteeism = absenteeism;
	}
	@Override
	public String toString() {
		return "EmpAttendance [employeeSno=" + employeeSno + ", employeeName="
				+ employeeName + ", presentDate=" + presentDate + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", arriveLate=" + arriveLate + ", leaveEarly=" + leaveEarly + ", halfAbsenteeism=" + halfAbsenteeism
				+ ", absenteeism=" + absenteeism + "]";
	}
}
