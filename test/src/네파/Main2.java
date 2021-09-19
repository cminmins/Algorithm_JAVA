package 네파;

public class Main2 {

    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2 + 1;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }


    public static void main(String[] args) {


        System.out.println(solution(new int[]{1, 2, 5, 5, 5, 9, 9}, 5));
        System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 1));
        System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 2));
        System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 5));
        System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 9));



        System.out.println(solution(new int[]{1, 2, 4, 4, 4, 9, 9}, 5));
        System.out.println(solution(new int[]{1, 2, 4, 4, 5, 9, 9}, 5));
        System.out.println(solution(new int[]{1, 2, 4, 5, 5, 9, 9}, 5));
        System.out.println(solution(new int[]{1, 2, 5, 5, 5, 9, 9}, 5));
        System.out.println(solution(new int[]{1, 2, 5, 5, 5, 5, 9}, 5));
        System.out.println(solution(new int[]{5, 5, 5, 9}, 5));
        System.out.println(solution(new int[]{1, 3, 4, 9}, 5));
        System.out.println(solution(new int[]{1, 3, 9}, 5));
        ///
        System.out.println(solution(new int[]{1}, 5));
        System.out.println(solution(new int[]{1, 9}, 5));
        System.out.println(solution(new int[]{5}, 5));
        System.out.println(solution(new int[]{5, 9}, 5));
        System.out.println(solution(new int[]{5, 5}, 5));
        return;
    }
}
