package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        ArrayList<Integer> coins = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int dp[] = new int[10001];
//        dp[0] = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(br.readLine());
            if (idx > 10000) {
                continue;
            }
            dp[idx] = 1; // here
            for (int j = idx; j <= k; j++) {
                if (dp[j - idx] > 0) {
                    if (dp[j] == 0) {
                        dp[j] = dp[j - idx] + 1;
                    } else {
                        dp[j] = Math.min(dp[j - idx] + 1, dp[j]);
                    }
                }
            }
        }

        if (dp[k] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
        return;
    }
}
