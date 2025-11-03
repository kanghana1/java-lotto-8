package lotto;

public class Result {

    private final int[] results;
    private final double rateOfReturn;

    public Result(int[] r, double p) {
        this.results = r;
        this.rateOfReturn = p;
    }

    public int[] getResults() {
        return results;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
