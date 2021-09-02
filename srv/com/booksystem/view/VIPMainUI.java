package com.booksystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.User;
import com.booksystem.service.PortService;
import com.booksystem.service.Impl.PortServiceImpl;
import com.booksystem.view.vip.AboutLib;
import com.booksystem.view.vip.AddBook;
import com.booksystem.view.vip.BookMessage;
import com.booksystem.view.vip.TypeManage;
import com.booksystem.view.vip.TypeMessage;
import com.booksystem.view.vip.UserCold;
import com.booksystem.view.vip.UserMessage;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VIPMainUI extends JFrame {
    private User user;
	private JPanel contentPane;
	private PortService portservice=new PortServiceImpl();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIPMainUI frame = new VIPMainUI(new User());
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
	public VIPMainUI(User user) {
		this.user=user;
		setTitle("VIP\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 382);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u9996\u9875_\u57FA\u672C\u6570\u636E_\u5F53\u524D\u6A21\u5F0F.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7C7B\u578B\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    AddType(e);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406.png")));
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeMess();
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u7C7B\u578B.png")));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_3.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u56FE\u4E66\u7BA1\u7406.png")));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook(e);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u6DFB\u52A0.png")));
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u7EF4\u62A4");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libMess();
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406.png")));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u7528\u6237 \u7BA1\u7406.png")));
		mnNewMenu.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u7528\u6237\u51BB\u7ED3");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userCold(e);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u7528\u6237\u51BB\u7ED3.png")));
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u7528\u6237\u4FE1\u606F\u7EF4\u62A4");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usermess();
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/3.1\u7528\u6237\u4FE1\u606F\u7EF4\u62A4.png")));
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_1.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u5173\u4E8E\u6211\u4EEC.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC\u56FE\u4E66\u9986");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About(e);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(VIPMainUI.class.getResource("/image/vip/\u56FE\u4E66\u9986.png")));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u53D1\u516C\u544A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage(e);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6E05\u7A7A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		panel.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}

	protected void typeMess() {
		new TypeMessage(this,user).setVisible(true);
	}

	protected void libMess() {
		new BookMessage(this,user).setVisible(true);
	}

	protected void usermess() {
		new UserMessage(this, user).setVisible(true);
	}

	protected void userCold(ActionEvent e) {
		new UserCold(this,user).setVisible(true);
	}

	protected void addBook(ActionEvent e) {
		new AddBook(this,user).setVisible(true);;
	}

	protected void About(ActionEvent e) {
		new AboutLib(this,user).setVisible(true);
	}

	protected void AddType(ActionEvent e) {
		new TypeManage(this,user).setVisible(true);;
	}

	protected void sendMessage(ActionEvent e) {
		if(textArea.getText()!=null&&(!textArea.getText().equals(""))){
		boolean result=portservice.sendMessage(user.getUser_id(),textArea.getText());
		if(result){
			JOptionPane.showMessageDialog(this, "发送成功");
		}else{
			JOptionPane.showMessageDialog(this, "发送失败");
		}
		}else{
		    JOptionPane.showMessageDialog(this, "请输入信息");
		}
	}
}



