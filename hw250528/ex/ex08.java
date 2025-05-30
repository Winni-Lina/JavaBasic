package hw250528.ex;

import java.io.*;
import java.util.*;

public class ex08 {
    private static final int MAX_TRIES = 6;
    private static final String WORD_FILE = "words.txt";

    public static void main(String[] args) {
        List<String> words = loadWordsFromFile(WORD_FILE);
        if (words.isEmpty()) {
            System.out.println("단어 목록을 불러오지 못했습니다.");
            return;
        }

        String wordToGuess = words.get(new Random().nextInt(words.size()));
        char[] currentGuess = new char[wordToGuess.length()];
        Arrays.fill(currentGuess, '-');

        Set<Character> guessedLetters = new HashSet<>();
        int wrongGuesses = 0;

        Scanner scanner = new Scanner(System.in);

        while (wrongGuesses <= MAX_TRIES && new String(currentGuess).contains("-")) {
            System.out.println("추측할 단어입니다 : " + new String(currentGuess));
            System.out.print("지금까지 추측한 내용입니다 : ");
            for (char ch : guessedLetters) System.out.print(ch + " ");
            System.out.println();

            System.out.print("추측한 문자를 입력하세요 : ");
            String input = scanner.nextLine().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("문자를 입력하세요.");
                continue;
            }

            char guess = input.charAt(0);
            if (guessedLetters.contains(guess)) {
                System.out.println("이미 추측한 문자입니다.");
                continue;
            }

            guessedLetters.add(guess);

            if (wordToGuess.indexOf(guess) >= 0) {
                // 맞춘 경우
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        currentGuess[i] = guess;
                    }
                }
                System.out.printf("정확한 추측입니다 - %d번 더 추측할 수 있습니다.%n", MAX_TRIES - wrongGuesses);
            } else {
                // 틀린 경우
                wrongGuesses++;
                if (wrongGuesses > MAX_TRIES) break;
                System.out.printf("틀렸습니다 - %d번 더 추측할 수 있습니다.%n", MAX_TRIES - wrongGuesses);
            }
        }

        if (new String(currentGuess).equals(wordToGuess)) {
            System.out.println("축하합니다! 단어를 맞췄습니다: " + wordToGuess);
        } else {
            System.out.println("게임 종료! 정답은: " + wordToGuess);
        }
    }

    private static List<String> loadWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (!line.isEmpty()) {
                    words.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("단어 파일 읽기 오류: " + e.getMessage());
        }
        return words;
    }
}