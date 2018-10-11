//package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 봉우리가 여러개인 산 모양을 출력한다. 산 모양은 그림과 같고 좌우 대칭이다.
     *
     * 입력 : 첫 번째 줄에 숫자를 입력 받는다. 숫자의 크기는 20보다 작은 자연수이다.
     *
     * 출력 : 출력 예의 형식으로 출력한다.
     *
     * 예제 입력 : 3
     *
     * 예제 출력 : 1213121
     *
     * 예제 입력 2 : 5
     *
     * 예제 출력 2 : 1213121412131215121312141213121
     *
     * 출처 : 
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // 출력 하려는 값의 -1 과 -1 값을 각각 양옆으로 재귀 출력
        mountain(scanner.nextInt());
    }

    private static void mountain(final int value) {
        if (value > 1) {
            mountain(value - 1);
        }
        System.out.print(value);
        if (value > 1) {
            mountain(value - 1);
        }
    }
}
