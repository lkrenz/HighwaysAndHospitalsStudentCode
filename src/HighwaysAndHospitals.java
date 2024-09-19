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

        for (int[] city : cities) {
            int leftRoot = city[0];
            while (roots[leftRoot] > 0) {
                leftRoot = roots[leftRoot];
            }
            int current = city[0];
            while (current != leftRoot) {
                int temp = current;
                current = roots[current];
                roots[temp] = leftRoot;
            }

            int rightRoot = city[1];
            while (roots[rightRoot] > 0) {
                rightRoot = roots[rightRoot];
            }

            current = city[1];
            while (current != rightRoot) {
                int temp = current;
                current = roots[current];
                roots[temp] = rightRoot;
            }
            if (rightRoot != leftRoot) {
                if (roots[rightRoot] < roots[leftRoot]) {
                    roots[rightRoot] = roots[rightRoot] + roots[leftRoot] - 1;
                    roots[leftRoot] = rightRoot;
                }
                else {
                    roots[leftRoot] = roots[rightRoot] + roots[leftRoot] - 1;
                    roots[rightRoot] = leftRoot;
                }
            }
        }


        int count = 0;
        for (int i = 1; i < roots.length; i++) {
            if (roots[i] <= 0) {
                count++;
            }
        }

        long price = ((long)count) * hospitalCost + (long)highwayCost * (n-count);
        return price;
    }
}
