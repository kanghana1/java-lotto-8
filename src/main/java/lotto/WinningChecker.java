package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningChecker {
    public void resultCheck(String winningNums, String bonusNum) {
        Lotto lotto = winningNumsCheck(winningNums);
        bonusNumCheck(bonusNum, lotto);

    }

    private void bonusNumCheck(String num, Lotto lotto) {
        try {
            int bonusNum = Integer.parseInt(num);
            lotto.addBonusNum(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수형만 입력 가능합니다.");
        }
    }

    private Lotto winningNumsCheck(String nums) {
        try {
            String[] winningNumbers = nums.trim().split(",");
            List<Integer> inputNums = Arrays.stream(winningNumbers).map(Integer::parseInt)
                    .distinct()
                    .toList();

            return new Lotto(inputNums);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수형만 입력 가능합니다.");
        }
    }
}
