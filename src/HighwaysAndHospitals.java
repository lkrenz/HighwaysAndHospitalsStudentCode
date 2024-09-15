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
        int[] roots = new int[n + 1];

        for (int i = 0; i < cities.length; i++) {
            // Set the root of the second city to the root of the first city
            if (roots[cities[i][0]] == 0) {
                roots[cities[i][1]] = cities[i][0];
                System.out.println(Arrays.toString(roots));
            }
            else {
                int root = roots[cities[i][0]];
                while (root != 0) {
                    root = roots[root];
                }
                roots[cities[i][1]] = root;

            }
        }
        System.out.println(Arrays.toString(roots));
        int count = -1;
        for (int i = 0; i < n ; i++) {
            if (roots[i] == 0) {
                count++;
            }
        }
        return ((long)(count * hospitalCost)) + (highwayCost * (n - count));
    }
}
