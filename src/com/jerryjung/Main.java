package com.jerryjung;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * 문제 : 크기가 N×N인 도시가 있다.
     * 도시는 1×1크기의 칸으로 나누어져 있다.
     * 도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다.
     * 도시의 칸은 (r, c)와 같은 형태로 나타내고, r행 c열 또는 위에서부터 r번째 칸, 왼쪽에서부터 c번째 칸을 의미한다.
     * r과 c는 1부터 시작한다.
     *
     * 이 도시에 사는 사람들은 치킨을 매우 좋아한다.
     * 따라서, 사람들은 "치킨 거리"라는 말을 주로 사용한다.
     * 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.
     * 즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다.
     * 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
     *
     * 임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.
     *
     * 예를 들어, 아래와 같은 지도를 갖는 도시를 살펴보자.
     *
     * 0 2 0 1 0
     * 1 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 1 1
     * 0 0 0 1 2
     *
     * 0은 빈 칸, 1은 집, 2는 치킨집이다.
     *
     * (2, 1)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |2-1| + |1-2| = 2, (5, 5)에 있는 치킨집과의 거리는 |2-5| + |1-5| = 7이다.
     * 따라서, (2, 1)에 있는 집의 치킨 거리는 2이다.
     *
     * (5, 4)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |5-1| + |4-2| = 6, (5, 5)에 있는 치킨집과의 거리는 |5-5| + |4-5| = 1이다.
     * 따라서, (5, 4)에 있는 집의 치킨 거리는 1이다.
     *
     * 이 도시에 있는 치킨집은 모두 같은 프랜차이즈이다. 프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다.
     * 오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 최대 M개라는 사실을 알아내었다.
     *
     * 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다.
     * 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.
     *
     * 둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.
     *
     * 도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다.
     *
     * 집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다.
     *
     * 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.
     *
     * 출력 : 첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.
     *
     * 예제 입력 :
     * 5 3
     * 0 0 1 0 0
     * 0 0 2 0 1
     * 0 1 2 0 0
     * 0 0 1 0 0
     * 0 0 0 0 2
     *
     * 예제 출력 : 5
     *
     * 예제 입력 2 :
     * 5 2
     * 0 2 0 1 0
     * 1 0 1 0 0
     * 0 0 0 0 0
     * 2 0 0 1 1
     * 2 2 0 1 2
     *
     * 예제 출력 2 : 10
     *
     * 예제 입력 3 :
     * 5 1
     * 1 2 0 0 0
     * 1 2 0 0 0
     * 1 2 0 0 0
     * 1 2 0 0 0
     * 1 2 0 0 0
     *
     * 예제 출력 3 : 11
     *
     * 예제 입력 4 :
     * 5 1
     * 1 2 0 2 1
     * 1 2 0 2 1
     * 1 2 0 2 1
     * 1 2 0 2 1
     * 1 2 0 2 1
     *
     * 예제 출력 4 : 32
     *
     * 출처 : https://www.acmicpc.net/problem/15686
     */

    static class Pair {
        int row;
        int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private static int M = 0;
    private static ArrayList<Pair> homeArrayList = new ArrayList<>();
    private static ArrayList<Pair> chickenArrayList = new ArrayList<>();
    private static ArrayList<Pair> chosenArrayList = new ArrayList<>();
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        M = scanner.nextInt();
//        final int[][] map = new int[N][N];

//        int homeSize = 0;
//        int chickenSize = 0;
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                int value = scanner.nextInt();
                if (value == 1) {
//                    homeSize++;
                    homeArrayList.add(new Pair(row, column));
                } else if (value == 2) {
//                    chickenSize++;
                    chickenArrayList.add(new Pair(row, column));
                }
//                map[row][column] = value;
            }
        }

        boolean[] check = new boolean[chickenArrayList.size()];

        DFS(0, 0, check);

        System.out.print(result);

