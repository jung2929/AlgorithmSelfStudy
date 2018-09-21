package com.jerryjung;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int parameter1 = scanner.nextInt();
        final int parameter2 = scanner.nextInt();
        final int parameter3 = scanner.nextInt();

        int median = 0;

        if (parameter1 > parameter2) {
            if (parameter2 > parameter3) median = parameter2;
            else if (parameter1 > parameter3) median = parameter3;
            else median = parameter1;
        } else {
            // parameter2 > parameter1
            if (parameter1 > parameter3) median = parameter1;
            else if (parameter2 > parameter3) median = parameter3;
            else median = parameter2;
        }

        System.out.print(median);
    }
}
