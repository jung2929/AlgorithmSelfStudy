package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : n층의 A를 출력하는 프로그램을 작성하여라. Input, Output의 예제를 참고한다. (단, n은 항상 홀수만 주어진다.)
     * <p>
     * 입력 : 첫째 줄에 자연수이며, 홀수인 n이 주어진다. (5≤n≤100)
     * <p>
     * 출력 : 다음 예제와 같이 A 모양으로 ‘*’을 출력한다.
     * <p>
     * 예제 입력 : 5
     * <p>
     * 예제 출력 :
     *     *
     *    * *
     *   *****
     *  *     *
     * *       *
     * <p>
     * 예제 입력 2 : 7
     * <p>
     * 예제 출력 2 :
     *       *
     *      * *
     *     *   *
     *    *******
     *   *       *
     *  *         *
     * *           *
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();

        for (int row = 0; row < n; row++) {
            final int maxCol = n + row;
            for (int col = 0; col < maxCol; col++) {
                // 마지막 열이면 줄바꿈 *
                if (col == maxCol - 1) {
                    System.out.println("*");
                }
                // 첫 째줄이면 빈공간
                else if (row == 0) {
                    System.out.print(" ");
                }
                // 입력받은 홀수 값의 중간 줄이면 모두 *
                else if (row == n / 2) {
                    if (col <  n - (row + 1)) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
                // 현재 열이 입력받은 값 - 현재 줄과 같을 경우 *
                else if (col == n - (row + 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
