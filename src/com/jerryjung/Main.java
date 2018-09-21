package com.jerryjung;

//import java.util.ArrayList;
//import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * 문제 : N개의 숫자가 주어질 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     *
     * 입력 : 첫 번째 줄에 숫자의 개수 N이 주어진다. ( 1 <= N <= 1,000 ) 두 번째 줄에 정렬해야 할 N개의 숫자가 주어진다.
     *
     * 출력 : 첫 번째 줄에 N개의 숫자를 오름차순으로 정렬한 결과를 출력한다.
     *
     * 예제 입력 : 10
     * 1 9 2 8 3 4 5 7 6 10
     *
     * 예제 출력 : 1 2 3 4 5 6 7 8 9 10
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     */
    // Array 사용
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int size = scanner.nextInt();
        final int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
    /*
    // 직접 구축해본 sorting (마지막 인데스 비교 후 마지막인덱스보다 크면 바로 넣고, 작으면 지금까지 넣은것들 돌면서 자리교체 로직)
    // -> 테스트 케이스 3(테스트값 뭔지 모름)에서 Runtime Error (java.lang.IndexOutOfBoundsException) 발생
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int size = scanner.nextInt();
        final ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            final int target = scanner.nextInt();

            if (arrayList.size() == 0) {
                arrayList.add(i, target);
                continue;
            }
            // 넣으려는 값이 기존에 존재하던 마지막 값보다 클 경우
            if (arrayList.get(i - 1) < target) {
                arrayList.add(i, target);
            } else {
                // 넣으려는 값이 기존에 존재하던 마지막 값보다 작을 경우
                // 넣어있던 값들의 처음부터 비교 (끝부터 비교도 가능함)
                // 중간 값부터 비교하고싶은데 인덱스가 작기 때문에 오히려 시간복잡도상으로 오래걸림 -> arraySize 가 크다면 좋은 방법
                for (int j = 0; j < arrayList.size(); j++) {
                    final int value = arrayList.get(j);
                    if (value > target) {
                        arrayList.add(j, target);
                        break;
                    }
                }
            }
        }

        for (final int value : arrayList) {
            System.out.print(value + " ");
        }
    }*/

    /*
    // ArrayList 사용
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int size = scanner.nextInt();
        final ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final int target = scanner.nextInt();
            arrayList.add(target);
        }

        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Integer (클래스) 니까 equals 가 더 올바른듯
                return (o1 < o2) ? -1 : ((o1.equals(o2)) ? 0 : 1);
            }
        });

        *//*arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });*//*

        //arrayList.sort((o1, o2) -> o1.compareTo(o2));

        // 이건 어떻게 쓰는 건지 모르겠음 -> 공부필요
        //arrayList.sort(Integer::compareTo);

        // 오름차순
        //arrayList.sort(Comparator.naturalOrder());
        // 내림차순
        //arrayList.sort(Comparator.reverseOrder());

        for (final int value : arrayList) {
            System.out.print(value + " ");
        }
    }*/
}
