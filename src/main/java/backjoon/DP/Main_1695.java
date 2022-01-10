package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1695 {

    static int ans = Integer.MAX_VALUE;
    static int N;
//    static int[] arr;
    static int[][] dp;
    static ArrayList<Integer> arr;


    //    static int dfs(ArrayList<Integer> arr, int s, int e) {
    static int dfs(int s, int e) {
//        System.out.println("start : " + s + " : " + e);
        if (s > e) {
            return 0;
        }
        if (dp[s][e] != -1) {
            System.out.println("check : " + s + " : " + e);
            return dp[s][e];
        }
        if (arr.get(s) == arr.get(e)) {
//        if (arr[s] == arr[e]) {
            return dp[s][e] = dfs(s + 1, e - 1);
        } else {
            return dp[s][e] = Math.min(dfs(s + 1, e), dfs(s, e - 1)) + 1;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
//        arr = new int[N];
        dp = new int[N][N];

//        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
//            arr.add(Integer.parseInt(st.nextToken()));
            arr.add(1);
//            arr[i] = Integer.parseInt(st.nextToken());
//            arr[i] = i+1;
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        Integer a = 10000;
        Integer b = 10000;
        if (a == 10000) {
            System.out.println("a, b = true");
        }
        Integer c = (10);
        Integer d = (10);
        if (c == d) {
            System.out.println("c, d = true");
        }

        System.out.println(dfs(0, N-1));
    }
}
