package wilburhsu.LeetCode;

public class _62_UniquePaths {
    public int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];
        for(int i = 1;i < m;++i)
            dp[0][i] = 1;

        for(int j = 0;j < n;++j)
            dp[j][0] = 1;

        for(int i = 1;i < m;++i)//注意i和j的起始值
            for(int j = 1;j < n;++j)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }
}
