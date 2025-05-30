package hw250528.ex;

import java.io.IOException;
import java.io.OutputStream;

public class ex05 {
	public static void main(String[] args) throws IOException {
        OutputStream out = System.out;

        for (int i = 0; i < 36; i++) {
            if (i < 10) {
                out.write('0' + i); // 0~9
            } else {
                out.write('A' + (i - 10)); // A~Z
            }
        }

        out.flush();
    }
}
