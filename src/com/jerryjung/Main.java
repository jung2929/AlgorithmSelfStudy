package com.jerryjung;

import java.util.*;

public class Main {

    /**
     * 문제 : 5658. [모의 SW 역량테스트] 보물상자 비밀번호
     *
     * 입력 :
     *
     * 출력 :
     *
     * 예제 입력 :
     * 5
     * 12 10
     * 1B3B3B81F75E
     * 16 2
     * F53586D76286B2D8
     * 20 14
     * 88F611AE414A751A767B
     * 24 16
     * 044D3EBA6A647B2567A91D0E
     * 28 11
     * 8E0B7DD258D4122317E3ADBFEA99
     *
     * 예제 출력 :
     * #1 503
     * #2 55541
     * #3 334454
     * #4 5667473
     * #5 182189737
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo
     */
    // 중복 되지않는 값
    private final static ArrayList<Integer> decimalArrayList = new ArrayList<>();
//	final static ArrayList<String> stringArrayList = new ArrayList<>();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt(); // 테스트 케이스의 개수
        //System.out.print(Integer.parseInt("1F7", 16));
        // 테스트 케이스 모두 돌기
        for (int t = 1; t <= T; t++) {
            // 테스트 케이스에 필요한 값 선언
            final int N = scanner.nextInt(); // N= 테스트 숫자 개수
            final int textLength = N / 4; // 글자 자릿수
            final int K = scanner.nextInt(); // K= 찾을 순서
            final String value = scanner.next(); // 테스트 케이스 값
            final int valueLength = value.length(); // 문자열 길이
            final String[] allValue = new String[textLength];
//        	final String[] firstS = new String[4];
//        	final String[] secondS = new String[4];
//        	final String[] thirdS = new String[4];
//            String first = "";
//            String second = "";
//            String third = "";
//            String fourth = "";
            // 0회전, 1회전, 2회전 .. 모든 값 넣기
            for (int n = 0; n < 4; n++) {
                for (int m = 0; m < textLength; m++) {
                    String substringValue = "";
                    if (n == 0) {
                        substringValue = value.substring(valueLength - m, valueLength);
                        substringValue += (value.substring(0, textLength - m));
                    } else {
                        substringValue = value.substring((n * textLength) - m, ((n + 1) * textLength - m));
                    }
                    if (!isDuplicated(substringValue)) {
                        decimalArrayList.add(Integer.parseInt(substringValue, 16));
                    }
                }
        		/*
//        		firstS[n] = value.substring(n * textLength, (n + 1) * textLength);
        		first = value.substring(n * textLength, (n + 1) * textLength);

        		if (n == 0) {
//        			secondS[n] = value.substring(valueLength - 1, valueLength);
//        			secondS[n] += (value.substring(0, textLength - 1));

        			second = value.substring(valueLength - 1, valueLength);
        			second += (value.substring(0, textLength - 1));

//        			thirdS[n] = value.substring(valueLength - 2, valueLength);
//        			thirdS[n] += (value.substring(0, textLength - 2));
        			third = value.substring(valueLength - 2, valueLength);
        			third += (value.substring(0, textLength - 2));

        			fourth = value.substring(valueLength - 3, valueLength);
        			fourth += (value.substring(0, textLength - 3));
        		} else if (n == 3) {
//        			secondS[n] = value.substring((n * textLength) - 1, ((n + 1) * textLength) - 1);
        			second = value.substring((n * textLength) - 1, ((n + 1) * textLength) - 1);

//            		thirdS[n] = value.substring((n * textLength) - 2, ((n + 1) * textLength) - 2);
        			third = value.substring((n * textLength) - 2, ((n + 1) * textLength) - 2);

        			fourth = value.substring((n * textLength) - 3, ((n + 1) * textLength) - 3);
        		} else {
//        			secondS[n] = value.substring((n * textLength) - 1, ((n + 1) * textLength - 1));
//            		thirdS[n] = value.substring((n * textLength) - 2, ((n + 1) * textLength) - 2);
        			second = value.substring((n * textLength) - 1, ((n + 1) * textLength - 1));
            		third = value.substring((n * textLength) - 2, ((n + 1) * textLength) - 2);
            		fourth = value.substring((n * textLength) - 3, ((n + 1) * textLength) - 3);
        		}
        		if (!isDuplicated(first)) {
        			decimalArrayList.add(Integer.parseInt(first, 16));
//        			stringArrayList.add(first);
        		}
        		if (!isDuplicated(second)) {
        			decimalArrayList.add(Integer.parseInt(second, 16));
//        			stringArrayList.add(second);
        		}
        		if (!isDuplicated(third)) {
        			decimalArrayList.add(Integer.parseInt(third, 16));
//        			stringArrayList.add(third);
        		}
        		if (!isDuplicated(fourth)) {
        			decimalArrayList.add(Integer.parseInt(fourth, 16));
//        			stringArrayList.add(third);
        		}
        		*/
            }
            decimalArrayList.sort(Comparator.reverseOrder());
//        	stringArrayList.sort(Comparator.reverseOrder());
//        	if (decimalArrayList.size() < K) {
//        		System.out.println(decimalArrayList.get(K - decimalArrayList.size() - 1));
//        	} else {
//        		System.out.println(decimalArrayList.get(K - 1));
//        	}
            System.out.println("#" + t + " " + decimalArrayList.get(K - 1));
            // 초기화
            decimalArrayList.clear();
        }
    }

    private static boolean isDuplicated(final String value) {
        for (Integer v : decimalArrayList) {
            if (Integer.parseInt(value, 16) == v) {
                return true;
            }
        }
        return false;
    }

//    private static boolean isDuplicated2(final String value) {
//    	for (String v : stringArrayList) {
//    		if (value.equals(v)) {
//    			return true;
//    		}
//    	}
//    	return false;
//    }
}
