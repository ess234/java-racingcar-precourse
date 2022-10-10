package racingcar.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CarPosition {
    private static final int STANDARD_NUM = 4;
    private static final int MOVE_GO = 1;
    private static final int MOVE_STOP = 0;

    int distance = 0;

    public CarPosition() {
    }

    public void setDistance(int randomNum) {
        this.distance = this.distance + this.judgeGoOrStop(randomNum);
    }

    private int judgeGoOrStop(int randomNum) {
        if (this.isGo(randomNum)) {
            return MOVE_GO;
        }

        return MOVE_STOP;
    }

    private boolean isGo(int randomNum) {
        return STANDARD_NUM <= randomNum;
    }
}
