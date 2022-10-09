package racingcar.dto;

import camp.nextstep.edu.missionutils.Randoms;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
public class Cars {
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;
    List<Car> cars;

    public Cars(List<String> inputCars) {
        List<Car> cars = this.mapCars(inputCars);

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
        this.validationDuplication(cars);
    }

    private void validationDuplication(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);

        if (carSet.size() != cars.size()) {
            throw new IllegalStateException("[ERROR] Car duplicate occurrence");
        }
    }

    public boolean play() {
        for (Car car : this.cars) {
            car.play(Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM));
        }

        return true;
    }

    private List<Car> getCarsByDistance(int distance) {
        List<Car> resultCars = new ArrayList<>();

        for (Car car : cars) {
            resultCars = this.addCarByDistance(resultCars, distance, car);
        }

        return resultCars;
    }

    private List<Car> addCarByDistance(List<Car> resultCars, int distance, Car car) {
        if (distance == car.getCarPosition().getDistance()) {
            resultCars.add(car);
        }

        return resultCars;
    }

    public List<Car> getCarsByMaxDistance() {
        int maxDistance = 0;

        for (Car car : this.cars) {
            maxDistance = this.getMoreBigDistance(maxDistance, car);
        }

        return this.getCarsByDistance(maxDistance);
    }

    private int getMoreBigDistance(int maxDistance, Car car) {
        if (maxDistance < car.getCarPosition().getDistance()) {
            return car.getCarPosition().getDistance();
        }

        return maxDistance;
    }
}
