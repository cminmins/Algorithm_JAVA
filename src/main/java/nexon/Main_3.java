package nexon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTheGroups' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY queryType
     *  3. INTEGER_ARRAY students1
     *  4. INTEGER_ARRAY students2
     */

    private static List<List<Integer>> relations = new ArrayList<>();
    private static boolean[] check;

    public static int calculateFriends(int num, int n) {
        Stack<Integer> s = new Stack<>();
        int count = 0;
        if (check[num] == false) {
            check[num] = true;
            s.push(num);
            count++;
        }

        while (!s.isEmpty()) {
            int t = s.pop();
            for (int i = 0; i < relations.get(t).size(); i++) {
                if (check[relations.get(t).get(i)] == false) {
                    check[relations.get(t).get(i)] = true;
                    s.push(relations.get(t).get(i));
                    count++;
                }
            }
        }
        return count;
    }


    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        check = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < queryType.size(); i++) {
            if (queryType.get(i).equals("Friend")) {
                relations.get(students1.get(i)).add(students2.get(i));
                relations.get(students2.get(i)).add(students1.get(i));
            } else {
                Arrays.fill(check, false);
                answer.add(calculateFriends(students1.get(i), n) + calculateFriends(students2.get(i), n));
            }
        }
        return answer;
    }

}

public class Main_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int queryTypeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queryType = IntStream.range(0, queryTypeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int students1Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> students1 = IntStream.range(0, students1Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int students2Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> students2 = IntStream.range(0, students2Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.getTheGroups(n, queryType, students1, students2);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
        System.out.println(result.toString());
    }
}
