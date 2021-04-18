/**
 * @author Ochibobo Warren
 * 
 * 0/1 Knapsack Solutions (with and without) repetition
 * 
 */
class Solution{

    public static void main(String[] args) {
        final int[] weights = {15, 12, 10, 5};
        final int[] values = {15, 10, 8, 1};

        final int totalWeight = 22;

        int maxValue = knapSackNoRepetition(weights, values, totalWeight);
        int repMaxVal = knapSackRepetition(weights, values, totalWeight);

        System.out.println(maxValue); 
        System.out.println(repMaxVal);
    }

    //Return the maximum possible value to be formed
    private static int knapSackNoRepetition(int [] weights, int [] values, int totalWeight){
        int nWeights = weights.length;
        int m = nWeights + 1;
        int n = totalWeight + 1;

        // 2D matrix to hold the dp solutions
        final int [][] L = new int[m][n];

        for(int i = 0; i < m; i++) L[i][0] = 0;
        for(int b = 0; b < n; b++) L[0][b] = 0;

        for(int i = 1; i < m; i++){
            for(int b = 1; b < n; b++){
                if(weights[i - 1] <= b){
                    L[i][b] = Math.max(values[i - 1] + L[i - 1][b - weights[i - 1]],
                                     L[i - 1][b]);
                } else{ 
                    L[i][b] = L[i - 1][b];
                }
            }
        }

        return L[m - 1][n - 1];
    }


    // Knapssack with repetition
    private static int knapSackRepetition(int [] weights, int [] values, int totalWeight){
        final int [] L = new int[totalWeight];

        for(int b = 0; b < totalWeight; b++){
            L[b] = 0;
            for(int i = 0; i < weights.length; i++){
                if(weights[i] < b && L[b] < (values[i] + L[b - weights[i]])){
                    L[b] = values[i] + L[b - weights[i]];
                }
            }
        }


        return L[totalWeight - 1];
    }
}