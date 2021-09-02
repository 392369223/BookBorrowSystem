package com.booksystem.view.vip;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.booksystem.entity.User;
import com.booksystem.service.TypeService;
import com.booksystem.service.Impl.TypeServiceImpl;

public class TypeMessage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private TypeService typeservice=new TypeServiceImpl();
	private JFrame frame;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeMessage frame = new TypeMessage(null,null);
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
	public TypeMessage(JFrame frame,User user) {
		this.frame=frame;
		this.user=user;
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 477);
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
				"\u7C7B\u578B\u7F16\u53F7", "\u7C7B\u578B\u540D\u79F0", "\u7C7B\u578B\u7B80\u4ECB"
			}
		));
		scrollPane.setViewportView(table);
		this.setLocationRelativeTo(frame);
		initData();
	}

	private void initData() {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		List<com.booksystem.entity.Type> alls = typeservice.findAll2();
		Vector vec=null;
		for(int i=0;i<alls.size();i++){
			vec=new Vector();
			vec.add(alls.get(i).getId());
			vec.add(alls.get(i).getType_name());
			vec.add(alls.get(i).getType_desc());
			model.addRow(vec);
		}
	}

}
