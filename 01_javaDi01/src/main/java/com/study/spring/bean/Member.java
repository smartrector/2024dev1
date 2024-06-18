package com.study.spring.bean;

public class Member {
	private String name;
	private String nickname;
	private Printer printer;
	
	
	public Member() {
		
	}
	
	public Member(String name, String nickname, Printer printer) {
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("hello " + name + " : " + nickname);
	}
	
	
}
