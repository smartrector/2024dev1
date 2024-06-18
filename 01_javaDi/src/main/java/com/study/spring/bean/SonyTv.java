package com.study.spring.bean;

public class SonyTv implements ITV{
	public SonyTv() {
		System.out.println("SonyTv 생성");
	}
	public void powerOn() {
		System.out.println("SonyTv 키기");
	}
	public void powerOff() {
		System.out.println("SonyTv 끄기");
	}
	public void volumeUp() {
		System.out.println("SonyTv 소리키기");
	}
	public void volumeDown() {
		System.out.println("SonyTv 소리끄기");
	}
	
}
