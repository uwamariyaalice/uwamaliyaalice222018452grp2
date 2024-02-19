package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Employee {
	private int empid;
	private String name;
	private String postn;
	private String salry;
	private String gender;
	
	public Employee() {
	    // Default constructor
	}
	public Employee(int empid,String name,String postn,String salry ,String gender) {
		super();
		this.empid=empid;
	    this.name=name;
		this.postn=postn;
		this.salry=salry;
		this.gender=gender;
	}
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostn() {
		return postn;
	}
	public void setPostn(String postn) {
		this.postn = postn;
	}
	public String getSalry() {
		return salry;
	}
	public void setSalry(String salry) {
		this.salry = salry;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to insert data
	    String sql = "INSERT INTO employee (Name,Position,Salary,Gender) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	     
	       preparedStatement.setString(1, this.name);
	       preparedStatement.setString(2, this.postn);
	       preparedStatement.setString(3, this.salry);
	       preparedStatement.setString(4, this.gender);
	       
	        
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

			        String sql = "SELECT * FROM Employee";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }


	public void update(int inputempid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to update data
	    String sql = "UPDATE Employee SET Name=?, Position=?, Salary=?, Gender=?WHERE EmployeeID=?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getName());
	    	  stm.setString(2, this.getPostn());
	          stm.setString(3, this.getSalry());
	          stm.setString(4, this.getGender()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputempid);
	       
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
	public void delete(int inputempid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwamariya_alice_fms";
	    String user = "222018452";
	    String password = "222018452";

	    // SQL query to delete data
	    String sql = "DELETE FROM Employee WHERE  Employee_ID = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputempid); // Assuming there is a column named 'id' for the WHERE clause

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
