package backjoon.누적합;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        long result = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int y = 1; y <= i; y++) {
                    for (int x = 1; x <= j; x++) {
                        int temp = arr[i][j] - arr[y-1][j] - arr[i][x-1] + arr[y-1][x-1];
                        result = Math.max(result, temp);
                        result = Math.max(result, arr[i][j]);
                    }
                }
            }
        }
//        for (int i = 1; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                for (int y = i; y < N; y++) {
//                    for (int x = j; x < M; x++) {
//                        long temp = arr[y][x] - arr[i][j] - arr[j][x] + arr[i][j];
//                        result = Math.max(Math.max(result, temp), arr[y][x]);
//                    }
//                }
//            }
//        }

        System.out.println(result);
        return;
    }
}
