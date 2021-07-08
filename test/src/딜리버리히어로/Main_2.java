package 딜리버리히어로;

public class Main_2 {
    public static String solution(String S) {
        String[] arr = S.split(" ");
        String answer = "";
        int size = Integer.MAX_VALUE;


        for(int i=0; i<arr.length; i+=3) {
            String perf = arr[i+1];
            String owner = arr[i+0];
            String name = arr[i+2];
            // 첫번째 조건
            if (owner.equals("root")) {
                // 두번째 조건 읽기전용, 쓰기권한 X, 실행권한 상관없음
                if (perf.substring(0, 2).equals("r-")) {
                    String[] temp = name.split("\\.");
                    int len = temp.length;
                    String cm = temp[len - 1];
                    if (cm.equals("doc") || cm.equals("xls") || cm.equals("pdf")) {
                        if (name.length() < size) {
                            size = name.length();
                            answer = name;
                        }
                    }
                }
            }
        }
        if (answer != "") {
            return Integer.toString(answer.length());
        }
        else{
            return "NO FILES";
        }
    }

    public static void main(String[] args) {
        String tc = "root r-x delete-this.xls root r-- bug-report.pdf root r-x doc.xls root r-- podcast.flac alice r-- system.xls root --x invoices.pdf admin rwx SETUP.PY";
        System.out.println(solution(tc));

        return;
    }
}
