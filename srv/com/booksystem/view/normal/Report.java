package com.booksystem.view.normal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.User;
import com.booksystem.service.ReportService;
import com.booksystem.service.Impl.ReportServiceImpl;
import com.booksystem.utils.StringUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	private User user;
	private JFrame frame;
    private ReportService reportservice=new ReportServiceImpl();
    private JTextArea area;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report(null,null);
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
	public Report(JFrame frame,User user) {
		this.frame=frame;
		this.user=user;
		setTitle("\u4E3E\u62A5");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 419, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E3E\u62A5\u7528\u6237ID");
		lblNewLabel.setBounds(55, 36, 105, 32);
		contentPane.add(lblNewLabel);
		
		txt = new JTextField();
		txt.setBounds(181, 36, 105, 32);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4E3E\u62A5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		btnNewButton.setBounds(47, 419, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(188, 419, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 81, 316, 325);
		contentPane.add(scrollPane);
		
		area = new JTextArea();
		scrollPane.setViewportView(area);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E3E\u62A5\u539F\u56E0");
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		this.setLocationRelativeTo(frame);
	}
	protected void submit(ActionEvent e) {
		if(StringUtils.isEmpty(txt.getText())){
			JOptionPane.showMessageDialog(frame, "输入举报用户id");
		}else if(StringUtils.isEmpty(area.getText())){
			JOptionPane.showMessageDialog(frame, "输入举报原因");
		}else{
		com.booksystem.entity.Report report=new com.booksystem.entity.Report();
		report.setUserid(user.getUser_id());
		report.setBuserid(Integer.parseInt(txt.getText()));
		report.setMytime(new Date());
		report.setReason(area.getText());
		boolean r=reportservice.report(report);
		if(r){
			JOptionPane.showMessageDialog(frame, "举报成功");
		}else{
			JOptionPane.showMessageDialog(frame, "举报失败");
		}
		}
	}
}
