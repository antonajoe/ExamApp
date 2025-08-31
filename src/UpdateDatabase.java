
package examapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Joe
 */
public class UpdateDatabase {
	private Connection connection;
	private Statement statement;
        private String query;      
        
        public UpdateDatabase() { }
        
        public void update(String query) throws SQLException {
		
            try{
                connection = SingleConnection.getConnection();
                statement = connection.createStatement();
		statement.executeUpdate(query);
		}finally{ 
                	DbUtil.close(statement);
			DbUtil.close(connection); 
                } 
        }
        
        public void setQuery(String query){
            this.query = query;
        }
}
