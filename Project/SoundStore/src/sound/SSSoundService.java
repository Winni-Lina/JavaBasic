package sound;

import java.util.List;

public class SSSoundService implements SoundService{

	private SoundDAO soundDAO;
	
	public SSSoundService(SoundDAO soundDAO) {
		this.soundDAO = soundDAO;
	}

	@Override
	public boolean registSound(SoundVO sound) {
		return soundDAO.insertSound(sound);
	}

	@Override
	public List<SoundVO> listSounds() {
		return soundDAO.selectAllSounds();
	}

	@Override
	public SoundVO detailSoundInfo(int soundNo) {
		return soundDAO.selectSound(soundNo);
	}

	@Override
	public boolean updateSoundPrice(int soundNo, int price) {
		SoundVO sound = soundDAO.selectSound(soundNo);
		if(sound != null) {
			sound.setPrice(price);
			soundDAO.updateSound(sound);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeSound(int soundNo) {
		return soundDAO.deleteSound(soundNo);
		
	}

}