package com.booksystem.view.vip;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.BorrowShow;
import com.booksystem.entity.User;
import com.booksystem.service.BorrowService;
import com.booksystem.service.UserService;
import com.booksystem.service.Impl.BorrowServiceImpl;
import com.booksystem.service.Impl.UserServiceImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Borrow extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private User user;
	private JTextField txt;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private BorrowService borrowservice=new BorrowServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrow frame = new Borrow(null,null,0);
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
	public Borrow(JFrame frame,User user,int id) {
		setResizable(false);
		this.frame=frame;
		this.user=user;
		setTitle("\u501F\u4E66\u7528\u6237");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u501F\u4E66ID");
		lblNewLabel.setBounds(83, 96, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u501F\u4E66\u65E5\u671F");
		lblNewLabel_1.setBounds(83, 147, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237ID");
		lblNewLabel_2.setBounds(83, 44, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5F52\u8FD8\u65E5\u671F");
		lblNewLabel_3.setBounds(83, 203, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		txt = new JTextField();
		txt.setEditable(false);
		txt.setBounds(164, 41, 86, 24);
		contentPane.add(txt);
		txt.setColumns(10);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(164, 93, 86, 24);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setBounds(164, 144, 86, 24);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setBounds(164, 200, 86, 24);
		contentPane.add(txt3);
		txt3.setColumns(10);
		this.setLocationRelativeTo(frame);
		BorrowShow show=borrowservice.findUserById(id);
		if(show!=null){
			txt.setText(show.getUserid()+"");
			txt1.setText(""+show.getBookid());
			txt2.setText(show.getBtime());
			txt3.setText(""+show.getRtime());
		}
	}
}
