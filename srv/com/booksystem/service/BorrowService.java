package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Borrow;
import com.booksystem.entity.BorrowShow;
import com.booksystem.entity.HistoryBean;

public interface BorrowService {
	//��ѯlend�����Ƿ���
	//��������ˣ��ͷ���false
	//���û���飬���飬��ʾ����ɹ�
	public boolean returnBook(Borrow borrow);
	//�鿴�û����Ĺ���ͼ�飬����ͼ���״̬
    public List<HistoryBean> findHistoryBean(int user_id);
  //����ͼ��id�����û�id�͹黹ʱ��
  	public BorrowShow findUserById(int id);
}
