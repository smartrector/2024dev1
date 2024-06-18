package com.study.spring.bean;

public class SamsungTv implements ITV {
	public SamsungTv() {
		System.out.println("SamsungTv 생성");
	}
	public void powerOn() {
		System.out.println("SamsungTv 키기");
	}
	public void powerOff() {
		System.out.println("SamsungTv 끄기");
	}
	public void volumeUp() {
		System.out.println("SamsungTv 소리키기");
	}
	public void volumeDown() {
		System.out.println("SamsungTv 소리끄기");
	}
	
}
