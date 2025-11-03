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
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String price = Console.readLine();
                lottoPublisher.purchase(price);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1000원 이상의 정수여야 합니다.");
            }
        }
    }

    public Result inputWinningNumber() {
        while (true) {
            try {
                System.out.println("\n당첨번호를 입력해 주세요.");
                String winningNums = Console.readLine();
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String bonusNum = Console.readLine();
                return winningChecker.resultCheck(winningNums, bonusNum, lottoPublisher);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 중복 없는 1부터 45 사이의 숫자 6개를 입력해야 합니다.");
            }
        }
    }
}
