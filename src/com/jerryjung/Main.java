package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
     *
     * 출력 : 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
     *
     * 예제 입력 : 24 18
     *
     * 예제 출력 :
     * 6
     * 72
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     * 출처 : 한국정보올림피아드 지역본선 2004 중등부 1번, 고등부 1번
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        /*
        * 유클리드 호제법 알고리즘
        * 출처: http://itpangpang.xyz/131 [ITPangPang]
        */
        // 1번
        // 두 수를 입력받는다.
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        // 2번
        // 두 수중 큰수와 작은수를 구분한다.
        int bigger = first;
        int smaller = second;
        if (smaller > bigger) {
            int temp = bigger;
            bigger = smaller;
            smaller = temp;
        }
        // 3번
        // 두 수를 나눈 나머지가 0일때 까지 큰수와 작은수를 나눈다.
        int reminder = 1;
        while (reminder > 0) {
            reminder = bigger % smaller;
            bigger = smaller;
            smaller = reminder;
        }
        // 4번
        // 나머지가 0이 되는 순간 큰수가 최대공약수이다.
        int GCD = bigger;
        // 5번
        // 처음 입력받은 두수의 곱을 최대공약수로 나누면 최소공배수가된다.
        int LCM = (first * second) / bigger;
        System.out.println(GCD);
        System.out.println(LCM);
        /*final LinkedList<Integer> first_divisor = new LinkedList<>();
        final LinkedList<Integer> second_divisor = new LinkedList<>();

        final LinkedList<Integer> first_multiple = new LinkedList<>();
        final LinkedList<Integer> second_multiple = new LinkedList<>();*/

        /*
        // 1부터 9까지 곱한것에 나머지가 0 인것들을 모두 넣고
        // 큰수를 정렬, maxSize로 두고 for문 돌며 비교하는것으로 최대공약수를 구현
        // 하지만 "유클리드호제 법" 이란 것을 사용하면 쉽게 구하는것을 알게되어 주석처리


        // 공약수 넣기
        for (int i = 1; i < 9; i++) {
            if (first % i == 0) {
                first_divisor.add(i);
                first_divisor.add(first / i);
            }

            if (second % i == 0) {
                second_divisor.add(i);
                second_divisor.add(second / i);
            }
        }

        boolean isFirstMaxSize = false;
        int maxSize = 0;
        if (first_divisor.size() >= second_divisor.size()) {
            isFirstMaxSize = true;
            maxSize = first_divisor.size();
            first_divisor.sort(Comparator.naturalOrder());
        } else {
            maxSize = second_divisor.size();
            second_divisor.sort(Comparator.naturalOrder());
        }

        int maxDivisor = 1;
        for (int i = 0; i < maxSize; i++) {
            if (isFirstMaxSize) {
                for (Integer divisorValue : second_divisor) {
                    if (first_divisor.get(i).equals(divisorValue)) {
                        maxDivisor = first_divisor.get(i);
                    }
                }
            } else {
                for (Integer divisorValue : first_divisor) {
                    if (second_divisor.get(i).equals(divisorValue)) {
                        maxDivisor = second_divisor.get(i);
                    }
                }
            }
        }

        System.out.println("최대공약수 : " + maxDivisor);*/

        /*
        // 최소공배수를 각각 max 100까지 곱한값을 넣고 모두 비교 후 같은게없으면,
        // max를 200, 300, 400 ... 로 늘려가며 list에 넣어서 비교 하려고했음
        // 하지만 "유클리드호제 법" 이란 것을 사용하면 쉽게 구하는것을 알게되어 주석처리
        boolean isFirstNotYet = true;
        boolean isSecondNotYet = true;
        int value = 1;

        // 공배수 넣기
        while (isFirstNotYet || isSecondNotYet) {
            if (isFirstNotYet) {
                first_multiple.add(first * value);

                isFirstNotYet = false;
            }

            if (isSecondNotYet) {
                second_multiple.add(second * value);
                isSecondNotYet = false;
            }
        }*/
    }
}
