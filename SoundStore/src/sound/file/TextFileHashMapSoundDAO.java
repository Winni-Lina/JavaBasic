package sound.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import member.HashMapMemberDAO;
import member.MemberVO;
import sound.HashMapSoundDAO;
import sound.SoundVO;

public class TextFileHashMapSoundDAO extends HashMapSoundDAO implements FileSoundDB  {
	private String dataFilename = DATA_FILE + ".txt";
	private final String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";
			
	@Override
	public void saveSounds() {
		
		try (
			FileWriter fw = new FileWriter(dataFilename);
			PrintWriter pw = new PrintWriter(fw);
		) {
			
			for (SoundVO sound : soundDB.values()) {
				pw.println(sound.getSoundNo());
				pw.println(sound.getTitle());
				pw.println(sound.getAuthor());
				pw.println(sound.getPublisher());
				pw.println(sound.getPrice());
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				pw.println(sdf.format(sound.getRegDate()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
	}

	@Override
	public void loadSounds() {

		try ( FileReader fr = new FileReader(dataFilename);
			  BufferedReader br = new BufferedReader(fr);
		) {
			
			while (br.ready()) {
				int soundNo = Integer.parseInt(br.readLine());
				String title = br.readLine().strip();
				String author = br.readLine().strip();
				String publisher = br.readLine().strip();
				int price = Integer.parseInt(br.readLine());
				
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				Date regdate = sdf.parse(br.readLine());
				
				soundDB.put(soundNo, new SoundVO(soundNo, title, author, publisher, price, regdate));
				
				if (soundSeq <= soundNo) soundSeq = soundNo + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("[로딩] " + dataFilename + "이 없습니다.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}
}
