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
import AllEntities.Supplier;



public class SupplierForm implements ActionListener{
	JFrame frame;//supplierID	Name	Contact	Email	Gendar	

	JLabel splrid_lb=new JLabel("supplierID");
	JLabel name_lb=new JLabel("Name");
	JLabel ctct_lb=new JLabel("Contact");
	JLabel email_lb=new JLabel("Email");
	JLabel gender_lb=new JLabel("Gender");
	
	
	JTextField splrid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField ctct_txf=new JTextField();
	JTextField email_txf=new JTextField();
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
	public SupplierForm(){
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
		frame.setTitle("Supplier Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		
		splrid_lb.setBounds(10,50,130,30);
		name_lb.setBounds(10,90,150,30);
		ctct_lb.setBounds(10,130,200,30);
		email_lb.setBounds(10,170,150,30);
		gender_lb.setBounds(10, 210, 100, 30);
		
	
		splrid_txf.setBounds(230,50,190,30);
		name_txf.setBounds(230,90,190,30);
		ctct_txf.setBounds(230,130,190,30);
		email_txf.setBounds(230,170,190,30);
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
		
		splrid_lb.setFont(font);
		name_lb.setFont(font);
		ctct_lb.setFont(font);
		email_lb.setFont(font);
		gender_lb.setFont(font);
		
		
		splrid_txf.setFont(font);
		name_txf.setFont(font);
		ctct_txf.setFont(font);
		email_txf.setFont(font);
		genderBox.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
	
		frame.add(splrid_lb);
		frame.add(name_lb);
		frame.add(ctct_lb);
		frame.add(email_lb);
		frame.add(gender_lb);
		
		frame.add(splrid_txf);
		frame.add(name_txf);
		frame.add(ctct_txf);
		frame.add(email_txf);
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
	Supplier spl=new Supplier();
	if(e.getSource()==insert_btn) {
		spl.setName(name_txf.getText());
		spl.setCtct(ctct_txf.getText());
		spl.setEmail(email_txf.getText());
		String selectedOption = (String) genderBox.getSelectedItem();
		spl.setGender(selectedOption);
		spl.insertData();
		
	}
	
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("supplierID");
        model.addColumn("Name");
        model.addColumn("Contact");
        model.addColumn("Gendar");
       
        ResultSet resultSet =Supplier.viewData();
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
			int id=Integer.parseInt(splrid_txf.getText());
			spl.setName(name_txf.getText());
			spl.setCtct(ctct_txf.getText());
			spl.setEmail(email_txf.getText());
			spl.update(id);
	    }
	  else {
			int id=Integer.parseInt(splrid_txf.getText());
			spl.delete(id);}

	  }
		
	public static void main(String[] args) {
		SupplierForm CSTf= new SupplierForm();
		System.out.println(CSTf); 
	}

	

}
