import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import com.mysql.jdbc.Connection;
/**
 * ket noi toi csdl voi url, username, password lu trong file database.properties
 */
public class ConnectDB {
	String url;
	String user;
	String password;
	Connection connection;
	/*
	 * phuong thuc ket noi
	 * kieu tra ve : boolean
	 */
	public boolean Initialize() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("database.properties"));
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url + "?user=" + user 
							+ "&password=" +password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (connection == null) {
			System.out.println("Connection is null !");
		} 
		return true;
	}
	public static void main(String []args) {
		ConnectDB db = new ConnectDB();
		if (db.Initialize()) {
			System.out.println("Connection is initialize !");
		}
	}
}
