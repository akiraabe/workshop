package price.domain;

import common.AgeType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 客の一団をPartyとして表現してみました。
 * <pre>
 *     ここの表現は微妙で、素泊まりにするかどうかは各自ではなく、Party単位で決まるものと「仮定」した。
 *     同じく、幼児の食事や寝具がいるかどうかも、各自ではなく、Party単位で決まるものと「仮定」した。
 * </pre>
 */
@Data
public class Party {

    private Food food;
    private List<AgeType> people = new ArrayList<>();
    private Boolean babyNeedFood = Boolean.FALSE;
    private Boolean babyNeedBed = Boolean.FALSE;

    /**
     * Partyに人を登録するメソッドです。
     * <pre>
     *     実際は人を登録するというよりは年代種別を登録しています。
     * </pre>
     *
     * @param ageType
     * @param number  人数
     */
    public void add(AgeType ageType, Integer number) {
        for (int i = 0; i < number; i++) {
            people.add(ageType);
        }
    }

    /**
     * BABYを登録する専用メソッドです。
     *
     * @param number         人数
     * @param isBabyNeedFood
     * @param isBabyNeedBed
     */
    public void addBaby(Integer number, Boolean isBabyNeedFood, Boolean isBabyNeedBed) {
        add(AgeType.BABY, number);
        this.babyNeedBed = isBabyNeedBed;
        this.babyNeedFood = isBabyNeedFood;
    }

    /**
     * Partyの人数を数える。ただし、BABYは寝具も食事も使わない場合は加算対象外
     *
     * @return
     */
    public int count() {
        if (babyNeedBed || babyNeedFood) {
            return people.size();
        }
        return (int) people.stream().filter(a -> a != AgeType.BABY).count();
    }
}

