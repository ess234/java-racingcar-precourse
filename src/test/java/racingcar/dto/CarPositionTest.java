package racingcar.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {
    private CarPosition carPosition;

    @BeforeEach
    void setUp() {
        carPosition = new CarPosition();
    }

    @Test
    void 정지_TEST() {
        carPosition.setDistance(3);
        assertThat(carPosition.getDistance()).isEqualTo(0);
    }

    @Test
    void 전진_TEST() {
        carPosition.setDistance(4);
        assertThat(carPosition.getDistance()).isEqualTo(1);
    }
}
