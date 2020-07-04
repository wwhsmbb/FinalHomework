package com.conference.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.conference.entity.ConferenceEmployee;
import com.conference.entity.ConferenceMenu;
import com.conference.entity.ConferenceUser;

@Mapper
public interface LoginMapper {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public ConferenceUser loginUser(Map<String, String> map);
	
	/**
	 * 获取左侧菜单
	 * @return
	 */
	public List<ConferenceMenu> queryListMenu(String userId);
	

	/**
	 * 员工登录
	 * @param map
	 * @return
	 */
	public ConferenceEmployee loginEmployee(Map<String, String> map);
	
	/**
	 * 获取左侧菜单
	 * @param conferenceSno
	 * @return
	 */
	public List<ConferenceMenu> findListMenu(String employeeSno);
}
