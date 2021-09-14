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



class Main_2 {

    /*
     * Complete the 'paperCuttings' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER textLength
     *  2. INTEGER_ARRAY starting
     *  3. INTEGER_ARRAY ending
     */

    public static long paperCuttings(int textLength, List<Integer> starting, List<Integer> ending) {
        // Write your code here
        long answer = 0;
        Set<Integer> duplicated = new HashSet<>();
        List<Integer> newStarting = new ArrayList<>();
        List<Integer> newEnding = new ArrayList<>();

        for (int i = 0; i < starting.size(); i++) {
            for (int j = 0; j < starting.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (starting.get(i) != starting.get(j) &&
                        ending.get(i) != ending.get(j)) {
                    newStarting.add(starting.get(i));
                    newEnding.add(ending.get(i));
                }
            }
        }

        int ns = newStarting.size();
        int ne = newEnding.size();

        for (int i = 0; i < ne; i++) {
            for (int j = 0; j < ns; j++) {
                if (i == j) {
                    continue;
                }
                if (newEnding.get(i) < newStarting.get(j)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH.txt")));

        int textLength = Integer.parseInt(bufferedReader.readLine().trim());

        int startingCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> starting = IntStream.range(0, startingCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int endingCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ending = IntStream.range(0, endingCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = Main_2.paperCuttings(textLength, starting, ending);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
