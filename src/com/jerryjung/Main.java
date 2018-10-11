package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 두 정수 n, k를 입력받아 k개의 1을 가진 n자리 이진 패턴을 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 두 정수 n,k가 입력으로 주어진다. ( 0< n <= 30, 0 <= k < 8 , n>=k )
     *
     * 출력 : 결과를 내림차순으로 출력한다.
     *
     * 예제 입력 : 2 1
     *
     * 예제 출력 :
     * 10
     * 01
     *
     * 예제 입력 2 : 2 0
     *
     * 예제 출력 2 :
     * 00
     *
     * 예제 입력 3 : 4 2
     *
     * 예제 출력 3 :
     * 1100
     * 1010
     * 1001
     * 0110
     * 0101
     * 0011
     *
     * 출처 : 
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        final int[] check = new int[n];
        tobin(n, k, check, 0, 0);
    }

    private static void tobin(final int n, final int k, final int[] check, int loop, int count) {
        for (int i = loop; i < n; i++) {
            if (k == 0) {
                for (int value : check) {
                    System.out.print(value);
                }
                return;
            }

            if (check[i] == 0) {
                check[i] = 1;
                count += 1;
                tobin(n, k, check, i + 1, count);
                if (count == k) {
                    for (int z = 0; z < check.length; z++) {
                        if (z == check.length - 1) {
                            System.out.println(check[z]);
                        } else {
                            System.out.print(check[z]);
                        }
                    }
                }
                check[i] = 0;
                count -= 1;
            }
        }
    }
}
