package com.jerryjung;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * 문제 : 서로 다른 n개의 원소들 중에서 r개만을 뽑아 일렬로 나열하는 것을 순열이라 한다.
     * 예를 들어, 3개의 원소 a, b, c 중에서 2개만을 뽑아 나열하면 ab, ac, ba, bc, ca, cb 의 6가지 경우가 있다.
     * n과 r이 주어질 때, n개의 소문자 중에서 r개만을 뽑아 나열하는 모든 경우를 출력하는 프로그램을 작성하시오.
     * 단, a부터 시작하여 연속으로 n개의 알파벳을 갖고 있다고 하자.
     *
     * 입력 : 첫 번째 줄에 n과 r이 주어진다. ( 1 ≤ n ≤ 26, 1 ≤ r ≤ n )
     *
     * 출력 : 각 줄에 n개의 소문자 중에서 r개만을 뽑아 나열하는 경우를 사전순으로 나열한 결과를 출력한다.
     *
     * 예제 입력 : 4 2
     *
     * 예제 출력 :
     * ab
     * ac
     * ad
     * ba
     * bc
     * bd
     * ca
     * cb
     * cd
     * da
     * db
     * dc
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     */
    private final static String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x",
            "y", "z"};
    private final static ArrayList<Integer> selectedArrayList = new ArrayList<>();
    private static int loopCount = 0;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int r = scanner.nextInt();
        final ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        permutation(arrayList, 0, n, r);
    }

    private static void permutation(final ArrayList<Integer> removedArrayList, int index, final int n, final int r) {
        for (int i = 0; i < n; i++) {
            if (loopCount == 0) {
                index = i;
            }

            if (loopCount == r - 1) {
                for (int k = selectedArrayList.size() - 1; k >= 0; k--) {
                    removedArrayList.remove(selectedArrayList.get(k));
                }

                for (final int value : removedArrayList) {
                    for (final int selectedValue : selectedArrayList) {
                        System.out.print(alphabet[selectedValue]);
                    }
                    System.out.println(alphabet[value]);
                }
                // 초기화
                loopCount = 0;
                //index = ++i;
                selectedArrayList.clear();
                removedArrayList.clear();
                for (int j = 0; j < n; j++) {
                    removedArrayList.add(j);
                }
                continue;
                //break;
            }
            // 선택된 값 제거, 선택된 어레이리스트에 추가
            selectedArrayList.add(removedArrayList.get(index++));
            loopCount++;
            permutation(removedArrayList, index, n, r);
            /*// 초기화
            loopCount = 0;
            index = ++i;
            selectedArrayList.clear();
            removedArrayList.clear();
            for (int j = 0; j < n; j++) {
                removedArrayList.add(j);
            }*/
        }
    }
}
