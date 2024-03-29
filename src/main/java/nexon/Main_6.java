package nexon;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_6 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        BufferedWriter bw = new BufferedWriter(new FileWriter("gifs_" + filename));
        String str;

        // Pattern pattern = Pattern.compile("");
        // Matcher matcher = pattern.matcher(input)

        // while((str = br.readLine()) != null){
        //     if(str.contains("\"GET")){
        //         str = str.substring(str.indexOf("\"GET"));

        //     }

        // }
        Set<String> files = new TreeSet<>();
        while((str = br.readLine())!= null){
            if(str.contains("\"GET") && str.contains(".gif") && str.contains("HTTP/1.0") && str.contains("200")){
                str = str.substring(str.indexOf("\"GET"));
                String[] request = str.split(" ");
                String[] path = request[1].split("/");
                files.add(path[path.length - 1]);
            }
        }
        files.forEach(s -> {
            System.out.println(s);
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        br.close();
        bw.close();
    }
}