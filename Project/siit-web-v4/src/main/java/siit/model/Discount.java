package siit.model;

import java.math.BigDecimal;

public enum Discount {
    MINIM(BigDecimal.valueOf(0.95), 5),
    MEDIUM(BigDecimal.valueOf(0.90), 10),
    MAXIMUM(BigDecimal.valueOf(0.85), 15);

    private final BigDecimal percent;
    private final int minQuantityForDiscount;

    Discount(BigDecimal percent, int minQuantityForDicsount) {
        this.percent = percent;
        this.minQuantityForDiscount = minQuantityForDicsount;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public int getMinQuantityForDiscount() {
        return minQuantityForDiscount;
    }
}
