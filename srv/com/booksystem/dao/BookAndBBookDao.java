package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.TableUsed;

public interface BookAndBBookDao {
    //ʵ������sql�����зֱ��ѯ�ķ���
	//����ҳ����ѯ��ص�����
	public int selectAllRows(int id);
	public List<TableUsed> findDataByPage(int id,int page,int line);
}
