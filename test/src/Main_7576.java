import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
    public static class pair{
        int y;
        int x;
        pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int[] xx = {0, 1, 0, -1};
    static int[] yy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        Queue<pair> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    q.add(new pair(i,j));
            }
        }

        while(!q.isEmpty()){
            pair temp = q.poll();
            int y = temp.y;
            int x = temp.x;
            for(int i=0; i<4; i++){
                int y2 = y + yy[i];
                int x2 = x + xx[i];
                if((y2 >= 0 && y2 < N && x2 >= 0 && x2 < M ) && map[y2][x2] == 0) {
                    map[y2][x2] = map[y][x] + 1;
                    q.add(new pair(y2,x2));
                }
            }
        }
        int answer = -1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                else
                    answer = Math.max(answer, map[i][j]);
            }
        }
        System.out.println(answer-1);
        return;
    }
}
