package com.booksystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.User;
import com.booksystem.service.UserService;
import com.booksystem.service.Impl.UserServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {
	private JPanel contentPane;
	private JPasswordField pwd1;
	private JTextField txt1;
	private UserService userservice=new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("\u6CE8\u518C");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/image/pwd.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(56, 173, 87, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setIcon(new ImageIcon(Register.class.getResource("/image/username.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(56, 119, 87, 38);
		contentPane.add(lblNewLabel_1);
		
		pwd1 = new JPasswordField();
		pwd1.setBounds(178, 173, 131, 38);
		contentPane.add(pwd1);
		
		txt1 = new JTextField();
		txt1.setBounds(178, 119, 131, 38);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reg(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Register.class.getResource("/image/reg.png")));
		btnNewButton.setBounds(45, 295, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//不能使用this.dispose()，因为这是在匿名内部类里面
				dispose();
				//返回登陆界面
				new Login().setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Register.class.getResource("/image/cancel.png")));
		btnNewButton_1.setBounds(219, 295, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u6CE8\u518C");
		lblNewLabel_2.setIcon(new ImageIcon(Register.class.getResource("/image/userreg.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(125, 45, 164, 50);
		contentPane.add(lblNewLabel_2);
		this.setLocationRelativeTo(null);
	}

	protected void Reg(ActionEvent e) {
		//获取用户名和密码，
		String username=txt1.getText();
		String pwd=new String(pwd1.getPassword());
		if(username==null||username.equals("")){
			JOptionPane.showMessageDialog(this, "用户名不能为空");
		}else if(pwd==null||pwd.equals("")){
			JOptionPane.showMessageDialog(this, "密码不能为空");
		}else{
			//
			User u=userservice.Register(username, pwd);
			if(u==null){
				JOptionPane.showMessageDialog(this, "注册失败");
			}else if(u.getUser_id()==-1){
				JOptionPane.showMessageDialog(this, "该用户已存在");
			}else{
				dispose();
				//进入主页面
				new MainUI(u).setVisible(true);;
			}
		}
		
	}
}
