package common;

import price.domain.Price;

/**
 * 部屋種別のEnum ここに、宿泊料金の計算責務をカプセル化した。
 * 他のEnumにも計算責務を振り分けても良いかもしれないが、かえって可読性が落ちると思ったので、一点豪華主義でここに集めた。
 */
public enum RoomType implements RoomTypeIntf {
    SPECIAL {
        public Price calc(SeasonType seasonType, NumberOfPeople numberOfPeople) {
            switch (seasonType) {
                case WHITE:
                    switch (numberOfPeople) {
                        case ONE:
                            return new Price("16200");
                        case TWO:
                        case THREE:
                        case FOUR_OVER:
                            return new Price("15120");
                        default:
                            throw new BusinessException("Something is wrong");
                    }

                case GREEN:
                    switch (numberOfPeople) {
                        case ONE:
                            return new Price("17280");
                        case TWO:
                        case THREE:
                        case FOUR_OVER:
                            return new Price("16200");
                        default:
                            throw new BusinessException("Something is wrong");
                    }

                case BLUE:
                    switch (numberOfPeople) {
                        case ONE:
                            throw new BusinessException("We are sorry, can not accept only one customer.");
                        case TWO:
                            return new Price("20520");
                        case THREE:
                            return new Price("18360");
                        case FOUR_OVER:
                            return new Price("17280");
                        default:
                            throw new BusinessException("Something is wrong");
                    }
                case YELLOW:
                    switch (numberOfPeople) {
                        case ONE:
                            throw new BusinessException("We are sorry, can not accept only one customer.");
                        case TWO:
                            return new Price("23760");
                        case THREE:
                            return new Price("21600");
                        case FOUR_OVER:
                            return new Price("20520");
                        default:
                            throw new BusinessException("Something is wrong");
                    }
                case ORANGE:
                    switch (numberOfPeople) {
                        case ONE:
                            throw new BusinessException("We are sorry, can not accept only one customer.");
                        case TWO:
                            return new Price("24840");
                        case THREE:
                            return new Price("23760");
                        case FOUR_OVER:
                            return new Price("21600");
                        default:
                            throw new BusinessException("Something is wrong");
                    }
                default:
                    throw new BusinessException("Something is wrong");
            }
        }
    },
    REGULAR {
        public Price calc(SeasonType seasonType, NumberOfPeople numberOfPeople) {
            // TODO : Let's implement these kind of case.
            switch (seasonType) {
                case WHITE:
                    break;
                case GREEN:
                    break;
                case BLUE:
                    break;
                case YELLOW:
                    break;
                case ORANGE:
                    break;
                default:
                    return null; //TODO : Do not return null!
            }
            return null; // TODO : Do not return null!
        }
    };

}
