package lotto.io;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.LottoPublisher;
import lotto.Result;

public class OutputStream {
    String[] resultFormat = new String[5];

    public void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.print("[");
            for (int i = 0 ; i < 6 ; i++) {
                if (i == 5) {
                    System.out.println(numbers.get(i) + "]");
                    break;
                }
                System.out.print(numbers.get(i) + ", ");
            }
        }
    }

    public void printResults(Result results) {
        int[] result = results.getResults();
        double rateOfReturn = results.getRateOfReturn();
        makeStringFormat();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println(resultFormat[i] + result[i] + "개");
        }

        System.out.println("총 수익률은 " + Math.round(rateOfReturn * 10) / 10.0 + "%입니다.");
    }

    private void makeStringFormat() {
        resultFormat[0] = "3개 일치 (5,000원) - ";
        resultFormat[1] = "4개 일치 (50,000원) - ";
        resultFormat[2] = "5개 일치 (1,500,000원) - ";
        resultFormat[3] = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        resultFormat[4] = "6개 일치 (2,000,000,000원) - ";
    }

}
