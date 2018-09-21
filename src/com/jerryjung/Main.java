package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 가로 a, 세로 b의 사각형 테두리를 출력하는 프로그램을 작성하여라. Input, Output의 예제를 참고한다. (단, 사각형 테두리 내부는 빈공간이다.)
     *
     * 입력 : 첫째 줄에 자연수 a,b가 주어진다. (3≤a,b≤100)
     *
     * 출력 : 다음 예제와 같이 사각형 테두리 모양으로 ‘*’을 출력한다.
     *
     * 예제 입력 : 5 5
     *
     * 예제 출력 :
     * *****
     * *   *
     * *   *
     * *   *
     * *****
     *
     * 예제 입력 2 : 4 9
     *
     * 예제 출력 2 :
     * ****
     * *  *
     * *  *
     * *  *
     * *  *
     * *  *
     * *  *
     * *  *
     * ****
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int width = scanner.nextInt();
        final int height = scanner.nextInt();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == 0) {
                    System.out.print("*");
                } else if (col == width - 1) {
                    System.out.println("*");
                } else if (row == 0) {
                    System.out.print("*");
                } else if (row == height - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
