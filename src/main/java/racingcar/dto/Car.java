package racingcar.dto;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Car {
    public static final int MAX_CAR_NAMR_LENGTH = 5;
    private String name;
    private CarPosition carPosition;

    public Car(String name) {
        this.validation(name);
        this.name = name;
        this.carPosition = new CarPosition();
    }

    private void validation(String name) {
        if (this.isOverLength(name)) {
            throw new IllegalArgumentException("[ERROR] name length over " + MAX_CAR_NAMR_LENGTH);
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
}
