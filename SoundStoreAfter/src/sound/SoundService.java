package sound;

import java.util.List;

public interface SoundService {
	final int SEARCH_TYPE_SOUNDNO = 0;
	final int SEARCH_TYPE_TITLE = 1;
	final int SEARCH_TYPE_AUTHOR = 2;
	
	boolean registSound(SoundVO sound);
	List<SoundVO> listSounds();
	SoundVO detailSoundInfo(int soundNo);
	boolean updateSound(SoundVO sound);
	boolean removeSound(int bookNo);
	List<SoundVO> listSoundsBySearch(int type, String search);
}
