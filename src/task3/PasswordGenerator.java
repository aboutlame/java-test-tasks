package task3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private static String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
    private static String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String digits = "0123456789";
    private static String special = "!@#$%^&*()-_=+[]{};:,.<>?";
    private static String ALL = lowerLetters + upperLetters + digits + special;

    private static String generatePassword(int len){
        Random random = new Random();
        ArrayList<Character> password = new ArrayList<>();
        for (int i = 0; i < len; i++){
            password.add('№');
        }
        password.set(random.nextInt(password.size()),lowerLetters.charAt(random.nextInt(lowerLetters.length())));
        password.set(random.nextInt(password.size()),upperLetters.charAt(random.nextInt(upperLetters.length())));
        password.set(random.nextInt(password.size()),digits.charAt(random.nextInt(digits.length())));
        password.set(random.nextInt(password.size()),special.charAt(random.nextInt(special.length())));

        for (int i = 0; i < password.size(); i++){
            if (password.get(i).equals('№')){
                password.set(i, ALL.charAt(random.nextInt(ALL.length())));
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character c : password) {
            result.append(c);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println("Введите желаемую длинну пароля!: ");
        int passwordLen = new Scanner(System.in).nextInt();
        while (passwordLen < 8 || passwordLen > 12){
            System.out.println("Длина пароля должна быть от 8 до 12 символов! Введите новую длину: ");
            passwordLen = new Scanner(System.in).nextInt();
        }
        System.out.println("Ваш пароль: " + generatePassword(passwordLen));
    }
}
