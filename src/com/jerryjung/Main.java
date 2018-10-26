package com.jerryjung;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * 문제 : 사다리 게임은 N개의 세로선과 M개의 가로선으로 이루어져 있다.
     * 인접한 세로선 사이에는 가로선을 놓을 수 있는데, 각각의 세로선마다 가로선을 놓을 수 있는 위치의 개수는 H이고, 모든 세로선이 같은 위치를 갖는다.
     * 아래 그림은 N = 5, H = 6 인 경우의 그림이고, 가로선은 없다.
     *
     * 초록선은 세로선을 나타내고, 초록선과 점선이 교차하는 점은 가로선을 놓을 수 있는 점이다.
     * 가로선은 인접한 두 세로선을 연결해야 한다.
     * 단, 두 가로선이 연속하거나 서로 접하면 안된다.
     * 또, 가로선은 점선 위에 있어야 한다.
     *
     * 위의 그림에는 가로선이 총 5개 있다.
     * 가로선은 위의 그림과 같이 인접한 두 세로선을 연결해야 하고, 가로선을 놓을 수 있는 위치를 연결해야 한다.
     *
     * 사다리 게임은 각각의 세로선마다 게임을 진행하고, 세로선의 가장 위에서부터 아래 방향으로 내려가야 한다.
     * 이때, 가로선을 만나면 가로선을 이용해 옆 세로선으로 이동한 다음, 이동한 세로선에서 아래 방향으로 이동해야 한다.
     *
     * 위의 그림에서 1번은 3번으로, 2번은 2번으로, 3번은 5번으로, 4번은 1번으로, 5번은 4번으로 도착하게 된다.
     * 아래 두 그림은 1번과 2번이 어떻게 이동했는지 나타내는 그림이다.
     *
     * 사다리에 가로선을 추가해서, 사다리 게임의 결과를 조작하려고 한다.
     * 이때, i번 세로선의 결과가 i번이 나와야 한다.
     * 그렇게 하기 위해서 추가해야 하는 가로선 개수의 최솟값을 구하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에 세로선의 개수 N, 가로선의 개수 M, 세로선마다 가로선을 놓을 수 있는 위치의 개수 H가 주어진다.
     * (2 ≤ N ≤ 10, 1 ≤ H ≤ 30, 0 ≤ M ≤ (N-1)×H)
     *
     * 둘째 줄부터 M개의 줄에는 가로선의 정보가 한 줄에 하나씩 주어진다.
     *
     * 가로선의 정보는 두 정수 a과 b로 나타낸다.
     * (1 ≤ a ≤ H, 1 ≤ b ≤ N-1) b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다는 의미이다.
     *
     * 가장 위에 있는 점선의 번호는 1번이고, 아래로 내려갈 때마다 1이 증가한다.
     * 세로선은 가장 왼쪽에 있는 것의 번호가 1번이고, 오른쪽으로 갈 때마다 1이 증가한다.
     *
     * 입력으로 주어지는 가로선이 서로 연속하는 경우는 없다.
     *
     * 출력 : i번 세로선의 결과가 i번이 나오도록 사다리 게임을 조작하려면, 추가해야 하는 가로선 개수의 최솟값을 출력한다.
     * 만약, 정답이 3보다 큰 값이면 -1을 출력한다.
     * 또, 불가능한 경우에도 -1을 출력한다.
     *
     * 예제 입력 : 2 0 3
     *
     * 예제 출력 : 0
     *
     * 예제 입력 2 :
     * 2 1 3
     * 1 1
     *
     * 예제 출력 2 : 1
     *
     * 예제 입력 3 :
     * 5 5 6
     * 1 1
     * 3 2
     * 2 3
     * 5 1
     * 5 4
     *
     * 예제 출력 3 : 3
     *
     * 예제 입력 4 :
     * 6 5 6
     * 1 1
     * 3 2
     * 1 3
     * 2 5
     * 5 5
     *
     * 예제 출력 4 : 3
     *
     * 예제 입력 5 :
     * 5 8 6
     * 1 1
     * 2 2
     * 3 3
     * 4 4
     * 3 1
     * 4 2
     * 5 3
     * 6 4
     *
     * 예제 출력 5 : -1
     *
     *
     * 예제 입력 6 :
     * 5 12 6
     * 1 1
     * 1 3
     * 2 2
     * 2 4
     * 3 1
     * 3 3
     * 4 2
     * 4 4
     * 5 1
     * 5 3
     * 6 2
     * 6 4
     *
     * 예제 출력 6 : -1
     *
     * 예제 입력 7 :
     * 5 6 6
     * 1 1
     * 3 1
     * 5 2
     * 4 3
     * 2 3
     * 1 4
     *
     * 예제 출력 7 : 2
     *
     * 출처 : 
     */

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }


    static int N = 0;
    static int M = 0;
    static int H = 0;
    static int[][] map;
    static ArrayList<Pair> mArrayList = new ArrayList<>();

    public static void main(String[] args) {
        // 가로 배열 갯수 = N + (N - 1)
        // 세로 배열 갯수 = 2H + 1
        // 세로선 번호 (인덱스) = 0, 2, 4, 6, 8 ...
        // 가로선 번호 (인덱스) = 1, 3, 5, 7, 9 ...
        final Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        H = scanner.nextInt();

        int width = N + (N - 1);
        int height = (2 * H) + 1;
        map = new int[height][width];

        for (int i = 0; i < M; i++) {
            final int a = scanner.nextInt();
            final int b = scanner.nextInt();

            final Pair pair = new Pair(a, b);
            mArrayList.add(pair);
        }

        // 사다리 만들기
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (column % 2 == 0) {
                    map[row][column] = 1;
                } else {
                    map[row][column] = 0;
                }
            }
        }

        // 가로선 긋기
        for (Pair pair : mArrayList) {
            int row = 1 + ((pair.a - 1) * 2);
            int column = 2 * (pair.b - 1) + 1;
            map[row][column] = 1;
        }

        for (int[] a : map) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.print("\n");
        }

        // 가로선의 1의 갯수가 짝수여야 한다.
        int result = 0;
        /*for (int column = 0; column < width; column++) {
            int count = 0;
            for (int row = 0; row < height; row++) {
                if (column % 2 == 0) {
                    continue;
                }
                if (map[row][column] == 1) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                result++;
            }

            if (result > 3) {
                System.out.print(-1);
                return;
            }
        }*/

        System.out.print(result);
    }
}
