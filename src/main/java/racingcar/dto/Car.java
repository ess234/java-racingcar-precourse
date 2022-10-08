package racingcar.dto;

import java.util.Objects;

public class Car {
    public static final int MAX_CAR_NAMR_LENGTH = 5;
    private String name;

    public Car(String name) {
        this.validation(name);
        this.name = name;
    }

    private void validation(String name) {
        if (this.isOverLength(name)){
            throw new IllegalArgumentException("[ERROR] name length over "+MAX_CAR_NAMR_LENGTH);
        }
    }

    private boolean isOverLength(String name) {
        return (name.length() > MAX_CAR_NAMR_LENGTH);
    }

    public String getName() {
        return name;
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
