package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 임의의 자연수는 그보다 작은 자연수들의 합으로 표현될 수 있다. 예를 들어 4의 경우,
     * 4 = 3+1
     *   = 2+2
     *   = 2+1+1
     *   = 1+1+1+1
     * 위와 같은 방법으로 표현 될 수 있다.
     * 이 때 , 숫자의 구성이 같으면서 그 순서만이 다른 경우는 같은 경우로 생각하는데, 예를 들어 다음 세 가지 경우는 모두 같은 경우이다.
     * 2 + 1 + 1, 1 + 2 + 1 , 1 + 1 + 2
     * 자연수 n을 입력 받아 이를 n보다 작은 자연수들의 합으로 나타내는 방법을 모두 출력하는 프로그램을 재귀 호출을 사용하여 작성하시오.
     *
     * 입력 : 첫 줄에 2 이상 20 이하의 자연수 n이 주어진다.
     *
     * 출력 : 첫째 줄부터 모든 방법을 한 줄에 하나씩 출력한다.
     * 하나의 식 안에는 큰 숫자가 앞으로 오도록 하 고, 전체적으로는 앞의 숫자가 큰 식이 먼저 출력되도록 한다.
     * 숫자와 더하기 사이에는 공백이 없다.
     * 그리고 마지막 줄에는 나누어진 자연수의 개수를 출력한다.
     *
     * 예제 입력 : 5
     *
     * 예제 출력 :
     * 4+1
     * 3+2
     * 3+1+1
     * 2+2+1
     * 2+1+1+1
     * 1+1+1+1+1
     * 6
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     * 출처 : 
     */

//    private static int loop = 0;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        //division(scanner.nextInt(), 0, false);
        //division(scanner.nextInt(), 0, false);
//        loop = scanner.nextInt();
//        division(loop - 1, 1, "");
//        int start = scanner.nextInt();
//        String result = start - 1 + "+" + 1;
        division(scanner.nextInt()- 1, 1, "", "");
    }
    // 3 = 2 + 1
    //     1 + 1 + 1

    // 4 = 3 + 1
    //     2 + 2
    //     2 + 1 + 1
    //     1 + 1 + 1 + 1

    // 5 = 4 + 1
    //     3 + 2
    //     3 + 1 + 1
    //     2 + 2 + 1
    //     2 + 1 + 1 + 1
    //     1 + 1 + 1 + 1 + 1
    private static void division(int prev, int next, String start, String end) {
        if (prev > 1) {
            if (next == 1) {
                System.out.println(start + prev + "+" + next  + end);
                start = prev - 1 + "+";
                division(prev - 1, next + 1, start, end);
            } else if (next == 2) {
                System.out.println(start + next);
                end = "+1";
                //end = "";
                System.out.println(start + "1+1");
                start = prev - 1 + "+";
                division(prev - 1, next - 1, start, end);
            }
//            else {
//                System.out.println(result + next);
//                division(prev, next, result);
//                result = "";
//            }
        } else {
            System.out.print(start + 1 + "+" + 1 + end);
        }

//            if (i == 1) {
//                System.out.println(1);
//                return;
//            }
//
//            if (isLast) {
//                System.out.println(i);
//                if (i > 1) {
//                    System.out.print(i + 1);
//                }
//                division(i - 1, false);
//                return;
//            }
//
//            System.out.print(i - 1);
//            System.out.print("+");
//
//            if (i - 1 > 1) {
//                division(i - 1, true);
//                System.out.print("\n");
//            } else {
//                System.out.print();
//                System.out.print();
//            }
//        }
    }
}
