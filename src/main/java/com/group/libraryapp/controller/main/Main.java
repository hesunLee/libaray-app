package com.group.libraryapp.controller.main;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static HashMap<Integer, Integer> randNums = new HashMap<>();
    private static int maxNum;
    private static int dice;


    public static void main(String[] args) throws Exception {
        setDice();
        checkRandNum();
        printRandStatic();
    }

    private static void setDice() {
        System.out.println("숫자를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        maxNum = scanner.nextInt();

        System.out.println("주사위 면수를 입력하세요: ");
        dice = scanner.nextInt();
    }

    private static void checkRandNum() {
        for (int i = 0 ; i < maxNum ; i ++)  {
            int randNum = (int) Math.floor(Math.random() * dice);
            int count = randNums.containsKey(randNum) ? randNums.get(randNum).intValue() + 1  : 1;
            randNums.put(randNum, count);
        }
    }

    private static void printRandStatic() {
        for (int i = 1; i <= dice ; i++) {
            System.out.printf("%d은 %d번 나왔습니다. \n", i , randNums.containsKey(i) ? randNums.get(i) : 0);
        }
    }
}
