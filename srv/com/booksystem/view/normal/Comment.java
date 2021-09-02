package com.booksystem.view.normal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.dao.BookDao;
import com.booksystem.dao.Impl.BookDaoImpl;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;
import com.booksystem.service.BookService;
import com.booksystem.service.CommentService;
import com.booksystem.service.Impl.BookServiceImpl;
import com.booksystem.service.Impl.CommentServiceImpl;
import com.booksystem.utils.StringUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comment extends JFrame {

	private JPanel contentPane;
	private User user;
	private JFrame frame;
	private JTextField txt;
	private JTextField txt1;
	private CommentService commentservice=new CommentServiceImpl();
	private JScrollPane scrollPane;
	private BookService bookservice=new BookServiceImpl();
	JTextArea area1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comment frame = new Comment(null,null);
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
	public Comment(JFrame frame,User user) {
		setResizable(false);
		this.frame=frame;
		this.user=user;
		setTitle("\u8BC4\u8BBA\u9875");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setBounds(0, 0, 450, 100);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(this.getWidth(),100));
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66ID");
		lblNewLabel.setBounds(70, 13, 72, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		lblNewLabel_1.setBounds(70, 52, 72, 26);
		panel.add(lblNewLabel_1);
		
		txt = new JTextField();
		txt.setBounds(150, 13, 86, 26);
		panel.add(txt);
		txt.setColumns(10);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(150, 52, 86, 26);
		panel.add(txt1);
		txt1.setColumns(10);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		this.setLocationRelativeTo(frame);
		txt.setText("2");
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				publish();
			}
		});
		btnNewButton.setBounds(264, 52, 113, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quest(e);
			}
		});
		btnNewButton_1.setBounds(264, 13, 113, 27);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, BorderLayout.SOUTH);
		area1=new JTextArea();
		scrollPane_1.setViewportView(area1);
		scrollPane_1.setPreferredSize(new Dimension(this.getWidth(),100));
		initData();
	}
	protected void quest(ActionEvent e) {
		initData();
	}

	public void publish(){
		//发布内容
		com.booksystem.entity.Comment comment=new com.booksystem.entity.Comment();
		comment.setCommentBookid(user.getUser_id());
		if(!StringUtils.isEmpty(area1.getText())){
		comment.setCommentContent(area1.getText());
		comment.setCommentBookid(Integer.parseInt(txt.getText()));
		comment.setCommentTime(new Date());
		comment.setCommentUserid(user.getUser_id());
		boolean b=commentservice.publish(comment);
		if(b){
			JOptionPane.showMessageDialog(this, "发布成功");
			initData();
			area1.setText("");
		}else{
			JOptionPane.showMessageDialog(this, "发布失败");
		}
		}else{
			JOptionPane.showMessageDialog(this, "请输入发布内容");
		}
	}
	public void initData(){
			Box panel = Box.createVerticalBox();
			JTextArea area=null;
			int num=Integer.parseInt(txt.getText());
			String show=bookservice.findBookById(num);
			txt1.setText(""+show);
	        List<com.booksystem.entity.Comment> comments=commentservice.findAll(num);
	        for(int i=0;i<comments.size();i++){
	        	area=new JTextArea();
	        	//设置自动换行
				area.setLineWrap(true);
				area.setText("========================================================\n");
				//设置不可编辑
				area.setEditable(false);
			    area.append(StringUtils.parseComment(comments.get(i)));
			    panel.add(area);
	        }        
			scrollPane.setViewportView(panel);
	}
}
