public class Solution {

    public static void main(String[] args) {
        final String a = "BCDBCDA";
        final String b = "ABECBAB";

        int ans = getLongestCommonSubsequence(a, b);

        System.out.println(ans);
    }


    //This assumes that len(a) == len(b)
    private static int getLongestCommonSubsequence(String a, String b){
        int na = a.length();
        int nb = b.length();

        final int [][] L = new int[na + 1][nb + 1];

        //Fill in row = 0 with 0 && col = 0 with 0
        for(int i = 0; i <= na; i++) L[i][0] = 0;
        for(int i = 0; i <= nb; i++) L[i][0] = 0;

        //Compute the longest common subsequence
        for(int i = 1; i <= na; i++){
            for(int j = 1; j<= nb; j++){
                //If the chars are the same => 1 + diagonal
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    L[i][j] = 1 + L[i - 1][j - 1];
                } else{ 
                    //Best of 2 scenarios (drop last char of a or b) and get the entry
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }

        return L[na][nb];
    }
    

    //Traceback to find the solution
    // private static String retrieveSubsequence(int [][] L){
    //     return "";
    // }
}