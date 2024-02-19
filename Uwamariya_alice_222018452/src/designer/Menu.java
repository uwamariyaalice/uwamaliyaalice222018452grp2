package designer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import AllForms.CustomerForm;
import AllForms.EmployeeForm;
import AllForms.OrderForm;
import AllForms.ProductForm;
import AllForms.SupplierForm;

public class Menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem CustomerItem;
    private JMenuItem EmployeeItem;
    private JMenuItem OrderItem;
    private JMenuItem ProductItem;
    private JMenuItem SupplierItem;
    private JMenuItem settingsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public Menu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        CustomerItem = new JMenuItem("Customer");
        CustomerItem.addActionListener(this);
        EmployeeItem = new JMenuItem("Employee");
        EmployeeItem.addActionListener(this);
        OrderItem = new JMenuItem("Order");
        OrderItem.addActionListener(this);
        ProductItem = new JMenuItem("Product");
        ProductItem.addActionListener(this);
        SupplierItem = new JMenuItem("Supplier");
        SupplierItem.addActionListener(this);
        settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add( CustomerItem);
        homeMenu.add(EmployeeItem);
        homeMenu.add(OrderItem);
        homeMenu.add(ProductItem);
        homeMenu.add(SupplierItem);
        homeMenu.addSeparator();
        homeMenu.add(settingsItem);
        homeMenu.addSeparator();
        homeMenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(homeMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("Welcome " + loggedInUser + " to Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CustomerItem) {
            JOptionPane.showMessageDialog(this, "Customer Form...");
            new CustomerForm();
        } else if (e.getSource() == EmployeeItem) {
            JOptionPane.showMessageDialog(this, "Employee Form...");
            new EmployeeForm();
        } else if (e.getSource() == OrderItem) {
            JOptionPane.showMessageDialog(this, "Order Form...");
            new OrderForm();
        } else if (e.getSource() == ProductItem) {
            JOptionPane.showMessageDialog(this, "Product Form...");
            new ProductForm(); 
        } else if (e.getSource() == SupplierItem) {
            JOptionPane.showMessageDialog(this, "Supplier Form...");
            new SupplierForm();
        } else if (e.getSource() == settingsItem) {
            String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            JOptionPane.showMessageDialog(this, "User registered successfully: " + newUsername);
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu("uwamariya_alice_fms"));
    }
}






