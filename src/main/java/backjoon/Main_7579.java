package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2;
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        int[] mem = new int[n + 1];
        int[] cost = new int[n + 1];
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
            totalCost += cost[i];
        }
        int[] dp = new int[totalCost + 1];

        for (int i = 0; i < n; i++) {
            if (dp[cost[i]] == 0) {
                dp[cost[i]] = mem[i];
            }
            for (int k = cost[i]+1; k <= totalCost; k++) {
                if (dp[k] > 0) {
                    dp[k] = Math.max(dp[k], dp[k - cost[i]] + mem[i]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= m) {
                ans = Math.min(ans, i);
            }
        }
        System.out.println(ans);
        return;
    }
}
