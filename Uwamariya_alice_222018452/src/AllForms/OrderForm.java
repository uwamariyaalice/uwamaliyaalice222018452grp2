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
import AllEntities.Order;

public class OrderForm implements ActionListener{
	JFrame frame;//OrderID	CustomerID	OrderDate	TotalAmount	

	JLabel ordid_lb=new JLabel("OrderID");
	JLabel cstid_lb=new JLabel("CustomerID");
	JLabel orddt_lb=new JLabel("OrderDate");
	JLabel totamnt_lb=new JLabel("TotalAmount");
	
	JTextField ordid_txf=new JTextField();
	JTextField cstid_txf=new JTextField();
	JTextField orddt_txf=new JTextField();
	JTextField totamnt_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public OrderForm(){
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
		frame.setTitle("Order Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		ordid_lb.setBounds(10,10,130,30);
		cstid_lb.setBounds(10,50,150,30);
		orddt_lb.setBounds(10,90,200,30);
		totamnt_lb.setBounds(10,130,150,30);
		
		ordid_txf.setBounds(170,10,190,30);
		cstid_txf.setBounds(170,50,190,30);
		orddt_txf.setBounds(170,90,190,30);
		totamnt_txf.setBounds(170,130,190,30);
		
		insert_btn.setBounds(10,200,85,30);
		read_btn.setBounds(100,200,85,30);
		update_btn.setBounds(190,200,85,30);
		delete_btn.setBounds(280,200,85,30);
		table.setBounds(500, 10, 600, 240);

		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,20);
		ordid_lb.setFont(font);
		cstid_lb.setFont(font);
		orddt_lb.setFont(font);
		totamnt_lb.setFont(font);
		
		ordid_txf.setFont(font);
		cstid_txf.setFont(font);
		orddt_txf.setFont(font);
		totamnt_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}

	private void addcomponentforFrame() {
		frame.add(ordid_lb);
		frame.add(cstid_lb);
		frame.add(orddt_lb);
		frame.add(totamnt_lb);
		
		frame.add(ordid_txf);
		frame.add(cstid_txf);
		frame.add(orddt_txf);
		frame.add(totamnt_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Order ord=new Order();
		if(e.getSource()==insert_btn) {
			ord.setCstid(cstid_txf.getText());
			ord.setOrddt(orddt_txf.getText());
			ord.setTotamnt(totamnt_txf.getText());
			ord.insertData();
			
		}
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("OrderID");
        model.addColumn("CustomerID");
        model.addColumn("OrderDate");
        model.addColumn("TotalAmount");
       
        ResultSet resultSet =Order.viewData();
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
			int id=Integer.parseInt(ordid_txf.getText());
			ord.setCstid(cstid_txf.getText());
			ord.setOrddt(orddt_txf.getText());
			ord.setTotamnt(totamnt_txf.getText());
			ord.update(id);
	    }
	  else {
			int id=Integer.parseInt(ordid_txf.getText());
			ord.delete(id);}}
		
		
	public static void main(String[] args) {
		OrderForm ordf= new OrderForm();
		System.out.println(ordf);


	}

}
