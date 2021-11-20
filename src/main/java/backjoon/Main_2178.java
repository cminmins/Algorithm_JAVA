package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178 {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[][] miro = new int[n][m];
//        boolean[][] check = new boolean[n][m];

        sc.nextLine();
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0;j<m;j++){
                miro[i][j] = line.charAt(j) - '0';
            }
        }
        Pair here = null;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        while(q.size() != 0){
            here = q.poll();
            if(here.xpos == n-1 && here.ypos == m-1) break;
            for(int i=0;i<4;i++){
                int nextX = here.xpos + dx[i];
                int nextY = here.ypos + dy[i];
//                if(nextY < 0 || nextY >= m || nextX < 0 || nextX >= n)
//                    continue;
                try{
                    if(miro[nextX][nextY] == 1){
                        miro[nextX][nextY] = 0;
                        q.add(new Pair(nextX, nextY, here.depth+1));
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }

        System.out.println(here.depth);
        sc.close();
    }

    public static class Pair{
        int xpos;
        int ypos;
        int depth;

        public Pair(int xpos, int ypos, int depth){
            this.xpos = xpos;
            this.ypos = ypos;
            this.depth = depth;
        }
    }
}
