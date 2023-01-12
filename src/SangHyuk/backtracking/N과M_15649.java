package SangHyuk.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class N과M_15649 {
    static int N,M;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        pick(new boolean[N+1], new ArrayList<>(), 0);

        System.out.println(sb);
    }

    static void pick(boolean[] taken, ArrayList<Integer> picked, int toPick) {
        if (toPick == M) {
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


        for (int next = 1; next <= N; next++) {
            if (taken[next]) {
                continue;
            }

            picked.add(next);
            taken[next] = true;
            pick(taken, picked, toPick + 1);
            picked.remove(picked.size() - 1);
            taken[next] = false;
        }
    }
}
