//package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 5x5 2차원 배열이 주어질 때 어떤 원소가 상하좌우에 있는 원소보다 작을 때 해당 위치에 * 을 표시하는 프로그램을 작성하시오. 경계선에 있는 수는 상하좌우 중 존재하는 원소만을 비교한다.
     *
     * 입력 : 5x5 행렬의 정보가 25 개의 수로 주어진다. 각 수는 0 에서 9 사이 수이다.
     *
     * 출력 : *를 포함한 행렬을 출력예의 형식으로 출력한다.
     *
     * 예제 입력 :
     * 3 4 1 4 9
     * 2 9 4 5 8
     * 9 0 8 2 1
     * 7 0 2 8 4
     * 2 7 2 1 4
     *
     * 예제 출력 :
     * 3 4 * 4 9
     * * 9 4 5 8
     * 9 0 8 2 *
     * 7 0 2 8 4
     * * 7 2 * 4
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int[][] offset = new int[5][5];
        String[][] result = new String[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                offset[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int value = offset[i][j],top = 0, left = 0, right = 0, bottom = 0;
                switch (i) {
                    case 0:
                        switch (j) {
                            case 0:
                                right = offset[i][j + 1];
                                bottom = offset[i + 1][j];
                                if (value < right && value < bottom) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                            case 4:
                                left = offset[i][j - 1];
                                bottom = offset[i + 1][j];
                                if (value < left && value < bottom) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                            default:
                                //top = offset[i - 1][j];
                                left = offset[i][j - 1];
                                right = offset[i][j + 1];
                                bottom = offset[i + 1][j];
                                if (value < left && value < right && value < bottom) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                        }
                        break;
                    case 4:
                        switch (j) {
                            case 0:
                                top = offset[i - 1][j];
                                right = offset[i][j + 1];
                                if (value < top && value < right) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                            case 4:
                                top = offset[i - 1][j];
                                left = offset[i][j - 1];
                                if (value < top && value < left) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                            default:
                                top = offset[i - 1][j];
                                left = offset[i][j - 1];
                                right = offset[i][j + 1];
                                //bottom = offset[i + 1][j];
                                if (value < top && value < left && value < right) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                        }
                        break;
                    default:
                        switch (j) {
                            case 0:
                                top = offset[i - 1][j];
                                right = offset[i][j + 1];
                                bottom = offset[i + 1][j];
                                if (value < top && value < right && value < bottom) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                            case 4:
                                top = offset[i - 1][j];
                                left = offset[i][j - 1];
                                bottom = offset[i + 1][j];
                                if (value < top && value < left && value < bottom) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                            default:
                                top = offset[i - 1][j];
                                left = offset[i][j - 1];
                                right = offset[i][j + 1];
                                bottom = offset[i + 1][j];
                                if (value < top && value < left && value < right && value < bottom) {
                                    result[i][j] = "*";
                                } else {
                                    result[i][j] = String.valueOf(value);
                                }
                                break;
                        }
                        break;
                }
            }
        }

        for (String[] row : result) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.print("\n");
        }
    }
}
