package com.booksystem.view.vip;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.Report;
import com.booksystem.entity.User;
import com.booksystem.service.ReportService;
import com.booksystem.service.Impl.ReportServiceImpl;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserCold extends JFrame {

	private JPanel contentPane;
	private User user;
	private JFrame frame;
	private JTable table;
	private ReportService reportservice=new ReportServiceImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCold frame = new UserCold(null,null);
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
	public UserCold(JFrame frame,User user) {
		this.frame=frame;
		this.user=user;
		setTitle("\u7528\u6237\u51BB\u7ED3");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6295\u8BC9ID", "\u7528\u6237ID", "\u4E0D\u826F\u7528\u6237ID", "\u6295\u8BC9\u539F\u56E0",
				"Í¶ËßÊ±¼ä"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(96);
		scrollPane.setViewportView(table);
		this.setLocationRelativeTo(frame);
		initData();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MyMousePress();
			}	
		});
	}
    protected void MyMousePress() {
        int row=table.getSelectedRow();
        int id=Integer.parseInt(table.getValueAt(row,2).toString());
		new UserCold2(this,user,id).setVisible(true);
	}

	public void initData(){
    	DefaultTableModel model=(DefaultTableModel)table.getModel();
    	Vector vec=null;
    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	List<Report> data=reportservice.findAll();
        for(int i=0;i<data.size();i++){
        	vec=new Vector();
        	vec.add(data.get(i).getReportid());
        	vec.add(data.get(i).getUserid());
        	vec.add(data.get(i).getBuserid());
        	vec.add(data.get(i).getReason());
        	Date d=data.get(i).getMytime();
        	String s=format.format(d);
        	vec.add(s);
        	model.addRow(vec);        	
        }
    }
}
