package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


class Row
{

    // REMEMBER: each attribute is a column
    //
    private final String title;
    private final String description;
    private final int price;
    private final String location;
    private final int id;
    //private final String date;
    
    public Row(String title, String description, int price, String location,int id)
    {
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public int getPrice()
    {
        return price;
    }
    
    public String getLocation() {
    	return location;
    }
    public int getID() {
    	return id;
    }

}


public class Database {
	
	 // Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/assignment?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String SELECT_QUERY = "SELECT * FROM users WHERE username = ? and password = ?";
    private static final String POSTS_TABLE = "SELECT * FROM posts";

    public boolean validate(String emailId, String password) throws SQLException {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, emailId);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return false;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    public static ArrayList<Row> ticket() {
    	
 
    	 ArrayList<Row> rows = new ArrayList<>();
         Row row;
        
    	try (Connection connection = DriverManager
    			  .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    			  PreparedStatement preparedStatement = connection.prepareStatement(POSTS_TABLE)){
    		  	
    		  
    		  ResultSet resultSet = preparedStatement.executeQuery();
    		  
    		  while(resultSet.next()){
    			  
    			  long id 		= resultSet.getLong("id");
    			  row = new Row(resultSet.getString("title"),resultSet.getString("description"),resultSet.getInt("price"), 
    					  resultSet.getString("location"), resultSet.getInt("id"));
    		      rows.add(row);
    			 
    			  
    		  }
    		  
    		  
    	  } catch(Exception e) {
    		  
    	  }
    	
    	
    	return rows;
    			  
    	
    	
    } 

}
