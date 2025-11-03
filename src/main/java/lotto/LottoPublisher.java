package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.io.OutputStream;

public class LottoPublisher {
    private static final int UNIT = 1000;
    private List<Lotto> lottoNums = new ArrayList<>();
    public void purchase(String price) {
        int purchasePrice = validate(price);
        int count = calculate(purchasePrice);
        publishLottoNumber(count);
        OutputStream outputStream = new OutputStream();
        outputStream.printLottos(lottoNums);
    }

    public int getPrice() {
        return UNIT * lottoNums.size();
    }

    public List<Lotto> getLottoNums() {
        return lottoNums;
    }


    private int validate(String price) {
        try {
            int purchasePrice = Integer.parseInt(price);
            if (purchasePrice < UNIT) throw new IllegalArgumentException("[ERROR] 1000원 이상 입력해주세요.");
            if (purchasePrice % UNIT != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            return purchasePrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수타입을 입력해주세요.");
        }
    }

    private void publishLottoNumber(int cnt) {
        for (int i = 0; i < cnt ; i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            nums = nums.stream().sorted().collect(Collectors.toList());
            lottoNums.add(new Lotto(nums));
        }
    }

    private int calculate(int price) {
        return price / UNIT;
    }
}
