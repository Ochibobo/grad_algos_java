public class Solution {

    public static void main(String[] args) {
        final int [] arr = {5,7,4,-3,9,1,10,4,5,8,9,3};

        int n = arr.length;

        int sol = countLongestIncreasingSubsequence(arr, n);

        System.out.println(sol);
    }
    
    private static int countLongestIncreasingSubsequence(int [] arr, int n){
        //Array to store the length of the longest increasing subsequence at each index
        final int[] L = new int[n];
        //L[i] contains the length of the longest increasing subsequence up until index i

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            L[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && L[i] < (1 + L[j])){
                    L[i] = 1 + L[j];
                }
            }

            max = Math.max(max, L[i]);
        }

        return max;
    }
}