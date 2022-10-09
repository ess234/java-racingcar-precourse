package racingcar.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarTest {
    private Car car;
    private String name;

    @BeforeEach
    void setUp() {
        name = "jin";
        car = new Car("jin");
    }

    @Test
    void 자동차_이름_입력_TEST() {
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 자동차_이름_길이_초과_TEST() {
        String name = "jinyoon";

        assertThrows(IllegalArgumentException.class, () -> {
            new Car(name);
        });
    }

    @Test
    void 자동차_전진_TEST() {
        car.play(4);

        assertThat(car.getCarPosition().getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차_정지_TEST() {
        car.play(3);

        assertThat(car.getCarPosition().getDistance()).isEqualTo(0);
    }

    @Test
    void 자동자_randomNum_validation_TEST() {
        assertThat(car.play(9)).isTrue();

        assertThat(car.play(0)).isTrue();
    }

    @Test
    void 자동자_randomNum_validation_예외_TEST() {
        assertThrows(IllegalStateException.class, () -> {
            car.play(10);
        });

        assertThrows(IllegalStateException.class, () -> {
            car.play(-1);
        });
    }
}
