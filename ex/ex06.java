package hw250528.ex;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ex06 {
	public static void main(String[] args) {
        String[] animals = {"ant", "bat", "cat", "dog"};
        String filename = "animals.txt";

        try (PrintStream out = new PrintStream(filename)) {
            for (String animal : animals) {
                out.printf("%c: %s%n", animal.charAt(0), animal);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 생성하는 도중 오류가 발생: " + e.getMessage());
        }
    }
}
