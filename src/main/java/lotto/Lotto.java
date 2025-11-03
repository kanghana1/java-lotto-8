package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        numbers = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 없이 6개여야 합니다.");
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
