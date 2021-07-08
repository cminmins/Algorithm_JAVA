package 딜리버리히어로;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2 {
    public static String solution(String S){
        int answer = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        int Size_limit = 240 * 1 << 10;
        String Modified_limit_str = "1995-10-13";
        Date Modified_limit = null;
        try {
            Modified_limit = format.parse(Modified_limit_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] files = S.split("\n");

        for (int i=0; i<files.length; i++){
            String file = files[i];
            Date file_date = null;
            try {
                file_date = format.parse(file.substring(0, 10));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String[] split = file.substring(10).trim().split(" ");
            int file_size = Integer.parseInt(split[0]);
            String file_name = split[1];

            int compare = file_date.compareTo(Modified_limit);
            if (compare < 0) {
                if (file_size < Size_limit) {
                    String[] temp = file_name.split("\\.");
                    int len = temp.length;
                    String cm = temp[len - 1];
                    if (cm.equals("zip") || cm.equals("rar") || cm.equals("tgz")) {
                        answer++;
                    }
                }
            }
        }

        if (answer == 0) {
            return "NO FILES";
        }
        return Integer.toString(answer);
    }

    public static void main(String[] args) throws ParseException {
        String tc = "1988-08-29        956 system.zip\n" +
                "1976-09-16     126976 old-photos.tgz\n" +
                "1987-02-03     118784 logs.rar\n" +
                "1961-12-04  703594496 very-long-filename.rar\n" +
                "1980-08-03          2 DELETE-THIS.TXT\n" +
                "2014-08-23        138 important.rar\n" +
                "2001-08-26     595968 MOONLIGHT-SONATA.FLAC\n" +
                "1967-11-30     245760 archive.rar\n" +
                "1995-10-13        731 file.tgz\n";


        System.out.println(solution(tc));
    }
}