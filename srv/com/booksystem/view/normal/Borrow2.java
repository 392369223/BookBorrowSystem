package com.booksystem.view.normal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;
import com.booksystem.service.BookService;
import com.booksystem.service.BookShowService;
import com.booksystem.service.Impl.BookServiceImpl;
import com.booksystem.service.Impl.BookShowServiceImpl;
import com.booksystem.utils.StringUtils;

public class Borrow2 extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private User user;
	private JFrame frame;
	private boolean state;
	private BookService bookservice=new BookServiceImpl();
	private BookShowService bookshowservice=new BookShowServiceImpl();
    private BookShow show;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrow2 frame = new Borrow2(null,null);
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
	public Borrow2(JFrame frame,User user) {
		this.frame=frame;
		this.user=user;
		setTitle("\u501F\u9605\u56FE\u4E66");
		setResizable(false);
		setBounds(100, 100, 397, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
		lblNewLabel.setBounds(34, 89, 82, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66ID");
		lblNewLabel_1.setBounds(34, 45, 82, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\u540D\u79F0");
		lblNewLabel_2.setBounds(34, 135, 82, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u8005\u6027\u522B");
		lblNewLabel_3.setBounds(34, 181, 82, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u4EF7\u683C");
		lblNewLabel_4.setBounds(34, 227, 82, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u7C7B\u578B");
		lblNewLabel_5.setBounds(34, 283, 82, 33);
		contentPane.add(lblNewLabel_5);
		
		txt = new JTextField();
		txt.setBounds(168, 45, 98, 33);
		contentPane.add(txt);
		txt.setColumns(10);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(168, 89, 98, 33);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setBounds(168, 135, 98, 33);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setBounds(168, 181, 98, 33);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setEditable(false);
		txt4.setBounds(168, 227, 98, 33);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setEditable(false);
		txt5.setBounds(168, 283, 98, 33);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select(e);
			}
		});
		btnNewButton.setBounds(34, 340, 113, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u501F\u9605");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrow(e);
			}
		});
		btnNewButton_1.setBounds(178, 340, 113, 27);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(frame);
	}
    //如果state是true，然后点击borrow订阅
	protected void borrow(ActionEvent e) {
		if(state){
			if(bookshowservice.Borrow(user, show)){
				JOptionPane.showMessageDialog(frame, "订阅成功");
				txt.setText("");
				txt1.setText("");
	    		txt2.setText("");
	    		txt3.setText("");
	    		txt4.setText("");
	    		txt5.setText("");
	    		
			}else{
				JOptionPane.showMessageDialog(frame, "订阅失败");
			}
			state=false;
			show=null;
		}
	}

	protected void select(ActionEvent e) {
	    String s=txt.getText();
	    if(StringUtils.isEmpty(s)){
	    	JOptionPane.showMessageDialog(frame, "请输入图书id");
	    }else{
	    	int id=Integer.parseInt(s);
	    	BookShow show=bookservice.findBook(id);
	    	if(show==null){
	    	JOptionPane.showMessageDialog(frame, "查无此书");	
	    	}else{
	    		this.show=show;
	    		state=true;
	    		txt1.setText(show.getBook_name());
	    		txt2.setText(show.getAuthor());
	    		txt3.setText(show.getSex());
	    		txt4.setText(""+show.getPrice());
	    		txt5.setText(""+show.getBook_type());
	    	}
	    }
	}

}
