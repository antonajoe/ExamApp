
package examapp;

import java.sql.*;
/**
 *
 * @author Joe
 */
public class SingleConnection {

	private static SingleConnection instance = new SingleConnection();
	public static final String url = "jdbc:mysql://localhost:3306/exam";
	public static final String user = "root";
	public static final String password = "root";
	public static final String driverClass = "com.mysql.jdbc.Driver"; 
	
	private SingleConnection() {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {}
	}
	
        public static SingleConnection getInstance(){
            if(instance == null) {
                instance = new SingleConnection();
            }
            return instance;
        }
        
	public Connection createConnection() {
		Connection connection = null;
		try {
                    connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {}
		
		return connection;
	}	
	
	public static Connection getConnection() {
		return instance.createConnection();
	}
}
