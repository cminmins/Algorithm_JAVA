package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2583 {

    static class pos {
        int y;
        int x;

        public pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < K; i++) {
            String[] xy = br.readLine().split(" ");
            for (int y = Integer.parseInt(xy[1]); y < Integer.parseInt(xy[3]); y++) {
                for (int x = Integer.parseInt(xy[0]); x < Integer.parseInt(xy[2]); x++) {
                    map[y][x] = -1;
                }
            }
        }
        Queue<pos> q = new LinkedList<>();


        ArrayList<Integer> al = new ArrayList<>();
        int num = 0;
        int cnt = 0;
        for (int yi = 0; yi < M; yi++) {
            for (int xi = 0; xi < N; xi++) {
                if (map[yi][xi] == 0) {
                    q.add(new pos(yi, xi));
                    map[yi][xi] = ++num;
                    cnt = 1;
                    int[][] dir = {
                            {0, 1, 0, -1},
                            {1, 0, -1, 0}};
                    while (!q.isEmpty()) {
                        int y = q.peek().y;
                        int x = q.peek().x;
                        q.poll();
                        for (int i = 0; i < 4; i++) {
                            int yy = y + dir[0][i];
                            int xx = x + dir[1][i];
                            if (yy >= 0 && yy < M && xx >= 0 && xx < N
                                    && map[yy][xx] == 0) {
                                q.add(new pos(yy, xx));
                                map[yy][xx] = num;
                                cnt++;
                            }
                        }
                    }
                    al.add(cnt);
                }
            }
        }

        Collections.sort(al);
        System.out.println(num);
        for (int i : al) {
            System.out.print(i + " ");
        }
    }
}
