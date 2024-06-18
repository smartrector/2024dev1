package com.study.spring.bean;

public class LgTv implements ITV{
	public LgTv() {
		System.out.println("lgTv 생성");
	}
	public void powerOn() {
		System.out.println("lgTv 키기");
	}
	public void powerOff() {
		System.out.println("lgTv 끄기");
	}
	public void volumeUp() {
		System.out.println("lgTv 소리키기");
	}
	public void volumeDown() {
		System.out.println("lgTv 소리끄기");
	}
	
}
