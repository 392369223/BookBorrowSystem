package com.booksystem.test;

import com.booksystem.entity.User;

public class InnerClassTest {
	//��������̽�������ڲ������������
	private static int num;
	public static void main(String[] args) {
		User u=new User();
		MyTest t=new MyTest(){
			@Override
			public int test() {
				u.setPwd("123");
				num++;
				System.out.println(u.getPwd());
				//����:����̽������main�����е������������Ȼint�����Ͳ��У�
				//����������ŵ������棬�ǵü�static
				//��Ȼ���������취����main�����е���������ȫ��д��һ���Ǿ�̬�����У�
				//Ȼ����main�����Ѹ���ʵ������һ�������ڵ��ø÷�������
				return 0;
			}
			@Override
			public void test2() {
		
			}
		};
		t.test();
	}
}
