package hw250528.task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class task02 {
	public static void main(String[] args) {
		String fileName = "D:\\Temp\\file.txt";
		// String fileName = "C:\\Users\\PC\\Documents\\test.txt";
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일을 열 수 없습니다.");
		} catch (IOException ex) {
			System.out.println(fileName + " 파일을 읽을 수 없습니다.");
		}
	}
}
