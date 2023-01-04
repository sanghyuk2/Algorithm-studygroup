package SangHyuk.종만북.무식하게풀기;

import java.util.Scanner;

public class 보글게임 {
    static final int dx[] = {-1, -1, -1, 1, 1, 1, 0, 0};
    static final int dy[] = {-1, 0, 1, -1, 0, 1, -1, 1};
    static final char[][] board = new char[5][5];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; ++i) {
            String tmpStr = sc.next();
            for(int j = 0; j < 5; ++j) {
                board[i][j] = tmpStr.charAt(j);
            }
        }

        int testCount = sc.nextInt();
        String[] str = new String[testCount];

        for (int i = 0; i < str.length; i++) {
            str[i] = sc.next();
        }

        for (int n = 0; n < str.length; n++) {
            boolean isWord = false;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (hasWord(i, j, str[n])) {
                        isWord = true;
                        break;
                    }
                }
                if(isWord) break;
            }
            System.out.print(str[n] + " ");
            if (isWord) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }

    static boolean hasWord(int y, int x, final String word) {
        if (!inRange(y, x)) {
            return false;
        }

        if (board[y][x] != word.charAt(0)) {
            return false;
        }

        if (word.length() == 1) {
            return true;
        }

        for (int direction = 0; direction < 8; ++direction) {
            int nextY = y + dy[direction], nextX = x + dx[direction];
            if (hasWord(nextY, nextX, word.substring(1))) {
                return true;
            }
        }
        return false;
    }

    static boolean inRange(int y, int x) {
        return (x >= 0 && x < 5) && (y >= 0 && y < 5);
    }

}
