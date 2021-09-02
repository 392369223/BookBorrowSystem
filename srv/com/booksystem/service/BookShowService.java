package com.booksystem.service;

import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;

public interface BookShowService {
	//查询这个书是否被借阅
	//如果被借阅了，那么就失败了
	//如果没有被借阅，那么就借阅
	public boolean Borrow(User u,BookShow show);
}
