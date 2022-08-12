package polymorphism;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("====> 애플 스피커 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("Apple ===> 소리업");
	}

	@Override
	public void volumeDown() {
		System.out.println("Apple ===> 소리다운");
	}
}