//        final int[][] values = new int[homeSize][chickenSize];
//        int homeIndex = 0;
//        for (int row = 0; row < N; row++) {
//            for (int column = 0; column < N; column++) {
//                int value = map[row][column];
//                if (value == 1) {
//                    addDistance(map, values, row, column, homeIndex);
//                    homeIndex += 1;
//                }
//            }
//        }

//        for (int[] v : values) {
//            for (int vv : v) {
//                System.out.print(vv + " ");
//            }
//            System.out.print("\n");
//        }

//        if (M == 1) {
//            searchResult(values, homeSize, chickenSize);
//        } else {
//            // 모든 치킨집 개수 보다 M의 개수가 작을 경우
//            if (chickenSize > M) {
//                int[] eachCount = new int[chickenSize];
//                for (int row = 0; row < homeSize; row++) {
//                    // 오름차순 정렬
//                    //int[] temps = values[row];
//                    //Arrays.sort(temps);
//
//                    // 각 행의 최솟값에 해당하는 열의 count + 1
//                    int min = Integer.MAX_VALUE;
//                    int minIndex = Integer.MAX_VALUE;
//                    for (int column = 0; column < chickenSize; column++) {
//                        int temp = values[row][column];
//                        if (min >= temp) {
//                            min = temp;
//                            minIndex = column;
//                        }
//                    }
//                    System.out.print(minIndex + " ");
//                    eachCount[minIndex]++;
//                }
//                System.out.print("\n");
//                for (int m = 0 ; m < M; m++) {
//                    System.out.print(v + " ");
//                }
//
//                for (int loop = 0; loop < M; loop++) {
//
//                }
//
//            } else {
//                searchResult(values, homeSize, chickenSize);
//            }
//        }
    }

    private static void DFS(int start, int count, boolean[] check) {
        // 치킨집 최대 갯수만큼 구햇을 경우 거리 계산
        if (count == M) {
            int totalDistance = calculateDistance();
            if (result > totalDistance) {
                result = totalDistance;
            }
            return;
        }

        // 모든 치킨집 갯수만큼 돌기
        for (int i = start; i < chickenArrayList.size(); i++) {
            // 이미 방문한 치킨집이면 PASS
            if (check[i]) {
                continue;
            }
            check[i] = true;
            chosenArrayList.add(chickenArrayList.get(i));
            count++;
            DFS(i + 1, count, check);
            count--;
            chosenArrayList.remove(chickenArrayList.get(i));
            check[i] = false;
        }
    }

    private static int calculateDistance() {
        int totalDistance = 0;
        for (Pair homePair : homeArrayList) {
            int distance = Integer.MAX_VALUE;
            for (Pair chickenPair : chosenArrayList) {
                int temp = Math.abs(homePair.row - chickenPair.row)
                        + Math.abs(homePair.column - chickenPair.column);
                if (distance > temp) {
                    distance = temp;
                }
            }
            totalDistance += distance;
        }
        return totalDistance;
    }

//    private static void addDistance(int[][] map, int[][] values, int homeRow, int homeColumn, int homeIndex) {
//        int chickenIndex = 0;
//        for (int row = 0; row < map.length; row++) {
//            for (int column = 0; column < map[0].length; column++) {
//                if (map[row][column] == 2) {
//                    values[homeIndex][chickenIndex] = Math.abs((homeRow + 1) - (row + 1)) + Math.abs((homeColumn + 1) - (column + 1));
//                    chickenIndex += 1;
//                }
//            }
//        }
//    }

//    private static void searchResult(int[][] values, int homeSize, int chickenSize) {
//        int result = Integer.MAX_VALUE;
//        for (int row = 0; row < chickenSize; row++) {
//            int temp = 0;
//            for (int column = 0; column < homeSize; column++) {
//                temp += values[row][column];
//            }
//            System.out.print(temp + " ");
//            if (result > temp) {
//                result = temp;
//            }
//        }
//        System.out.print("\n");
//        System.out.print(result);
//    }
}
