package com.study.spring.bean;

public class PrinterB implements Printer {
	
	@Override
	public void print(String message) {
		System.out.println("print B : " + message);
	}
}
