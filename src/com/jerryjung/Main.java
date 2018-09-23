package com.jerryjung;

import java.util.ArrayList;
import java.util.HashMap;
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
    final static ArrayList<Integer> possible = new ArrayList<>();
    final static ArrayList<Integer> numbers = new ArrayList<>();
    final static HashMap<Integer, Integer> strikeMap = new HashMap<>();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int loopCount = scanner.nextInt();

        for (int i = 0; i < loopCount; i++) {
            int value = scanner.nextInt();

            String stringValue = String.valueOf(value);
            int first = Integer.valueOf(stringValue.substring(0, 1));
            int second = Integer.valueOf(stringValue.substring(1, 2));
            int third = Integer.valueOf(stringValue.substring(2, 3));

            int strikeCount = scanner.nextInt();
            int ballCount = scanner.nextInt();

            // 매칭된게 없으면 pass
            if (strikeCount == 0 && ballCount == 0) {
                continue;
            }
            // 지금까지 나온 수들
            addValueInNumbers(first);
            addValueInNumbers(second);
            addValueInNumbers(third);

            // 스트라이크와 볼이 0이 아닐때 / 아직 가능성있는 수가 하나도 안나왔으면 일단 3개 다 삽입
            if (possible.size() == 0) {
                possible.add(first);
                possible.add(second);
                possible.add(third);
                continue;
            }

            switch (strikeCount) {
                case 0:
                    if (ballCount == 3) {
                        possible.clear();
                        possible.add(first);
                        possible.add(second);
                        possible.add(third);
                    } else {
                        switch (strikeMap.size()) {
                            case 0:
                                addValueInPossible(first);
                                addValueInPossible(second);
                                addValueInPossible(third);
                                break;
                            case 1:
                                if (strikeMap.get(0) != null) {
                                    addValueInPossible(second);
                                    addValueInPossible(third);
                                } else if (strikeMap.get(1) != null) {
                                    addValueInPossible(first);
                                    addValueInPossible(third);
                                } else if (strikeMap.get(2) != null) {
                                    addValueInPossible(first);
                                    addValueInPossible(second);
                                }
                                break;
                            case 2:
                                if (strikeMap.get(0) != null && strikeMap.get(1) != null) {
                                    addValueInPossible(first);
                                    addValueInPossible(second);
                                } else if (strikeMap.get(0) != null && strikeMap.get(2) == null) {
                                    addValueInPossible(first);
                                    addValueInPossible(third);
                                } else if (strikeMap.get(1) != null && strikeMap.get(2) == null) {
                                    addValueInPossible(second);
                                    addValueInPossible(third);
                                }
                                break;
                        }
                    }
                    break;
                case 1:
                    for (Integer number : possible) {
                        if (first == number) {
                            strikeMap.putIfAbsent(0, first);
                            break;
                        } else if (second == number) {
                            strikeMap.putIfAbsent(1, second);
                            break;
                        } else if (third == number) {
                            strikeMap.putIfAbsent(2, third);
                            break;
                        }
                    }
                    if (ballCount == 1 || ballCount == 2) {
                        addValueInPossible(first);
                        addValueInPossible(second);
                        addValueInPossible(third);
                    }
                    break;
                case 2:
                    final int possibleSize = possible.size();
                    for (int j = 0; j < possibleSize; j++) {
                        int number = possible.get(j);
                        if (first == number) {
                            strikeMap.putIfAbsent(0, first);
                            addValueInPossible(second);
                            addValueInPossible(third);
                        }
                        if (second == number) {
                            strikeMap.putIfAbsent(1, second);
                            addValueInPossible(first);
                            addValueInPossible(third);
                        }
                        if (third == number) {
                            strikeMap.putIfAbsent(2, third);
                            addValueInPossible(first);
                            addValueInPossible(second);
                        }
                    }
                    switch (ballCount) {
                        case 0:
                            possible.clear();
                            for (int k = 0; k < 3; k++) {
                                if (strikeMap.get(k) == null) {
                                    switch (k) {
                                        case 0:
                                            removeValueInPossible(first);
                                            break;
                                        case 1:
                                            removeValueInPossible(second);
                                            break;
                                        case 2:
                                            removeValueInPossible(third);
                                            break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            break;
                    }
                    break;
                case 3:
                    // 스트라이크 3개면 가능성 1개
                    System.out.print(1);
                    return;
            }
        }

        for (int h = 0; h < strikeMap.size(); h++) {
            if (strikeMap.get(h) != null) {
                removeValueInPossible(strikeMap.get(h));
            }
        }

        System.out.print("End");
    }

    private static void addValueInPossible(int value) {
        boolean isExists = false;
        for (Integer v : possible) {
            if (value == v) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            possible.add(value);
        }
    }

    private static void removeValueInPossible(int value) {
        for (int i = 0; i < possible.size(); i++) {
            if (value == possible.get(i)) {
                possible.remove(i);
                break;
            }
        }
    }

    private static void addValueInNumbers(int value) {
        boolean isExists = false;
        for (Integer v : numbers) {
            if (value == v) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            numbers.add(value);
        }
    }

    /*private static void removeValueInNumbers(int value) {
        for (int i = 0; i < numbers.size(); i++) {
            if (value == numbers.get(i)) {
                numbers.remove(i);
                break;
            }
        }
    }*/

    /*private static int addValueInStrikeMap(int index, int value) {
        for (Integer number : possible) {
            if (value == number) {
                strikeMap.putIfAbsent(index, value);
            }
        }
        return index;
    }*/

    /*private static void addValueInImpossible(int value) {
        boolean isExists = false;
        for (Integer v : impossible) {
            if (value == v) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            impossible.add(value);
        }
    }*/
}
