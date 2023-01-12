package SangHyuk.backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class N과M_15650 {
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

        int smallest = picked.isEmpty() ? 1 : picked.get(picked.size() - 1) + 1;

        for (int next = smallest; next <= N; next++) {
            picked.add(next);
            pick(picked, toPick + 1);
            picked.remove(picked.size() - 1);
        }
    }
}
