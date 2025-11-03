package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.LottoPublisher;
import lotto.Result;
import lotto.WinningChecker;

public class InputStream {
    private LottoPublisher lottoPublisher;
    private WinningChecker winningChecker;

    public InputStream() {
        this.winningChecker = new WinningChecker();
        this.lottoPublisher = new LottoPublisher();
    }
    public void inputPurchasePrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String price = Console.readLine();
            lottoPublisher.purchase(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수타입을 입력해주세요.");
        }
    }

    public Result inputWinningNumber() {
        System.out.println("\n당첨번호를 입력해 주세요.");
        String winningNums = Console.readLine();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        return winningChecker.resultCheck(winningNums, bonusNum, lottoPublisher);
    }
}
