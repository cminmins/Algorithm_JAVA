package 엔테크서비스2022;

import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    class Solution
    {
        class pair{
            int y;
            int x;

            pair(int y, int x){
                this.y = y;
                this.x = x;
            }
        }


        public boolean checker(int y, int x, int r, int c){
            return y >= 0 && y < r && x >=0 && x <c;
        }

        public int[] solution(int[][] image)
        {
            int r = image.length;
            int c = image[0].length;
            int[] answer = {4,2};
            int[] dy1 = {0, 1, 0, -1};
            int[] dx1 = {1, 0, -1, 0};

            int[] dy2 = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] dx2 = {1, 1, 0, -1, -1, -1, 0, 1};

            int[][] map1 = new int[r][c];
            int[][] map2 = new int[r][c];

            Queue<pair> q1 = new LinkedList<>();
            Queue<pair> q2 = new LinkedList<>();

            int cnt1 = 0;
            int cnt2 = 0;
            for(int y=0; y<r; y++){
                for(int x=0; x<c; x++){
                    if(image[y][x] == 1 && map1[y][x] == 0){
                        q1.add(new pair(y, x));
                        cnt1++;
                        map1[y][x] = cnt1;
                    }
                    if(image[y][x] == 1 && map2[y][x] == 0){
                        q2.add(new pair(y,x));
                        cnt2++;
                        map2[y][x] = cnt2;
                    }

                    while(!q1.isEmpty()){
                        pair p = q1.remove();
                        int sy = p.y;
                        int sx = p.x;
                        for(int i=0; i<4; i++){
                            int ddy = sy + dy1[i];
                            int ddx = sx + dx1[i];
                            if(checker(ddy, ddx, r, c) && map1[ddy][ddx] == 0 && image[ddy][ddx] == 1){
                                q1.add(new pair(ddy, ddx));
                                map1[ddy][ddx] = cnt1;
                            }
                        }
                    }

                    while(!q2.isEmpty()){
                        pair p = q2.remove();
                        int sy = p.y;
                        int sx = p.x;
                        for(int i=0; i<8; i++){
                            int ddy = sy + dy2[i];
                            int ddx = sx + dx2[i];
                            if(checker(ddy, ddx, r, c) && map2[ddy][ddx] == 0 && image[ddy][ddx] == 1){
                                q2.add(new pair(ddy, ddx));
                                map2[ddy][ddx] = cnt2;
                            }
                        }
                    }
                }
            }
            return new int[]{cnt1, cnt2};
        }
    }
}

//2.
//        import sys
//        from collections import defaultdict
//        si = sys.stdin.readline
//        N = int(si())
//        A = list(map(int, si().split()))
//        sum, ans = 0, 0
//        for x in A:
//        if x == 0:
//        sum = 0
//        else:
//        sum += 1
//        ans = max(ans, sum)
//        print(ans)