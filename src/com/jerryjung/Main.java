package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 윤성이는 어렸을 적부터 수없이 몰려오는 적으로부터 기지를 방어하는 디펜스 유형의 게임을 플레이하는 것을 좋아했다.
     *
     * 그래서 간단한 디펜스 게임을 만들어 보려고 한다.
     *
     * 당신은 윤성이를 도와, 디펜스 게임 내에서 플레이어가 설치하는 유닛의 사거리를 나타내는 기능을 구현하면 된다.
     *
     * 입력 : 입력 첫째 줄에는 디펜스 게임의 맵 크기 N이 주어딘다.
     *
     * 맵은 N×N 크기의 2차원 형태이다. (N은 6이상 100이하의 짝수)
     *
     * 둘째 줄에는 유닛이 설치될 위치 X, Y와 유닛의 사거리 R이 주어진다.
     *
     * X는 행의 번호, Y는 열의 번호를 의미한다. (X, Y는 1이상 N이하의 자연수, R은 N/2이하의 자연수)
     *
     * 출력 : 예제 출력과 같이 유닛의 사거리를 나타내어 출력한다. (유닛의 사거리가 아무리 길어도 맵을 벗어날 수는 없다.)
     *
     * 예제 입력 : 8
     * 4 5 3
     *
     * 예제 출력 :
     * 0 0 0 0 3 0 0 0
     * 0 0 0 3 2 3 0 0
     * 0 0 3 2 1 2 3 0
     * 0 3 2 1 x 1 2 3
     * 0 0 3 2 1 2 3 0
     * 0 0 0 3 2 3 0 0
     * 0 0 0 0 3 0 0 0
     * 0 0 0 0 0 0 0 0
     *
     * 예제 입력 2 : 6
     * 2 3 3
     *
     * 예제 출력 2 :
     * 3 2 1 2 3 0
     * 2 1 x 1 2 3
     * 3 2 1 2 3 0
     * 0 3 2 3 0 0
     * 0 0 3 0 0 0
     * 0 0 0 0 0 0
     *
     * 출처 : 
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        final int X = scanner.nextInt();
        final int Y = scanner.nextInt();
        final int R = scanner.nextInt();

        final int XIndex = X - 1;
        final int YIndex = Y - 1;

        final String[][] map = new String[N][N];
        map[XIndex][YIndex] = "x";

        for (int r = 1; r <= R; r++) {
            // 상
            if (XIndex - r > -1) {
                int value = r;
                map[XIndex - r][YIndex] = String.valueOf(value++);
                for (int i = YIndex - 1; i > YIndex - R + (r - 1); i--) {
                    if (i < 0) {
                        break;
                    }
                    map[XIndex - r][i] = String.valueOf(value++);
                }
                value = r + 1;
                for (int i = YIndex + 1; i < YIndex + R - (r - 1); i++) {
                    if (i > N - 1) {
                        break;
                    }
                    map[XIndex - r][i] = String.valueOf(value++);
                }
            }
            // 하
            if (XIndex + r < N) {
                int value = r;
                map[XIndex + r][YIndex] = String.valueOf(value++);
                for (int i = YIndex - 1; i > YIndex - R + (r - 1); i--) {
                    if (i < 0) {
                        break;
                    }
                    map[XIndex + r][i] = String.valueOf(value++);
                }
                value = r + 1;
                for (int i = YIndex + 1; i < YIndex + R - (r - 1); i++) {
                    if (i > N - 1) {
                        break;
                    }
                    map[XIndex + r][i] = String.valueOf(value++);
                }
            }
        }
        // 좌
        int value = 1;
        for (int i = YIndex - 1; i >= YIndex - R; i--) {
            if (i <= -1) {
                break;
            }
            map[XIndex][i] = String.valueOf(value++);
        }
        // 우
        value = 1;
        for (int i = YIndex + 1; i <= YIndex + R; i++) {
            if (i >= N) {
                break;
            }
            map[XIndex][i] = String.valueOf(value++);
        }
        for (String[] row : map) {
            for (String column : row) {
                if (column == null) {
                    System.out.print("0 ");
                } else {
                    System.out.print(column + " ");
                }
            }
            System.out.print("\n");
        }
    }
}
