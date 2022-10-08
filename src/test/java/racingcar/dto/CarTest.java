package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarTest {

    @Test
    void 자동차_이름_입력_TEST() {
        String name = "jin";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 자동차_이름_길이_초과_TEST() {
        String name = "jinyoon";
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(name);
        });
    }
}
