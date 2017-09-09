//****** 7. Серед простих чисел, які не перевищують заданий n,
//****** знайти таке, в двійковій формі якого максимальна кількість нулів.
//****** Просте число – це натуральне число, яке ділиться на 1 та на себе.


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = 0;
        number = input(number);
        int arraySimpleNumber []= sieveOfEratosthena(number);
        System.out.println(Arrays.toString(arraySimpleNumber));
    }

    private static int [] sieveOfEratosthena(int number) {
        int[] full = new int[number];
        for (int i = 2; i < number; i++) {
            full[i] = i;
        }
        for (int s = 2; s < number; s++) {
            if (full[s] != 0) {
                for (int w = s * 2; w < number; w += s) {
                    full[w] = 0;
                }
            }
        }
        return full;
    }

    private static int input(int number) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        System.out.println("input number > 1 and <" + Integer.MAX_VALUE);
        try {
            while (flag) {
                number = sc.nextInt();
                if (number > 1 && number < Integer.MAX_VALUE) {
                    flag = false;
                } else {
                    System.out.println("Sorry u write not need int number");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Sorry u write not int number");
            number = input(number);        }
        return number;
    }
}