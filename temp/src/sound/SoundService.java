package sound;

import java.util.LinkedList;
import java.util.List;

public class SoundService {
	private List<Sound> soundList = new LinkedList<Sound>();
	private int soundSeq = 100;

	public SoundService(LinkedList<Sound> linkedList) {
		this.soundList = linkedList;
	}
	
	public Sound selectSound(int soundNo) {
		for(Sound sound : soundList) {
			if(sound.getSoundNo() == soundNo) return sound;
		}
		return null;
	}
	
	public List<Sound> selectAllSounds(){
		return soundList;
	}
	
	public boolean insertSound(Sound sound) {
		sound.setSoundNo(soundSeq++);
		return soundList.add(sound);
	}
	
	public boolean updateSound(Sound sound) {
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
