import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466 {
    
    static int answer;
    static int[] arr;
    static boolean[] ch;

    static void dfs(int s, int idx, int cnt){
//        if(s == idx){
//            answer -= cnt;
//            return;
//        }
        if(ch[idx]){
            if(s != idx) {
                return;
            }
            else{
                answer -= cnt;
                return;
            }
        }
        else{
            ch[idx] = true;
            dfs(s, arr[idx], cnt+1);
        }
        return;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            arr = new int[v+1];
            ch = new boolean[v+1];
            answer = v;
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=v; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=1; j<=v; j++){
                dfs(j, j, 1);
            }
            System.out.println(answer);
        }
        return;
    }
}
