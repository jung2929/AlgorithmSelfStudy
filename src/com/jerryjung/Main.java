package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 체스에서 룩이라는 기물은 상, 하, 좌, 우 방향으로 막혀있지만 않으면 움직일 수 있다.
     * 체스는 킹만 잡히면 지게 되는 게임이다. 그 중에서도 알랩이는 룩으로 인해 게임을 지는 것을 극도로 싫어한다!
     * 현재 체스판의 상태가 주어져 있고, 다음 차례가 상대의 차례일 때, 킹이 룩에게 잡힐 가능성이 있는지 알아보자
     *
     * 입력 : 8줄에 걸쳐 8x8 체스판의 상태가 주어진다.
     * 이때 0은 기물이 없는 상태이고, 1은 알랩이의 킹을 의미하고, 2는 상대의 룩을 의미하며 3은 그 외 다른 기물들을 의미한다.
     * (킹은 하나만 존재하며, 상대의 룩은 최대 2개까지 있을 수 있다. 그 외 기물들은 최대 29개까지 있을 수 있다.)
     *
     * 출력 : 킹이 룩에게 잡힐 가능성이 있으면 1, 아니면 0을 출력한다.
     *
     * 예제 입력 :
     * 0 3 0 0 0 0 0 0
     * 3 1 0 0 0 0 2 0
     * 0 3 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     *
     * 예제 출력 : 1
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     * 출처 :
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[][] array = new int[8][8];
        int firstRookRow = -1, firstRookColumn = -1;
        int secondRookRow = -1, secondRookColumn = -1;
        int kingRow = -1, kingColumn = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final int value = scanner.nextInt();
                if (value == 1) {
                    kingRow = i;
                    kingColumn = j;
                } else if (value == 2) {
                    if (firstRookRow == -1) {
                        firstRookRow = i;
                        firstRookColumn = j;
                    } else {
                        secondRookRow = i;
                        secondRookColumn = j;
                    }
                }
                array[i][j] = value;
            }
        }

//        System.out.println("firstRookRow : " + firstRookRow);
//        System.out.println("firstRookColumn : " + firstRookColumn);
//        System.out.println("secondRookRow : " + secondRookRow);
//        System.out.println("secondRookColumn : " + secondRookColumn);
//        System.out.println("kingRow : " + kingRow);
//        System.out.println("kingColumn : " + kingColumn);

        if (firstRookRow == -1) {
            System.out.print(0);
            return;
        } else {
            if (firstRookRow == kingRow) {
                if (isBlockedForRow(array, firstRookRow, firstRookColumn, kingColumn)) {
                    if (secondRookRow == -1) {
                        System.out.print(0);
                        return;
                    } else {
                        if (secondRookRow == kingRow) {
                            if (isBlockedForRow(array, secondRookRow, secondRookColumn, kingColumn)) {
                                System.out.print(0);
                                return;
                            } else {
                                System.out.print(1);
                                return;
                            }
                        }
                        if (secondRookColumn == kingColumn) {
                            if (isBlockedForColumn(array, secondRookColumn, secondRookRow, kingRow)) {
                                System.out.print(0);
                                return;
                            } else {
                                System.out.print(1);
                                return;
                            }
                        }
                    }
                    System.out.print(0);
                    return;
                } else {
                    System.out.print(1);
                    return;
                }
            }
            if (firstRookColumn == kingColumn) {
                if (isBlockedForColumn(array, firstRookColumn, firstRookRow, kingRow)) {
                    if (secondRookRow == -1) {
                        System.out.print(0);
                        return;
                    } else {
                        if (secondRookRow == kingRow) {
                            if (isBlockedForRow(array, secondRookRow, secondRookColumn, kingColumn)) {
                                System.out.print(0);
                                return;
                            } else {
                                System.out.print(1);
                                return;
                            }
                        }
                        if (secondRookColumn == kingColumn) {
                            if (isBlockedForColumn(array, secondRookColumn, secondRookRow, kingRow)) {
                                System.out.print(0);
                                return;
                            } else {
                                System.out.print(1);
                                return;
                            }
                        }
                    }
                    System.out.print(0);
                    return;
                } else {
                    System.out.print(1);
                    return;
                }
            }
        }
        if (secondRookRow == kingRow) {
            if (isBlockedForRow(array, secondRookRow, secondRookColumn, kingColumn)) {
                System.out.print(0);
                return;
            } else {
                System.out.print(1);
                return;
            }
        }
        if (secondRookColumn == kingColumn) {
            if (isBlockedForColumn(array, secondRookColumn, secondRookRow, kingRow)) {
                System.out.print(0);
                return;
            } else {
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }

    private static boolean isBlockedForRow(final int[][] array, final int row, final int rookTarget, final int kingTarget) {
        if (rookTarget > kingTarget) {
            for (int j = kingTarget + 1; j < rookTarget; j++) {
                if (array[row][j] != 0) {
//                        System.out.print(0);
                    return true;
                }
            }
//                System.out.print(1);
            return false;
        } else {
            for (int j = rookTarget + 1; j < kingTarget; j++) {
                if (array[row][j] != 0) {
//                        System.out.print(0);
                    return true;
                }
            }
//                System.out.print(1);
            return false;
        }
    }

    private static boolean isBlockedForColumn(final int[][] array, final int column, final int rookTarget, final int kingTarget) {
        if (rookTarget > kingTarget) {
            for (int j = kingTarget + 1; j < rookTarget; j++) {
                if (array[j][column] != 0) {
//                        System.out.print(0);
                    return true;
                }
            }
//                System.out.print(1);
            return false;
        } else {
            for (int j = rookTarget + 1; j < kingTarget; j++) {
                if (array[j][column] != 0) {
//                        System.out.print(0);
                    return true;
                }
            }
//                System.out.print(1);
            return false;
        }
    }
}