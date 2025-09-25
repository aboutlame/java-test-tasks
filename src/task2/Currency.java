package task2;

import java.util.Scanner;

public class Currency {
    private static final double EUR = 0.010188;
    private static final double USD = 0.01196;
    private static final double JPY = 1.78;
    private static final double CNY = 0.085397;
    private static final double KZT = 6.49;

    public static void main(String[] args) {
        System.out.println("==========================");
        System.out.println("Это конвертирование курса валют!!");
        System.out.println("Доступные валюты: ");
        System.out.println("1. EUR - Евро");
        System.out.println("2. USD - Доллар США");
        System.out.println("3. JPY - Японская йена");
        System.out.println("4. CNY - Китайский юань");
        System.out.println("5. KZT - Казахстанский тенге");
        System.out.println("==========================");
        System.out.println();


        System.out.println("Выберите валюту! (Число: 1 - 5): ");
        int currencyNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите сумму: ");
        int amount = new Scanner(System.in).nextInt();

        double amountInRub = convertToRub(amount, currencyNumber);

        System.out.println("EUR: " + convertFromRub(amountInRub, 1) + " €");
        System.out.println("USD: " + convertFromRub(amountInRub, 2) + " $");
        System.out.println("JPY: " + convertFromRub(amountInRub, 3) + " Y");
        System.out.println("CNY: " + convertFromRub(amountInRub, 4) + " ¥");
        System.out.println("KZT: " + convertFromRub(amountInRub, 5) + " T");
    }

    private static double convertToRub(double amount, int currencyNumber){
        switch (currencyNumber){
            case 1: return amount / EUR ;
            case 2: return amount / USD;
            case 3: return amount / JPY;
            case 4: return amount / CNY;
            case 5: return amount / KZT;
            default: return amount;
        }
    }

    private static double convertFromRub(double amount, int currencyNumber){
        switch (currencyNumber){
            case 1: return EUR * amount;
            case 2: return USD * amount;
            case 3: return JPY * amount;
            case 4: return CNY * amount;
            case 5: return KZT * amount;
            default: return amount;
        }
    }
}
