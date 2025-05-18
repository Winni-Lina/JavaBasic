package sound;

import java.util.LinkedList;
import java.util.List;

public class ListSoundDAO implements SoundDAO{
	private List<SoundVO> soundList = new LinkedList<SoundVO>();
	private int soundseq = 200;

	@Override
	public boolean insertSound(SoundVO sound) {
		sound.setSoundNo(soundseq++);
		soundList.add(sound);
		return true;
	}

	@Override
	public SoundVO selectSound(int soundNo) {
		for(SoundVO sound : soundList) {
			if(sound.getSoundNo() == soundNo){
				return sound;
			}
		}
		return null;
	}

	@Override
	public List<SoundVO> selectAllSounds() {
		return soundList;
	}

	@Override
	public boolean updateSound(SoundVO sound) {
		for(int i = 0; i < soundList.size(); i++) {
			if(soundList.get(i).getSoundNo() == sound.getSoundNo()) {
				soundList.set(i, sound);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteSound(int soundNo) {
		for(SoundVO sound : soundList) {
			if(sound.getSoundNo() == soundNo){
				soundList.remove(sound);
			}
		}
		return false;
	}

}
