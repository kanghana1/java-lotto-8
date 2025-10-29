package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoPublisher;
import lotto.WinningChecker;

public class InputStream {
    private LottoPublisher lottoPublisher;
    private WinningChecker winningChecker;

    public InputStream() {
        this.winningChecker = new WinningChecker();
        this.lottoPublisher = new LottoPublisher();
    }
    public void inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();

    }

    public void inputWinningNumber() {
        System.out.println("\n당첨번호를 입력해 주세요.");
        String winningNums = Console.readLine();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        winningChecker.resultCheck(winningNums, bonusNum);
    }
}
