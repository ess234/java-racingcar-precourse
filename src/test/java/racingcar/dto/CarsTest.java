package racingcar.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {

    @Test
    void 자동차들_생성_TEST() {
        assertThat(new Cars(Arrays.asList("pobi", "woni", "jun"))).isNotNull();
    }

    @Test
    void 자동차들_중복_발생_TEST() {
        assertThrows(IllegalStateException.class, () -> {
            new Cars(Arrays.asList("pobi", "woni", "woni"));
        });
    }

    @Test
    void 자동차들_위치_이동_TEST() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"));

        assertThat(cars.play()).isTrue();
    }
}
