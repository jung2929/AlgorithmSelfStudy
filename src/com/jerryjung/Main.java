package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 숫자를 입력 받아 이진수로 출력하는 프로그램을 작성하시오.
     *
     * 입력 : 첫 번째 줄에 숫자를 입력 받는다. 숫자의 크기는 1,000보다 작거나 같다.
     *
     * 출력 : 첫째 줄에 숫자를 이진수로 바꾸어 출력한다.
     *
     * 예제 입력 : 14
     *
     * 예제 출력 : 1110
     *
     * 예제 입력 2 : 31
     *
     * 예제 출력 2 : 11111
     *
     * 출처 : 
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(Integer.toBinaryString(scanner.nextInt()));
    }
}
