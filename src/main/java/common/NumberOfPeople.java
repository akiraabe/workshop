package common;

import java.util.Arrays;

/**
 * 人数種別のEnumです。
 */
public enum NumberOfPeople {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR_OVER(4);

    private Integer number;

    private NumberOfPeople(Integer number) {
        this.number = number;
    }

    Integer getValue() {
        return number;
    }

    /**
     * 人数からEnumを逆引きするメソッド。
     * <pre>
     *     TODO: 実は、４人以上のときは対応してないという問題がある。
     * </pre>
     *
     * @param number
     * @return
     */
    public static NumberOfPeople getByNumber(int number) {
        if (number > 3) throw new BusinessException("4人以上のときはこれを呼ばないで");
        return Arrays.stream(NumberOfPeople.values())
                .filter(data -> data.getValue().equals(number))
                .findFirst()
                .orElse(null);
    }
}

