package by.sportliner.lk.core.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class PaymentSettings {

    private boolean usePrevPrice;

    private Map<Type, PriceItem> currentPrice;

    private Map<Type, PriceItem> prevPrice;

    public boolean isUsePrevPrice() {
        return usePrevPrice;
    }

    public void setUsePrevPrice(boolean usePrevPrice) {
        this.usePrevPrice = usePrevPrice;
    }

    public Map<Type, PriceItem> getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Map<Type, PriceItem> currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Map<Type, PriceItem> getPrevPrice() {
        return prevPrice;
    }

    public void setPrevPrice(Map<Type, PriceItem> prevPrice) {
        this.prevPrice = prevPrice;
    }

    public record PriceItem(BigDecimal normalPrice, BigDecimal benefitsPrice) {

    }

    public enum Type {

        ONE_LESSON(1),

        TWO_LESSONS(2),

        THREE_LESSONS(3),

        FOUR_LESSONS(4),

        FIVE_LESSONS(5),

        SIX_LESSONS(6),

        SEVEN_LESSONS(7),

        EIGHT_LESSONS(8),

        NINE_LESSONS(9),

        TEN_LESSONS(10),

        ELEVEN_LESSONS(11),

        TWELVE_LESSONS(12),

        UNLIM(16);

        Type(int countLessons) {
            this.countLessons = countLessons;
        }

        private int countLessons;

        public int getCountLessons() {
            return countLessons;
        }

        public static Type getByCountLessons(int countLessons) {
            Objects.requireNonNull(countLessons, "countLessons");

            return Stream.of(values())
                .filter(it -> it.getCountLessons() == countLessons)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found lesson fees type:" + countLessons));
        }

    }

}
