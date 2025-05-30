package hw250528.ex;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class ex07 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("파일 이름을 입력하세요 : ");
		
		String fileName = scan.nextLine();
		System.out.print("세고자 하는 문자를 입력하세요: ");
		
		char lookFor = scan.nextLine().charAt(0);
		int iscount = new CountLetter(lookFor, fileName).isCount();
		int chcount = new CountLetter(lookFor, fileName).channelCount();

		System.out.format("%s 파일에 %c 문자가 %d개 \n", fileName, lookFor, iscount);
		System.out.format("%s 파일에 %c 문자가 %d개 \n", fileName, lookFor, chcount);
		
		scan.close();
	}
}

class CountLetter {
    private final char target;
    private final String fileName;

    public CountLetter(char target, String fileName) {
        this.target = target;
        this.fileName = fileName;
    }

    public int isCount() {
        int count = 0;
        try (FileInputStream in = new FileInputStream(fileName)) {
            int data;
            while ((data = in.read()) != -1) {
                if ((char) data == target) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
        return count;
    }
    
    public int channelCount() {
        int count = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
             FileChannel channel = fis.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (channel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    if ((char) buffer.get() == target) {
                        count++;
                    }
                }
                buffer.clear();
            }

        } catch (IOException e) {
            System.out.println("채널 읽기 오류: " + e.getMessage());
        }
        return count;
    }
}
