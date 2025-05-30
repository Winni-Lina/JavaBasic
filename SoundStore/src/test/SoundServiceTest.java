package test;

import sound.HashMapSoundDAO;
import sound.ListSoundDAO;
import sound.SSSoundService;
import sound.SoundDAO;
import sound.SoundService;
import sound.SoundVO;
import sound.file.FileSoundDB;
import sound.file.TextFileHashMapSoundDAO;

public class SoundServiceTest {
	static SoundService ss = new SSSoundService(new HashMapSoundDAO());
	//SoundDAO soundDAO = new ListSoundDAO();
	static SoundDAO soundDAO = new TextFileHashMapSoundDAO();
	
	public static void main(String[] args) {
		testSaveSounds();
		testLoadSounds();
	}
	
	static void testSaveSounds() {
		ss.registSound(new SoundVO("sound1", "YJ", "w", 5000));
		ss.registSound(new SoundVO("sound2", "jk", "w", 1000));
		ss.registSound(new SoundVO("sound3", "pl", "a", 3000));
		((FileSoundDB) soundDAO).saveSounds();
	}
	
	static void testLoadSounds() {
		((FileSoundDB) soundDAO).loadSounds();
		System.out.println(ss.listSounds());

		ss.registSound(new SoundVO("sound4", "42", "d", 7000));
		System.out.println(ss.listSounds());
		((FileSoundDB) soundDAO).saveSounds();
	}
	
	
	static void ServiceTest() {
		
		// 사운드 등록
		ss.registSound(new SoundVO("sound1", "YJ", "w", 5000));
		ss.registSound(new SoundVO("sound2", "jk", "w", 1000));
		ss.registSound(new SoundVO("sound3", "pl", "a", 3000));
		
		// 사운드 목록
		System.out.println(ss.listSounds());
		
		// 사운드 상세정보
		System.out.println(ss.detailSoundInfo(200));
		
		// 사운드 정보 수정
		ss.updateSoundPrice(200, 30000);
		
		System.out.println(ss.listSounds());
		
		// 사운드 삭제
		ss.removeSound(202);

		System.out.println(ss.listSounds());
	}
	
	static void DAOTest() {
		// 사운드 등록
		soundDAO.insertSound(new SoundVO("sound1", "YJ", "w", 5000));
		soundDAO.insertSound(new SoundVO("sound2", "jk", "w", 1000));
		soundDAO.insertSound(new SoundVO("sound3", "pl", "a", 3000));
		
		// 사운드 정보
		System.out.println(soundDAO.selectAllSounds());
		System.out.println(soundDAO.selectSound(200));
		
		// 사운드 정보 수정
		SoundVO sound= soundDAO.selectSound(202);
		sound.setAuthor("유진");
		soundDAO.updateSound(sound);
		

		sound = soundDAO.selectSound(202);
		sound.setPrice(30000);
		soundDAO.updateSound(sound);
		
		System.out.println(soundDAO.selectAllSounds());
		
		// 사운드 삭제
		soundDAO.deleteSound(201);
		System.out.println(soundDAO.selectAllSounds());
		
	}
}