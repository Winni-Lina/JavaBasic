package hw250528.ex;

import java.io.File;

public class ex01 {
    public static void main(String[] args) {
        String filePath = "D:\\Temp\\file.txt";
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("파일이 존재합니다");
        } else {
            System.out.println("파일이 존재하지 않습니다");
        }
    }
}