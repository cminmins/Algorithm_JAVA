import java.util.*;

public class Main_1260 {
    static boolean[] ch;
    static ArrayList<Integer>[] arr;

    static void dfs(int start){
        for(int i=0; i<arr[start].size(); i++){
            int temp = arr[start].get(i);
            if(!ch[temp]){
                ch[temp] = true;
                System.out.print(temp + " ");
                dfs(temp);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, v;
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        ch = new boolean[n+1];
        arr = new ArrayList[n + 1];
        for(int i=0; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i=0;i<n+1; i++){
            Collections.sort(arr[i]);
        }

        //DFS
        System.out.print(v + " "); ch[v] = true;
        dfs(v);
        System.out.println();
        Arrays.fill(ch, false);

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(v); ch[v] = true;
        System.out.print(v+ " ");
        while(!q.isEmpty()){
            int start = q.poll();
            for(int k = 0; k<arr[start].size(); k++){
                int temp = arr[start].get(k);
                if(!ch[temp]){
                    q.add(temp);
                    ch[temp] = true;
                    System.out.print(temp + " ");
                }
            }
        }
    }
}
