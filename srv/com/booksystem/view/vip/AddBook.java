package com.booksystem.view.vip;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.Book;
import com.booksystem.entity.User;
import com.booksystem.service.BookService;
import com.booksystem.service.TypeService;
import com.booksystem.service.Impl.BookServiceImpl;
import com.booksystem.service.Impl.TypeServiceImpl;
import com.booksystem.utils.StringUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	private JTextField txt1;
	private JTextField txt2;
	private TypeService typeservice=new TypeServiceImpl();
	private JComboBox com1;
	private User user;
	private JFrame frame;
	private JComboBox com2;
	private JTextArea area;
	private BookService bookservice=new BookServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook(null,null);
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
	public AddBook(JFrame frame,User user) {
		setResizable(false);
		this.user=user;
		this.frame=frame;
		setTitle("\u6DFB\u52A0\u56FE\u4E66");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
		lblNewLabel.setBounds(75, 48, 72, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
		lblNewLabel_1.setBounds(75, 101, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\u6027\u522B");
		lblNewLabel_2.setBounds(75, 157, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u4EF7\u683C");
		lblNewLabel_3.setBounds(75, 211, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u7C7B\u578B");
		lblNewLabel_4.setBounds(75, 260, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		txt = new JTextField();
		txt.setBounds(188, 46, 101, 24);
		contentPane.add(txt);
		txt.setColumns(10);
		
		txt1 = new JTextField();
		txt1.setBounds(188, 98, 101, 24);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		com2 = new JComboBox();
		com2.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		com2.setBounds(188, 154, 101, 24);
		contentPane.add(com2);
		
		txt2 = new JTextField();
		txt2.setBounds(188, 208, 101, 24);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		com1 = new JComboBox();
		com1.setBounds(188, 257, 101, 24);
		contentPane.add(com1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 294, 332, 221);
		contentPane.add(scrollPane);
		
		area = new JTextArea();
		scrollPane.setViewportView(area);
		
		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		scrollPane.setColumnHeaderView(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		btnNewButton.setBounds(317, 45, 113, 27);
		contentPane.add(btnNewButton);
		initData();
		this.setLocationRelativeTo(frame);
	}
	protected void submit(ActionEvent e) {
		if(StringUtils.isEmpty(txt.getText())){
			JOptionPane.showMessageDialog(frame,"图书名称不能为空");
		}else if(StringUtils.isEmpty(txt1.getText())){
			JOptionPane.showMessageDialog(frame, "图书作者不能为空");
		}else if(StringUtils.isEmpty(com2.getSelectedItem().toString())){
			JOptionPane.showMessageDialog(frame, "性别不能为空");
		}else if(StringUtils.isEmpty(txt2.getText())){
			JOptionPane.showMessageDialog(frame, "价格不能为空");
		}else if(StringUtils.isEmpty(area.getText())){
			JOptionPane.showMessageDialog(frame, "描述不能为空");
		}else if(StringUtils.isEmpty(com1.getSelectedItem().toString())){
			JOptionPane.showMessageDialog(frame, "类型不能为空");
		}else{
		Book book=new Book();
		book.setBook_name(txt.getText());
	    book.setAuthor(txt1.getText());
		book.setSex(com2.getSelectedItem().toString());
		book.setPrice(Double.parseDouble(txt2.getText()));
		book.setBook_desc(area.getText());
		int num=typeservice.getId(com1.getSelectedItem().toString());
		book.setBook_typeid(num);
		boolean result=bookservice.addBook(book);
		if(result){
			JOptionPane.showMessageDialog(frame, "添加成功");
		}else{
			JOptionPane.showMessageDialog(frame, "添加失败");
		}
		}
	}

	public void initData(){
		List<String> types=typeservice.findAll();
		com1.setModel(new DefaultComboBoxModel(types.toArray()));
	}
}
