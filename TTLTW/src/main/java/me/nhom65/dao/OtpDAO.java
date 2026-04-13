package me.nhom65.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import me.nhom65.model.OTP;
import me.nhom65.model.User;
import me.nhom65.util.DatabaseConnection;

public class OtpDAO {

	
	public boolean createOtp(User user,String type, String randomotp, Timestamp expireTime) {
		Connection conn = null;

		try {
			conn = DatabaseConnection.getConnection();

			String sql = "INSERT INTO otps (user_id, otp_hash, type, expired_at) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getUsedId());
			ps.setString(2, randomotp);
			ps.setString(3, type);
			ps.setTimestamp(4, expireTime);
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

	public OTP getOtp(String username, String type) {
		Connection conn = null;
		try  {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT o.* FROM otps o JOIN users u ON o.user_id = u.user_id WHERE u.username = ? AND o.type = ? AND o.expired_at > CURRENT_TIMESTAMP AND o.is_used = 0 ORDER BY o.otp_id DESC LIMIT 1;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, type);
			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					int id = rs.getInt("otp_id");
					int userid = rs.getInt("user_id");
					String otp_hash = rs.getString("otp_hash");
					String typeotp = rs.getString("type");
					int isused = rs.getInt("is_used");
					int attemptcount = rs.getInt("attempt_count");
					Timestamp createat = rs.getTimestamp("created_at");
					Timestamp expireat = rs.getTimestamp("expired_at");
					return new OTP(id,userid,otp_hash,typeotp,isused,attemptcount,createat,expireat);
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

	public OTP getOtpFromCode(String username, String type, String otpinput) {
		Connection conn = null;
		try  {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT o.* FROM otps o JOIN users u ON o.user_id = u.user_id WHERE u.username = ? AND o.otp_hash = ? AND o.type = ? AND o.expired_at > CURRENT_TIMESTAMP AND o.is_used = 0 ORDER BY o.otp_id DESC LIMIT 1;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, otpinput);
			ps.setString(3, type);
			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					int id = rs.getInt("otp_id");
					int userid = rs.getInt("user_id");
					String otp_hash = rs.getString("otp_hash");
					String typeotp = rs.getString("type");
					int isused = rs.getInt("is_used");
					int attemptcount = rs.getInt("attempt_count");
					Timestamp createat = rs.getTimestamp("created_at");
					Timestamp expireat = rs.getTimestamp("expired_at");
					return new OTP(id,userid,otp_hash,typeotp,isused,attemptcount,createat,expireat);
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
	public boolean activeOTP(int userId, String type, String otpinput) {
		Connection conn = null;
		try  {
			conn = DatabaseConnection.getConnection();
			String sql = "UPDATE otps SET is_used = 1 WHERE user_id = ? AND otp_hash = ? AND type = ? AND is_used = 0 AND expired_at > CURRENT_TIMESTAMP;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, otpinput);
			ps.setString(3, type);
			return ps.executeUpdate() > 0;	
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
		return false;
	}

	public boolean isUnActiveOTP(String username, String type) {
		Connection conn = null;
		try  {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT 1 FROM otps o JOIN users u ON o.user_id = u.user_id WHERE u.username = ? AND o.type = ? AND o.expired_at > CURRENT_TIMESTAMP AND o.is_used = 0 LIMIT 1;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, type);
			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					return true;
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
		return false;
	}
}
