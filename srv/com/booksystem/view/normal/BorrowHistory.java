package com.booksystem.view.normal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksystem.entity.HistoryBean;
import com.booksystem.entity.User;
import com.booksystem.service.BorrowService;
import com.booksystem.service.Impl.BorrowServiceImpl;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class BorrowHistory extends JFrame {

	private JPanel contentPane;
	private User user;
	private JFrame frame;
	private JTable table;
    private BorrowService borrowservice=new BorrowServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowHistory frame = new BorrowHistory(new JFrame(),null);
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
	public BorrowHistory(JFrame frame,User user) {
		setTitle("\u501F\u4E66\u5386\u53F2");
		this.frame=frame;
		this.user=user;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 502);
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
				"\u56FE\u4E66ID", "\u501F\u4E66\u65F6\u95F4", "\u8FD8\u4E66\u65F6\u95F4", "\u8FD8\u4E66\u72B6\u6001"
			}
		));
		scrollPane.setViewportView(table);
		this.setLocationRelativeTo(frame);
		initTable();
	}
    public void initTable(){
        List<HistoryBean> beans=borrowservice.findHistoryBean(user.getUser_id());
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        Vector vec=null;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<beans.size();i++){
        	vec=new Vector();
        	vec.add( beans.get(i).getBookid());
        	vec.add(format.format(beans.get(i).getBtime()));
        	vec.add(format.format(beans.get(i).getRtime()));
        	vec.add(beans.get(i).getState());
        	model.addRow(vec);
        }
    }
}
