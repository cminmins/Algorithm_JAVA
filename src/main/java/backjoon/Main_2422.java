package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2422 {

    static boolean[][] rel;
    static boolean[] check;
    static int[] ice = new int[3];
    static int N;
    static int answer = 0;
    static void dfs(int index, int cnt) {
        if (cnt == 3) {
//            if (checker()) {
                answer++;
//            }
            return;
        }

        for (int i = index; i <= N; i++) {
            if (check[i] == false) {
                check[i] = true;
                ice[cnt] = i;
                if(checker())
                    dfs(i + 1, cnt + 1);
                check[i] = false;
                ice[cnt] = 0;
            }
        }
        return;
    }

    static boolean checker() {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (rel[ice[i]][ice[j]] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        rel = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            rel[y][x] = rel[x][y] = true;
        }
        dfs(1, 0);
        System.out.println(answer);
    }
}
