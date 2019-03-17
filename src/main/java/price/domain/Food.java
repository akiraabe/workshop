package price.domain;

/**
 * Food 食事をどうするかを表現するクラスです。
 * <pre>
 *     TODO: 現状は素泊まりかどうかを表しているだけなので、無駄に複雑になっただけ感がある。
 * </pre>
 */
public class Food {

    private Boolean withoutFood = Boolean.FALSE;

    /**
     * 素泊まりかどうかを問い合わせるメソッド
     *
     * @return
     */
    public Boolean withoutFood() {
        return this.withoutFood;
    }

    /**
     * 素泊まりじゃないという表現を返す。
     *
     * @return 素泊まりじゃない状態
     */
    public static Food needFood() {
        return new Food();
    }

    /**
     * 素泊まりという状態を返す。
     *
     * @return 素泊まりという状態
     */
    public static Food noNeedFood() {
        Food food = new Food();
        food.withoutFood = Boolean.TRUE;
        return food;
    }
}

