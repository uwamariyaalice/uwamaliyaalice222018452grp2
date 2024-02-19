package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Product {//ProductID	Name	Description	Price	SupplierID
	private int prdid;
	private String name;
	private String dscpt;
	private String price;
	private String splid;
	public Product() {
	    // Default constructor
	}
	public Product(int prdid,String name,String dscpt,String price,String splid) {
		super();
		this.prdid=prdid;
		this.name=name;
		this.dscpt=dscpt;
		this.price=price;
		this.splid=splid;
	}
	
	
	
			public int getPrdid() {
		return prdid;
	}
	public void setPrdid(int prdid) {
		this.prdid = prdid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDscpt() {
		return dscpt;
	}
	public void setDscpt(String dscpt) {
		this.dscpt = dscpt;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSplid() {
		return splid;
	}
	public void setSplid(String splid) {
		this.splid = splid;
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to insert data
	    String sql = "INSERT INTO Product (Name,	Description,	Price,	SupplierID) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.name);
	       preparedStatement.setString(2, this.dscpt);
	       preparedStatement.setString(3, this.price);
	       preparedStatement.setString(4, this.splid);
	       
	     
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

			        String sql = "SELECT * FROM Product";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }

	public void update(int inputprdid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to update data
	    String sql = "UPDATE Product SET  Name= ?,Description= ?, Price= ?,SupplierID=?  WHERE ProductID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getName());
	          stm.setString(2, this.getDscpt());
	          stm.setString(3, this.getPrice());
	          stm.setString(4, this.getSplid()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputprdid);
	       
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
	public void delete(int inputprdid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to delete data
	    String sql = "DELETE FROM product WHERE  ProductID = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputprdid); // Assuming there is a column named 'id' for the WHERE clause

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


