package sound.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Map;

import sound.HashMapSoundDAO;
import sound.SoundVO;

public class ObjFileHashMapSoundDAO extends HashMapSoundDAO implements FileSoundDB{
	private String dataFilename = DATA_FILE + ".obj";
	
	public ObjFileHashMapSoundDAO() {
		loadSounds();
	}
	
	@Override
	public void saveSounds() {
		try (
			FileOutputStream fos = new FileOutputStream(dataFilename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			oos.writeObject(soundDB);
				
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void loadSounds() {
		try (
			FileInputStream fis = new FileInputStream(dataFilename);
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			
			soundDB = (Map<Integer, SoundVO>)ois.readObject();
			soundSeq = Collections.max(soundDB.keySet()) + 1;
				
		} catch (FileNotFoundException e) {
			System.out.println("[DB로딩] " + dataFilename + "가 없습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertSound(SoundVO sound) {
		boolean result = super.insertSound(sound);
		if(result) saveSounds();
		return result;
	}

	@Override
	public boolean updateSound(SoundVO sound) {
		boolean result = super.updateSound(sound);
		if(result) saveSounds();
		return result;
	}

	@Override
	public boolean deleteSound(int soundNo) {
		boolean result = super.deleteSound(soundNo);
		if(result) saveSounds();
		return result;
	}

	
}
