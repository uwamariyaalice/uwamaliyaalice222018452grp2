package AllForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllEntities.Customer;
import AllEntities.Employee;

public class EmployeeForm implements ActionListener{
	JFrame frame;//EmployeeID,Name,Position,Salary,Gender

	JLabel empid_lb=new JLabel("EmployeeID");
	JLabel name_lb=new JLabel("Name");
	JLabel postn_lb=new JLabel("Position");
	JLabel salry_lb=new JLabel("Salary");
	JLabel gender_lb=new JLabel("Gender");
	
	
	JTextField empid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField postn_txf=new JTextField();
	JTextField salry_txf=new JTextField();
	JTextField gender_txf=new JTextField();
	
	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public EmployeeForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("Employee Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		
		empid_lb.setBounds(10,50,130,30);
		name_lb.setBounds(10,90,150,30);
		postn_lb.setBounds(10,130,200,30);
		salry_lb.setBounds(10,170,150,30);
		gender_lb.setBounds(10, 210, 100, 30);
		
	
		empid_txf.setBounds(230,50,190,30);
		name_txf.setBounds(230,90,190,30);
		postn_txf.setBounds(230,130,190,30);
		salry_txf.setBounds(230,170,190,30);
        genderBox.setBounds(230, 210, 190, 30);
		
		insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		
		table.setBounds(500, 10, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		
		empid_lb.setFont(font);
		name_lb.setFont(font);
		postn_lb.setFont(font);
		salry_lb.setFont(font);
		gender_lb.setFont(font);
		
		
		empid_txf.setFont(font);
		name_txf.setFont(font);
		postn_txf.setFont(font);
		salry_txf.setFont(font);
		genderBox.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
	
		frame.add(empid_lb);
		frame.add(name_lb);
		frame.add(postn_lb);
		frame.add(salry_lb);
		frame.add(gender_lb);
		
		frame.add(empid_txf);
		frame.add(name_txf);
		frame.add(postn_txf);
		frame.add(salry_txf);
		frame.add(genderBox);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Employee em=new Employee();
			if(e.getSource()==insert_btn) {
				em.setName(name_txf.getText());
				em.setPostn(postn_txf.getText());
				em.setSalry(salry_txf.getText());
				String selectedOption = (String) genderBox.getSelectedItem();
				em.setGender(selectedOption);
				em.insertData();
				
			}
			
			else if (e.getSource() == read_btn) {
		        model.setColumnCount(0);
		        model.setRowCount(1);
		        model.addColumn("CustomerID");
		        model.addColumn("Name");
		        model.addColumn("Email");
		        model.addColumn("Address");
		       
		        ResultSet resultSet =Employee.viewData();
		        if (resultSet != null) {
		            try {
		                while (resultSet.next()) {
		                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
		                            resultSet.getString(3), resultSet.getString(4)});
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		    } 
		    else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(empid_txf.getText());
				em.setName(name_txf.getText());
				em.setPostn(postn_txf.getText());
				em.setSalry(salry_txf.getText());
				em.setGender((String)genderBox.getSelectedItem());
				em.update(id);
		    }
		  else {
				int id=Integer.parseInt(empid_txf.getText());
				em.delete(id);}
		
	}
	public static void main(String[] args) {
		EmployeeForm empf= new EmployeeForm();
		System.out.println(empf);

	}


}
