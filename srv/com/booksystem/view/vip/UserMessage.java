package com.booksystem.view.vip;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.booksystem.entity.User;
import com.booksystem.service.UserService;
import com.booksystem.service.Impl.UserServiceImpl;

public class UserMessage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private UserService userservice=new UserServiceImpl();
	private JFrame frame;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMessage frame = new UserMessage(null,null);
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
	public UserMessage(JFrame frame,User user) {
		this.frame=frame;
		this.user=user;
		setTitle("\u7528\u6237\u4FE1\u606F\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 563, 471);
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
				"\u7528\u6237ID", "\u7528\u6237\u540D", "\u7528\u6237\u72B6\u6001", "\u7528\u6237\u7C7B\u578B"
			}
		));
		scrollPane.setViewportView(table);
		initData();
		this.setLocationRelativeTo(frame);
	}
	 public void initData(){
		 DefaultTableModel model=(DefaultTableModel)table.getModel();
		 List<User> users=userservice.findAll();
		 Vector vec=null;
		 for(int i=0;i<users.size();i++){
			 vec=new Vector();
			 vec.add(users.get(i).getUser_id());
			 vec.add(users.get(i).getUser_name());
			 vec.add(users.get(i).getUser_state()==0?"未冻结":"已冻结"); 
			 vec.add(users.get(i).getUser_type()==0?"普通用户":"管理员");
			 model.addRow(vec);
		 }
	 }
}
