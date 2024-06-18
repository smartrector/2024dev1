package com.study.spring.bean;

public class TVUser {
	public static void main(String[] args) {
//		LgTv tv = new LgTv();
		
		BeanContainer container = new BeanContainer();
//		ITV tv = new LgTv();
		
		ITV tv = (ITV)container.getBean(args[0]);
		
				
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
	
}
