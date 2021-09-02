package com.booksystem.view.vip;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserCold2 extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	private JTextField txt1;
	private JTextField txt2;
	private User user;
	private JFrame frame;
	private JButton btn;
	private UserService userservice=new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCold2 frame = new UserCold2(null,null,0);
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
	public UserCold2(JFrame frame,User user,int id) {
		this.frame=frame;
		this.user=user;
		setTitle("\u7528\u6237\u51BB\u7ED3");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 371, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237id");
		lblNewLabel.setBounds(70, 68, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setBounds(70, 129, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u72B6\u6001");
		lblNewLabel_2.setBounds(70, 193, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		txt = new JTextField();
		txt.setEditable(false);
		txt.setBounds(185, 65, 86, 24);
		contentPane.add(txt);
		txt.setColumns(10);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(185, 126, 86, 24);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setBounds(185, 190, 86, 24);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		btn = new JButton("\u51BB\u7ED3");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cold(e);
			}
		});
		btn.setBounds(29, 255, 113, 27);
		contentPane.add(btn);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myclose();
			}
		});
		btnNewButton_1.setBounds(185, 255, 113, 27);
		contentPane.add(btnNewButton_1);
		initData(id);
		this.setLocationRelativeTo(frame);
	}
	
	protected void cold(ActionEvent e) {
	    boolean b=userservice.coldUserById(Integer.parseInt(txt.getText()));
	    if(b){
	    	JOptionPane.showMessageDialog(frame, "冻结成功");
	    }else{
	    	JOptionPane.showMessageDialog(frame, "冻结失败");
	    }
	}
	
	protected void myclose(){
		dispose();
	}
	public void initData(int id){
       User user =userservice.findUserById(id);
       if(user.getUser_state()==1){
    	   btn.setEnabled(false);
       }
       txt.setText(user.getUser_id()+"");
       txt1.setText(""+user.getUser_name());
       txt2.setText(user.getUser_state()==0?"未冻结":"已冻结");
	}
}
