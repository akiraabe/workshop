package price.domain;

import java.math.BigDecimal;

/**
 * 料金クラスです。
 */
public class Price {

    final private BigDecimal amount;

    public Price(String amount) {
        this.amount = new BigDecimal(amount);
    }

    public Price(BigDecimal amount) {
        this.amount = amount;
    }

    public Price discountByRate(BigDecimal rate) {
        return new Price(this.amount.multiply(rate));
    }

    public String toString() {
        return amount.toPlainString();
    }
}
