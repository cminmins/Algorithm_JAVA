package 네이버클라우드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public int costMax = Integer.MIN_VALUE;

    void dfs(int[][] costs, int xcost, int ycost, int y, int x, int sum) {
        costMax = Math.max(costMax, sum);
        // 아래로 한칸
        if (y < costs.length - 1) {
            dfs(costs, xcost, ycost, y + 1, x, sum + costs[y + 1][x] - ycost);
        }
        if (x < costs[0].length - 1) {
            dfs(costs, xcost, ycost, y, x + 1, sum + costs[y][x + 1] - xcost);
        }
        return;
    }


    public int solution(int[][] costs, int xcost, int ycost) {
        int answer = -1;
        dfs(costs, xcost, ycost, 0, 0, costs[0][0]);
        answer = costMax;
        return answer;
    }
}

public class Main2 {
    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();


        int[][] costs1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int xcost1 = 0, ycost1 = 0;
        System.out.println(sol.solution(costs1, xcost1, ycost1));

        sol.costMax = 0;
        int[][] costs2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int xcost2 = 1, ycost2 = 1;
        System.out.println(sol.solution(costs2, xcost2, ycost2));

        sol.costMax = 0;
        int[][] costs3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int xcost3 = 100, ycost3 = 0;
        System.out.println(sol.solution(costs3, xcost3, ycost3));


    }
}
