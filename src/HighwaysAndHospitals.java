import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        if (hospitalCost < highwayCost) {
            return ((long) hospitalCost) * n;
        }
        ArrayList<Integer>[] connections = new ArrayList[n];

        for (int i = 0; i < cities.length; i++) {
            connections[i] = new ArrayList<>();
            connections[cities[i][0]].add(cities[i][1]);
            connections[cities[1][1]].add(cities[i][0]);
        }

        int numVisited = 0;

        boolean[] visited = new boolean[n];

        ArrayList<Integer> clusters = new ArrayList<>();

        Queue<Integer> toVisit = new LinkedList<>();

        int numCluster = 0;
        while (numVisited != n) {
            int location = 0;
            clusters.add(0);
            while ((visited[location])) {
                location++;
            }
            toVisit.add(location);

            while (!toVisit.isEmpty()) {
                location = toVisit.poll();
                numVisited++;
                for (int i = 0; i < connections[location].size(); i++) {
                    if (visited[connections[location].get(i)]) {
                        continue;
                    }
                    toVisit.add(connections[location].get(i));
                    visited[connections[location].get(i)] = true;
                    clusters.set(numCluster, clusters.get(numCluster) + 1);
                }
            }
            numCluster++;
        }

        long price = 0;

        for (int i = 0; i < clusters.size(); i++) {
            price += hospitalCost + (clusters.get(i) - 1) * highwayCost;
        }

        return price;

    }
}
