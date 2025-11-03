package lotto;

import java.util.List;
import lotto.io.InputStream;
import lotto.io.OutputStream;

public class Application {
    public static void main(String[] args) {
        InputStream inputStream = new InputStream();
        inputStream.inputPurchasePrice();
        Result results = inputStream.inputWinningNumber();
        OutputStream outputStream = new OutputStream();
        outputStream.printResults(results);
    }
}
