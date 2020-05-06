package com.ds.rani.dp;

/**
 * 0-1 Knapsack Problem
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in t
 * he knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 * associated with n items respectively. Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 * Example:
 * Input:
 *      int val[] = new int[]{60, 100, 120};
 *      int wt[] = new int[]{10, 20, 30};
 *     int  targetW = 50;
 * Output:220
 */
//Approach:draw tree based on whether to take the item or not take the item. So it consists of various similar calculations.
//So this is DP. their are 2 constraints first is targetW and second is value sum should be maximum so create 2D array
public class Knapsack {
    /**
     *
     * @param targetW size of the sack
     * @param wt weight array
     * @param val value array
     * @return  maximum value that can be put in a knapsack of capacity targetW
     */
    //time complexity:o(n*m) where n is input array size and m is targetW or sack capacity.
    //Space complexity:o(n*m) where n is input array size and m is targetW or sack capacity.
    public static int knapSack(int targetW, int wt[], int val[]) {
        int row, w;
        int n = wt.length;
        //create 2 D array of size number of elements in array+1 and targetW+1
        int DP[][] = new int[n + 1][targetW + 1];

        // Build table DP[][]
        //    0 1 2 3 4 5 6 7 8 9....50
        //0   0 0 0 0 0 0 0 0 0 0
        //1   0
        //2   0

        for (row = 0; row <= n; row++) {
            for (w = 0; w <= targetW; w++) {
                if (row == 0 || w == 0)
                    DP[row][w] = 0;
                else if (wt[row - 1] <= w)
                    DP[row][w] = Math.max( val[row - 1] + DP[row - 1][w - wt[row - 1]], DP[row - 1][w] );
                else
                    DP[row][w] = DP[row - 1][w];
            }
        }

        return DP[n][targetW];
    }

    public static void main(String args[]) {
        int wt[] = new int[]{10, 20, 30};
        int val[] = new int[]{60, 100, 120};
        int targetW = 50;
        System.out.println( knapSack( targetW, wt, val ) );

    }
}
