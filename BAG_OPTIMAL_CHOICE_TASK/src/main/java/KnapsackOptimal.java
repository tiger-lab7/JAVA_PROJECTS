import org.jetbrains.annotations.NotNull;

public class KnapsackOptimal {


    static int findMaxCost(@NotNull final Treasure[] tr, final int maxWeight) {

        int trCount = tr.length;
        int[][] dp = new int[trCount + 1][maxWeight + 1];

        for (int i = 1; i < trCount + 1; ++i) {
            for (int weight = 1; weight < maxWeight + 1; ++weight) {
                Treasure currentItem = tr[i - 1];
                if (currentItem.weight() <= weight) {
                    dp[i][weight] =
                            Math.max(dp[i - 1][weight],
                                    currentItem.cost() + dp[i - 1][weight - currentItem.weight()]);
                }
                else {
                    dp[i][weight] = dp[i - 1][weight];
                }
            }
        }
        Util.print2DIntArray(dp);
        return dp[trCount][maxWeight];
    }

    private KnapsackOptimal() {}
}
