package com.jerryjung;

import java.util.*;

public class Main {

    /**
     * 문제 :
     *
     * 입력 :
     *
     * 출력 :
     *
     * 예제 입력 :
     * 9 12
     * 1 2
     * 1 3
     * 2 3
     * 2 4
     * 2 6
     * 3 7
     * 4 5
     * 4 7
     * 4 8
     * 5 6
     * 7 8
     * 8 9
     *
     * 예제 출력 :
     *
     * 예제 입력 2 :
     *
     * 예제 출력 2 :
     *
     * 출처 : 
     */
    //DFS
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int node = scanner.nextInt();
        final int edge = scanner.nextInt();

        graph = new ArrayList[node + 1];
        for (int i = 0; i < node + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            final int a = scanner.nextInt();
            final int b = scanner.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        DFS(1);
        System.out.println(1 + "번 노드 DFS 완료");
    }

    private static void DFS(int x) {
        // x 부터 시작해서 DFS 하는 함수, visited[] 에는 방문 기록이 있다.
        visited[x] = true;
        System.out.println(x + "번째 노드 방문");

        for(int i = 0; i < graph[x].size(); i++) {
            // x와 y가 연결되어있다.
            final int y = graph[x].get(i);

            if (!visited[y]) {
                DFS(y);
                System.out.println(y + "번 노드 DFS 완료");
            }
        }
    }
}
