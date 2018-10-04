package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : 정보문화진흥원 정보 영재 동아리에서 동아리 활동을 하던 영수와 민혁이는 쉬는 시간을 틈타 숫자야구 게임을 하기로 했다.
     *
     * 영수는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 마음속으로 생각한다.
     * (예: 324) 민혁이는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 영수에게 묻는다.
     * (예: 123) 민혁이가 말한 세 자리 수에 있는 숫자들 중 하나가 영수의 세 자리 수의 동일한 자리에 위치하면 스트라이크 한 번으로 센다.
     * 숫자가 영수의 세 자리 수에 있긴 하나 다른 자리에 위치하면 볼 한 번으로 센다.
     *
     * 예) 영수가 324를 갖고 있으면
     * * 429는 1 스트라이크 1 볼이다.
     * * 241은 0 스트라이크 2 볼이다.
     * * 924는 2 스트라이크 0 볼이다.
     *
     * 영수는 민혁이가 말한 수가 몇 스트라이크 몇 볼인지를 답해준다.
     * 민혁이가 영수의 세 자리 수를 정확하게 맞추어 3 스트라이크가 되면 게임이 끝난다.
     * 아니라면 민혁이는 새로운 수를 생각해 다시 영수에게 묻는다.
     * 현재 민혁이와 영수는 게임을 하고 있는 도중에 있다.
     * 민혁이가 영수에게 어떤 수들을 물어보았는지, 그리고 각각의 물음에 영수가 어떤 대답을 했는지가 입력으로 주어진다.
     * 이 입력을 바탕으로 여러분은 영수가 생각하고 있을 가능성이 있는 수가 총 몇 개인지를 알아맞혀야 한다.
     *
     * 아래와 같은 경우를 생각해보자.
     * * 민혁: 123
     * * 영수: 1 스트라이크 1 볼.
     * * 민혁: 356
     * * 영수: 1 스트라이크 0 볼.
     * * 민혁: 327
     * * 영수: 2 스트라이크 0 볼.
     * * 민혁: 489
     * * 영수: 0 스트라이크 1 볼.
     *
     * 이 때 가능한 답은 324와 328, 이렇게 두 가지이다.
     *
     * 영수는 동아리의 규율을 잘 따르는 착한 아이라 민혁이의 물음에 곧이곧대로 정직하게 답한다. 그러므로 영수의 답들에는 모순이 없다.
     *
     * 민혁이의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에는 민혁이가 영수에게 몇 번이나 질문을 했는지를 나타내는 1 이상 100 이하의 자연수 N이 주어진다.
     * 이어지는 N개의 줄에는 각 줄마다 민혁이가 질문한 세 자리 수와 영수가 답한 스트라이크 개수를 나타내는 정수와 볼의 개수를 나타내는 정수,
     * 이렇게 총 세 개의 정수가 빈칸을 사이에 두고 주어진다.
     *
     * 출력 : 첫 줄에 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력한다.
     *
     * 예제 입력 : 4
     * 123 1 1
     * 356 1 0
     * 327 2 0
     * 489 0 1
     *
     * 예제 출력 : 2
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int loopCount = scanner.nextInt();
        final int[] targetValues = new int[loopCount];
        final int[] targetStrikes = new int[loopCount];
        final int[] targetBalls = new int[loopCount];
        for (int i = 0; i < loopCount; i++) {
            targetValues[i] = scanner.nextInt();
            targetStrikes[i] = scanner.nextInt();
            targetBalls[i] = scanner.nextInt();
        }

        int result = 0;
        int compareValue = 123;
        while (compareValue <= 987) {
            int matchCount = 0;
            for (int i = 0; i < loopCount; i++) {
                final int value = targetValues[i];
                final int strike = targetStrikes[i];
                final int ball = targetBalls[i];

                final String stringValue = String.valueOf(value);
                final int first = Integer.valueOf(stringValue.substring(0, 1));
                final int second = Integer.valueOf(stringValue.substring(1, 2));
                final int third = Integer.valueOf(stringValue.substring(2, 3));

                final String compareStringValue = String.valueOf(compareValue);
                final int compareFirst = Integer.valueOf(compareStringValue.substring(0, 1));
                final int compareSecond = Integer.valueOf(compareStringValue.substring(1, 2));
                final int compareThird = Integer.valueOf(compareStringValue.substring(2, 3));
                int compareStrike = 0;
                int compareBall = 0;

                if (compareFirst == compareSecond || compareSecond == compareThird || compareFirst == compareThird) {
                    break;
                }

                if (compareFirst == 0 || compareSecond == 0 || compareThird == 0) {
                    break;
                }

                if (first == compareFirst) {
                    compareStrike++;
                }

                if (second == compareSecond) {
                    compareStrike++;
                }

                if (third == compareThird) {
                    compareStrike++;
                }

                if (first == compareSecond || first == compareThird) {
                    compareBall++;
                }

                if (second == compareFirst || second == compareThird) {
                    compareBall++;
                }

                if (third == compareFirst || third == compareSecond) {
                    compareBall++;
                }

                if (strike == compareStrike && ball == compareBall) {
                    matchCount++;
                } else {
                    break;
                }
            }
            if (matchCount == loopCount) {
                result++;
            }
            compareValue++;
        }

        System.out.print(result);
    }
}
