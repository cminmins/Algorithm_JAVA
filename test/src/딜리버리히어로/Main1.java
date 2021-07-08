package 딜리버리히어로;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main1 {

    public static String solution(String S, String C){
        C = C.toLowerCase(Locale.ROOT);
        // split people
        String[] people = S.split("\\; ");
        int len = people.length;


        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<len; i++){
            String person = people[i].toLowerCase(Locale.ROOT);

            // Split names
            String[] names = person.split(" ");
            String First = names[0];
            String Last = names[names.length- 1].replace("-", "");

            StringBuilder sb = new StringBuilder();

            // Email name format
            sb.append(Last);
            sb.append("_");
            sb.append(First);

            // Check names
            String temp = sb.toString();
            if(!map.containsKey(temp)){
                map.put(temp, 2);
            }
            else{
                sb.append(map.get(temp));
                map.put(temp, map.get(temp) + 1);
            }

            // Email company format
            sb.append("@");
            sb.append(C);
            sb.append(".com");

            // Name + <Email>;
            answer.append(people[i]);
            answer.append(" <");
            answer.append(sb);
            answer.append(">; ");
        }

        answer.delete(answer.length() -2, answer.length());
        return answer.toString();
    }

    public static void main(String[] args){
        System.out.println(solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "Example"));
    }
}
