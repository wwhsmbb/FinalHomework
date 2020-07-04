package com.conference.entity;

import java.io.Serializable;
import java.util.List;

public class ConferenceMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;  //树权限用
	
	private String name;  //树权限用
	
	private String menuId;

	private String menuName;

	private String pId;

	private String menuUrl;

	private String menuCode;

	private int orderNum;

	private List<ConferenceMenu> childs;

	private String isMenu;
	
	private String menuPic;
	
	/*是否选中*/
	private String isCheck;
	
	/**
	 * @return the isCheck
	 */
	public String getIsCheck() {
		return isCheck;
	}

	/**
	 * @param isCheck the isCheck to set
	 */
	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the menuPic
	 */
	public String getMenuPic() {
		return menuPic;
	}

	/**
	 * @param menuPic the menuPic to set
	 */
	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId == null ? null : menuId.trim();
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId == null ? null : pId.trim();
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl == null ? null : menuUrl.trim();
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setChilds(List<ConferenceMenu> childs) {
		this.childs = childs;
	}

	public List<ConferenceMenu> getChilds() {
		return childs;
	}

	public boolean hasChild() {
		if (childs != null && childs.size() > 0)
			return true;
		return false;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setIsMenu(String isMenu) {
		this.isMenu = isMenu;
	}

	public String getIsMenu() {
		return isMenu;
	}
	

	@Override
	public String toString() {
		return new StringBuffer("menuId:").append(menuId).append(";menuName:").append(menuName).append(";pId:").append(pId).append(";menuUrl:").append(menuUrl).append(";menuCode:")
				.append(menuCode).append(";orderNum:").append(orderNum).append(";isMenu:").append(isMenu).append(";menuPic:").append(menuPic).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj || obj.toString().equals(this.toString()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
