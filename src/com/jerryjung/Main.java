package com.jerryjung;

import java.util.Scanner;

public class Main {

    /**
     * 문제 : The Game of Death
     * 희현이와 주경이는 The Game of Death를 좋아한다.
     *
     * The Game of Death 규칙:
     *
     * 플레이어는 각자 한 명씩 지목을 한다(자신도 가능).
     * 처음 시작하는 사람은 임의의 자연수 K를 말한다.
     * 시작한 사람부터 지목한 사람을 차례대로 따라가다가 K번째 지목당한 사람이 걸리게 된다.
     * 희현이는 희현이부터 이 게임을 시작할 때 이 게임에서 반드시 주경이를 반드시! 걸리게 하고 싶다. 주경이가 걸릴 수 있도록 희현이를 도와주자.
     *
     * 입력 :
     * 첫 줄에는 테스트 케이스의 숫자 T가 주어지며, 이어서 T번에 걸쳐 테스트 케이스들이 주어진다.
     *
     * 매 테스트 케이스의 첫 줄에는 플레이어의 숫자 N(1 ≤ N ≤ 10,000)이 주어진다.
     *
     * 이어서 N줄에 걸쳐 각 플레이어가 지명한 사람의 숫자 Ai(1 ≤ Ai ≤ N, 1 ≤ i ≤ N)이 주어진다.
     *
     * 희현이는 1번, 주경이는 N번이다,
     *
     * 출력 :
     * 매 테스트 케이스마다 한 줄에 걸쳐 희현이가 주경이를 걸리게 하고 싶을 때 불러야 하는 최소 숫자 K를 출력한다.
     *
     * 만약 어떤 숫자를 말해도 주경이가 걸리지 않는다면 0을 출력해야 한다.
     *
     * 예제 입력 :
     * 1
     * 7
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 1
     *
     * 예제 출력 : 6
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     * 출처 : 
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt();
        // 테스트 케이스만큼 수행
        for (int t = 0; t < T; t++) {
            final int N = scanner.nextInt();
            final int[] map = new int[N + 1];
            for (int n = 1; n <= N; n++) {
                int value = scanner.nextInt();
                map[n] = value;
            }
            int loop = 1;
            int index = 1;
            int result = 0;
            while (true) {
                if (map[index] == N) {
                    result = loop;
                    break;
                }
                index = map[index];
                loop++;
                if (loop > N) break;
            }
            System.out.println(result);
        }
    }
}