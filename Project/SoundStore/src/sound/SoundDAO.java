package sound;

import java.util.List;

public interface SoundDAO {
	boolean insertSound(SoundVO sound);
	SoundVO selectSound(int soundNo);
	List<SoundVO> selectAllSounds();
	boolean updateSound(SoundVO sound);
	boolean deleteSound(int soundNo);
}
