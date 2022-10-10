package racingcar.service;

import lombok.Getter;
import racingcar.dto.Car;
import racingcar.dto.Cars;

import java.util.Arrays;
import java.util.List;

@Getter
public class RacingCar {
    private static final String SEPARATOR_CARS_NAME = ",";
    Cars cars;

    public RacingCar(String carsName) {
        this.validationCarsName(carsName);

        this.cars = new Cars(Arrays.asList(carsName.split(SEPARATOR_CARS_NAME)));
    }

    private void validationCarsName(String carsNameStr) {
        if (!carsNameStr.contains(SEPARATOR_CARS_NAME)) {
            throw new IllegalArgumentException("cars name does not contain correct separator");
        }
    }

    public boolean start(int tryCnt) {
        System.out.println("실행 결과");

        for (int i = 0; i < tryCnt; i++) {
            this.cars.play();

            System.out.println();
        }

        return true;
    }

    public boolean end() {
        System.out.println("최종 우승자 : " + printWinnerCarsName());

        return true;
    }

    private String printWinnerCarsName() {
        String result = "";

        List<Car> winnerCar = this.getWinnerCars();

        for (Car car : winnerCar) {
            result += car.getName() + ",";
        }

        return result.substring(0, result.length() - 1);
    }

    private List<Car> getWinnerCars() {
        List<Car> winnerCars = this.cars.getCarsByMaxDistance();

        return winnerCars;
    }
}
