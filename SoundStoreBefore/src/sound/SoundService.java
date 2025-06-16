package sound;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SoundService {
	private List<Sound> soundList = new LinkedList<Sound>();
	private int soundSeq = 001;

	public final int SEARCH_TYPE_SOUNDNO = 0;
	public final int SEARCH_TYPE_TITLE = 1;
	public final int SEARCH_TYPE_AUTHOR = 2;
	
	
	public SoundService(LinkedList<Sound> linkedList) {
		this.soundList = linkedList;
		this.addTestData();
	}
	
	public void addTestData() {
		this.insertSound(new Sound("sound1", "test1", 1000));
		this.insertSound(new Sound("sound2", "test1", 3000));
		this.insertSound(new Sound("sound3", "test1", 0));
		this.insertSound(new Sound("sound4", "test2", 2000));
		this.insertSound(new Sound("sound5", "test2", 500));
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
	
	public boolean updateSound(Sound sound){
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
	
	public List<Sound> selectAllSoundBySearch(int type, String search){
		List<Sound> sounds = new ArrayList<Sound>();
		
		for(Sound s : soundList) {
			switch(type) {
				case SEARCH_TYPE_SOUNDNO:
					if(s.getSoundNo() == Integer.parseInt(search)) sounds.add(s);
					break;
				case SEARCH_TYPE_TITLE:	
					if(s.getTitle().equals(search)) sounds.add(s);
					break;
				case SEARCH_TYPE_AUTHOR:
					if(s.getAuthor().equals(search)) sounds.add(s);
					break;
			}
		}
		
		return sounds;
	}
}
