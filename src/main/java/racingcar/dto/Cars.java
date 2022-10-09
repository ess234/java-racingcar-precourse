package racingcar.dto;

import camp.nextstep.edu.missionutils.Randoms;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class Cars {
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    List<Car> cars;

    public Cars(List<String> inputCars) {
        List<Car> cars = mapCars(inputCars);
        this.validation(cars);

        this.cars = cars;
    }

    private List<Car> mapCars(List<String> inputCars) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < inputCars.size(); i++) {
            Car car = new Car(inputCars.get(i));

            cars.add(car);
        }
        return cars;
    }

    private void validation(List<Car> cars) {
        validationDuplication(cars);
    }

    private void validationDuplication(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);

        if (carSet.size() != cars.size()) {
            throw new IllegalStateException("[ERROR] Car duplicate occurrence");
        }
    }

    public boolean play() {
        for (Car car : this.cars){
            car.play(Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM));
        }

        return true;
    }
}
