package 딜리버리히어로;

public class Main_3 {
    public static int solution(int S) {
//        String str = S;
        String str = Integer.toString(S + 1);
        int rep = 0;
        while(true)
        {
            // 몇을 더할지 계산
            boolean check = false;
            // S보다 1큰 정수
            str = str + "0".repeat(rep);
            // 중복되는지 찾기
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    rep = str.length() - (i+2);
                    str = Integer.toString(Integer.parseInt(str.substring(0, i+2)) +1);
                    check = false;
                    break;
                }
                check = true;
            }
            if(check == true){
                return Integer.parseInt(str);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(55));
        System.out.println(solution(1765));
        System.out.println(solution(98));
        System.out.println(solution(44432));
        System.out.println(solution(3298));
        System.out.println(solution(1000000000));


        return;
    }
}
