package price.domain;

import common.AgeType;
import lombok.Data;

/**
 * 料金の詳細情報を保持するデータクラスです。
 */
@Data
public class PriceDetail {
    private Price price;
    private AgeType ageType;
    private Food food;
    private Boolean babyNeedFood;
    private Boolean babyNeedBed;

}
