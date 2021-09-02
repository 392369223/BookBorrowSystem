package com.booksystem.view.vip;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.User;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class AboutLib extends JFrame {

	private JPanel contentPane;
    private User user;
    private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutLib frame = new AboutLib(null,null);
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
	public AboutLib(JFrame frame,User user) {
		this.frame=frame;
		this.user=user;
		setResizable(false);
		setTitle("\u56FE\u4E66\u9986\u7B80\u4ECB");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 361, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AboutLib.class.getResource("/image/vip/lib.jpg")));
		lblNewLabel.setBounds(28, 13, 300, 200);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u9633\u5149\u56FE\u4E66\u9986\u6C38\u8FDC\u6B22\u8FCE\u4F60\uFF01");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(33, 251, 272, 63);
		contentPane.add(lblNewLabel_1);
		this.setLocationRelativeTo(frame);
	}

}
