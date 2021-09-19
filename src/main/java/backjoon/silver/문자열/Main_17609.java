package backjoon.silver.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            String str = br.readLine();
            int front = 0;
            int back = str.length() - 1;
            int check = 0;

            while (front <= back) {
                if (str.charAt(front) != str.charAt(back)) {
                    int left = front + 1;
                    int right = back;
                    while (left <= right) {
                        if (str.charAt(left) != str.charAt(right)) {
                            check++;
                            break;
                        } else {
                            left++;
                            right--;
                        }
                    }
                    // 이거 통과했으면 check == 0

                    left = front;
                    right = back - 1;
                    while (left <= right) {
                        if (str.charAt(left) != str.charAt(right)) {
                            check++;
                            break;
                        } else {
                            left++;
                            right--;
                        }
                    }
                    check = Math.max(1, check);
                    break;
                } else {
                    front++;
                    back--;
                }
            }
            System.out.println(check);
        }
        return;
    }
}
