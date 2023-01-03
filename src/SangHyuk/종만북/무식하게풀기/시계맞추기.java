package SangHyuk.종만북.무식하게풀기;

import java.util.Scanner;

public class 시계맞추기 {
    static final int INF = 987654321;
    static final int SWITCHES = 10;
    static final int CLOCK = 16;
    static int linked[][] = {
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] result = new int[size];
        int[] clocks = new int[CLOCK];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < CLOCK; j++) {
                clocks[j] = sc.nextInt();
            }

            result[i] = solve(clocks, 0);
            if (result[i] == INF) {
                result[i] = -1;
            }
        }

        for (int output : result) {
            System.out.println(output);
        }
    }

    public static boolean areAligned(int[] clocks) {
        for (int i = 0; i < CLOCK; i++) {
            if (clocks[i] != 12) {
                return false;
            }
        }
        return true;
    }

    //사용자가 누른 스위치 번호에 연결된 시계들 전부 3시간씩 돌아간다.
    public static void push(int[] clocks, int swtch) {
        for (int clock = 0; clock < CLOCK; clock++) {
            if (linked[swtch][clock] == 1) {
                clocks[clock] += 3;
                if (clocks[clock] == 15) {
                    clocks[clock] = 3;
                }
            }
        }
    }

    //clocks: 시침 배열, swtch: 스위치 번호
    public static int solve(int[] clocks, int swtch) {
        if (swtch == SWITCHES) {
            return areAligned(clocks) ? 0 : INF;
        }

        int ret = INF;
        for (int cnt = 0; cnt < 4; cnt++) {
            ret = Math.min(ret, cnt + solve(clocks, swtch + 1));
            //0번에서 9번까지 스위치를 각각 0번에서 3번까지 눌러본다.
            push(clocks, swtch);
        }
        return ret;
    }


}
