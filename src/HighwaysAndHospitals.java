/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Liam Krenz
 *
 */

public class HighwaysAndHospitals {

    // Returns the minimum cost associated with providing access to a hospital for every city.
    public static long cost(int n, int hospitalCost, int highwayCost, int[][] cities) {

        // Handles edge case with hospitals everywhere
        if (hospitalCost <= highwayCost) {
            return (long)n * hospitalCost;
        }

        // Map to store roots and number of descendants of roots
        int[] roots = new int[n + 1];

        // Iterates through edges and runs union find
        for (int[] connections : cities) {
            fastFind(roots, connections);
        }

        // Finds the number of disconected subgraphs
        int count = 0;
        for (int i = 1; i < roots.length; i++) {
            if (roots[i] <= 0) {
                count++;
            }
        }
        return ((long)count) * hospitalCost + (long)highwayCost * (n-count);
    }

    // Handles each connection in the union find algorithm
    private static void fastFind(int[] roots, int[] connection) {

        // Find the root of the left city
        int leftRoot = connection[0];
        while (roots[leftRoot] > 0) {
            leftRoot = roots[leftRoot];
        }

        // Compresses the path taken to the root for the left city
        int current = connection[0];
        while (roots[current] > 0) {
            int temp = current;
            current = roots[current];
            roots[temp] = leftRoot;
        }

        // Finds the root of the right city
        int rightRoot = connection[1];
        while (roots[rightRoot] > 0) {
            rightRoot = roots[rightRoot];
        }

        // Compresses path taken from right city to its root
        current = connection[1];
        while (roots[current] > 0) {
            int temp = current;
            current = roots[current];
            roots[temp] = rightRoot;
        }

        // Sets root of node with less descendants to the root of the other city if the roots aren't equal
        if (rightRoot != leftRoot) {

            // Chooses which root to keep and updates root values
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
}
