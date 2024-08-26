package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 트리의지름_1167 {
    static class Node {
        int end, dist;

        Node(int end, int dist) {
//            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    static ArrayList<Node>[] nodeList;
    static int max, lastNode;
    static boolean[] visit;

    static void dfs(int start, int dist) {
        if (dist > max) {
            max = dist;
            lastNode = start;
        }
        visit[start] = true;
        for (int i = 0; i < nodeList[start].size(); i++) {
            Node cur = nodeList[start].get(i);
            if (visit[cur.end]) continue;
            dfs(cur.end, dist + cur.dist);
            visit[cur.end] = true;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodeList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            String[] arr = br.readLine().split(" ");
            int idx = 1;
            int start = Integer.parseInt(arr[0]);
            while (Integer.parseInt(arr[idx]) != -1) {
                int end = Integer.parseInt(arr[idx]);
                int dist = Integer.parseInt(arr[idx + 1]);
//                System.out.println(i);
                nodeList[start].add(new Node(end, dist));
                nodeList[end].add(new Node(start,dist));
                idx += 2;
            }
        }
        visit = new boolean[N + 1];
        max = 0;
        lastNode = -1;
        dfs(1,0);
        visit = new boolean[N + 1];
        dfs(lastNode,0);
        System.out.println(max);
    }
}
