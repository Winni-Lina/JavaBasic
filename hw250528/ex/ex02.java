package hw250528.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex02 {
	public static void main(String[] args) {
        // BufferedReader를 키보드 입력 스트림에 연결
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("입력하고 싶은 내용을 입력하세요: ");

        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("입력 중 오류가 발생했습니다.");
        }
    }
}
