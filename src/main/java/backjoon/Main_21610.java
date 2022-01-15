package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610 {

    static class pair {
        int y;
        int x;

        public pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};

    static pair moveSeedCloud(int d, int s, int n, pair pos, int[][] map, boolean[][] madedCloud) {
        pos.y = (pos.y + (n + dy[d]) * s) % n;
        pos.x = (pos.x + (n + dx[d]) * s) % n;
        map[pos.y][pos.x]++;
        madedCloud[pos.y][pos.x] = true;
        return pos;
    }

    static boolean checker(int y, int x, int n) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    static void copyWater(int[][] map, boolean[][] madeCloud) {
        for (int t = 0; t < map.length; t++) {
            for (int j = 0; j < map.length; j++) {
                if (madeCloud[t][j] == true) {
                    for (int i = 1; i < 8; i += 2) {
                        int ddy = t + dy[i];
                        int ddx = j + dx[i];
                        if (checker(ddy, ddx, map.length) && map[ddy][ddx] > 0) {
                            map[t][j]++;
                        }
                    }
                }
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Queue<pair> q = new LinkedList<>();
        int[][] map = new int[n][n];
        boolean[][] madeCloud = new boolean[n][n];

        // 물 세팅
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름 세팅
        q.add(new pair(n - 1, 0));
        q.add(new pair(n - 1, 1));
        q.add(new pair(n - 2, 0));
        q.add(new pair(n - 2, 1));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            //1. d 방향으로 s칸만큼 이동(% 8)후 1씩 비 생성 후 마킹
            while (!q.isEmpty()) {
                moveSeedCloud(d-1, s, n, q.remove(), map, madeCloud);
            }
            // 물복사
            copyWater(map, madeCloud);

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (madeCloud[y][x] == false && map[y][x] >= 2) {
                        q.add(new pair(y, x));
                        map[y][x] -= 2;
                    }
                }
            }
            for (int t = 0; t < n; t++) {
                Arrays.fill(madeCloud[t], false);
            }
        }
        int sum = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                sum += map[y][x];
            }
        }
        System.out.println(sum);
        return;
    }
}