package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 1 부터 나선 형 모양으로 배열에 값을 넣은 후 출력하는 프로그램을 작성하시오.
     *
     * 입력 : 입력은 배열의 크기 n 이 주어진다. n * n 행 배열이다. ( 3 <= n <= 25)
     *
     * 출력 : 각 숫자 사이 한 칸의 공백을 가지고 나선형(달팽이) 배열을 출력한다.
     *
     * 예제 입력 : 3
     *
     * 예제 출력 :
     * 1 2 3
     * 8 9 4
     * 7 6 5
     *
     * 예제 입력 2 : 6
     *
     * 예제 출력 2 :
     * 1 2 3 4 5 6
     * 20 21 22 23 24 7
     * 19 32 33 34 25 8
     * 18 31 36 35 26 9
     * 17 30 29 28 27 10
     * 16 15 14 13 12 11
     *
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[][] spiral = new int[n][n];

        int value = 1;
        int widthIndex = 0;
        int heightIndex = 1;

        while (value <= n * n) {
            // 좌 -> 우
            for (int i = widthIndex; i < n - widthIndex; i++) {
                spiral[widthIndex][i] = value++;
                if (value >= n*n) break;
            }

            // 상 -> 하
            for (int i = heightIndex; i < n - widthIndex; i++) {
                spiral[i][n - heightIndex] = value++;
                if (value >= n*n) break;
            }

            // 우 -> 좌
            for (int i = n - heightIndex - 1; i >= widthIndex; i--) {
                spiral[n - heightIndex][i] = value++;
                if (value >= n*n) break;
            }

            // 하 -> 상
            for (int i = n - heightIndex - 1; i >= heightIndex; i--) {
                spiral[i][widthIndex] = value++;
                if (value >= n*n) break;
            }

            widthIndex++;
            heightIndex++;
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.println(spiral[i][j]);
                } else {
                    System.out.print(spiral[i][j] + " ");
                }
            }
        }
    }
}
