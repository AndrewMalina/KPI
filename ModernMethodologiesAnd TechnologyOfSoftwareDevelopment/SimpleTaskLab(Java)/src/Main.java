//****** 7. Серед простих чисел, які не перевищують заданий n,
//****** знайти таке, в двійковій формі якого максимальна кількість нулів.
//****** Просте число – це натуральне число, яке ділиться на 1 та на себе.


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = 0;
        number = input(number);
        ArrayList<Integer> obj = sieveOfEratosthena(number);
        searchNumber(obj);
    }

    private static void searchNumber(ArrayList<Integer> arraySimpleNumber) {
        int number = arraySimpleNumber.get(0);
        String binaryIntInStrLast = Integer.toBinaryString(number);
        int countLast = 0;
        int countNext = 0;
        for (int j = 0; j < binaryIntInStrLast.length(); j++) {
            if (binaryIntInStrLast.charAt(j) == '0') {
                countLast++;
            }
        }
        for (Integer integer : arraySimpleNumber) {
            String binaryIntInStr = Integer.toBinaryString(integer);
            System.out.println(integer + " " + binaryIntInStr);
            for (int j = 0; j < binaryIntInStr.length(); j++) {
                if (binaryIntInStr.charAt(j) == '0') {
                    countNext++;
                }
            }
            if (countLast < countNext) {
                number = integer;
                countLast = countNext;
                countNext = 0;
            }else{
                countNext = 0;
            }
        }
        System.out.print(number);
    }

    private static ArrayList<Integer> sieveOfEratosthena(int number) {
        int[] full = new int[number];
        ArrayList<Integer> obj = new ArrayList<>();
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
        for (int i = 0; i < number; i++) {
            if (full[i] != 0) {
                obj.add(full[i]);
            }
        }
        return obj;
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
            number = input(number);
        }
        return number;
    }
}