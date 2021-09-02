package com.booksystem.view.normal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;
import com.booksystem.service.BookShowService;
import com.booksystem.service.Impl.BookShowServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Borrow extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JFrame frame;
	private User user;
	private BookShow show;
	private BookShowService bookshowservice=new BookShowServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrow frame = new Borrow(new JFrame(),null,null);
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
	public Borrow(JFrame frame,BookShow show,User u) {
		this.frame=frame;
		this.show=show;
		user=u;
		setTitle("\u501F\u9605\u754C\u9762");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 429, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
		lblNewLabel.setBounds(60, 97, 72, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C\u8005\u540D\u79F0");
		lblNewLabel_1.setBounds(60, 147, 72, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\u6027\u522B");
		lblNewLabel_2.setBounds(60, 196, 72, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u4EF7\u683C");
		lblNewLabel_3.setBounds(60, 239, 72, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u7C7B\u578B");
		lblNewLabel_4.setBounds(60, 282, 72, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66ID");
		lblNewLabel_5.setBounds(60, 54, 72, 30);
		contentPane.add(lblNewLabel_5);
		
		txt = new JTextField();
		txt.setEditable(false);
		txt.setBounds(146, 57, 86, 24);
		contentPane.add(txt);
		txt.setColumns(10);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(146, 100, 86, 24);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setBounds(146, 150, 86, 24);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setBounds(146, 199, 86, 24);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setEditable(false);
		txt4.setBounds(146, 245, 86, 24);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setEditable(false);
		txt5.setBounds(146, 285, 86, 24);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JButton btnNewButton = new JButton("\u501F\u9605");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBook(e);
			}
		});
		btnNewButton.setBounds(45, 322, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(200, 322, 113, 27);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(frame);
		txt.setText(""+show.getBook_id());
		txt1.setText(""+show.getBook_name());
		txt2.setText(""+show.getAuthor());
		txt3.setText(""+show.getSex());
		txt4.setText(""+show.getPrice());
		txt5.setText(""+show.getBook_type());
	}

	protected void BorrowBook(ActionEvent e) {
		if(bookshowservice.Borrow(user,show)){
			JOptionPane.showMessageDialog(frame,"借书成功");
		}else{
			JOptionPane.showMessageDialog(frame,"借书失败");
		}
	}
}
