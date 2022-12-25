package SangHyuk.종만북.무식하게풀기;

public class 소풍 {
//    int n;
//    boolean[][] areFriends = new boolean[10][10];
//
//    int countPairing(boolean taken[]) {
//        boolean finished = true;
//
//        for (int i = 0; i < n; ++i) {
//            if (!taken[i]) {
//                finished = false;
//            }
//        }
//
//        if (finished) {
//            return 1;
//        }
//
//        int ret = 0;
//
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (!taken[i] && !taken[j] && areFriends[i][j]) {
//                    taken[i] = taken[j] = true;
//                    ret += countPairing(taken);
//                    taken[i] = taken[j] = false;
//                }
//            }
//        }
//        return ret;
//    }

    int n;
    boolean[][] areFriends = new boolean[10][10];

    int countPairings(boolean[] taken) {
        int firstFree = -1;

        for (int i = 0; i < n; ++i) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }

        if (firstFree == -1) {
            return 1;
        }

        int ret = 0;

        for (int pairWith = firstFree + 1; pairWith < n; ++pairWith) {
            if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairings(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }
}
