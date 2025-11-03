package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호와_당첨_번호가_중복되면_예외_발생() {
        WinningChecker winningChecker = new WinningChecker();

        assertThatThrownBy(() -> winningChecker.resultCheck("1, 2, 3, 4, 5, 6", "5", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_6개를_넘으면_예외_발생() {
        WinningChecker winningChecker = new WinningChecker();

        assertThatThrownBy(() -> winningChecker.resultCheck("1, 2, 3, 4, 5, 6, 7", "12", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_6개가_안되면_예외_발생() {
        WinningChecker winningChecker = new WinningChecker();

        assertThatThrownBy(() -> winningChecker.resultCheck("1, 2, 3, 4, 5", "12", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_중복되면_예외_발생() {
        WinningChecker winningChecker = new WinningChecker();

        assertThatThrownBy(() -> winningChecker.resultCheck("1, 2, 3, 5, 6, 6", "12", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_6개를_초과하고_중복되면_예외_발생() {
        WinningChecker winningChecker = new WinningChecker();

        assertThatThrownBy(() -> winningChecker.resultCheck("1, 2, 3, 5, 6, 6, 7", "12", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_정수형으로_파싱_불가하면_예외_발생() {
        WinningChecker winningChecker = new WinningChecker();

        assertThatThrownBy(() -> winningChecker.resultCheck("1, 2, 3, 4, 5, aa", "12", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
