package com.booksystem.test;

import com.booksystem.entity.User;

public class InnerClassTest {
	//本类用来探究匿名内部类和他的性质
	private static int num;
	public static void main(String[] args) {
		User u=new User();
		MyTest t=new MyTest(){
			@Override
			public int test() {
				u.setPwd("123");
				num++;
				System.out.println(u.getPwd());
				//结论:可以探究放在main方法中的任意变量，当然int等类型不行，
				//解决方法：放到类里面，记得加static
				//当然还有其他办法，把main方法中的所有内容全部写到一个非静态方法中，
				//然后在main方法把该类实例化出一个对象，在调用该方法即可
				return 0;
			}
			@Override
			public void test2() {
		
			}
		};
		t.test();
	}
}
