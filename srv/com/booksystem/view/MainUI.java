package com.booksystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.Port;
import com.booksystem.entity.User;
import com.booksystem.service.PortService;
import com.booksystem.service.Impl.PortServiceImpl;
import com.booksystem.utils.StringUtils;
import com.booksystem.view.normal.Borrow2;
import com.booksystem.view.normal.BorrowHistory;
import com.booksystem.view.normal.Comment;
import com.booksystem.view.normal.FindBook;
import com.booksystem.view.normal.MyBookCar;
import com.booksystem.view.normal.MyBookCar2;
import com.booksystem.view.normal.Report;
import com.booksystem.view.normal.UpdatePassword;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MainUI extends JFrame {
	private User user;
	private JScrollPane scrollPane;
    private PortService portservice=new PortServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI(new User());
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
	public MainUI(User user) {
		setResizable(false);
		setTitle("\u4E3B\u754C\u9762");
		this.user=user;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 414);
		JPanel panel1=new JPanel();
		this.setContentPane(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		/*JTextArea area=new JTextArea(10,10);
		area.setText("你好");
		scrollPane.add(area);*/
		
		initial();
		panel1.add(scrollPane,BorderLayout.CENTER);
		
		/*JTextArea area1 = new JTextArea();
		area1.setText("");
		scrollPane.setViewportView(area1);*/
		 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("\u7528\u6237\u540D");
		menu1.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u7528\u6237.png")));
		menuBar.add(menu1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6211\u7684\u4E66\u67B6");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyBookAction(e);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u6211\u7684\u4E66\u67B6.png")));
		menu1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePassword();
				
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u4FEE\u6539\u5BC6\u7801.png")));
		menu1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7528\u6237\u9000\u51FA");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainUI.class.getResource("/image/icon_\u7528\u6237\u9000\u51FA.png")));
		menu1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u56FE\u4E66\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u67E5\u8BE2");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectAction(e);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u56FE\u4E66\u67E5\u8BE2.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u501F\u9605\u56FE\u4E66");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrow(e);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u501F\u9605\u56FE\u4E66.png")));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5F52\u8FD8\u56FE\u4E66");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBook(e);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u8FD8\u4E66.png")));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u501F\u4E66\u5386\u53F2");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				history(e);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(MainUI.class.getResource("/image/icon-\u501F\u4E66\u5386\u53F2.png")));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u56FE\u4E66\u8BC4\u8BBA");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comment(e);
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u8BC4\u8BBA.png")));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u4E3E\u62A5\u975E\u6CD5\u7528\u6237");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report(e);
			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon(MainUI.class.getResource("/image/\u4E3E\u62A5.png")));
		mnNewMenu_1.add(mntmNewMenuItem_8);
		menu1.setText(user.getUser_name());
		
		this.setLocationRelativeTo(null);
	}

	protected void report(ActionEvent e) {
		new Report(this, user).setVisible(true);
	}

	protected void comment(ActionEvent e) {
		new Comment(this,user).setVisible(true);
	}
    protected void history(ActionEvent e) {
		new BorrowHistory(this, user).setVisible(true);;
	}

	protected void returnBook(ActionEvent e) {
		new MyBookCar2(this,user).setVisible(true);
	}

	protected void borrow(ActionEvent e) {
		new Borrow2(this,user).setVisible(true);
	}

	protected void SelectAction(ActionEvent e) {
		new FindBook(this,user).setVisible(true);
	}

	protected void MyBookAction(ActionEvent e) {
		new MyBookCar(this).setVisible(true);
		
	}

	protected void UpdatePassword() {
		new UpdatePassword(this).setVisible(true);
	}

	public void initial(){
		Box panel = Box.createVerticalBox();
		JTextArea area=null;
		/*for(int i=0;i<4;i++){
			area=new JTextArea();
			area.setText("===============================================================================\n");
		    panel.add(area);
		}*/
		List<Port> ports=portservice.findAll();
		for(Port port:ports){
			area=new JTextArea();
			//设置自动换行
			area.setLineWrap(true);
			area.setText("===============================================================================\n");
			//设置不可编辑
			area.setEditable(false);
		    area.append(StringUtils.parse(port));
		    panel.add(area);
		}
		scrollPane.setViewportView(panel);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
