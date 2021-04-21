import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_10451 {
    static ArrayList<Integer>[] arr;
    static int[] ch;

    public static void dfs(int s, int c){
        ch[s] = c;
        for(int i=0; i<arr[s].size(); i++){
            int temp = arr[s].get(i);
            if(ch[temp] == 0){
                dfs(temp, c);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for(int t=0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new ArrayList[v+1];
            ch = new int[v+1];
            for(int i=0; i<v+1; i++){
                arr[i] = new ArrayList<>();
            }

            for(int i=1; i<=v; i++){
                int a = Integer.parseInt(st.nextToken());
                arr[i].add(a);
            }
            int cnt = 1;
            for(int i=1; i<=v; i++){
                if(ch[i] == 0){
                    dfs(i, cnt++);
                }
            }

//            int max_value = 0;
//            for(int i=1; i<=v; i++){
//                max_value = Math.max(max_value, ch[i]);
//            }
            System.out.println(cnt-1);
        }
        return;
    }
}
