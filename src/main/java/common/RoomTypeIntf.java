package common;

import price.domain.Price;

public interface RoomTypeIntf {
    Price calc(SeasonType seasonType, NumberOfPeople numberOfPeople);
}
