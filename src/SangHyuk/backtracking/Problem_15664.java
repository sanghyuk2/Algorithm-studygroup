package SangHyuk.backtracking;

import java.util.*;

public class Problem_15664 {
    static int N,M;
    static int[] nums;
    static HashSet<String> set = new HashSet<>();
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

        pick(new boolean[N], new ArrayList<>(), 0);

        System.out.println(sb);

    }

    static void pick(boolean[] taken, ArrayList<Integer> picked, int toPick) {
        if (toPick == M) {
            //Collection을 여기다 사용함으로써 {7, 1}이던게 {1,7}이 되면서 picked.remove(picked.size()-1)에서 7이 삭제가 된다.
            Collections.sort(picked);
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < toPick; i++) {
                temp.append(picked.get(i)).append(' ');
            }

            String str = temp.toString();

            if (!set.contains(str)) {
                set.add(str);
                sb.append(temp).append('\n');
            }

            return;
        }

        for (int next = 0; next < N; next++) {
            if (taken[next]) {
                continue;
            }

            picked.add(nums[next]);
            taken[next] = true;
            pick(taken, picked, toPick + 1);
            //remove()에 int를 넘겨주면 index로 판단하므로 object형태인 Integer로 넘겨줘야한다.
            picked.remove(Integer.valueOf(nums[next]));
            taken[next] = false;
        }
    }
}
