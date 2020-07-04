package com.conference.service;

import java.util.List;

import com.conference.entity.ConferenceEmployee;
import com.conference.entity.ConferenceMenu;
import com.conference.entity.ConferenceUser;

public interface ILoginService {
	
	/**
	 * 登录用户
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public ConferenceUser loginUser(String loginName,String loginPwd);
	
	/**
	 * 获取左侧菜单
	 * @param userId
	 * @return
	 */
	public List<ConferenceMenu> queryListMenu(String userId);
	
	
	/**
	 * 员工登录
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public ConferenceEmployee loginEmployee(String loginName,String loginPwd);
	
	/**
	 * 获取左侧菜单
	 * @param conferenceSno
	 * @return
	 */
	public List<ConferenceMenu> findListMenu(String employeeSno);
	
}
