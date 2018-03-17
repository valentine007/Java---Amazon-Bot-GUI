package service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.openqa.selenium.WebDriver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblAddNewItem;
	private JLabel lblLogin;
	private JLabel lblPassword_1;
	private JLabel lblAsin;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnCreateAccount;
	private JButton btnAddToCart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow window = new StartWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateNewAmazon = new JLabel("Create new Amazon Account:");
		lblCreateNewAmazon.setBounds(131, 11, 160, 14);
		frame.getContentPane().add(lblCreateNewAmazon);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setBounds(10, 32, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(10, 57, 58, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblFirstName = new JLabel("first name:");
		lblFirstName.setBounds(10, 82, 58, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("last name:");
		lblLastName.setBounds(10, 107, 58, 14);
		frame.getContentPane().add(lblLastName);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
				textField.setText(email);
			}
		});
		textField.setBounds(66, 29, 225, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = textField_1.getText();
				textField_1.setText(pass);
			}
		});
		textField_1.setBounds(66, 54, 225, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = textField_2.getText();
				textField_2.setText(firstName);
			}
		});
		textField_2.setBounds(66, 82, 225, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = textField_3.getText();
				textField_3.setText(lastName);
			}
		});
		textField_3.setBounds(66, 104, 225, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblAddNewItem = new JLabel("Add new item to Cart:");
		lblAddNewItem.setBounds(131, 135, 145, 14);
		frame.getContentPane().add(lblAddNewItem);
		
		lblLogin = new JLabel("login:");
		lblLogin.setBounds(10, 155, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		lblPassword_1 = new JLabel("password:");
		lblPassword_1.setBounds(10, 180, 58, 14);
		frame.getContentPane().add(lblPassword_1);
		
		lblAsin = new JLabel("ASIN:");
		lblAsin.setBounds(10, 209, 46, 14);
		frame.getContentPane().add(lblAsin);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_4.getText();
				textField_4.setText(email);
			}
		});
		textField_4.setBounds(66, 152, 225, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = textField_5.getText();
				textField_5.setText(pass);
			}
		});
		textField_5.setBounds(66, 177, 225, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String asin = textField_6.getText();
				textField_6.setText(asin);
			}
		});
		textField_6.setBounds(66, 205, 225, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WebDriver driver = BotService.getFirefoxDriver();
				
				String email = textField.getText();
				textField.setText(email);
				
				String pass = textField_1.getText();
				textField_1.setText(pass);
				
				String firstName = textField_2.getText();
				textField_2.setText(firstName);
				
				String lastName = textField_3.getText();
				textField_3.setText(lastName);
				
				Account account = new Account(/*"Valentin.Demac1234@gmail.com"*/email,
						/*"126789q123"*/ pass, /*"Valia"*/ firstName,
						/*"Demchenkova"*/ lastName);
				driver = BotService.registerAccount(driver, account);
				
			}
		});
		btnCreateAccount.setBounds(301, 57, 123, 39);
		frame.getContentPane().add(btnCreateAccount);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WebDriver driver = BotService.getFirefoxDriver();

				
				String email = textField_4.getText();
				textField_4.setText(email);
				
				String pass = textField_5.getText();
				textField_5.setText(pass);
				
				String asin = textField_6.getText();
				textField_6.setText(asin);		
				
				Good good = new Good(asin, "someGood", "someURL");
				
				Account account = new Account(email, pass, "someName", "someSecondName");
				driver = BotService.addGoodToCart(driver, asin, account, good);
				
				if (driver != null) {
					driver = BotService.addGoodToCart(driver, asin, account, good);
					driver.quit();
					}
			}
		});
		btnAddToCart.setBounds(301, 168, 123, 39);
		frame.getContentPane().add(btnAddToCart);
	}

}
