package 티맥스;

public class Main_1 {

    public static int solution(int money, String expected, String actual) {
        int answer = 0;
        int bat = 100;
        for (int i = 0; i < expected.length(); i++) {
            if (expected.charAt(i) == actual.charAt(i)) {
                money += bat;
                bat = 100;
            }
            else{
                money -= bat;
                if (money == 0) {
                    return 0;
                }
                bat *= 2;
                if (money <= bat) {
                    bat = money;
                }
            }
        }

        return money;
    }



    public static void main(String[] args){

//        solution(1000, "HTHTHTH", "TTHHTTH");
//        solution(1200, "TTHHH", "HHTHT");
        solution(1500, "HHHTH", "TTTHT");
        return;
    }
}
