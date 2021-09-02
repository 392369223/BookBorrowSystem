package com.booksystem.view.normal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.booksystem.constant.Constant;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;
import com.booksystem.service.BookService;
import com.booksystem.service.Impl.BookServiceImpl;
import com.booksystem.utils.StringUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindBook extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JTextField txt;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JTextField txt1;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JButton btn1;
	private JButton btn2;
	private JLabel lbl2;
	private int cur=1;
	private int totalPage;
	private int line=1;
	private int state=Constant.NOCONDITION;
	private BookService bookservice=new BookServiceImpl();
	private JFrame frame;
	private String libname;
	private String autname;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindBook frame = new FindBook(new JFrame(),null);
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
	public FindBook(JFrame frame,User user) {
		this.user=user;
		setTitle("\u67E5\u8BE2\u56FE\u4E66");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 788, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(){
			 public boolean isCellEditable(int row, int column){
				 return false;
			 }
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Borrow(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66ID", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005\u540D\u79F0", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u7C7B\u578B"
			}
		));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		panel.add(lblNewLabel_1);
		
		txt1 = new JTextField();
		panel.add(txt1);
		txt1.setColumns(10);
		
		lblNewLabel = new JLabel("\u4F5C\u8005\u540D\u79F0");
		panel.add(lblNewLabel);
		
		txt = new JTextField();
		panel.add(txt);
		txt.setColumns(10);
		
		btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable();
			}
		});
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btn1 = new JButton("\u4E0A\u4E00\u9875");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous();
			}
		});
		panel_1.add(btn1);
		
		lbl2 = new JLabel("1/0");
		panel_1.add(lbl2);
		
		btn2 = new JButton("\u4E0B\u4E00\u9875");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		panel_1.add(btn2);
		fillTable();
		init();
		this.setLocationRelativeTo(this);
	}
	protected void Borrow(MouseEvent e) {
		//System.out.println("你被点击到了");
		BookShow show=new BookShow();
		int row=table.getSelectedRow();
		show.setBook_id(Integer.parseInt(table.getValueAt(row, 0).toString()));
		show.setBook_name(table.getValueAt(row, 1).toString());
		show.setAuthor(table.getValueAt(row,2).toString());
		show.setSex(table.getValueAt(row, 3).toString());
	    show.setPrice(Double.parseDouble(table.getValueAt(row, 4).toString()));
		show.setBook_type(table.getValueAt(row, 5).toString());
		//dispose();
		new Borrow(this,show,user).setVisible(true);;
	}

	protected void init(){
		if(cur==1&&totalPage==1){
			btn1.setEnabled(false);
			btn2.setEnabled(false);
		}else{
			btn1.setEnabled(false);
			btn2.setEnabled(true);
		}
	}
    protected void next() {
    	DefaultTableModel model=null;
    	List<BookShow> shows=null;
    	Vector vec=null;
    	btn1.setEnabled(true);
    	cur++;
    	lbl2.setText(cur+"/"+totalPage);
		if(cur==totalPage){
			btn2.setEnabled(false);
		}
		if(state==Constant.NOCONDITION){
			shows=bookservice.findBook(cur, line);
			model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
			for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
		}else if(state==Constant.ONECONDITIONLIB){
			shows=bookservice.findBookByLibName(libname, cur, line);
			model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
			for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
		}else if(state==Constant.ONECONDITIONAUTHOR){
			shows=bookservice.findBookByAutName(autname, cur, line);
			model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
			for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
		}else{
			shows=bookservice.findBookByAll(libname, autname, cur, line);
			model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
			for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
		}
	}

	protected void previous() {
		List<BookShow> shows=null;
		DefaultTableModel model=null;
    	Vector vec=null;
		btn2.setEnabled(true);
		cur--;
		lbl2.setText(cur+"/"+totalPage);
		if(cur==1){
			btn1.setEnabled(false);
		}
        if(state==Constant.NOCONDITION){
        	shows=bookservice.findBook(cur, line);
			model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
			for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
		}else if(state==Constant.ONECONDITIONLIB){
			shows=bookservice.findBookByLibName(libname, cur, line);
			model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
			for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
		}else if(state==Constant.ONECONDITIONAUTHOR){
			shows=bookservice.findBookByAutName(autname, cur, line);
			model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
			for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
		}else{
			shows=bookservice.findBookByAll(libname, autname, cur, line);
			model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
			for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
		}
	}

	public void fillTable(){
    	DefaultTableModel model=(DefaultTableModel)table.getModel();
    	List<BookShow> shows=null;
    	Vector vec=null;
    	model.setRowCount(0);
    	if(StringUtils.isEmpty(txt1.getText())&&StringUtils.isEmpty(txt.getText())){
    		//两个都是空
    		state=Constant.NOCONDITION;
    		cur=1;
    		//查出满足条件的有多少行，进而算出页数，
    		int rows=bookservice.findBookCount();
    		//System.out.println("rows:"+rows+" line:"+line);
    		totalPage=rows%line==0?rows/line:rows/line+1;
    		//System.out.println("totalPage:"+totalPage);
    		/*if(totalPage==1){
    			btn1.setEnabled(false);
    			btn2.setEnabled(false);
    		}else{
    			btn1.setEnabled(false);
    		}*/
    		init();
    		lbl2.setText(cur+"/"+totalPage);
    		shows=bookservice.findBook(cur, line);
    		for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
    	}else if(StringUtils.isEmpty(txt1.getText())&&(!StringUtils.isEmpty(txt.getText()))){
    		//txt1是空，txt不是空
    		//根据图书作者查询
    		//System.out.println("进入author");
    		autname=txt.getText();
    		cur=1;
    		state=Constant.ONECONDITIONAUTHOR;
    		int rows=bookservice.findBookByAutName(txt.getText());
    		totalPage=rows%line==0?rows/line:rows/line+1;
    		init();
    		lbl2.setText(cur+"/"+totalPage);
    		shows=bookservice.findBookByAutName(txt.getText(), cur, line);
    		for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
    	}else if((!StringUtils.isEmpty(txt1.getText()))&&StringUtils.isEmpty(txt.getText())){
    		//txt是空，txt1不是空
    		//根据图书名称查询
    		libname=txt1.getText();
    		cur=1;
    		state=Constant.ONECONDITIONLIB;
    		int rows=bookservice.findBookByLibName(txt1.getText());
    		totalPage=rows%line==0?rows/line:rows/line+1;
    		init();
    		lbl2.setText(cur+"/"+totalPage);
    		shows=bookservice.findBookByLibName(txt.getText(), cur, line);
    		for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
    	}else{
    		//txt和txt1都不是空
    		libname=txt1.getText();
    		autname=txt.getText();
    		cur=1;
    		state=Constant.ALLCONDITION;
    		int rows=bookservice.findBookByAll(txt1.getText(),txt.getText());
    		totalPage=rows%line==0?rows/line:rows/line+1;
    		init();
    		lbl2.setText(cur+"/"+totalPage);
    		shows=bookservice.findBookByAll(txt1.getText(),txt.getText(), cur, line);
    		for(BookShow show:shows){
    			vec=new Vector();
    			vec.add(show.getBook_id());
    			vec.add(show.getBook_name());
    			vec.add(show.getAuthor());
    			vec.add(show.getSex());
    			vec.add(show.getPrice());
    			vec.add(show.getBook_type());
    			model.addRow(vec);
    		}
    	}
    }
}
