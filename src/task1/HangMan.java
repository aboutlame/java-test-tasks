package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    private static final ArrayList<String> WORDS = new ArrayList<>(Arrays.asList("джава", "курс", "хочется", "учить", "компьютер"));
    private static final int MAX_LIVES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("==========================");
        System.out.println("Это игра Виселица!!");
        System.out.println(String.format("У вас %d жизней!", MAX_LIVES));
        System.out.println("Ваша задача - определить загаданное слово!");
        System.out.println("==========================");
        System.out.println();
        System.out.println();

        String our_word = WORDS.get(random.nextInt(WORDS.size()));
        ArrayList<String> hiddenWord = new ArrayList<>();
        for (int i = 0; i < our_word.length(); i++) {
            hiddenWord.add("_");
        }

        int remainingLives = MAX_LIVES;
        ArrayList<String> guessedLetters = new ArrayList<>();

        while (remainingLives > 0 && isNotFinished(hiddenWord)){
            drawHangman(remainingLives);
            currentState(guessedLetters, hiddenWord, remainingLives);
            System.out.println("Введите букву! - ");
            String letter = scanner.nextLine();

            if (letter.length() != 1) {
                System.out.println("\u001B[33m" + "Пожалуйста, введите только одну букву!" + "\u001B[0m");
                continue;
            }

            if (guessedLetters.contains(letter)) {
                System.out.println("\u001B[33m" + "Вы уже вводили эту букву!" + "\u001B[0m");
                continue;
            }

            if (our_word.contains(letter) && checkLetter(letter)){
                boolean guessed = false;
                for (int i = 0; i < our_word.length(); i++){
                    if (String.valueOf(our_word.charAt(i)).equals(letter)){
                        hiddenWord.set(i, letter);
                        guessed = true;
                    }
                }
                if (guessed) {
                    System.out.println("\u001B[32m" + "Вы угадали! Такая буква есть!" + "\u001B[0m");
                    guessedLetters.add(letter);
                }
            } else {
                System.out.println("\u001B[31m" + "Такой буквы к сожалению нет!" + "\u001B[0m");
                guessedLetters.add(letter);
                remainingLives--;
            }
        }

        // Проверка результата игры
        drawHangman(remainingLives);
        if (!hiddenWord.contains("_")) {
            System.out.println("\u001B[32m" + "Поздравляем! Вы выиграли! Слово: " + our_word + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "Игра окончена! Вы проиграли! Загаданное слово: " + our_word + "\u001B[0m");
        }
    }

    private static void currentState(ArrayList<String> guessedLetters, ArrayList<String> hiddenWord, int lives){
        System.out.println("Слово: " + String.join(" ", hiddenWord));
        System.out.println("Использованные буквы: " + String.join(", ", guessedLetters));
        System.out.println(String.format("Ваши жизни: %d", lives));
    }

    private static void drawHangman(int lives) {
        switch (lives) {
            case 6:
                System.out.println("""
                    -----
                    |   |
                    |
                    |
                    |
                    |
                    ---""");
                break;
            case 5:
                System.out.println("""
                    -----
                    |   |
                    |   O
                    |
                    |
                    |
                    ---""");
                break;
            case 4:
                System.out.println("""
                    -----
                    |   |
                    |   O
                    |   |
                    |
                    |
                    ---""");
                break;
            case 3:
                System.out.println("""
                    -----
                    |   |
                    |   O
                    |  /|
                    |
                    |
                    ---""");
                break;
            case 2:
                System.out.println("""
                    -----
                    |   |
                    |   O
                    |  /|\\
                    |
                    |
                    ---""");
                break;
            case 1:
                System.out.println("""
                    -----
                    |   |
                    |   O
                    |  /|\\
                    |  /
                    |
                    ---""");
                break;
            case 0:
                System.out.println("""
                    -----
                    |   |
                    |   O
                    |  /|\\
                    |  / \\
                    |
                    ---""");
                break;
        }
        System.out.println();
    }

    private static boolean checkLetter(String letter){
        return letter.length() == 1 && Character.isLetter(letter.charAt(0));
    }

    private static boolean isNotFinished(ArrayList<String> hiddenWord){
        return hiddenWord.contains("_");
    }
}