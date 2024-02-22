package send_read_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class sign_signup {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField p1;
	private JTextField tb2;
	private JPasswordField p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_signup window = new sign_signup();
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
	public sign_signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tb1 = new JTextField();
		tb1.setBounds(164, 36, 124, 42);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(164, 128, 124, 43);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.setBounds(60, 223, 155, 48);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String USER=tb1.getText();
				String PWD=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse","root","mrec");
					PreparedStatement stn=con.prepareStatement("select user,password from users where user=? and password=?");
					stn.setString(1, USER);
					stn.setString(2, PWD);
					ResultSet rs=stn.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(btnNewButton,"VALID USER");
					}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton,"INVALID USER");
				}
				
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		tb2 = new JTextField();
		tb2.setBounds(459, 36, 124, 42);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBounds(380, 223, 162, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		p2 = new JPasswordField();
		p2.setBounds(459, 135, 113, 34);
		frame.getContentPane().add(p2);
		
		JLabel lblNewLabel = new JLabel("PWD :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(29, 143, 81, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(29, 36, 113, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USER :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(337, 42, 102, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PWD :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(337, 143, 76, 28);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
