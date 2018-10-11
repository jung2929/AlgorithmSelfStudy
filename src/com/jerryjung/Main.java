package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 오민식 선생님은 올해 형택초등학교 6학년 1반 담임을 맡게 되었다.
     * 오민식 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
     * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
     * 그래서 오민식 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
     * 예를 들어 학생 수가 5명일 때의 표를 살펴보자.
     *
     * 위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
     * 2번 학생과는 4학년 때 같은 반이었음을 알 수 있다.
     * 그러므로 이 학급에서 4번 학생과 한번이라도 같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
     * 이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
     * 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다.
     * 학생 수는 3 이상 1000 이하이다.
     * 둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
     * 주어지는 정수는 모두 1 이상 9 이하의 정수이다.
     *
     * 출력 : 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다. 단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
     *
     * 예제 입력 : 5
     * 2 3 1 7 3
     * 4 1 9 6 8
     * 5 5 2 4 4
     * 6 5 2 6 7
     * 8 4 2 2 2
     *
     * 예제 출력 : 4
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     * 출처 : 한국정보올림피아드 KOI 2006 본선 초등부1번
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        final int[][] array = new int[N][5];
        final int[][] check = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        final int[] count = new int[N];
        for (int column = 0; column < 5; column++) {
            for (int row = 0; row < N; row++) {
                final int value = array[row][column];
                for (int other = 0; other < N; other++) {
                    if (row == other) continue;
                    final int compareValue = array[other][column];
                    if (value == compareValue && check[row][other] == 0) {
//                    if (value == compareValue) {
                        count[row]++;
                        check[row][other] = 1;
                        /**
                         * check 배열을 만들어놓고, break를 해서 전부 다 체크를 못하는 경우 조심!!
                         */
//                        break;
                    }
                }
            }
        }

        /*for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (check[i][j] == 1) {
                    cnt++;
                    System.out.println((i + 1) + "번째 학생과 겹치는 학생 : " + (j + 1));
                }
            }
            System.out.println((i + 1) + "번째 학생의 겹치는 학생 수 : " + cnt);
        }

        System.out.println("--------------------------------------");*/

        int maxCount = 0;
        int maxCountIndexValue = 0;
//        int maxCountIndexValue = -1;
        for (int i = 0; i < count.length; i++) {
//            System.out.println(count[i]);
            if (count[i] > maxCount) {
                maxCount = count[i];
//                maxCountIndexValue = i + 1;
                maxCountIndexValue = i;
            }
        }

//        System.out.println("--------------------------------------");

        /*if (maxCountIndexValue == -1) {
            System.out.print(0);
        } else {
            System.out.print(maxCountIndexValue);
        }*/
        System.out.print(maxCountIndexValue + 1);
    }
}
