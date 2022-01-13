package 엔테크서비스2022;

public class Main1 {

    class Solution {
        public int solution(int[][] customer) {
            int answer = 0;
            int[] sum = new int[10000001];
            int maxIndex = 0;

            for(int i=0; i<customer.length; i++){
                int s = customer[i][0];
                int e = customer[i][1];
                sum[s]++;
                sum[e]--;
                maxIndex = Math.max(maxIndex,e);
            }

            for(int i=1; i<=maxIndex; i++){
                sum[i] += sum[i-1];
            }

            for(int i=0; i<=maxIndex; i++){
                // System.out.print(sum[i] + " ");
                if(sum[i] >= 1){
                    answer++;
                }
            }
            return answer;
        }
    }
}

//1.
//        import sys
//        from collections import defaultdict
//        si = sys.stdin.readline
//        N = int(si())
//        cnt = [0 for _ in range(10000005)]
//        for _ in range(N):
//        s, e = map(int, si().split())
//        cnt[s] += 1
//        cnt[e] -= 1
//        ans = 0
//        for i in range(1, 10000001):
//        cnt[i] += cnt[i - 1]
//        if cnt[i] > 0:
//        ans += 1
//        print(ans)
