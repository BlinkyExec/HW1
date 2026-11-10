public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        // The shortest path from a vertex to itself is 0
        if (i == j) {
            return 0;
        }

        int n = m.length;
        if (n == 0) {
            return -1;
        }

        // dist[v] stores the shortest distance from vertex i to vertex v (-1 means unvisited)
        int[] dist = new int[n];
        for (int k = 0; k < n; k++) {
            dist[k] = -1;
        }

        int[] queue = new int[n];
        int head = 0;
        int tail = 0;

        dist[i] = 0;
        queue[tail++] = i;

        while (head < tail) {
            int curr = queue[head++];

            // Check all adjacent vertices
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (m[curr][neighbor] == 1 && dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;

                    // If we reached the target vertex j, return the distance immediately
                    if (neighbor == j) {
                        return dist[neighbor];
                    }

                    queue[tail++] = neighbor;
                }
            }
        }

        // If target vertex j is unreachable
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}
