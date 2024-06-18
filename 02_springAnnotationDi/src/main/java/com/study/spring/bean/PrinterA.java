package com.study.spring.bean;

import org.springframework.stereotype.Component;

@Component("printerA")
public class PrinterA implements Printer {
	
	@Override
	public void print(String message) {
		System.out.println("print A : " + message);
	}
}
