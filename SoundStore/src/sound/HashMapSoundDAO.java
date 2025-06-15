package sound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HashMapSoundDAO implements SoundDAO {

	protected Map<Integer, SoundVO> soundDB = new HashMap<>();
	protected int soundSeq = 001;
	
	@Override
	public SoundVO selectSound(int soundNo) {
		return soundDB.get(soundNo);
	}

	@Override
	public List<SoundVO> selectAllSounds() {
		return new ArrayList<>(soundDB.values());
	}

	@Override
	public boolean insertSound(SoundVO sound) {
		sound.setSoundNo(soundSeq++);
		soundDB.put(sound.getSoundNo(), sound);
		return true;
	}

	@Override
	public boolean updateSound(SoundVO sound) {
		soundDB.put(sound.getSoundNo(), sound);
		return true;
	}

	@Override
	public boolean deleteSound(int soundNo) {
		return soundDB.remove(soundNo) != null;
	}

}
