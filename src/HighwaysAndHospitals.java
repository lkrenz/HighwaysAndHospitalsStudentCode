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


        /**
         * Need to find a way to separate each individual network of connectable cities.
         * Potentially run a search algorithm on each point in the graph and see if it can reach each other point.
         * If theres a point the graph can't reach, add every point it can to its graph.
         * Once I have the graphs set up based off of which ones can be connected, place a hospital on every node
         * and calculate the total price. From there, start removing hospitals starting with the node with the
         * least number of connections and add highways to connect that node to the nearest hospital with the highest
         * number of hospitals nearby. If that reduces the price, keep this case and move on. Once the price increases,
         * back off of this path.
         */

        /**
         * To separate the graph between the different colonies, pick a random point, (probably go through the array
         * based off of how many connections each point has), and find every point it can reach through breadth first
         * search.
         */

        /**
         * Once you have the arrays of each colony created, you can run the cycle outlined in the section above on each
         * individual colony to save on running efficiency. The method could be made more effecient if, instead of
         * creating the map of individual colonies, I just keep removing hospitals until the space cannot be connected
         * to a hospital. To do this, I could add a boolean value to to each node that says whether it is connected to a
         * hospital. If I can't connect a space to a space that is connected to a hospital, I would backup until I could
         */
        return 0;
    }
}
