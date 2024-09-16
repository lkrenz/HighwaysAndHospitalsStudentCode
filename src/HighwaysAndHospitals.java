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

        if (hospitalCost <= highwayCost) {
            return (long)n * hospitalCost;
        }

        for (int i = 0; i < cities.length; i++) {
            // Set the root of the second city to the root of the first city
            if (roots[cities[i][0]] == 0) {
                roots[cities[i][1]] = cities[i][0];
                System.out.println(roots[0] + "  :  " + Arrays.toString(cities[i]));
            }
            else {
                int root = roots[cities[i][1]];
                while (roots[root] != 0) {
                    root = roots[root];
                }
                // Root is the index of the right side's root
                roots[root] = roots[cities[i][0]];

            }
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (roots[i] == 0) {
                count++;
            }
        }

        long price = ((long)count) * hospitalCost + (long)highwayCost * (n-count);
        System.out.println(count);
        System.out.println(price);
        return price;
    }
}
