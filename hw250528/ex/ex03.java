package hw250528.ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex03 {
	public static void main(String[] args) {
        double[] numbers = {3.14, 2.71, 1.41, 0.577, 1.618};
        String filename = "doubles.txt";
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            for (double num : numbers) {
                dos.writeDouble(num);
            }
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("파일에서 읽은 double 값들:");
            for (int i = 0; i < numbers.length; i++) {
                double value = dis.readDouble();
                System.out.println(value);
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
    }
}
