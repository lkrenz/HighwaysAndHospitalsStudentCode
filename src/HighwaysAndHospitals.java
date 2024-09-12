import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Integer>[] connections = new ArrayList[n + 1];

        for (int i=0; i< connections.length; i++) {
            connections[i] = new ArrayList<>();
        }
        for (int i = 0; i < cities.length; i++) {
            connections[cities[i][0]].add(cities[i][1]);
            connections[cities[i][1]].add(cities[i][0]);
        }

        int numVisited = 0;

        boolean[] visited = new boolean[n + 1];

        ArrayList<Integer> clusters = new ArrayList<>();

        Queue<Integer> toVisit = new LinkedList<>();

        int numCluster = 0;
        while (numVisited <= n) {
            int location = 1;
            clusters.add(0);
            while ((visited[location]) && location < n) {
                location++;
            }
            toVisit.add(location);
            visited[location] = true;

            while (!toVisit.isEmpty()) {
                location = toVisit.poll();
                numVisited++;
                for (int i = 0; i < connections[location].size(); i++) {
                    if (!visited[connections[location].get(i)]) {
                        toVisit.add(connections[location].get(i));
                        visited[connections[location].get(i)] = true;
                        clusters.set(numCluster, clusters.get(numCluster) + 1);
                    }
                }
            }
            numCluster++;
        }

        long price = 0;
        for (int i = 0; i < clusters.size() - 1; i++) {
            price += hospitalCost + ((clusters.get(i)) * highwayCost);
        }

        return price;

    }
}
