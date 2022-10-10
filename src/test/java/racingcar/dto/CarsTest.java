package racingcar.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> setUpCars = new ArrayList<>();

        setUpCars.add(new Car ("pobi"));
        setUpCars.add(new Car ("woni"));
        setUpCars.add(new Car ("jun"));

        cars = new Cars(setUpCars);
    }

    @Test
    void 자동차들_생성_TEST() {
        assertThat(cars).isNotNull();
    }

    @Test
    void 자동차들_중복_발생_TEST() {
        assertThrows(IllegalStateException.class, () -> {
            List<Car> setUpCars = new ArrayList<>();

            setUpCars.add(new Car ("pobi"));
            setUpCars.add(new Car ("woni"));
            setUpCars.add(new Car ("woni"));

            new Cars(setUpCars);
        });
    }

    @Test
    void 자동차들_위치_이동_TEST() {
        assertThat(cars.play()).isTrue();
    }

    @Test
    void 거리가_제일_먼_자동차_가져오기_TEST() {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.play();

                    for (Car car : cars.getCars()) {
                        System.out.println(car.getName() + " : " + car.getCarPosition().getDistance());
                    }

                    assertThat(cars.getCarsByMaxDistance()).isEqualTo(Arrays.asList(new Car("woni")));
                },
                3, 4, 3
        );

    }

    @Test
    void 거리가_제일_먼_자동차들_가져오기_TEST() {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.play();

                    for (Car car : cars.getCars()) {
                        System.out.println(car.getName() + " : " + car.getCarPosition().getDistance());
                    }

                    assertThat(cars.getCarsByMaxDistance()).isEqualTo(Arrays.asList(new Car("woni"), new Car("jun")));
                },
                3, 4, 4
        );

    }

}
