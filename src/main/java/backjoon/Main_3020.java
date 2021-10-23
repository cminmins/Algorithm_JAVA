package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3020 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        boolean[][] cave = new boolean[H][N];

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            // 석순
            if (i % 2 == 0) {
                for (int j = 0; j < t; j++) {
                    cave[j][i] = true;
                }
            }
            // 종유석
            else if (i % 2 == 1) {
                for (int j = 0; j < t; j++) {
                    cave[H - 1 - j][i] = true;
                }
            }
        }

        int[] height = new int[H];
        int min_value = Integer.MAX_VALUE;
        for (int i = 0; i < H; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (cave[i][j]) {
                    cnt++;
                }
            }
            height[i] = cnt;
            min_value = Math.min(min_value, cnt);
        }
        int num = 0;
        for (int i = 0; i < H; i++) {
            if (min_value == height[i]) {
                num++;
            }
        }
        System.out.println(min_value + " " + num);
        return;
    }
}
