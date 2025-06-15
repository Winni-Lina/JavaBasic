package sound;

import java.util.LinkedList;
import java.util.List;

public class LinkedListSoundDAO implements SoundDAO {
	private int soundSeq = 001;
	private List<SoundVO> soundList = new LinkedList<SoundVO>();

	
	
	public LinkedListSoundDAO(LinkedList<SoundVO> linkedList) {
		this.soundList = linkedList;
		//this.addTestData();
	}
	
	public void addTestData() {
		this.insertSound(new SoundVO("sound1", "test1", 1000));
		this.insertSound(new SoundVO("sound2", "test1", 3000));
		this.insertSound(new SoundVO("sound3", "test1", 0));
		this.insertSound(new SoundVO("sound4", "test2", 2000));
		this.insertSound(new SoundVO("sound5", "test2", 500));
	}
	
	public SoundVO selectSound(int soundNo) {
		for(SoundVO sound : soundList) {
			if(sound.getSoundNo() == soundNo) return sound;
		}
		return null;
	}
	
	public List<SoundVO> selectAllSounds(){
		return soundList;
	}
	
	public boolean insertSound(SoundVO sound) {
		sound.setSoundNo(soundSeq++);
		return soundList.add(sound);
	}
	
	public boolean updateSound(SoundVO sound){
		for(int i = 0; i < soundList.size(); i++) {
			if(soundList.get(i).getSoundNo() == sound.getSoundNo()) {
				soundList.set(i, sound);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteSound(int soundNo) {
		for(int i = 0; i < soundList.size(); i++) {
			if(soundList.get(i).getSoundNo() == soundNo) {
				soundList.remove(i);
				return true;
			}
		}
		return false;
	}
}
