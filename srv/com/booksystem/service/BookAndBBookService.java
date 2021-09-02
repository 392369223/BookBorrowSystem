package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.TableUsed;

public interface BookAndBBookService {
	public int selectAllRows(int id);
	public List<TableUsed> findDataByPage(int id,int page,int line);
}
