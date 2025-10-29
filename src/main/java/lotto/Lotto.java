package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    public void addBonusNum(int bonusNum) {
        this.numbers.add(bonusNum);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (int num : numbers) {
            if (num > 45 || num < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지 입력 가능합니다.");
            }
        }
    }
}
