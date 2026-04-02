package me.nhom65.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import me.nhom65.model.User;
import me.nhom65.util.DatabaseConnection;

public class UserDAO {

	public List<User> getAllUsers() {
		Connection conn = null;
		List<User> resultList = new ArrayList<User>();
		try {
			conn = DatabaseConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM users;");
			while (result.next()) {
				int userid = result.getInt("user_id");
				String username = result.getString("username");
				String password = result.getString("password_hash");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String address = result.getString("address");
				int role = result.getInt("role_id");
				Timestamp create_at = result.getTimestamp("created_at");
				User student = new User(userid, username, password, email, phone, address, role, create_at);
				resultList.add(student);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	
	
	public User findByUsername(String username) {
		Connection conn = null;
		try  {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					int userid = rs.getInt("user_id");
					String uname = rs.getString("username");
					String pass = rs.getString("password_hash");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					int role = rs.getInt("role_id");
					Timestamp createAt = rs.getTimestamp("created_at"); 
					return new User(userid, uname, pass,email, phone, address, role, createAt);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
	public User findByUsernameAndPassword(String username, String password_hash) {
		
		Connection conn = null;
		try  {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM users WHERE username = ? AND password_hash = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password_hash); 
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					int userid = rs.getInt("user_id");
					String uname = rs.getString("username");
					String pass = rs.getString("password_hash");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					int role = rs.getInt("role_id");
					Timestamp createAt = rs.getTimestamp("created_at"); 
					return new User(userid, uname, email,pass, phone, address, role, createAt);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public boolean insert(User user) {
		Connection conn = null;
		try  {
			conn = DatabaseConnection.getConnection();
			String sql = "INSERT INTO users (username, password_hash, email, phone, address, role_id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPasswordHash());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getAddress());
			ps.setInt(6, user.getRoleId());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean createUser(String username, String password_hash, String gmail, String phone, String address) {
		Connection conn = null;

		try {
			conn = DatabaseConnection.getConnection();

			String sql = "INSERT INTO users (username, password_hash, email, phone, address, role_id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password_hash);
			ps.setString(3, gmail);
			ps.setString(4, phone);
			ps.setString(5, address);
			ps.setInt(6, 1); 
			int rows = ps.executeUpdate();
			ps.close();

			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
