package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int h = 1;
        int moveCount = 1;
        int stage = 0;

        int y = n / 2;
        int x = n / 2;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] arr = new int[n][n];

        int ansY = -1;
        int ansX = -1;
        int num = 1;

        while (h <= n) {
            int d = 0;
            for (int i = 0; i < moveCount; i++) {
                if (num == target) {
                    ansX = x + 1;
                    ansY = y + 1;
                }
                arr[y][x] = num++;

                if (y + dy[d] >= n / 2 + stage + 1 ||
                        x + dx[d] >= n / 2 + stage + 1 ||
                        y + dy[d] <= n / 2 - (stage + 1) ||
                        x + dx[d] <= n / 2 - (stage + 1)){
                    d = (d + 1) % 4;
                }
                if (i + 1 < moveCount) {
                    y += dy[d];
                    x += dx[d];
                }
            }
            h += 2;
            moveCount = (int) (Math.pow(h, 2) - Math.pow((h - 2), 2));
            if (y - 1 >= 0) {
                y -= 1;
                stage++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y1 = 0; y1 < n; y1++) {
            for (int x1 = 0; x1 < n; x1++) {
//                System.out.print(arr[y1][x1] + " ");
                sb.append(arr[y1][x1] + " ");
            }
//            System.out.println();
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.println(ansY + " " + ansX);
        return;
    }
}
