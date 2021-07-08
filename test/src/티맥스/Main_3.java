package 티맥스;

public class Main_3 {

    public static int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i*i <= n; i++) {
            dp[i*i] = 1;
        }


        for (int i = 3; i <= n; i++) {
            int min_value = Integer.MAX_VALUE;
            if(dp[i] == 0){
                for (int k = i; k > 1; k--) {
                    min_value = Math.min((dp[k - 1] + dp[i - k + 1]), min_value);
                }
                dp[i] = min_value;
            }
        }
        answer = dp[n];
        return answer;
    }



    public static void main(String[] args){
        System.out.println(solution(9));
        System.out.println(solution(15));
        System.out.println(solution(41));
        return;
    }
}
