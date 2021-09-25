package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1003 {

    static int temp[] = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int dp[][] = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(dp[k][0] + " " + dp[k][1]);
        }


        Arrays.fill(temp, -1);
        int result = fibo(40);

        return;
    }

    static int fibo(int a) {
        if (a == 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        }

        if (temp[a] != -1) {
            return temp[a];
        } else {
            temp[a] = fibo(a-1) + fibo(a-2);
            return temp[a];
        }
    }
}
