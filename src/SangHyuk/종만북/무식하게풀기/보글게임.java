package SangHyuk.종만북.무식하게풀기;

public class 보글게임 {
    final int dx[] = {-1, -1, -1, 1, 1, 1, 0, 0};
    final int dy[] = {-1, 0, 1, -1, 0, 1, -1, 1};

    boolean hasWord(int y, int x, final String[] word) {
        if (!inRange(y, x)) {
            return false;
        }

        if (board[y][x] != word[0]) {
            return false;
        }

        if (word.length == 1) {
            return true;
        }

        for (int direction = 0; direction < 8; ++direction) {
            int nextY = y + dy[direction], nextX = x + dx[direction];
            if (hasWord(nextY, nextX, word)) {
                return true;
            }
        }
        return false;
    }

}
