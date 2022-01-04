package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836 {

    static class pair {
        int x;
        int y;
        int depth;
        boolean sword;

        public pair(int x, int y, int depth, boolean sword) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.sword = sword;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dest_x = Integer.parseInt(st.nextToken()), dest_y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int arr[][] = new int[dest_x + 1][dest_y + 1];
        int check[][] = new int[dest_x + 1][dest_y + 1];
        int check2[][] = new int[dest_x + 1][dest_y + 1];

        for (int x = 1; x <= dest_x; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= dest_y; y++) {
                arr[x][y] = Integer.parseInt(st.nextToken());
            }
        }
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(1, 1, 0, false));
        check[1][1] = 1;
        while (!q.isEmpty()) {
            pair target = q.remove();
            for (int i = 0; i < 4; i++) {
                int ddy = target.y + dy[i];
                int ddx = target.x + dx[i];
                if ((ddx >= 1 && ddx <= dest_x && ddy >= 1 && ddy <= dest_y)) {
                    if (!target.sword && check[ddx][ddy] == 0 && arr[ddx][ddy] != 1) {
                        if (arr[ddx][ddy] == 2) {
                            target.sword = true;
                            check2[ddx][ddy] = target.depth + 1;
                        }
                        check[ddx][ddy] = target.depth + 1;
                        q.add(new pair(ddx, ddy, target.depth + 1, target.sword));
                    } else if (target.sword && check2[ddx][ddy] == 0) {
                        check2[ddx][ddy] = target.depth + 1;
                        q.add(new pair(ddx, ddy, target.depth + 1, target.sword));
                    }
                }
            }
        }


        int answer1 = check[dest_x][dest_y], answer2 = check2[dest_x][dest_y];
        if (answer1 > 0 && answer2 > 0) {
            answer1 = Math.min(answer1, answer2);
            if (answer1 <= t && answer1 > 0) {
                System.out.println(answer1);
                return;
            }
        } else if(answer1 == 0 && answer2 > 0){
            if (answer2 <= t && answer2 > 0) {
                System.out.println(answer2);
                return;
            }
        } else if (answer1 > 0 && answer2 == 0) {
            if (answer1 <= t && answer1 > 0) {
                System.out.println(answer1);
                return;
            }
        }
        System.out.println("Fail");
        return;
    }
}