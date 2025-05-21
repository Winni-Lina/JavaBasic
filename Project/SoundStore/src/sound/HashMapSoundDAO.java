package sound;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSoundDAO implements SoundDAO{
	private Map<Integer, SoundVO> soundDB = new HashMap<>();
	private int soundSeq = 200;

	@Override
	public boolean insertSound(SoundVO sound) {
		sound.setSoundNo(soundSeq++);
		sound.setRegDate(new Date());
		
		return soundDB.put(sound.getSoundNo(), sound) != null;
	}

	@Override
	public SoundVO selectSound(int soundNo) {
		return soundDB.get(soundNo);
	}

	@Override
	public List<SoundVO> selectAllSounds() {
		return new ArrayList<>(soundDB.values());
	}

	@Override
	public boolean updateSound(SoundVO sound) {
		return soundDB.put(sound.getSoundNo(), sound) != null;
	}

	@Override
	public boolean deleteSound(int soundNo) {
		return soundDB.remove(soundNo) != null;
	}

}
