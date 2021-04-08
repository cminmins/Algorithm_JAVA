import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11724 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
//        n = sc.nextInt();
//        m = sc.nextInt();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[] ch = new boolean[n+1];
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for(int i=0; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        // BFS
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(!ch[i]) {
                answer++;
                ch[i] = true; q.add(i);
                while (!q.isEmpty()) {
                    int start = q.poll();
                    for (int k = 0; k < arr[start].size(); k++) {
                        int temp = arr[start].get(k);
                        if (!ch[temp]) {
                            q.add(temp);
                            ch[temp] = true;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        return;
    }
}
