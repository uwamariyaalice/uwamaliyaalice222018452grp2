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
import AllEntities.Product;

public class ProductForm implements ActionListener{
	JFrame frame;//ProductID	Name	Description	Price	SupplierID	

	JLabel prdid_lb=new JLabel("ProductID");
	JLabel Name_lb=new JLabel("Name");
	JLabel dscpt_lb=new JLabel("Description");
	JLabel price_lb=new JLabel("Price");
	JLabel splid_lb=new JLabel("SupplierID");
	
	JTextField prdid_txf=new JTextField();
	JTextField Name_txf=new JTextField();
	JTextField dscpt_txf=new JTextField();
	JTextField price_txf=new JTextField();
	JTextField splid_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public ProductForm(){
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
		frame.setTitle("Product Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		prdid_lb.setBounds(10,10,130,30);
		Name_lb.setBounds(10,50,150,30);
		dscpt_lb.setBounds(10,90,200,30);
		price_lb.setBounds(10,130,150,30);
		splid_lb.setBounds(10,170,160,30);
		
		prdid_txf.setBounds(170,10,190,30);
		Name_txf.setBounds(170,50,190,30);
		dscpt_txf.setBounds(170,90,190,30);
		price_txf.setBounds(170,130,190,30);
		splid_txf.setBounds(170,170,190,30);
		
		insert_btn.setBounds(10,250,85,30);
		read_btn.setBounds(100,250,85,30);
		update_btn.setBounds(190,250,85,30);
		delete_btn.setBounds(280,250,85,30);
		
		table.setBounds(500, 10, 600, 240);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,20);
		prdid_lb.setFont(font);
		Name_lb.setFont(font);
		dscpt_lb.setFont(font);
		price_lb.setFont(font);
		splid_lb.setFont(font);
		
		prdid_txf.setFont(font);
		Name_txf.setFont(font);
		dscpt_txf.setFont(font);
		price_txf.setFont(font);
		splid_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}

	private void addcomponentforFrame() {
		frame.add(prdid_lb);
		frame.add(Name_lb);
		frame.add(dscpt_lb);
		frame.add(price_lb);
		frame.add(splid_lb);
		
		frame.add(prdid_txf);
		frame.add(Name_txf);
		frame.add(dscpt_txf);
		frame.add(price_txf);
		frame.add(splid_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Product prd=new Product();
		if(e.getSource()==insert_btn) {
			prd.setName(Name_txf.getText());
			prd.setDscpt(dscpt_txf.getText());
			prd.setPrice(price_txf.getText());
			prd.setSplid(splid_txf.getText());
			prd.insertData();
			
		} 
		
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("ProductID");
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Price");
        model.addColumn("SupplierID");
       
        ResultSet resultSet =Product.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } 
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(prdid_txf.getText());
			prd.setName(Name_txf.getText());
			prd.setDscpt(dscpt_txf.getText());
			prd.setPrice(price_txf.getText());
			prd.setSplid(splid_txf.getText());
			prd.update(id);
	    }
	  else {
			int id=Integer.parseInt(prdid_txf.getText());
			prd.delete(id);}

	  }
		
	public static void main(String[] args) {
		ProductForm CSTf= new ProductForm();
		System.out.println(CSTf); 
	}

	

}
