package SangHyuk.backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class N과M_15651 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        pick(new ArrayList<>(), 0);

        System.out.println(sb);

    }

    static void pick(ArrayList<Integer> picked, int toPick) {
        if (toPick == M) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < toPick; i++) {
                temp.append(picked.get(i)).append(' ');
            }

            sb.append(temp).append('\n');

            return;
        }

        for (int next = 1; next <= N; next++) {
            picked.add(next);
            pick(picked, toPick + 1);
            picked.remove(picked.size() - 1);
        }

    }
}
