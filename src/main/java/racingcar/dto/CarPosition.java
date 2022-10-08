package racingcar.dto;

public class CarPosition {
    public static final int STANDARD_NUM = 4;
    public static final int MOVE_GO = 1;
    public static final int MOVE_STOP = 0;

    int distance = 0;

    public CarPosition() {
    }

    public void setDistance(int randomNum) {
        this.distance = this.distance+this.judgeGoOrStop(randomNum);
    }

    private int judgeGoOrStop(int randomNum) {
        if (isGo(randomNum)){
            return MOVE_GO;
        }

        return MOVE_STOP;
    }

    private boolean isGo(int randomNum) {
        return STANDARD_NUM <= randomNum;
    }

    public int getDistance() {
        return this.distance;
    }
}
