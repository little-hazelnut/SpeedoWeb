package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.sun.media.rtsp.protocol.Request;

import edu.csu.speedo.dto.UserDto;

public class UserInfoDao extends BaseDao {
	//查询用户email是否重复
	public boolean isExist(String emailString){
		boolean isExist = false;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "SELECT * FROM [UserInfo] WHERE [user_email] = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setString(1, emailString);
			resultSet = prst.executeQuery();
			if(resultSet.next())
				//如果用户名已经在数据库中存在，设置标志位true
				isExist = true;
			//关闭结果集
			resultSet.close();
			//释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist;
	}

	//修改用户信息
	public int updateUserById(UserDto userDto,int userId){
		int result = 0;
		System.out.println("Update userId:"+userId);
		PreparedStatement prst = null;
		String sqlString = "UPDATE [UserInfo] SET [user_id] =?,[user_name] =?,[passwd] =?,[userright_id] =?,[user_address] =?,[user_email] =?,[user_phone] =?,[user_score] =?,[user_sex] =?,[user_birthday] =?,[user_icon] =? WHERE [user_id] = ?";
		int userRightId = new UserRightDao().getUserRightIdByName(userDto.getUserRightString());
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, userDto.getUserId());
			prst.setString(2, userDto.getUserNameString());
			prst.setString(3, userDto.getUserPasswordString());
			prst.setInt(4, userRightId);
			prst.setString(5, userDto.getUserAddress());
			prst.setString(6, userDto.getUserEmailString());
			prst.setString(7, userDto.getUserPhoneNumberString());
			prst.setString(8, userDto.getUserScoreString());
			prst.setString(9, userDto.getUserSex());
			prst.setDate(10, userDto.getUserBirthday());
			prst.setString(11, userDto.getUserIconUrlString());
			prst.setInt(12, userId);
			//System.out.println(prst.toString());
			result = prst.executeUpdate();
			//释放连接
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result);

		return result;
	}
	//添加用户
	public int addUser(UserDto userDto) {
		int result =0 ;
		PreparedStatement prst = null;
		String sqlString = "insert into [UserInfo] values(?,?,?,?,?,?,?,?,?,?)";
		int userRightId = new UserRightDao().getUserRightIdByName(userDto.getUserRightString());
		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, userDto.getUserId());
			prst.setString(1, userDto.getUserNameString());
			prst.setString(2, userDto.getUserPasswordString());
			prst.setInt(3, userRightId);
			prst.setString(4, userDto.getUserAddress());
			prst.setString(5, userDto.getUserEmailString());
			prst.setString(6, userDto.getUserPhoneNumberString());
			prst.setString(7, userDto.getUserScoreString());
			prst.setString(8, userDto.getUserSex());
			prst.setDate(9, userDto.getUserBirthday());
			prst.setString(10, userDto.getUserIconUrlString());
			System.out.println(prst.toString());
			result = prst.executeUpdate();
			
			//释放连接
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result);

		return result;

	}

	//验证用户
	public boolean isUser(UserDto userDto){
		boolean isUser = false;
		PreparedStatement prst = null;
		String sqlString = "select * from [UserInfo] where [user_email] = ? and [passwd] = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setString(1, userDto.getUserEmailString());
			prst.setString(2, userDto.getUserPasswordString());
			ResultSet resultSet = prst.executeQuery();
			if(resultSet.next())
				//如果验证登录成功返回true
				isUser = true;
			//关闭结果集
			resultSet.close();
			//释放连接
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(isUser);
		return isUser;
	}
	//删除用户
	public int delUserById(int userId){
		int result =0 ;
		PreparedStatement prst = null;
		String sqlString = "DELETE FROM [UserInfo] WHERE user_id = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, userId);
			result = prst.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result);

		return result;
	}
	//通过用户ID获取用户
	public UserDto getUserById(int userId){
		UserDto userDto = new UserDto();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "SELECT * FROM [UserInfo] WHERE user_id = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, userId);
			resultSet = prst.executeQuery();
			if(resultSet.next()){
				userDto.setUserId(resultSet.getInt(1));
				userDto.setUserNameString(resultSet.getString(2));
				userDto.setUserPasswordString(resultSet.getString(3));
				userDto.setUserRightString(new UserRightDao().getUserRightNameById(resultSet.getInt(4)));
				userDto.setUserAddress(resultSet.getString(5));
				userDto.setUserEmailString(resultSet.getString(6));
				userDto.setUserPhoneNumberString(resultSet.getString(7));
				userDto.setUserScoreString(resultSet.getString(8));
				userDto.setUserSex(resultSet.getString(9));
				userDto.setUserBirthday(resultSet.getDate(10));
				userDto.setUserIconUrlString(resultSet.getString(11));
			}
			//关闭结果集
			resultSet.close();
			//释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDto;
	}
	//获得全部用户
	public ArrayList<UserDto> getAllUser(){
		ArrayList<UserDto> userList = new ArrayList<UserDto>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "SELECT * FROM [UserInfo]";
		try {
			prst = super.connection.prepareStatement(sqlString);
			resultSet = prst.executeQuery();
			while(resultSet.next()){
				UserDto userDto = new UserDto();
				userDto.setUserId(resultSet.getInt(1));
				userDto.setUserNameString(resultSet.getString(2));
				userDto.setUserPasswordString(resultSet.getString(3));
				//userDto.setUserRightId(resultSet.getInt(4));
				userDto.setUserRightString(new UserRightDao().getUserRightNameById(resultSet.getInt(4)));
				userDto.setUserAddress(resultSet.getString(5));
				userDto.setUserEmailString(resultSet.getString(6));
				userDto.setUserPhoneNumberString(resultSet.getString(7));
				userDto.setUserScoreString(resultSet.getString(8));
				userDto.setUserSex(resultSet.getString(9));
				userDto.setUserBirthday(resultSet.getDate(10));
				userDto.setUserIconUrlString(resultSet.getString(11));
				userList.add(userDto);
			}
			//关闭结果集
			resultSet.close();
			//释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	//通过email返回对应UserInfoDto
	//通过用户ID获取用户
		public UserDto getUserByEmail(String userEmail){
			UserDto userDto = new UserDto();
			PreparedStatement prst = null;
			ResultSet resultSet = null;
			String sqlString = "SELECT * FROM [UserInfo] WHERE [user_email] = ?";
			try {
				prst = super.connection.prepareStatement(sqlString);
				prst.setString(1, userEmail);
				resultSet = prst.executeQuery();
				if(resultSet.next()){
					userDto.setUserId(resultSet.getInt(1));
					userDto.setUserNameString(resultSet.getString(2));
					userDto.setUserPasswordString(resultSet.getString(3));
					userDto.setUserRightString(new UserRightDao().getUserRightNameById(resultSet.getInt(4)));
					userDto.setUserAddress(resultSet.getString(5));
					userDto.setUserEmailString(resultSet.getString(6));
					userDto.setUserPhoneNumberString(resultSet.getString(7));
					userDto.setUserScoreString(resultSet.getString(8));
					userDto.setUserSex(resultSet.getString(9));
					userDto.setUserBirthday(resultSet.getDate(10));
					userDto.setUserIconUrlString(resultSet.getString(11));
				}
				//关闭结果集
				resultSet.close();
				//释放connection
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userDto;
		}
}
