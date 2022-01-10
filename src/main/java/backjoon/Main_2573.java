package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573 {
    static class pair{
        int y;
        int x;

        public pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static boolean checker(int y, int x, int n, int m) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] isl = new int[n][m];
        Queue<pair> ice = new LinkedList<>();
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] > 0) {
                    ice.add(new pair(y, x));
                }
            }
        }
        int year = 0;
        while (true) {
            year++;
            // 1년마다 빙하 녹음
            Queue<pair> newIce = new LinkedList<>();
            Queue<pair> deleteIce = new LinkedList<>();
            while (!ice.isEmpty()) {
                pair pos = ice.remove();
                int y = pos.y;
                int x = pos.x;
                int melting = 0;

                // 동서남북에 바다면 녹을값 계산
                for (int i = 0; i < 4; i++) {
                    int ddy = y + dy[i];
                    int ddx = x + dx[i];
                    if (checker(ddy, ddx, n, m)) {
                        if (map[ddy][ddx] == 0) {
                            melting++;
                        }
                    }
                }
                // 0보다 같거나 낮아지면 빙하가 없어진 것으로 처리
                if (map[y][x] - melting <= 0) {
                    deleteIce.add(new pair(y, x));
                } else {
                    // 0보다 크면 아직 빙하가 있는것으로 처리
                    map[y][x] -= melting;
                    newIce.add(new pair(y, x));
                }
            }
            // 남아있는 빙하를 ice queue에 다시 배치
            ice.addAll(newIce);
            // 다 녹은 빙하들의 값을 0으로 하여 바다로 만듬
            while (!deleteIce.isEmpty()) {
                pair pos = deleteIce.remove();
                map[pos.y][pos.x] = 0;
            }

            // 섬의 개수 판별
            int[][] counting = new int[n][m];
            for (int y = 0; y < n; y++) {
                Arrays.fill(counting[y], 0);
            }

            // 섬분리 확인
            int cnt = 0;
            // 현재는 ice, newIce가 같은 값이므로, ice는 다음 while문에서 사용해야되니 newIce를 이용
            while (!newIce.isEmpty()) {
                pair p = newIce.remove();
                Queue<pair> q = new LinkedList<>();
                // 큐에 있는 값들중에 방문안한 좌표가 있으면 추가하고 cnt+1
                if (counting[p.y][p.x] == 0) {
                    q.add(p);
                    cnt++;
                    counting[p.y][p.x] = cnt;
                }
                // p와 연결된 모든 빙하 방문
                while (!q.isEmpty()) {
                    pair pos = q.remove();
                    int y = pos.y;
                    int x = pos.x;
                    for (int i = 0; i < 4; i++) {
                        int ddy = y + dy[i];
                        int ddx = x + dx[i];
                        if (checker(ddy, ddx, n, m) && counting[ddy][ddx] == 0 && map[ddy][ddx] > 0) {
                            q.add(new pair(ddy, ddx));
                            counting[ddy][ddx] = cnt;
                        }
                    }
                }
            }
            // 모든 빙하를 방문했을때 섬의 개수가 2개이상이면 결과 리턴
            if (cnt >= 2) {
                System.out.println(year);
                return;
            }
            // 더이상 녹아내릴 빙하가 없으면 0 리턴
            if (ice.isEmpty()) {
                System.out.println(0);
                return;
            }
        }
    }
}
