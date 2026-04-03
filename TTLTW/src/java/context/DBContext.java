package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    /* CHỈ CẦN THAY ĐỔI CÁC THÔNG SỐ DƯỚI ĐÂY */
    private final String serverName = "localhost";
    private final String dbName = "webppp"; // Tên schema trong MySQL Workbench
    private final String portNumber = "3306";
    private final String instance = ""; // MySQL thường không dùng instance như SQL Server
    private final String userID = "root";
    private final String password = "mysql";

    public Connection getConnection() throws Exception {
        // 1. Khai báo Driver của MySQL (Phải có file mysql-connector-j-xxx.jar trong thư viện)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // 2. Tạo URL theo chuẩn MySQL
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName + "?serverTimezone=UTC";
        
        // 3. Trả về kết nối
        return DriverManager.getConnection(url, userID, password);
    }

//	public static void main(String[] args) throws ClassNotFoundException {
//        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
//        String user = "root";
//        String password = "mysql";
//        Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Đang kết nối...");
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(url, user, password);
//            if (conn != null) {
//                System.out.println("KẾT NỐI THÀNH CÔNG!");
//                System.out.println("Thông tin Database: " + conn.getMetaData().getDatabaseProductName());
//                conn.close();
//            }
//        } catch (ClassNotFoundException e) {
//            System.out.println("LỖI: Không tìm thấy Driver.");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("LỖI: Kết nối thất bại. Kiểm tra lại URL, User hoặc Password.");
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
    public static void main(String[] args) {
    	Connection conn;
		try {
			conn = new DBContext().getConnection();
			if(conn != null) System.out.println("Kết nối MySQL thành công!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

	}
}
