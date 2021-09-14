package backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder req = new StringBuilder(br.readLine());


        for (int i = 0; i < req.length(); i++) {
            if (req.charAt(i) == '<') {
                // Tag count
                sb.append(req, i, req.indexOf(">", i) + 1);
                i = req.indexOf(">", i);

                // Make word
                if(req.indexOf(" ", i) > 0);

            }
        }

        System.out.println(sb.toString());
        return;
    }
}
