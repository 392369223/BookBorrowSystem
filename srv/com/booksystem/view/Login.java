package com.booksystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.User;
import com.booksystem.service.UserService;
import com.booksystem.service.Impl.UserServiceImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JPasswordField pwd1;
    private UserService userservice=new UserServiceImpl();
    private JComboBox combox1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		setTitle("\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 481);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u56FE\u4E66\u501F\u9605\u7CFB\u7EDF");
		label.setBounds(129, 57, 204, 50);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setIcon(new ImageIcon(Login.class.getResource("/image/book.png")));
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/image/username.png")));
		lblNewLabel.setBounds(58, 152, 91, 35);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/image/pwd.png")));
		lblNewLabel_1.setBounds(58, 210, 91, 35);
		
		txt1 = new JTextField();
		txt1.setBounds(178, 152, 167, 35);
		txt1.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(txt1);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/image/login.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAction(e);
			}			
		});
		btnNewButton.setBounds(36, 347, 91, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.setIcon(new ImageIcon(Login.class.getResource("/image/reg.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Register().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(178, 347, 91, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u6743\u9650");
		lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/image/\u6743\u9650.png")));
		lblNewLabel_1_1.setBounds(58, 272, 91, 35);
		contentPane.add(lblNewLabel_1_1);
		
		pwd1 = new JPasswordField();
		pwd1.setBounds(178, 210, 167, 35);
		contentPane.add(pwd1);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAction(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Login.class.getResource("/image/reset.png")));
		btnNewButton_2.setBounds(312, 347, 91, 27);
		contentPane.add(btnNewButton_2);
		
		combox1 = new JComboBox();
		combox1.setModel(new DefaultComboBoxModel(new String[] {"\u7528\u6237", "\u7BA1\u7406\u5458"}));
		combox1.setBounds(178, 272, 167, 35);
		contentPane.add(combox1);
		//设置居中不行是因为大小不定
		this.setLocationRelativeTo(null);
	}
	protected void resetAction(ActionEvent e) {
		txt1.setText("");
		pwd1.setText("");
		combox1.setSelectedIndex(0);
	}

	public void LoginAction(ActionEvent e) {
		User u=null;
		if(txt1.getText()==null||txt1.getText().equals("")){
			JOptionPane.showMessageDialog(this,"用户名不能为空");
		}else if(new String(pwd1.getPassword())==null||new String(pwd1.getPassword()).equals("")){
			JOptionPane.showMessageDialog(this,"密码不能为空");
		}else{
			u=userservice.Login(txt1.getText(),new String(pwd1.getPassword()), combox1.getSelectedIndex());
			if(u==null){
				JOptionPane.showMessageDialog(this, "该用户不存在");
			}else if(u.getUser_id()==-1){
				JOptionPane.showMessageDialog(this,"角色错误");
			}else{
				if(u.getUser_type()==1){
					this.dispose();
					new VIPMainUI(u).setVisible(true);
				}else{
				//关闭当前页面
				this.dispose();
				//把User传输到主页面
				new MainUI(u).setVisible(true);
				//new Register(u).setVisible(true);	
				}
			}
		}
		/*
		 //关闭当前页面
		this.dispose();
		//把User传输到主页面
		new Register(u).setVisible(true);
		*/
	}
}
