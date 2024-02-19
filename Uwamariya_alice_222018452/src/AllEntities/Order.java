package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Order {//OrderID	CustomerID	OrderDate	TotalAmount	

 
	private int ordid;
	private String cstid;
	private String orddt;
	private String totamnt;
	public Order() {
	    // Default constructor
	}
	public Order(int ordid,String cstid,String orddt,String totamnt) {
		super();
		this.ordid=ordid;
		this.cstid=cstid;
		this.orddt=orddt;
		this.totamnt=totamnt;
	}
	
			public int getOrdid() {
		return ordid;
	}
	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}
	public String getCstid() {
		return cstid;
	}
	public void setCstid(String cstid) {
		this.cstid = cstid;
	}
	public String getOrddt() {
		return orddt;
	}
	public void setOrddt(String orddt) {
		this.orddt = orddt;
	}
	public String getTotamnt() {
		return totamnt;
	}
	public void setTotamnt(String totamnt) {
		this.totamnt = totamnt;
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to insert data
	    String sql = "INSERT INTO orders (CustomerID,	OrderDate,	TotalAmount	) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.cstid);
	       preparedStatement.setString(2, this.orddt);
	       preparedStatement.setString(3, this.totamnt);
	       
	       
	     
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
			 public static ResultSet viewData() {
			        String host = "jdbc:mysql://localhost/uwamariya_alice_fms";
			        String user = "222018452";
			        String password = "222018452";

			        String sql = "SELECT * FROM Orders";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }

	public void update(int inputordid) {
 		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to update data
	    String sql = "UPDATE orders SET  CustomerID= ?,OrderDate= ?, TotalAmount= ?  WHERE OrderID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getCstid());
	          stm.setString(2, this.getOrddt());
	          stm.setString(3, this.getTotamnt()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputordid);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputordid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to delete data
	    String sql = "DELETE FROM Orders WHERE  OrderID = ?";
 
	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputordid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}


