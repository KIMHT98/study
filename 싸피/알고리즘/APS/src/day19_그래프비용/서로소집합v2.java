package day19_그래프비용;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소집합v2 {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
            StringBuilder ans = new StringBuilder();
            
            makeSet(n);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int method = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (method == 0) {
                    union(a, b);
                } else {
                    if (check(a, b))
                        ans.append(1);
                    else
                        ans.append(0);
                }
            }
            System.out.println("#" + t + " " + ans.toString());
        }
    }

    static void makeSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findSet(int x) {
        if (x != parent[x])
            parent[x] = findSet(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else {
                parent[rootX] = rootY;
                if (rank[rootX] == rank[rootY])
                    rank[rootY]++;
            }
        }
    }

    static boolean check(int x, int y) {
        return findSet(x) == findSet(y);
    }
}

