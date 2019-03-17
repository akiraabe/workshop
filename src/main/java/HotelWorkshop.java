import common.AgeType;
import common.RoomType;
import common.SeasonType;
import price.domain.Food;
import price.domain.Party;
import price.domain.PriceDetail;
import price.service.PriceService;

import java.util.List;

public class HotelWorkshop {

    public static void main(String[] args) {

        Party party = new Party();
        party.setFood (Food.needFood());
        party.add(AgeType.ADULT,2 );
        party.add(AgeType.CHILD, 1);
        party.addBaby(1, Boolean.FALSE, Boolean.TRUE);

        PriceService priceService = new PriceService(SeasonType.YELLOW, RoomType.SPECIAL, party);

        List<PriceDetail> priceDetails = priceService.calculate();

        // Print
        priceDetails.forEach(System.out::println);

    }

}
