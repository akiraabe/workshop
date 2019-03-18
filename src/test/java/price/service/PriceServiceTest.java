package price.service;

import common.AgeType;
import common.RoomType;
import common.SeasonType;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import price.domain.Food;
import price.domain.Party;
import price.domain.PriceDetail;

import java.util.List;

public class PriceServiceTest {

    @Test
    public void testNormalSchenerio() {

        Party party = new Party();
        party.setFood (Food.needFood());
        party.add(AgeType.ADULT,2 );
        party.add(AgeType.CHILD, 1);
        party.addBaby(1, Boolean.FALSE, Boolean.TRUE);

        PriceService priceService = new PriceService(SeasonType.YELLOW, RoomType.SPECIAL, party);

        List<PriceDetail> priceDetails = priceService.calculate();

        // Print
        priceDetails.forEach(System.out::println);

        assertThat(priceDetails.get(0).getAgeType()).isEqualTo(AgeType.ADULT);
        assertThat(priceDetails.get(0).getPrice().toString()).isEqualTo("20520");

        assertThat(priceDetails.get(2).getAgeType()).isEqualTo(AgeType.CHILD);
        assertThat(priceDetails.get(2).getPrice().toString()).isEqualTo("16416.0");

    }
}
