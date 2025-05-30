package hw250528.ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ex04 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("자바 소스 파일 이름을 입력: ");
        String filename = scan.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.printf("%3d: %s%n", lineNumber++, line);
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류가 발생: " + e.getMessage());
        }
        scan.close();
    }
}
