package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : a부터 c까지 증가한 뒤, c-1부터 b까지 감소하는 과정을 출력해보자.
     *
     * 입력 : 첫째 줄에 자연수 a,c,b가 공백을 가지고 주어진다. a는 c보다 작거나 같으며, c는 b보다 크게 입력된다. ( 1 <= a,b,c <= 1,000)
     *
     * 출력 : 첫째 줄에 a부터 c까지의 자연수를 공백을 사이에 두고 차례대로 출력한 뒤, c-1부터 b까지의 자연수를 공백을 사이에 두고 차례대로 출력한다.
     *
     * 예제 입력 : 2 5 3
     *
     * 예제 출력 : 2 3 4 5 4 3
     *
     * 예제 입력 2 : 1 7 2
     *
     * 예제 출력 2 : 1 2 3 4 5 6 7 6 5 4 3 2
     *
     */
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
