package racingcar.service;

public class RacingCar {
    int tryCnt = 0;

    public RacingCar(String tryCnt) {
        validation(tryCnt);
        this.tryCnt = Integer.parseInt(tryCnt);
    }

    private void validation(String tryCnt) {
        volidationIsNum(tryCnt);
    }

    private void volidationIsNum(String tryCnt) {
        try {
            Integer.parseInt(tryCnt);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] TryCnt is not Number");
        }
    }

    public int getTryCnt() {
        return this.tryCnt;
    }
}
