package com.booksystem.view.vip;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.BookShow2;
import com.booksystem.entity.User;
import com.booksystem.service.BookService;
import com.booksystem.service.UserService;
import com.booksystem.service.Impl.BookServiceImpl;
import com.booksystem.service.Impl.UserServiceImpl;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookMessage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JFrame frame;
	private User user;
	private BookService bookservice=new BookServiceImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMessage frame = new BookMessage(null,null);
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
	public BookMessage(JFrame frame,User user) {
		this.frame=frame;
		this.user=user;
		setTitle("\u56FE\u4E66\u4FE1\u606F\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66ID", "\u56FE\u4E66\u540D", "\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u7C7B\u578B", "\u56FE\u4E66\u4EF7\u683C", "\u501F\u4E66\u72B6\u6001"
			}
		));
		scrollPane.setViewportView(table);
		this.setLocationRelativeTo(frame);
		initData();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=table.getSelectedRow();
				String s=table.getValueAt(row,6).toString();
				if(s.equals("已借出")){
					create(Integer.parseInt(table.getValueAt(row, 0).toString()));
				}
			}
		});
	}
	protected void create(int id) {
		new Borrow(this,user,id).setVisible(true);
	}

	public void initData(){
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		List<BookShow2> books=bookservice.findAll();
		Vector vec=null;
		for(int i=0;i<books.size();i++){
			vec=new Vector();
			vec.add(books.get(i).getBook_id());
			vec.add(books.get(i).getBook_name());
			vec.add(books.get(i).getAuthor());
			vec.add(books.get(i).getSex());
			vec.add(books.get(i).getBook_type());
			vec.add(books.get(i).getPrice());
			vec.add(books.get(i).getIsFlag()==0?"未借出":"已借出");
			model.addRow(vec);
		}
	}

}
