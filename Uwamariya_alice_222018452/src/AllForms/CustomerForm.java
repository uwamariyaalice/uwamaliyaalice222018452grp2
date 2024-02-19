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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllEntities.Customer;

public class CustomerForm implements ActionListener{
	JFrame frame;//CustomerID	Name	Email	Address
	JLabel cusid_lb=new JLabel("CustomerID");
	JLabel name_lb=new JLabel("Name");
	JLabel email_lb=new JLabel("Email");
	JLabel address_lb=new JLabel("Address");
	
	JTextField cusid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField address_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight(); 
	public CustomerForm(){
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
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		cusid_lb.setBounds(10,10,130,30);
		name_lb.setBounds(10,50,150,30);
		email_lb.setBounds(10,90,200,30);
		address_lb.setBounds(10,130,150,30);
		
		cusid_txf.setBounds(170,10,190,30);
		name_txf.setBounds(170,50,190,30);
		email_txf.setBounds(170,90,190,30);
		address_txf.setBounds(170,130,190,30);
		
		insert_btn.setBounds(10,200,85,30);
		read_btn.setBounds(100,200,85,30);
		update_btn.setBounds(190,200,85,30);
		delete_btn.setBounds(280,200,85,30);
		
		table.setBounds(500, 10, 600, 240);
		setFontforall();
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,20);
		cusid_lb.setFont(font);
		name_lb.setFont(font);
		email_lb.setFont(font);
		address_lb.setFont(font);
		
		cusid_txf.setFont(font);
		name_txf.setFont(font);
		email_txf.setFont(font);
		address_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}

	private void addcomponentforFrame() {
		frame.add(cusid_lb);
		frame.add(name_lb);
		frame.add(email_lb);
		frame.add(address_lb);
		
		frame.add(cusid_txf);
		frame.add(name_txf);
		frame.add(email_txf);
		frame.add(address_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Customer cs=new Customer();
		if(e.getSource()==insert_btn) {
			cs.setName(name_txf.getText());
			cs.setEmail(email_txf.getText());
			cs.setAddress(address_txf.getText());
			cs.insertData();
			
		}
		
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("CustomerID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Address");
       
        ResultSet resultSet =Customer.viewData();
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
			int id=Integer.parseInt(cusid_txf.getText());
			cs.setName(name_txf.getText());
			cs.setEmail(email_txf.getText());
			cs.setAddress(address_txf.getText());
			cs.update(id);
	    }
	  else {
			int id=Integer.parseInt(cusid_txf.getText());
			cs.delete(id);}

	  }
		
	public static void main(String[] args) {
		CustomerForm CSTf= new CustomerForm();
		System.out.println(CSTf); 
	}

	

}
