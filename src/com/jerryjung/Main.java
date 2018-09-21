package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 3 개의 정수가 주어질 때, 이 중 중간값을 찾는 프로그램을 작성하여라.
     *
     * 입력 : 첫째 줄에 3개의 정수a,b,c 가 주어진다. (0≤a,b,c≤10,000)
     *
     * 출력 : 첫째 줄에 a,b,c 중 중간값을 출력한다.
     *
     * 예제 입력 : 10 2 5
     *
     * 예제 출력 : 5
     *
     * 예제 입력 2 : 3 7 7
     *
     * 예제 출력 2 : 7
     *
     */
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
