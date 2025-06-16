package sound;

import java.util.ArrayList;
import java.util.List;

public class YJSoundService implements SoundService{
	private SoundDAO soundDAO;
	
	public YJSoundService(SoundDAO soundDAO) {
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
	public boolean updateSound(SoundVO sound) {
		return soundDAO.updateSound(sound);
	}

	@Override
	public boolean removeSound(int bookNo) {
		return soundDAO.deleteSound(bookNo);
	}

	@Override
	public List<SoundVO> listSoundsBySearch(int type, String search) {
		List<SoundVO> sounds = new ArrayList<SoundVO>();
		List<SoundVO> soundList = soundDAO.selectAllSounds();
		
		for(SoundVO s : soundList) {
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
