package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.TableUsed;

public interface BookAndBBookDao {
    //实现利用sql语句进行分别查询的方法
	//根据页数查询相关的数据
	public int selectAllRows(int id);
	public List<TableUsed> findDataByPage(int id,int page,int line);
}
