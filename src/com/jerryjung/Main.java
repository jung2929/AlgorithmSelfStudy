//package com.jerryjung;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int c = scanner.nextInt();
        final int b = scanner.nextInt();

        for (int i = a; i <= c; i++) {
            System.out.print(i + " ");
        }

        for (int j = c - 1; j >= b; j--) {
            System.out.print(j + " ");
        }
    }
}
