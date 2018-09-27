package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 테트리스를 해본 사람이라면 작대기 모양 테트리미노가 나오길 간절히 기다렸던 적이 있을 것이다. 지금 윤성이가 그러하다. 기다리고 기다리던 작대기 모양 테트리미노가 드디어 나온 것이다.
     *
     * 테트리스 맵은 가로로 C칸, 세로로 R칸의 C×R격자형 모양이다. 예를 들어보자. 아래 그림은 가로가 6칸, 세로가 6칸인 테트리스 맵의 상태이다.
     *
     * 0 0 0 0 0 0
     * 0 0 0 0 0 0
     * 1 1 1 0 0 1
     * 1 1 1 1 0 1
     * 1 1 1 1 0 1
     * 1 1 1 1 0 1
     *
     * (1 칸은 이미 메워져있던 칸이고, 0 칸은 이번에 메울 작대기 모양 테트리미노를 의미한다.)
     *
     * 이때 가로가 1칸이고 세로가 4칸인 1×4 직사가형 작대기 모양의 테트리미노(테트리미노는 항상 1×4)를 왼쪽에서 5번째 칸에 둘 경우 총 세줄의 수평선을 메울 수 있다.
     * 테트리스는 한번에 여러 수평선을 메울수록 큰 점수를 얻는 게임이므로, 위 경우에서는 이 방법이 가장 높은 점수를 얻을 수 있는 방법이다.
     *
     * 윤성이를 도와 작대기 모양 테트리미노를 어디에 두었을 때 가장 높은 점수를 얻을 수 있는지 알려주자.
     * (윤성이는 작대기 모양 테트리미노가 나왔을때 게임오버를 당할지언정 가로가 더 길도록 눕혀서 두지 않는다는 나름의 테트리스 철학이 있다.)
     *
     * 입력 : 첫 줄에는 격자 크기를 나타내는 정수 C와 R이 하나의 공백을 사이에 두고 차례대로 주어진다.
     * 두 값의 범위는 5 ≤ C, R ≤ 20이다.
     * 그다음 줄 부터 총 R줄에 걸쳐 맵의 상태를 나타내는 숫자들이 공백을 사이에 두고 주어진다.
     * 0은 아직 채워지지 않은 칸을 나타내며 1은 채워져있는 칸을 나타낸다.
     *
     * 출력 : 작대기를 왼쪽에서 X번째 자리에 두었을 때 가장 높은 점수를 얻을 수 있고 그 때 완전히 메워지는 수평선의 개수가 Y개라면, Y를 최대로 만드는 X와 그 때의 Y를 하나의 공백을 사이에 두고 출력해야 한다.
     *
     * 만약 어떤 자리에 두어도 수평선을 하나도 메울 수 없거나 게임오버가 일어나는 경우라면 X와 Y를 둘다 0으로 출력한다.
     * (게임오버는 새로 내려온 작대기가 맵상을 벗어난 경우에 일어난다. 새로나온 작대기가 맵의 가장자리에 걸쳐있는 경우는 게임오버가 아니다.)
     *
     * 예제 입력 : 6 6
     * 0 0 0 0 0 0
     * 0 0 0 0 0 0
     * 1 1 1 0 0 1
     * 1 1 1 1 0 1
     * 1 1 1 1 0 1
     * 1 1 1 1 0 1
     *
     * 예제 출력 : 5 3
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     */

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int C = scanner.nextInt();
        final int R = scanner.nextInt();
        final int[][] tetris = new int[R][C];

        if (R < 4) {
            System.out.print("0 0");
            return;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tetris[i][j] = scanner.nextInt();
            }
        }

        int[] rowValueInEachColumn = new int[C];
        // 열 기준으로 돌아서 몇개가 가능한지 확인
        for (int columnIndex = 0; columnIndex < C; columnIndex++) {
            int bottomRowValue = R;
            for (int rowIndex = R - 1; rowIndex >= 0; rowIndex--) {
                if (tetris[rowIndex][columnIndex] == 1) {
                    bottomRowValue = rowIndex;
                }
            }
            // 최하단 = 놓을수있는 최대 수
            rowValueInEachColumn[columnIndex] = bottomRowValue;
        }

        // 타켓 열 인덱스 찾기
        int targetColumnIndex = 0;
        int targetRowValue = rowValueInEachColumn[0];
        boolean isLose = true;
        for (int columnIndex = 1; columnIndex < C; columnIndex++) {
            if (rowValueInEachColumn[columnIndex] >= 4) {
                isLose = false;
            }
            // 이전 열의 maxRow 와 현재 열의 maxRow 비교
            if (targetRowValue < rowValueInEachColumn[columnIndex]) {
                targetRowValue = rowValueInEachColumn[columnIndex];
                targetColumnIndex = columnIndex;
            }
        }

        if (isLose) {
            System.out.print("0 0");
            return;
        }

        ////////////////////////////////////
        // 타겟 열, 타겟 로우 필요
        int maxRow = 0;
        for (int i = targetRowValue; i > targetRowValue - 4; i--) {
            if (isAllOne(tetris, i, targetColumnIndex, C)) {
                maxRow++;
            }
        }

        if (maxRow == 0) {
            System.out.print("0 0");
        } else {
            System.out.print((targetColumnIndex + 1) + " " + maxRow);
        }
    }

    private static boolean isAllOne(final int[][] tetris, int targetRow, int targetColumn, int maxColumn) {
        boolean isAllOne = true;
        for (int i = 0; i < maxColumn; i++) {
            if (i != targetColumn) {
                if (tetris[targetRow - 1][i] == 0) {
                    isAllOne = false;
                    break;
                }
            }
        }
        return isAllOne;
    }
}
