package sound;

import java.util.List;

public interface SoundService {
	boolean registSound(SoundVO sound);
	List<SoundVO> listSounds();
	SoundVO detailSoundInfo(int soundNo);
	boolean updateSoundPrice(int soundNo, int price);
	boolean removeSound(int soundNo);
}
