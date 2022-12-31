package SangHyuk.종만북.무식하게풀기;

import java.util.List;

import static java.lang.Math.min;

public class 여행하는외판원 {
    final static double MAX = Integer.MAX_VALUE;
    int n;
    double[][] dist;

    double shortestPath(List<Integer> path, boolean[] visited, double currentLength) {
        if (path.size() == n) {
            return currentLength + dist[path.get(0)][path.get(path.size() - 1)];
        }

        double ret = MAX;

        for (int next = 0; next < n; next++) {
            if (visited[next]) {
                continue;
            }
            int here = path.get(path.size() - 1);
            path.add(next);
            visited[next] = true;
            double cand = shortestPath(path, visited, currentLength + dist[here][next]);
            ret = min(ret, cand);
            visited[next] = false;
            path.remove(path.size() - 1);
        }
        return ret;
    }
}
