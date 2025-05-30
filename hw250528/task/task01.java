package hw250528.task;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class task01 {
	public static void main(String[] args) {
		String fileName = "D:\\Temp\\file.txt";
		// String fileName = "C:\\Users\\PC\\Documents\\test.txt";
		
		try {
			byte[] buf = new byte[100];
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);

			int bytesRead;
			while ((bytesRead = bis.read(buf)) != -1) {
				String line = new String(buf, 0, bytesRead, "UTF-8");
				System.out.print(line);
			}
			
			fis.close();
			bis.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일을 열 수 없습니다.");
		} catch(IOException ex) {
			System.out.println(fileName + " 파일을 읽을 수 없습니다.");
		}
	}
}
