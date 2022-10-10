package racingcar.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class Car {
    private static final int MAX_CAR_NAMR_LENGTH = 5;
    private static final String PRINT_DISTANCE = "-";
    private String name;
    private CarPosition carPosition;

    public Car(String name) {
        this.validation(name);
        this.name = name;
        this.carPosition = new CarPosition();
    }

    private void validation(String name) {
        if (this.isOverLength(name)) {
            throw new IllegalArgumentException("name length over " + MAX_CAR_NAMR_LENGTH);
        }
    }

    private boolean isOverLength(String name) {
        return (name.length() > MAX_CAR_NAMR_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean play(int randomNum) {
        this.isValidationRandomNum(randomNum);

        this.carPosition.setDistance(randomNum);

        System.out.println(printCarDistance());

        return true;
    }

    private String printCarDistance() {
        String printStr = this.getName() + " : ";

        for (int i = 0; i < this.getCarPosition().getDistance(); i++) {
            printStr += PRINT_DISTANCE;
        }

        return printStr;
    }

    private void isValidationRandomNum(int randomNum) {
        if (!(0 <= randomNum && 9 >= randomNum)) {
            throw new IllegalStateException("randomNum is not valid");
        }
    }


}
