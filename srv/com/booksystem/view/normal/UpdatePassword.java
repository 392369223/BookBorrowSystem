package com.booksystem.view.normal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.User;
import com.booksystem.service.UserService;
import com.booksystem.service.Impl.UserServiceImpl;
import com.booksystem.view.MainUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class UpdatePassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private JFrame frame;
    private User user;
	private JPasswordField pwd1;
	private JPasswordField pwd2;
	private UserService userservice=new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdatePassword dialog = new UpdatePassword(new JFrame());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdatePassword(JFrame frame) {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		this.frame=frame;
		MainUI main=null;
		if(frame instanceof MainUI)
		{
			main=(MainUI)frame;
			user=main.getUser();
		}
		
		this.setModal(true);
		setBounds(100, 100, 450, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel.setBounds(75, 80, 72, 24);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_1.setBounds(75, 141, 72, 24);
		contentPanel.add(lblNewLabel_1);
		
		pwd1 = new JPasswordField();
		pwd1.setBounds(161, 80, 99, 24);
		contentPanel.add(pwd1);
		
		pwd2 = new JPasswordField();
		pwd2.setBounds(161, 141, 99, 24);
		contentPanel.add(pwd2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UpdatePassword(e);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setLocationRelativeTo(frame);
	}

	protected void UpdatePassword(ActionEvent e) {
		//验证两次输入的密码是否相等
		String passwd1=new String(pwd1.getPassword());
		String passwd2=new String(pwd2.getPassword());
		//如果相等，修改密码，否则，弹出密码不一致的内容
		if(passwd1.equals(passwd2)){
			if(userservice.UpdatePassword(user.getUser_id(), passwd1)){
				JOptionPane.showMessageDialog(frame, "修改成功");
				dispose();
			}else{
				JOptionPane.showMessageDialog(frame, "修改失败");
			}
		}else{
			JOptionPane.showMessageDialog(frame, "两次输入密码不一致");
		}
	}	
}
