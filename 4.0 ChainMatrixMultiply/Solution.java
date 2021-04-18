import java.util.*;
import java.util.stream.IntStream;
/**
 * Chain Matrix Multiplication (DP)
 * 
 * @author Ochibobo Warren
 * 
 */
class Solution{

    public static void main(String[] args) {
        final int [][] dimensions = {
            {4,10},
            {10,3},
            {3,12}, 
            {12,20},
            {20,7}
        };

        int n = dimensions.length;

        // Get the minimum number of matrix operations required
        int nOperations = findMinimalNumberOfOperations(dimensions, n);
        
        System.out.println(nOperations);
    }
    

    private static int findMinimalNumberOfOperations(int [][] arr, int n){
        // Array to hold the result of the computations
        final int[][] L = new int[n][n];

        // Array to hold the matrix used in the operation
        final int[][] S = new int[n][n];

        // Fill the diagonal values with zeros
        for(int i = 0; i < n; i++) L[i][i] = 0;

        // Compute the minimum number of calculations required
        for(int s = 1; s < n; s++){ // The width to be traversed
            // The rows
            for(int i = 0; i < (n - s); i++){
                int j = i + s; // The end of the substring
                L[i][j] = Integer.MAX_VALUE; // Initialize min to largest integral value
                // Shift the position of the bracket
                for(int l = i; l < j; l++){
                    // Compute the current cost
                    int computedCost = arr[i][0] * arr[l + 1][0] * arr[j][1] + L[i][l] + L[l + 1][j];
                    // Update if computerd current cost is lesser than existing cost
                    if(L[i][j] > computedCost) {
                        L[i][j] = computedCost;
                        S[i][j] = l; //Update the position the bracket will be placed
                    }
                }
            }
        }

        print(S);
        return L[0][n - 1];
    }

    private static void print(int [][]  arr){
        for(int [] a : arr){
            System.out.println(Arrays.deepToString(IntStream.of(a).boxed().toArray()));
        }
    }
}