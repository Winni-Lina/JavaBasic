package sound;

import java.util.List;

public interface SoundDAO {
	SoundVO selectSound(int soundNo);
	List<SoundVO> selectAllSounds();
	boolean insertSound(SoundVO sound);
	boolean updateSound(SoundVO sound);
	boolean deleteSound(int soundNo);
}
