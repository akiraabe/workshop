package price.service;

import common.*;
import price.domain.Party;
import price.domain.Price;
import price.domain.PriceDetail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 料金計算全体のFacadeです。
 */
public class PriceService {

    private SeasonType seasonType;
    private RoomType roomType;
    private Party party;
    private Price basePrice;

    public PriceService(SeasonType seasonType, RoomType roomType, Party party) {
        this.seasonType = seasonType;
        this.roomType = roomType;
        this.party = party;
    }

    public List<PriceDetail> calculate() {

        if (party.getFood().withoutFood()) {
            calcWithoutFood();
        } else {
            NumberOfPeople numberOfPeople;
            if (party.count() >= 4) {
                numberOfPeople = NumberOfPeople.FOUR_OVER;
            } else {
                numberOfPeople = NumberOfPeople.getByNumber(party.count());
            }
            basePrice = roomType.calc(seasonType, numberOfPeople);
        }

        List<PriceDetail> priceDetails = new ArrayList<>();
        for (AgeType ageType : party.getPeople()) {
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setAgeType(ageType);
            priceDetail.setFood(party.getFood());
            priceDetail.setBabyNeedBed(party.getBabyNeedBed());
            priceDetail.setBabyNeedFood(party.getBabyNeedFood());
            if (ageType == AgeType.ADULT) {
                priceDetail.setPrice(basePrice);
            } else if (ageType == AgeType.CHILD) {
                priceDetail.setPrice(basePrice.discountByRate(new BigDecimal(("0.8")))); //TODO: 定数べた書き！
            } else {
                BigDecimal babyPrice = BigDecimal.ZERO;
                if (priceDetail.getBabyNeedBed()) {
                    babyPrice = babyPrice.add(new BigDecimal("3240"));
                }
                if (priceDetail.getBabyNeedFood()) {
                    babyPrice = babyPrice.add(new BigDecimal("3240"));
                }
                priceDetail.setPrice(new Price(babyPrice));
            }
            priceDetails.add(priceDetail);
        }
        return priceDetails;
    }


    /**
     * 素泊まりの料金計算
     */
    private void calcWithoutFood() {
        if (seasonType == SeasonType.GREEN) {
            basePrice = new Price("8640");
        } else if (seasonType == SeasonType.WHITE) {
            basePrice = new Price("7560");
        } else {
            throw new BusinessException("素泊まりはホワイト、グリーンのみです");
        }
    }
}
