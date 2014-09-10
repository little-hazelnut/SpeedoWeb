package edu.csu.speedo.dto;

import java.sql.Date;

public class UserDto {


	private int userId;
	private String userNameString;
	private String userEmailString;
	private String userPasswordString;
	private String userRightString;
	private String userAddress ;
	private String userPhoneNumberString;
	private String userScoreString;
	private String userSex;
	private Date userBirthday;
	private String userIconUrlString;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserNameString() {
		return userNameString;
	}
	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}
	public String getUserEmailString() {
		return userEmailString;
	}
	public void setUserEmailString(String userEmailString) {
		this.userEmailString = userEmailString;
	}
	public String getUserPasswordString() {
		return userPasswordString;
	}
	public void setUserPasswordString(String userPasswordString) {
		this.userPasswordString = userPasswordString;
	}
	public String getUserRightString() {
		return userRightString;
	}
	public void setUserRightString(String userRightString) {
		this.userRightString = userRightString;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhoneNumberString() {
		return userPhoneNumberString;
	}
	public void setUserPhoneNumberString(String userPhoneNumberString) {
		this.userPhoneNumberString = userPhoneNumberString;
	}
	public String getUserScoreString() {
		return userScoreString;
	}
	public void setUserScoreString(String userScoreString) {
		this.userScoreString = userScoreString;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserIconUrlString() {
		return userIconUrlString;
	}
	public void setUserIconUrlString(String userIconUrlString) {
		this.userIconUrlString = userIconUrlString;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.userNameString;
	}
	
}
