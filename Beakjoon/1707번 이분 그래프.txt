import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1707 {

    static ArrayList<Integer>[] arr;
    static int check[];
    public static boolean dfs(int s, int c){
        check[s] = c;
        for(int i=0; i<arr[s].size(); i++){
            int temp = arr[s].get(i);
            if(check[temp] == 0){
                if(dfs(temp, 3-c) == false){
                    return false;
                }
            }
            else if(check[temp] == c){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for(int t=0; t<k; t++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 배열 초기화 및 생성
            check = new int[v+1];
            arr = new ArrayList[v+1];
            for(int a=0; a<=v; a++){
                arr[a] = new ArrayList<>();
            }

            // 좌표 입력
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x].add(y);
                arr[y].add(x);
            }
            boolean cc = true;
            for(int q=1; q<=v; q++){
                if(check[q] == 0 && !dfs(q, 1)){
                    cc = false;
                }
            }
            if(cc){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        return;
    }
}
