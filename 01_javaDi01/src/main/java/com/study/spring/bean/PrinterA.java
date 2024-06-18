package com.study.spring.bean;

public class PrinterA implements Printer {
	
	@Override
	public void print(String message) {
		System.out.println("print A : " + message);
	}
}
