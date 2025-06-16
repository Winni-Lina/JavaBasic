package sound.file;

public interface FileSoundDB {
	String DATA_FILE = "./data/soundDB";
	void saveSounds();
	void loadSounds();
}
