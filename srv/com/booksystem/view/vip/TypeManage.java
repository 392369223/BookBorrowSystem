package com.booksystem.view.vip;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.User;
import com.booksystem.service.TypeService;
import com.booksystem.service.Impl.TypeServiceImpl;
import com.booksystem.utils.StringUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TypeManage extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
    private JFrame frame;
    private User user;
    private JTextArea area;
    private TypeService typeservice=new TypeServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeManage frame = new TypeManage(null,null);
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
	public TypeManage(JFrame frame,User user) {
		setResizable(false);
		this.frame=frame;
		this.user=user;
		setTitle("\u7C7B\u522B\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lblNewLabel.setBounds(83, 114, 85, 29);
		contentPane.add(lblNewLabel);
		
		txt = new JTextField();
		txt.setBounds(182, 114, 85, 29);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 171, 359, 305);
		contentPane.add(scrollPane);
		area = new JTextArea();
		scrollPane.setViewportView(area);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddType(e);
			}
		});
		btnNewButton.setBounds(295, 115, 97, 29);
		contentPane.add(btnNewButton);
	    this.setLocationRelativeTo(frame);
	}

	protected void AddType(ActionEvent e) {
		String txtcontent=txt.getText();
		String areacontent=area.getText();
		if(StringUtils.isEmpty(txtcontent)){
			JOptionPane.showMessageDialog(frame,"请输入类型名称");
		}else if(StringUtils.isEmpty(areacontent)){
			JOptionPane.showMessageDialog(frame, "请输入类型描述");
		}else{
			com.booksystem.entity.Type type=new com.booksystem.entity.Type();
			type.setType_name(txtcontent);
			type.setType_desc(areacontent);
		    boolean result=typeservice.addType(type);
		    if(result){
		    	txt.setText("");
		    	area.setText("");
		    	JOptionPane.showMessageDialog(frame, "添加成功");
		    }else{
		    	JOptionPane.showMessageDialog(frame, "添加失败");
		    }
		    }
	}
}
