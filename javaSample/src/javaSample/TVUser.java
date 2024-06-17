package javaSample;

public class TVUser {

	public static void main(String[] args) {
//		LgTv tv = new LgTv();
		
		SamsungTv tv = new SamsungTv();
//		Tv tv = new SamsungTv();
//		tv.turnOn();
//		tv.soundOn();
//		tv.soundOff();
//		tv.turnOff();
		
		tv.powerOn();
		tv.volumeOn();
		tv.volumeOff();
		tv.powerOff();
	}

}
