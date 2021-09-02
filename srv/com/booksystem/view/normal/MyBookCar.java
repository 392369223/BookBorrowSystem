package com.booksystem.view.normal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import com.booksystem.dao.BookAndBBookDao;
import com.booksystem.dao.Impl.BookAndBBookDaoImpl;
import com.booksystem.entity.TableUsed;
import com.booksystem.entity.User;
import com.booksystem.service.BookAndBBookService;
import com.booksystem.service.PortService;
import com.booksystem.service.Impl.BookAndBBookServiceImpl;
import com.booksystem.service.Impl.PortServiceImpl;
import com.booksystem.view.MainUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class MyBookCar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btn;
	private JButton btn1;
	private JLabel lbl;
	private int cur=1;
	private int totalPage=0;
	private int page=2;
	private JFrame frame;
	private User user;
	private BookAndBBookService service=new BookAndBBookServiceImpl();
	private JPanel panel_1;
	private JTextField txt;
	private JTextField txt1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyBookCar frame = new MyBookCar(new JFrame());
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
	public MyBookCar(JFrame frame) {
		this.frame=frame;
		MainUI main=null;
		if(frame instanceof MainUI)
		{
			main=(MainUI)frame;
			user=main.getUser();
		}
		setTitle("\u6211\u7684\u4E66\u67B6");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 926, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MyMousePressAction(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u7C4D\u540D\u79F0", "\u4E66\u7C4D\u4F5C\u8005", "\u501F\u4E66\u65F6\u95F4", "\u5F52\u8FD8\u65F6\u95F4"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btn = new JButton("\u4E0A\u4E00\u9875");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("进入上一页");
				btn1.setEnabled(true);
				cur--;
				lbl.setText(cur+"/"+totalPage);
				fillTable();
				if(cur==1){
					btn.setEnabled(false);
				}
			}
		});
		panel.add(btn);
		
		lbl = new JLabel("1");
		panel.add(lbl);
		
		btn1 = new JButton("\u4E0B\u4E00\u9875");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cur!=totalPage){
			    btn.setEnabled(true);
			    //System.out.println("进入下一页");
				cur++;
				fillTable();
				lbl.setText(cur+"/"+totalPage);
				if(cur==totalPage){
					btn1.setEnabled(false);
				}
				}
			}
		});
		panel.add(btn1);
		btn.setEnabled(false);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("\u4E66\u7C4D\u540D\u79F0");
		panel_1.add(lblNewLabel);
		
		txt = new JTextField();
		panel_1.add(txt);
		txt.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u4E66\u7C4D\u4F5C\u8005");
		panel_1.add(lblNewLabel_1);
		
		txt1 = new JTextField();
		panel_1.add(txt1);
		txt1.setColumns(10);
		fillTable();
		this.setLocationRelativeTo(frame);
		txt.setEditable(false);
		txt1.setEditable(false);
	}
    protected void MyMousePressAction(MouseEvent e) {
    	//System.out.println("进入方法");
		//获取行号
    	int row=table.getSelectedRow();
    	txt.setText((String)table.getValueAt(row, 1));
    	txt1.setText((String)table.getValueAt(row, 2));
	}

	public void fillTable(){
        //获取table中的model
        DefaultTableModel model=(DefaultTableModel)table.getModel();
         model.setRowCount(0);
        int total=service.selectAllRows(user.getUser_id());
        totalPage=total%page==0?total/page:total/page+1;
        List<TableUsed> books=service.findDataByPage(user.getUser_id(),cur, page);
        //定义一个向量
        Vector vec=null;
        //定义一个simpledateformat类
        SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(TableUsed book:books){
        	vec=new Vector();
        	vec.add(book.getBook_id());
        	vec.add(book.getBook_name());
        	vec.add(book.getAuthor());
        	vec.add(simple.format(book.getBtime()));
        	vec.add(simple.format(book.getReturntime()));
        	model.addRow(vec);
        }
        //将数据清空
    	//table.getdefa
    	lbl.setText(cur+"/"+totalPage);
    }
}
