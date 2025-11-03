package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningChecker {

    private List<Integer> winningNums = new ArrayList<>();
    private int[] winningCnt = new int[5]; // 3, 4, 5, 6(5 + 보너스), 7(6개)
    private static int[] winnings = new int[]{5000, 50000, 1500000, 30000000, 2000000000};

    public Result resultCheck(String winningNums, String bonusNum, LottoPublisher lottoPublisher) {
        winningNumsCheck(winningNums);
        int bonus = bonusNumCheck(bonusNum);

        for (Lotto lotto : lottoPublisher.getLottoNums()) {
            int cnt = count(lotto, bonus);
            if (cnt >= 3) {
                winningCnt[cnt - 3]++;
            }
        }

        double rateOfReturn = calculateRateOfReturn(lottoPublisher.getPrice());

        return new Result(winningCnt, rateOfReturn);
    }

    private double calculateRateOfReturn(int price) {
        int sum = 0;
        for (int i = 0 ; i < 5 ; i++) {
            sum += winningCnt[i] * winnings[i];
        }
        return (double) sum / price;
    }

    private int count(Lotto lotto, int bonusNum) {
        int cnt = 0;
        boolean bonus = false;
        List<Integer> numbers = lotto.getNumbers();
        int idx = 0;
        for (int num : winningNums) {
            while (idx < numbers.size()) {
                if (bonusNum == numbers.get(idx)) {
                    bonus = true;
                    idx++;
                    continue;
                }

                if (numbers.get(idx) == num) {
                    cnt++;
                    break;
                } else idx++;
            }
        }
        if (cnt == 5 && bonus) return 6;
        if (cnt == 6) return 7;
        return cnt;
    }

    private int bonusNumCheck(String num) {
        try {
            int bonusNum = Integer.parseInt(num);
            if (winningNums.contains(bonusNum)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되는 수는 입력이 불가능합니다.");
            }
            return bonusNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수형만 입력 가능합니다.");
        }
    }

    private void winningNumsCheck(String nums) {
        try {
            String[] winningNumbers = nums.trim().split(",");
            winningNums = Arrays.stream(winningNumbers)
                    .map(this::validate)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            if (winningNums.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 중복되지 않는 수로 6개를 입력해야 합니다.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수형만 입력 가능합니다.");
        }
    }

    private int validate(String str) {
        try {
            String trim = str.trim();
            int n = Integer.parseInt(trim);
            if (n > 45) throw new IllegalArgumentException("[ERROR] 45를 초과하는 수는 입력할 수 없습니다.");
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력할 수 있습니다.");
        }
    }
}
