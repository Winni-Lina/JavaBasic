package test;

import java.util.LinkedList;
import java.util.List;

import sound.SoundService;
import sound.Sound;

public class SoundServiceTest {
	static SoundService ss = new SoundService(new LinkedList<Sound>());
	
	public static void main(String[] args) {
		
		printlist();
		
		System.out.println("사운드 등록 시작 ======");
		System.out.println("사운드1 등록 결과 : " + ss.insertSound(new Sound("배경음1", "yj")));
		System.out.println("사운드2 등록 결과 : " + ss.insertSound(new Sound("효과음3", "자바")));
		System.out.println("사운드3 등록 결과 : " + ss.insertSound(new Sound("노래2", "뮤지커")));
		System.out.println("사운드 등록 끝 ======");

		printlist();
		
		System.out.println("100번 사운드 값 업데이트");
		Sound sound = ss.selectSound(100);
		sound.setCountLikes(3);
		sound.setCountFavorites(7);
		
		System.out.println("수정할 값 : " + sound);
		System.out.println("수정 결과 : " + ss.updateSound(sound));
		
		printlist();
		
		System.out.println("102번 사운드 값 삭제");
		System.out.println("삭제 결과 : " + ss.deleteSound(102));

		printlist();
	}
	
	static void printlist() {

		System.out.println("==== 현재 데이터 ====");
		
		List<Sound> soundList = ss.selectAllSounds();
		for(Sound s : soundList) {
			System.out.println(s);
		}
		
		System.out.println("==================");
	}
}
