package backjoon.silver.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder req = new StringBuilder(br.readLine());
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < req.length(); i++) {
            if (req.charAt(i) == '<') {
                // Close tag가 올때
                if(temp.length() > 0){
                    sb.append(temp.reverse());
                    temp = new StringBuilder();
                }
                // Open tag가 올때
                sb.append(req, i, req.indexOf(">", i) + 1);
                i = req.indexOf(">", i);
            } else if (req.charAt(i) == ' ') {
                sb.append(temp.reverse());
                sb.append(' ');
                temp = new StringBuilder();
            }
            // 단어
            else{
                temp.append(req.charAt(i));
            }
        }
        sb.append(temp.reverse());
        System.out.println(sb.toString());
        return;
    }
}
