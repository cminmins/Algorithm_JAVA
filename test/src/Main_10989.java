import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
//        List<Integer> l = new LinkedList<>();
        int[] l = new int[10001];
//        Arrays.fill(l, 0);
        for(int i=0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
//            l.add(temp);
            l[temp]++;
        }
//        Collections.sort(l);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<10001; i++){
//            System.out.println(l.get(i));
            for(int k=0; k<l[i]; k++){
//                System.out.println(i);
                bw.append(i + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
        return;
    }
}
