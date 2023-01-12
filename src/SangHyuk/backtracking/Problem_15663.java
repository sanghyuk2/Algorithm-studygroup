package SangHyuk.backtracking;

import java.util.*;

public class Problem_15663 {
    /*
    * 문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

N개의 자연수 중에서 M개를 고른 수열
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
* */
    static int N,M;
    static int[] nums;
    static LinkedHashSet<String> answ = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        pick(new boolean[N], new ArrayList<>(), M);

        System.out.println(sb);

    }

    static void pick(boolean[] taken, List<Integer> picked, int toPick) {
        if (toPick == 0) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < M; i++) {
                temp.append(picked.get(i)).append(' ');
            }

            String str = temp.toString();

            if (!answ.contains(str)) {
                answ.add(str);
                sb.append(temp).append('\n');
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (taken[i]) {
                continue;
            }

            taken[i] = true;
            picked.add(nums[i]);
            pick(taken, picked, toPick - 1);
            taken[i] = false;
            picked.remove(picked.size() - 1);
        }
    }

}
