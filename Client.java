package com.liuhao.AprioriAll;

public class Client {
	public static void main(String[] args){
		String path="C:\\Users\\Administrator\\Desktop\\test\\100.txt";
		int minsupport=5;
		AprioriAll aprioriAll=new AprioriAll(path,minsupport);
		aprioriAll.generateOne();
		
	}

}
