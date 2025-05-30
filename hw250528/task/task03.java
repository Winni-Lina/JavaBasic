package hw250528.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class task03 {
	public static void main(String[] args) {
//		String fileName = "D:\\Temp\\file.txt";
		 String fileName = "C:\\Users\\PC\\Documents\\test.txt";

		try {
			File file = new File(fileName);
			Path path = file.toPath();

			Stream<String> lines = Files.lines(path);

			lines.forEach(line -> System.out.println(line));

			lines.close();

		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일을 열 수 없습니다.");
		} catch(IOException ex) {
			System.out.println(fileName + " 파일을 읽을 수 없습니다.");
		}
	}
}