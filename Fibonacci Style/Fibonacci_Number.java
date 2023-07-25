import java.util.*;

class Fibonacci_Number {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // int ans = Recursion(n);
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        // int ans = Memoization(n, dp);
        int ans = Tabulation(n);
        // int ans = Space_Optimised(n);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int n) {
        if (n == 0 || n == 1)
            return n;
        return Recursion(n - 1) + Recursion(n - 2);
    }

    static int Memoization(int n, int dp[]) {
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = Memoization(n - 1, dp) + Memoization(n - 2, dp);
        return dp[n];
    }

    static int Tabulation(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    static int Space_Optimised(int n) {
        if (n == 0 || n == 1)
            return n;
        int curr = 0;
        int prev = 1;
        int prev1 = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev + prev1;
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
}