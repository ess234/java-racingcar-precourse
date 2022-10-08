package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {

    @Test
    void 시도회수_입력_TEST() {
        String tryCnt = "0";
        RacingCar racingCar = new RacingCar(tryCnt);

        assertThat(racingCar.getTryCnt()).isEqualTo(Integer.parseInt(tryCnt));
    }

    @Test
    void 시도회수_숫자_아닌_값_입력_TEST() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar("a");
        });
    }
}
